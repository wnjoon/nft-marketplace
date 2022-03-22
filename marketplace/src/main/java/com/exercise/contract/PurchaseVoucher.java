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
    public static final String BINARY = "0x608060405234801561001057600080fd5b50610682806100206000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c8063aa95d7c014610030575b600080fd5b61004361003e366004610437565b610045565b005b600060649050600080866001600160a01b031660008051602061062d833981519152338a8660405160240161007c939291906104eb565b60408051601f198184030181529181526020820180516001600160e01b03166001600160e01b03199094169390931790925290516100ba91906104b2565b6000604051808303816000865af19150503d80600081146100f7576040519150601f19603f3d011682016040523d82523d6000602084013e6100fc565b606091505b5091509150818015610126575080511580610126575080806020019051810190610126919061048b565b61014b5760405162461bcd60e51b815260040161014290610554565b60405180910390fd5b600080876001600160a01b03168760405160240161016991906105e0565b60408051601f198184030181529181526020820180516001600160e01b031663fd268b4560e01b1790525161019e91906104b2565b600060405180830381855afa9150503d80600081146101d9576040519150601f19603f3d011682016040523d82523d6000602084013e6101de565b606091505b5091509150816101ed57600080fd5b60006101f882610414565b90506000806001600160a01b038c1660008051602061062d83398151915233856102228c8e6105e9565b604051602401610234939291906104eb565b60408051601f198184030181529181526020820180516001600160e01b03166001600160e01b031990941693909317909252905161027291906104b2565b6000604051808303816000865af19150503d80600081146102af576040519150601f19603f3d011682016040523d82523d6000602084013e6102b4565b606091505b50915091508180156102de5750805115806102de5750808060200190518101906102de919061048b565b6102fa5760405162461bcd60e51b815260040161014290610596565b6000808c6001600160a01b03167f640441567a63f93bb708d33df4fb558ccf2ec59f306cc74b9bed436c9354d20386338f60405160240161033d939291906104eb565b60408051601f198184030181529181526020820180516001600160e01b03166001600160e01b031990941693909317909252905161037b91906104b2565b6000604051808303816000865af19150503d80600081146103b8576040519150601f19603f3d011682016040523d82523d6000602084013e6103bd565b606091505b50915091508180156103e75750805115806103e75750808060200190518101906103e7919061048b565b6104035760405162461bcd60e51b81526004016101429061050f565b505050505050505050505050505050565b6020015190565b80356001600160a01b038116811461043257600080fd5b919050565b600080600080600060a0868803121561044e578081fd5b6104578661041b565b94506104656020870161041b565b93506104736040870161041b565b94979396509394606081013594506080013592915050565b60006020828403121561049c578081fd5b815180151581146104ab578182fd5b9392505050565b60008251815b818110156104d257602081860181015185830152016104b8565b818111156104e05782828501525b509190910192915050565b6001600160a01b039384168152919092166020820152604081019190915260600190565b602080825260379082015260008051602061060d833981519152604082015276494c45442842555920564f554348455220544f4b454e2960481b606082015260800190565b602080825260349082015260008051602061060d833981519152604082015273494c4544284d4f4e455920544f2041444d494e2960601b606082015260800190565b6020808252603c9082015260008051602061060d83398151915260408201527b494c4544284d4f4e455920544f20415254574f524b204f574e45522960201b606082015260800190565b90815260200190565b60008282101561060757634e487b7160e01b81526011600452602481fd5b50039056fe5472616e7366657248656c7065723a205452414e534645525f46524f4d5f464123b872dd7302113369cda2901243429419bec145408fa8b352b3dd92b66c680ba2646970667358221220bf643a95951dee82e812ba0c8b939bf4e0e88759675400d59c61e8c7bb3f1da964736f6c63430008000033";

    public static final String FUNC_PURCHASEVOUCHERTOKEN = "purchaseVoucherToken";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("13691", "0xd6A7c915066E17ba18024c799258C8A286fFBc00");
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
