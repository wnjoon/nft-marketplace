package com.exercise.contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
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
public class MoneyToken extends Contract {
    public static final String BINARY = "0x6080604052650ae9f7bcc0006006553480156200001b57600080fd5b50604080518082018252601e81527f53696d706c65204d61726b6574706c61636520455243323020546f6b656e00006020808301918252835180850190945260058452644d6f6e657960d81b9084015281519192916200007e9160039162000198565b5080516200009490600490602084019062000198565b505050620000ab33600654620000b160201b60201c565b620002e0565b6001600160a01b038216620000e35760405162461bcd60e51b8152600401620000da906200023e565b60405180910390fd5b620000f16000838362000193565b80600260008282546200010591906200027e565b90915550506001600160a01b03821660009081526020819052604081208054839290620001349084906200027e565b90915550506040516001600160a01b038316906000907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef906200017990859062000275565b60405180910390a36200018f6000838362000193565b5050565b505050565b828054620001a690620002a3565b90600052602060002090601f016020900481019282620001ca576000855562000215565b82601f10620001e557805160ff191683800117855562000215565b8280016001018555821562000215579182015b8281111562000215578251825591602001919060010190620001f8565b506200022392915062000227565b5090565b5b8082111562000223576000815560010162000228565b6020808252601f908201527f45524332303a206d696e7420746f20746865207a65726f206164647265737300604082015260600190565b90815260200190565b600082198211156200029e57634e487b7160e01b81526011600452602481fd5b500190565b600281046001821680620002b857607f821691505b60208210811415620002da57634e487b7160e01b600052602260045260246000fd5b50919050565b610a0980620002f06000396000f3fe608060405234801561001057600080fd5b50600436106100af5760003560e01c806306fdde03146100b4578063095ea7b3146100d257806318160ddd146100f257806323b872dd146101075780632ff2e9dc1461011a578063313ce5671461012257806339509351146101375780634f8632ba1461014a57806370a082311461015f57806395d89b4114610172578063a457c2d71461017a578063a9059cbb1461018d578063dd62ed3e146101a0575b600080fd5b6100bc6101b3565b6040516100c99190610729565b60405180910390f35b6100e56100e03660046106e1565b610245565b6040516100c9919061071e565b6100fa610262565b6040516100c9919061095d565b6100e56101153660046106a6565b610268565b6100fa610301565b61012a610307565b6040516100c99190610966565b6100e56101453660046106e1565b61030c565b610152610360565b6040516100c9919061070a565b6100fa61016d366004610653565b61036f565b6100bc61038e565b6100e56101883660046106e1565b61039d565b6100e561019b3660046106e1565b610416565b6100fa6101ae366004610674565b61042a565b6060600380546101c290610998565b80601f01602080910402602001604051908101604052809291908181526020018280546101ee90610998565b801561023b5780601f106102105761010080835404028352916020019161023b565b820191906000526020600020905b81548152906001019060200180831161021e57829003601f168201915b5050505050905090565b6000610259610252610455565b8484610459565b50600192915050565b60025490565b600061027584848461050d565b6001600160a01b038416600090815260016020526040812081610296610455565b6001600160a01b03166001600160a01b03168152602001908152602001600020549050828110156102e25760405162461bcd60e51b81526004016102d990610847565b60405180910390fd5b6102f6856102ee610455565b858403610459565b506001949350505050565b60065481565b601290565b6000610259610319610455565b848460016000610327610455565b6001600160a01b03908116825260208083019390935260409182016000908120918b168152925290205461035b9190610974565b610459565b6005546001600160a01b031681565b6001600160a01b0381166000908152602081905260409020545b919050565b6060600480546101c290610998565b600080600160006103ac610455565b6001600160a01b03908116825260208083019390935260409182016000908120918816815292529020549050828110156103f85760405162461bcd60e51b81526004016102d990610918565b61040c610403610455565b85858403610459565b5060019392505050565b6000610259610423610455565b848461050d565b6001600160a01b03918216600090815260016020908152604080832093909416825291909152205490565b3390565b6001600160a01b03831661047f5760405162461bcd60e51b81526004016102d9906108d4565b6001600160a01b0382166104a55760405162461bcd60e51b81526004016102d9906107bf565b6001600160a01b0380841660008181526001602090815260408083209487168084529490915290819020849055517f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b9259061050090859061095d565b60405180910390a3505050565b6001600160a01b0383166105335760405162461bcd60e51b81526004016102d99061088f565b6001600160a01b0382166105595760405162461bcd60e51b81526004016102d99061077c565b610564838383610637565b6001600160a01b0383166000908152602081905260409020548181101561059d5760405162461bcd60e51b81526004016102d990610801565b6001600160a01b038085166000908152602081905260408082208585039055918516815290812080548492906105d4908490610974565b92505081905550826001600160a01b0316846001600160a01b03167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef8460405161061e919061095d565b60405180910390a3610631848484610637565b50505050565b505050565b80356001600160a01b038116811461038957600080fd5b600060208284031215610664578081fd5b61066d8261063c565b9392505050565b60008060408385031215610686578081fd5b61068f8361063c565b915061069d6020840161063c565b90509250929050565b6000806000606084860312156106ba578081fd5b6106c38461063c565b92506106d16020850161063c565b9150604084013590509250925092565b600080604083850312156106f3578182fd5b6106fc8361063c565b946020939093013593505050565b6001600160a01b0391909116815260200190565b901515815260200190565b6000602080835283518082850152825b8181101561075557858101830151858201604001528201610739565b818111156107665783604083870101525b50601f01601f1916929092016040019392505050565b60208082526023908201527f45524332303a207472616e7366657220746f20746865207a65726f206164647260408201526265737360e81b606082015260800190565b60208082526022908201527f45524332303a20617070726f766520746f20746865207a65726f206164647265604082015261737360f01b606082015260800190565b60208082526026908201527f45524332303a207472616e7366657220616d6f756e7420657863656564732062604082015265616c616e636560d01b606082015260800190565b60208082526028908201527f45524332303a207472616e7366657220616d6f756e74206578636565647320616040820152676c6c6f77616e636560c01b606082015260800190565b60208082526025908201527f45524332303a207472616e736665722066726f6d20746865207a65726f206164604082015264647265737360d81b606082015260800190565b60208082526024908201527f45524332303a20617070726f76652066726f6d20746865207a65726f206164646040820152637265737360e01b606082015260800190565b60208082526025908201527f45524332303a2064656372656173656420616c6c6f77616e63652062656c6f77604082015264207a65726f60d81b606082015260800190565b90815260200190565b60ff91909116815260200190565b6000821982111561099357634e487b7160e01b81526011600452602481fd5b500190565b6002810460018216806109ac57607f821691505b602082108114156109cd57634e487b7160e01b600052602260045260246000fd5b5091905056fea2646970667358221220793ed34dacc70e4c5ebe945f46f331f72ec70e6fe80b578962ca95a0593d2aa464736f6c63430008000033";

