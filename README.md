# NFT Marketplace

Web3j를 이용하여 이더리움의 ERC20과 ERC721을 서로 교환하는 마켓플레이스를 구현한다.
- 최근 업데이트 : 2022.03.05

## 1. 이더리움 네트워크

### 1.1. PoW (Proof of Work)
- 경로 : [ethereum/pow](ethereum/pow)
- 네트워크 구동 
```
# 자동으로 채굴(mining) 시작
$ ./network.sh start (stop)
```
- 채굴
```
$ ./mining start (stop)
```

### 1.2. PoA
- 경로 : [ethereum/poa](ethereum/poa)
- 네트워크 구동 
```
$ ./network.sh start (stop)
```

<br>

## 2. 스마트 컨트랙트

### 2.1. 솔리디티 파일
- 경로 : [smartcontract/contracts](smartcontract/contracts)
- 목록 : [ERC20](smartcontract/contracts/MyERC20.sol), [ERC721](smartcontract/contracts/MyERC721.sol)

### 2.2. 배포(migrate)
- 솔리디티 파일을 이더리움 네트워크에 배포
- 경로 : [smartcontract/deploy.sh](smartcontract/deploy.sh)
	- <u>본 소스에서 진행되는 PoA, PoW는 모두 testnetwork 태그 이하에서 실행된다.</u>
### 2.3. 자바 Wrapper Class 생성
- 솔리디티 기반의 스마트 컨트랙트를 자바에서 직접 사용할 수 있도록 클래스 형태로 변환하는 기능
- Web3j를 사용하기 위해 변환한다.
- 경로 : [smartcontract/contracts/scripts/generateWrapperClass.sh](smartcontract/contracts/scripts/generateWrapperClass.sh)


<br>

## 3. 어플리케이션

### 3.1. pom.xml

본 어플리케이션은 web3j(java) 기반으로 구성되었으며, Maven을 이용하여 라이브러리를 관리한다.
- 경로: [marketplace/pom.xml](marketplace/pom.xml)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"  ... >
	...
	<properties>
		<java.version>8</java.version>
		<web3j.version>4.8.8</web3j.version>
	</properties>
	<dependencies>
		...
		<!-- web3j -->
		<dependency>
			<groupId>org.web3j</groupId>
			<artifactId>core</artifactId>
			<version>${web3j.version}</version>
		</dependency>		
		<dependency>
			<groupId>com.squareup.okhttp3</groupId>
			<artifactId>okhttp</artifactId>
			<version>4.9.1</version>
		</dependency>
		...
	</dependencies>
...
```

### 3.2. 디렉토리

* [database](marketplace/database/postgresql)
	- 마켓플레이스 응용계층과 연결되는 데이터베이스를 다룬다.
	- <u>응용 실행 전에 꼭 데이터베이스를 활성화하도록 한다.</u>
	- 실행방법 : [README.md](marketplace/database/postgresql/README.md)
	- JPA를 활용해본다 : [Sample Practice](https://www.bezkoder.com/spring-boot-postgresql-example/)

* [contract](marketplace/src/main/java/com/exercise/contract)
    - WrapperClass를 이용해서 클래스 형태로 변환한 스마트 컨트랙트 

* [marketplace](marketplace/src/main/java/com/exercise/marketplace)
	- 마켓플레이스 앱 메인 

* [request](marketplace/src/main/java/com/exercise/request)
	- Rest API로 호출할 때 사용하는 요청 클래스
	- 모든 내용들은 json 기반의 POST 형태로 호출

* [token](marketplace/src/main/java/com/exercise/token)
	- ERC 기반의 토큰에 대한 컨트롤러/서비스 클래스

* [util](marketplace/src/main/java/com/exercise/util)
	- 서비스 클래스 내부에서 공통적으로 사용되는 유틸리티를 모아놓음
	- [NetworkConnector](marketplace/src/main/java/com/exercise/util/NetworkConnector.java) : Web3j 기반으로 이더리움 네트워크에 접속할 때 사용하는 기능들을 클래스로 합쳐놓음