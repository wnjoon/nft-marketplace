pragma solidity >=0.5.16;

import 'openzeppelin-solidity/contracts/token/ERC20/ERC20.sol'; 


contract MyERC20 is ERC20{ 
    address public user;   // 실제 유효하게 사용되지 않을 것으로 예상됨. 일단 운영자가 있다는 전제에서 관용적 사용

    uint public INITIAL_SUPPLY = 12000000000000; 
    constructor() ERC20("Simple Marketplace ERC20 Token", "Money"){ 
        user = msg.sender;
        _mint(user, INITIAL_SUPPLY);       
    } 
}