    public static final String FUNC_INITIAL_SUPPLY = "INITIAL_SUPPLY";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_INCREASEALLOWANCE = "increaseAllowance";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_USER = "user";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("13691", "0x4245CF4518CB2C280f5e9c6a03c90C147F80B4d9");
    }

    @Deprecated
    protected MoneyToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MoneyToken(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MoneyToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MoneyToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> INITIAL_SUPPLY() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_INITIAL_SUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> allowance(String owner, String spender) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner), 
                new org.web3j.abi.datatypes.Address(spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String spender, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(spender), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> decimals() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> decreaseAllowance(String spender, BigInteger subtractedValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DECREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(spender), 
                new org.web3j.abi.datatypes.generated.Uint256(subtractedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> increaseAllowance(String spender, BigInteger addedValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INCREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(spender), 
                new org.web3j.abi.datatypes.generated.Uint256(addedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> name() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> symbol() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalSupply() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transfer(String recipient, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String sender, String recipient, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(sender), 
                new org.web3j.abi.datatypes.Address(recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> user() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_USER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static MoneyToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MoneyToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MoneyToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MoneyToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MoneyToken load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MoneyToken(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MoneyToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MoneyToken(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MoneyToken> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MoneyToken.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<MoneyToken> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MoneyToken.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MoneyToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MoneyToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MoneyToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MoneyToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }
}
