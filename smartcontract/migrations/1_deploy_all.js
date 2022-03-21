
const MoneyToken = artifacts.require("./MoneyToken.sol");
const BanksyToken = artifacts.require("./BanksyToken.sol");
const VoucherToken = artifacts.require("./VoucherToken.sol");
const PurchaseVoucher = artifacts.require("./PurchaseVoucher.sol");

var moneyToken_contract_address = "";
var banksyToken_contract_address = "";
var voucherToken_contract_address = "";
var purchaseVoucher_contract_address = "";

module.exports = function (deployer) {

    deployer.deploy(MoneyToken).then(function(){
        moneyToken_contract_address = MoneyToken.address;
    });

    deployer.deploy(BanksyToken).then(function(){
        banksyToken_contract_address = BanksyToken.address;
    });

    deployer.deploy(VoucherToken).then(function(){
        voucherToken_contract_address = VoucherToken.address;
    });

    deployer.deploy(PurchaseVoucher).then(function(){
        purchaseVoucher_contract_address = PurchaseVoucher.address;
    });

    console.log("MoneyToken         : ", moneyToken_contract_address);
    console.log("BanksyToken        : ", banksyToken_contract_address);
    console.log("VoucherToken       : ", voucherToken_contract_address);
    console.log("PurchaseVoucher    : ", purchaseVoucher_contract_address);
};
