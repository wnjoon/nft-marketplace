#!/bin/bash

OPTION=$1

if [ "${OPTION}" = "start" ]; then
  echo "Devmode ${OPTION}"
  mkdir -p dev-chain-dir
  nohup geth --datadir dev-chain-dir --http --http.api "eth,net,web3,personal" --dev --http.corsdomain "https://remix.ethereum.org,http://remix.ethereum.org" --ipcpath "/tmp/dev/geth.ipc" > ./dev-chain-dir/gethNode.log &
  sleep 5
  geth attach /tmp/dev/geth.ipc
elif [ "${OPTION}" = "stop" ]; then 
  echo "Devmode ${OPTION}"
  rm -Rf dev-chain-dir
  ps -ef | grep geth | grep pow-chain-dir | grep -v grep | awk '{print $2}' | xargs kill -9
else
  echo "Not Correct Command"
fi
