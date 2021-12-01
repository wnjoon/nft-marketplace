#!/bin/bash

geth attach http://localhost:8545 --exec "web3.personal.unlockAccount('0xfe3b557e8fb62b89f4916b721be55ceb828dbd73','pwd')"
truffle migrate --reset --network gethPowmode
geth attach http://localhost:8545 --exec "web3.personal.lockAccount('0xfe3b557e8fb62b89f4916b721be55ceb828dbd73')"

# cd migrations
# node deploy_0x_contracts.js
# cd -
