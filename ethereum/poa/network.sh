#!/bin/bash

OPTION=$1
ACCOUNTDIR=/Users/joon/Workspace/git/nft-marketplace/ethereum/accounts

if [ "${OPTION}" = "start" ]; then
    echo "Private Network (PoA) ${OPTION}"

    ps -ef | grep geth | grep poa-chain-dir | grep -v grep | awk '{print $2}' | xargs kill -9
    rm -Rf ./poa-chain-dir
 
    geth init genesis.json --datadir poa-chain-dir
    cp data/keystore/UTC--2021-11-25T00-45-25.293804000Z--f70e0e6ba284481deb1d53765fce4a49df5e1624 ./poa-chain-dir/keystore/

    geth --datadir=./poa-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account1
    geth --datadir=./poa-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account2
    geth --datadir=./poa-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account3
    geth --datadir=./poa-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account4
 
    nohup geth --networkid 13691 --datadir poa-chain-dir --nodekey ./data/key --http --http.port 8545 --http.api "personal,db,eth,net,web3,txpool,miner" --http.corsdomain "*" --allow-insecure-unlock --nodiscover --snapshot=false --unlock 'f70e0e6ba284481deb1d53765fce4a49df5e1624' --password $ACCOUNTDIR/password.txt --mine --ipcpath "/tmp/geth.ipc" > ./poa-chain-dir/gethNode.log &

elif [ "${OPTION}" = "stop" ]; then 
    echo "Private Network (PoA) ${OPTION}"

    ps -ef | grep geth | grep poa-chain-dir | grep -v grep | awk '{print $2}' | xargs kill -9   
    rm -Rf ./poa-chain-dir

else
    echo "Not Correct Command"
fi








