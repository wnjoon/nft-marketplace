pragma solidity >=0.5.16;

import "openzeppelin-solidity/contracts/token/ERC721/extensions/ERC721URIStorage.sol";
import "openzeppelin-solidity/contracts/token/ERC721/extensions/IERC721Metadata.sol";
import "openzeppelin-solidity/contracts/utils/Counters.sol";
import "openzeppelin-solidity/contracts/access/Ownable.sol";

contract PurchaseVoucher {
    // uint256 private constant COPYRIGHT_FEE_RATE = 5;

    // 거래를 위한 TrasnferFrom 호출
    bytes4 private constant TRANSFER_FROM_FUNC =
        bytes4(keccak256("transferFrom(address,address,uint256)"));

    // 거래를 위한 purchase 호출
    bytes4 private constant PURCHASE_FUNC =
        bytes4(keccak256("purchase(address,address,uint256)"));

    // Marketplace 운영자 주소
    // address public ADMIN_ADDRESS = 0xfe3b557e8fb62b89f4916b721be55ceb828dbd73;

    constructor() {}

    /*
     * MoneyToken으로 VoucherToken을 구매
     * 10% = 운영자(marketplace)
     * 90% = 판매자
     */
    function purchaseVoucherToken(address admin, address moneyToken, address voucherToken, uint256 voucherTokenId, uint256 price) public {
        
        uint256 feePrice = price * 10 / 100;
        /* 
         * 10% 수수료 전송 (buyer -> admin)
         */
        (
            bool successPayMoneyToAdmin,
            bytes memory dataPayMoneyToAdmin
        ) = moneyToken.call(
                abi.encodeWithSelector(
                    TRANSFER_FROM_FUNC,
                    msg.sender,
                    admin,
                    feePrice
                )
            );
        require(
            successPayMoneyToAdmin &&
                (dataPayMoneyToAdmin.length == 0 ||
                    abi.decode(dataPayMoneyToAdmin, (bool))),
            "TransferHelper: TRANSFER_FROM_FAILED(MONEY TO ADMIN)"
        );

        /*
         * 수수료를 제외한 나머지 price 전송 (buyer -> seller)
         */
        (
            bool isOwnerOfToken, 
            bytes memory dataOwnerOfToken
        ) = voucherToken.staticcall(
                abi.encodeWithSignature(
                    "getVoucherTokenOwner(uint256)", 
                    voucherTokenId)
            );
        if (!isOwnerOfToken) {
            revert();
        }
        address voucherTokenOwner = bytesToAddress(dataOwnerOfToken);

        (
            bool successPayMoneyToOwner,
            bytes memory dataToPayMoneyToOwner
        ) = moneyToken.call(
                abi.encodeWithSelector(
                    TRANSFER_FROM_FUNC,
                    msg.sender,
                    voucherTokenOwner,
                    price - feePrice
                )
            );
        require(
            successPayMoneyToOwner &&
                (dataToPayMoneyToOwner.length == 0 ||
                    abi.decode(dataToPayMoneyToOwner, (bool))),
            "TransferHelper: TRANSFER_FROM_FAILED(MONEY TO ARTWORK OWNER)"
        );
        
        // VoucherToken 전송
        (
            bool successToBuyVoucherToken, 
            bytes memory dataToBuyVoucherToken
        ) = voucherToken.call(
                abi.encodeWithSelector(
                    // TRANSFER_FROM_FUNC,
                    PURCHASE_FUNC,
                    voucherTokenOwner,
                    msg.sender,
                    voucherTokenId
                )
            );
        require(
            successToBuyVoucherToken &&
                (dataToBuyVoucherToken.length == 0 ||
                    abi.decode(dataToBuyVoucherToken, (bool))),
            "TransferHelper: TRANSFER_FROM_FAILED(BUY VOUCHER TOKEN)"
        );        
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
