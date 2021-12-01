#!/bin/bash

#!/bin/bash

OPTION=$1

if [ "${OPTION}" = "start" ]; then
    echo "Mining ${OPTION}"
    geth attach http://localhost:8545 --exec "miner.start()"
elif [ "${OPTION}" = "stop" ]; then 
    echo "Mining ${OPTION}"
    geth attach http://localhost:8545 --exec "miner.stop()"
else
    echo "Not Correct Command"
fi


