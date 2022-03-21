package com.exercise.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class PurchaseVoucher extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b506106e0806100206000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c8063aa95d7c014610030575b600080fd5b61004361003e36600461044c565b610045565b005b6000606461005483600a61061e565b61005e91906105fe565b9050600080866001600160a01b031660008051602061068b833981519152338a8660405160240161009193929190610500565b60408051601f198184030181529181526020820180516001600160e01b03166001600160e01b03199094169390931790925290516100cf91906104c7565b6000604051808303816000865af19150503d806000811461010c576040519150601f19603f3d011682016040523d82523d6000602084013e610111565b606091505b509150915081801561013b57508051158061013b57508080602001905181019061013b91906104a0565b6101605760405162461bcd60e51b815260040161015790610569565b60405180910390fd5b600080876001600160a01b03168760405160240161017e91906105f5565b60408051601f198184030181529181526020820180516001600160e01b031663fd268b4560e01b179052516101b391906104c7565b600060405180830381855afa9150503d80600081146101ee576040519150601f19603f3d011682016040523d82523d6000602084013e6101f3565b606091505b50915091508161020257600080fd5b600061020d82610429565b90506000806001600160a01b038c1660008051602061068b83398151915233856102378c8e61063d565b60405160240161024993929190610500565b60408051601f198184030181529181526020820180516001600160e01b03166001600160e01b031990941693909317909252905161028791906104c7565b6000604051808303816000865af19150503d80600081146102c4576040519150601f19603f3d011682016040523d82523d6000602084013e6102c9565b606091505b50915091508180156102f35750805115806102f35750808060200190518101906102f391906104a0565b61030f5760405162461bcd60e51b8152600401610157906105ab565b6000808c6001600160a01b03167f640441567a63f93bb708d33df4fb558ccf2ec59f306cc74b9bed436c9354d20386338f60405160240161035293929190610500565b60408051601f198184030181529181526020820180516001600160e01b03166001600160e01b031990941693909317909252905161039091906104c7565b6000604051808303816000865af19150503d80600081146103cd576040519150601f19603f3d011682016040523d82523d6000602084013e6103d2565b606091505b50915091508180156103fc5750805115806103fc5750808060200190518101906103fc91906104a0565b6104185760405162461bcd60e51b815260040161015790610524565b505050505050505050505050505050565b6020015190565b80356001600160a01b038116811461044757600080fd5b919050565b600080600080600060a08688031215610463578081fd5b61046c86610430565b945061047a60208701610430565b935061048860408701610430565b94979396509394606081013594506080013592915050565b6000602082840312156104b1578081fd5b815180151581146104c0578182fd5b9392505050565b60008251815b818110156104e757602081860181015185830152016104cd565b818111156104f55782828501525b509190910192915050565b6001600160a01b039384168152919092166020820152604081019190915260600190565b602080825260379082015260008051602061066b833981519152604082015276494c45442842555920564f554348455220544f4b454e2960481b606082015260800190565b602080825260349082015260008051602061066b833981519152604082015273494c4544284d4f4e455920544f2041444d494e2960601b606082015260800190565b6020808252603c9082015260008051602061066b83398151915260408201527b494c4544284d4f4e455920544f20415254574f524b204f574e45522960201b606082015260800190565b90815260200190565b60008261061957634e487b7160e01b81526012600452602481fd5b500490565b600081600019048311821515161561063857610638610654565b500290565b60008282101561064f5761064f610654565b500390565b634e487b7160e01b600052601160045260246000fdfe5472616e7366657248656c7065723a205452414e534645525f46524f4d5f464123b872dd7302113369cda2901243429419bec145408fa8b352b3dd92b66c680ba264697066735822122014a818e91c40a2459a651d5d5ef23d18ea8652e1fd180bac5bfdcfc028b0dad764736f6c63430008000033";

    public static final String FUNC_PURCHASEVOUCHERTOKEN = "purchaseVoucherToken";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("13691", "0x9B8397f1B0FEcD3a1a40CdD5E8221Fa461898517");
    }

    @Deprecated
    protected PurchaseVoucher(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PurchaseVoucher(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PurchaseVoucher(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PurchaseVoucher(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> purchaseVoucherToken(String admin, String moneyToken, String voucherToken, BigInteger voucherTokenId, BigInteger price) {
        final Function function = new Function(
                FUNC_PURCHASEVOUCHERTOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(admin), 
                new org.web3j.abi.datatypes.Address(moneyToken), 
                new org.web3j.abi.datatypes.Address(voucherToken), 
                new org.web3j.abi.datatypes.generated.Uint256(voucherTokenId), 
                new org.web3j.abi.datatypes.generated.Uint256(price)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static PurchaseVoucher load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PurchaseVoucher(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PurchaseVoucher load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PurchaseVoucher(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PurchaseVoucher load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PurchaseVoucher(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PurchaseVoucher load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PurchaseVoucher(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PurchaseVoucher> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PurchaseVoucher.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<PurchaseVoucher> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PurchaseVoucher.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PurchaseVoucher> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PurchaseVoucher.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PurchaseVoucher> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PurchaseVoucher.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
