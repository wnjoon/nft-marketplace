#!/bin/bash

MODE=$1
OPTION=$2
BASEDIR=/Users/joon/Workspace/git/nft-marketplace/ethereum
ACCOUNTDIR=$BASEDIR/accounts
GENESISFILEDIR=$BASEDIR/genesisFiles

printHelp() {
    echo "-------------------- Manual --------------------"
    echo "./network.sh MODE OPTION"
    echo ""
    echo "MODE"
    echo " L pow    : pow mode"
    echo " L poa    : poa mode"
    echo " L dev    : dev mode"
    echo "OPTION"
    echo " L start  : start network"
    echo " L stop   : stop network"
    echo "------------------------------------------------"
}


if [ "${MODE}" = "pow" ]; then

    if [ "${OPTION}" = "start" ]; then

        echo "Private Network (PoW) ${OPTION}"

        ps -ef | grep geth | grep pow-chain-dir | grep -v grep | awk '{print $2}' | xargs kill -9
        rm -Rf $BASEDIR/pow-chain-dir

        geth init $GENESISFILEDIR/genesis_pow.json --datadir $BASEDIR/pow-chain-dir

        # geth --datadir=$BASEDIR/pow-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account0
        geth --datadir=$BASEDIR/pow-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account1
        geth --datadir=$BASEDIR/pow-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account2
        geth --datadir=$BASEDIR/pow-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account3
        geth --datadir=$BASEDIR/pow-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account4

        nohup geth --networkid 13691 --datadir $BASEDIR/pow-chain-dir --miner.gasprice 0 --miner.gaslimit 0 --txpool.pricelimit 0  --http --http.port 8545 --http.api "personal,db,eth,net,web3,txpool,miner" --http.corsdomain "*" --allow-insecure-unlock --nodiscover --snapshot=false --mine --ipcpath "/tmp/geth.ipc" > $BASEDIR/pow-chain-dir/gethNode.log &
        sleep 5
        source $BASEDIR/mining.sh start

    elif [ "${OPTION}" = "stop" ]; then 

        echo "Private Network (PoW) ${OPTION}"
        source $BASEDIR/mining.sh stop

        ps -ef | grep geth | grep pow-chain-dir | grep -v grep | awk '{print $2}' | xargs kill -9
        rm -Rf $BASEDIR/pow-chain-dir

    else 
        printHelp
    fi 

elif [ "${MODE}" = "poa" ]; then
    if [ "${OPTION}" = "start" ]; then

        echo "Private Network (PoA) ${OPTION}"

        ps -ef | grep geth | grep poa-chain-dir | grep -v grep | awk '{print $2}' | xargs kill -9
        rm -Rf $BASEDIR/poa-chain-dir
    
        geth init $GENESISFILEDIR/genesis_poa.json --datadir $BASEDIR/poa-chain-dir
        cp $ACCOUNTDIR/poaData/keystore/UTC--2021-11-25T00-45-25.293804000Z--f70e0e6ba284481deb1d53765fce4a49df5e1624 $BASEDIR/poa-chain-dir/keystore/

        geth --datadir=$BASEDIR/poa-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account1
        geth --datadir=$BASEDIR/poa-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account2
        geth --datadir=$BASEDIR/poa-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account3
        geth --datadir=$BASEDIR/poa-chain-dir --password $ACCOUNTDIR/password.txt account import $ACCOUNTDIR/account4
    
        nohup geth --networkid 13691 --datadir $BASEDIR/poa-chain-dir --nodekey ./data/key --http --http.port 8545 --http.api "personal,db,eth,net,web3,txpool,miner" --http.corsdomain "*" --allow-insecure-unlock --nodiscover --snapshot=false --unlock 'f70e0e6ba284481deb1d53765fce4a49df5e1624' --password $ACCOUNTDIR/password.txt --mine --ipcpath "/tmp/geth.ipc" > $BASEDIR/poa-chain-dir/gethNode.log &
  
    elif [ "${OPTION}" = "stop" ]; then 

        echo "Private Network (PoA) ${OPTION}"

        ps -ef | grep geth | grep poa-chain-dir | grep -v grep | awk '{print $2}' | xargs kill -9   
        rm -Rf $BASEDIR/poa-chain-dir
  
    else 
        printHelp
    fi

elif [ "${MODE}" = "dev" ]; then

    if [ "${OPTION}" = "start" ]; then

        echo "Dev mode ${OPTION}"
        mkdir -p $BASEDIR/dev-chain-dir
        nohup geth --datadir $BASEDIR/dev-chain-dir --http --http.api "eth,net,web3,personal" --dev --http.corsdomain "https://remix.ethereum.org,http://remix.ethereum.org" --ipcpath "/tmp/dev/geth.ipc" > $BASEDIR/dev-chain-dir/gethNode.log &
        sleep 5
        geth attach /tmp/dev/geth.ipc

    elif [ "${OPTION}" = "stop" ]; then 

        echo "Dev mode ${OPTION}"
        rm -Rf $BASEDIR/dev-chain-dir
        ps -ef | grep geth | grep pow-chain-dir | grep -v grep | awk '{print $2}' | xargs kill -9

    else 
        printHelp
    fi

else
    printHelp
fi










