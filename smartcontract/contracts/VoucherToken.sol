pragma solidity >=0.5.16;

import "openzeppelin-solidity/contracts/token/ERC721/extensions/ERC721URIStorage.sol";
import "openzeppelin-solidity/contracts/token/ERC721/extensions/IERC721Metadata.sol";
import "openzeppelin-solidity/contracts/utils/Counters.sol";
import "openzeppelin-solidity/contracts/access/Ownable.sol";

contract VoucherToken is ERC721URIStorage, Ownable {
    using Counters for Counters.Counter;  
    Counters.Counter private _tokenIds;
    uint256 private _usageFeeRate;  // 저작권료

    mapping(uint256 => Metadata) private metadataMap;

    struct Metadata {
        address startDate;
        address endDate;
        address tokenOwner;
        address artworkAddress;
        uint256 artworkId;
        uint256 usageFeeRate;
    }

    constructor() ERC721("Art work Voucher Token", "Artwork") { 
        _usageFeeRate = 10;
    }

    event Purchase(
        address indexed _from,
        address indexed _to,
        uint256 indexed _tokenId,
        Metadata _metadata
    );

    function totalSupply() public view returns (uint256) {
        return _tokenIds.current();
    }

    /*
     * Swap.sol에서 실행된 purchase 내 ERC721 토큰 구매 부분
     * 로직 마지막에 event 전송 (emit)
     */
    function purchase(
        address seller, // 판매자
        address buyer,
        uint256 voucherTokenId
    ) public {
        // ERC721 전송 (melon -> buyer)
        transferFrom(seller, buyer, voucherTokenId);
        emit Purchase(seller, buyer, voucherTokenId, metadataMap[voucherTokenId]);
    }

    /*
     * VoucherToken은 해당 artwork 토큰의 소유자만 민트할 수 있음
     */
    function mint(
        address _to,
        address _artworkAddress,
        uint256 _artworkId,
        address _startDate,
        address _endDate
    ) public onlyOwner returns (uint256) {
        // 실제 존재하는 artwork 토큰인지 확인
        (bool success, bytes memory data) = address(_artworkAddress)
            .staticcall(
                abi.encodeWithSignature("ownerOf(uint256)", _artworkId)
            );
        if (!success) {
            revert();
        }
        address tokenOwner = bytesToAddress(data);

        // 해당 토큰을 소유한 사람만이 이를 이용하여 VoucherToken을 만들 수 있도록 함
        if (tokenOwner != msg.sender) {
            revert();
        }

        // mint
        _tokenIds.increment();
        uint256 voucherTokenId = _tokenIds.current();
        _mint(_to, voucherTokenId);

        // token metadata
        Metadata memory metadata;
        metadata.startDate = _startDate;
        metadata.endDate = _endDate;
        metadata.tokenOwner = tokenOwner;
        metadata.artworkAddress = _artworkAddress;
        metadata.artworkId = _artworkId;
        metadata.usageFeeRate = _usageFeeRate;
        metadataMap[voucherTokenId] = metadata;

        return voucherTokenId;
    }

    function getMetadata(uint256 _tokenId)
        external
        view
        returns (Metadata memory metadata)
    {
        return metadataMap[_tokenId];
    }

    function getVoucherTokenOwner(uint256 _tokenId)
        external
        view
        returns (address tokenOwner)
    {
        return metadataMap[_tokenId].tokenOwner;
    }

    function bytesToAddress(bytes memory bys)
        private
        pure
        returns (address addr)
    {
        assembly {
            addr := mload(add(bys, 32))
        }
    }
}
