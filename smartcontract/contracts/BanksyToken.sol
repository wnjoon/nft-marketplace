pragma solidity >=0.5.16;

import 'openzeppelin-solidity/contracts/token/ERC721/extensions/ERC721URIStorage.sol'; 
import 'openzeppelin-solidity/contracts/token/ERC721/extensions/IERC721Metadata.sol';
import 'openzeppelin-solidity/contracts/utils/Counters.sol';
import 'openzeppelin-solidity/contracts/access/Ownable.sol';


contract BanksyToken is ERC721URIStorage, Ownable{
  // address public user;   // 실제 유효하게 사용되지 않을 것으로 예상됨. 일단 운영자가 있다는 전제에서 관용적 사용

  using Counters for Counters.Counter;
  Counters.Counter private _tokenIds;

  constructor() ERC721("Banksy's First NFT Token", "NFT"){ 
  } 

  function totalSupply() public view returns (uint256) {
      return _tokenIds.current();
  }

  // function mint(address marketplaceUser, string memory tokenURI)
  function mint(string memory tokenURI)
      public
      /// onlyOwner
      returns (uint256){
      _tokenIds.increment();
      uint256 nftId = _tokenIds.current();
      _mint(msg.sender, nftId);
      _setTokenURI(nftId, tokenURI);
      return nftId;
  }  
}