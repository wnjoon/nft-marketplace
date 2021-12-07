#!/bin/bash

OPTION=$1
ACCOUNTDIR=/Users/joon/Workspace/git/nft-marketplace/ethereum/accounts

if [ "${OPTION}" = "start" ]; then
    echo "Private Network (PoA) ${OPTION}"

    ps -ef | grep geth | grep poa-chain-dir | grep -v grep | awk '{print $2}' | xargs kill -9
    rm -Rf ./poa-chain-dir

    geth init genesis.json --datadir poa-chain-dir

    geth --datadir=./pow-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account1
    geth --datadir=./pow-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account2
    geth --datadir=./pow-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account3
    geth --datadir=./pow-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account4

    nohup geth --networkid 13691 --datadir pow-chain-dir --miner.gasprice 0 --miner.gaslimit 0 --txpool.pricelimit 0  --http --http.port 8545 --http.api "personal,db,eth,net,web3,txpool,miner" --http.corsdomain "*" --allow-insecure-unlock --nodiscover --snapshot=false --mine --ipcpath "/tmp/geth.ipc" > ./pow-chain-dir/gethNode.log &
    sleep 5
    ./mining.sh start

elif [ "${OPTION}" = "stop" ]; then 
    echo "Private Network (PoW) ${OPTION}"

    ./mining.sh stop
    ps -ef | grep geth | grep pow-chain-dir | grep -v grep | awk '{print $2}' | xargs kill -9

else
    echo "Not Correct Command"
fi









