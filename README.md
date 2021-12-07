# NFT Marketplace

Web3j를 이용하여 이더리움의 ERC20과 ERC721을 서로 교환하는 마켓플레이스를 구현한다.

## 이더리움 네트워크

## 스마트 컨트랙트

### 1. 솔리디티 파일
- 경로 : [smartcontract/contracts](smartcontract/contracts)
- 목록 : [ERC20](smartcontract/contracts/MyERC20.sol), [ERC721](smartcontract/contracts/MyERC721.sol)

### 2. 자바 Wrapper Class 생성
- 솔리디티 기반의 스마트 컨트랙트를 자바에서 직접 사용할 수 있도록 클래스 형태로 변환하는 기능
- Web3j를 사용하기 위해 변환한다.
- 경로 : [smartcontract/contracts/scripts/generateWrapperClass.sh](smartcontract/contracts/scripts/generateWrapperClass.sh)