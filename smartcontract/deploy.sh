#!/bin/bash

echo "Deploy smart contract"
geth attach http://localhost:8545 --exec "web3.personal.unlockAccount('0xfe3b557e8fb62b89f4916b721be55ceb828dbd73','pwd')"
truffle migrate --reset --network testnetwork
geth attach http://localhost:8545 --exec "web3.personal.lockAccount('0xfe3b557e8fb62b89f4916b721be55ceb828dbd73')"
echo ""

sleep 5

echo "Generate smart contract wrapper"
source scripts/generateWrapperClass.sh MoneyToken
source scripts/generateWrapperClass.sh BanksyToken
source scripts/generateWrapperClass.sh VoucherToken
source scripts/generateWrapperClass.sh PurchaseVoucher
# cd migrations
# node deploy_0x_contracts.js
# cd -
