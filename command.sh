#!/bin/bash

OPTION=$1
ETHEREUMDIR=/Users/joon/Workspace/git/nft-marketplace/ethereum/pow
CONTRACTDIR=/Users/joon/Workspace/git/nft-marketplace/smartcontract

if [ "${OPTION}" = "netstart" ]; then
    echo "Ethereum network up(pow)"
    source $ETHEREUMDIR/network.sh start
    sleep 3
    echo "Smart contract deploy"
    source $CONTRACTDIR/deploy.sh
    sleep 2
    echo "Copy Contract Wrapper to Application"
    source $CONTRACTDIR/scripts/generateWrapperClass.sh MoneyToken
    source $CONTRACTDIR/scripts/generateWrapperClass.sh BanksyToken
elif [ "${OPTION}" = "netstop" ]; then 
    source $ETHEREUMDIR/network.sh stop
elif [ "${OPTION}" = "minstart" ]; then 
    source $ETHEREUMDIR/mining.sh start 
elif [ "${OPTION}" = "minstop" ]; then 
    source $ETHEREUMDIR/mining.sh stop 
else
    echo "Not Correct Command"
fi









