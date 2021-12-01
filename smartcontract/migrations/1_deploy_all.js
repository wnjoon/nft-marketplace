
const MyERC20 = artifacts.require("./MyERC20.sol");
const MyERC721 = artifacts.require("./MyERC721.sol");

var erc20_contract_address = "";
var erc721_contract_address = "";

module.exports = function (deployer) {

    deployer.deploy(MyERC20).then(function(){
        erc20_contract_address = MyERC20.address;
    });

    deployer.deploy(MyERC721).then(function(){
        erc721_contract_address = MyERC721.address;
    });

    console.log("ERC20  : ", erc20_contract_address);
    console.log("ERC721 : ", erc721_contract_address);
};
