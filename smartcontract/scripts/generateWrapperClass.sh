#!/bin/bash

# 본 파일은 json 타입으로 컴파일 된 솔리디티 기반의 스마트컨트랙트를 Web3j에서 사용하기 위해 Wrapper Class를 만들어주는 스크립트이다.
# web3j에 대한 설치가 미리 선행되어야 한다.
# 
# 설명
#  ㄴ CONTRACTPATH : 솔리디티 기반의 스마트컨트랙트가 저장되어 있는 경로
#  ㄴ APPLICATIONPATH : 자바 어플리케이션 경로. 소스 레벨 경로까지 포함해주어야 한다(예시참조)
#  ㄴ CONTRACTNAME : 특정 이름의 스마트컨트랙트를 클래스 형태로 생성한다(예시: MyERC20)

PROJECTDIR=/Users/joon/Workspace/git/nft-marketplace
CONTRACTPATH=$PROJECTDIR/smartcontract/build/contracts
CONTRACTNAME=$1
APPLICATIONPATH=$PROJECTDIR/marketplace/src/main/java

web3j generate truffle \
--truffle-json=$CONTRACTPATH/$CONTRACTNAME.json \
-o $APPLICATIONPATH \
-p com.exercise.contract