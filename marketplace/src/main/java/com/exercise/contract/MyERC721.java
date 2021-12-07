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
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
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
public class MyERC721 extends Contract {
    public static final String BINARY = "0x60806040523480156200001157600080fd5b50604080518082018252601f81527f53696d706c65204d61726b6574706c6163652045524337323120546f6b656e0060208083019182528351808501909452600384526213919560ea1b908401528151919291620000729160009162000113565b5080516200008890600190602084019062000113565b505050620000a56200009f620000bd60201b60201c565b620000c1565b600880546001600160a01b03191633179055620001f6565b3390565b600780546001600160a01b038381166001600160a01b0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b8280546200012190620001b9565b90600052602060002090601f01602090048101928262000145576000855562000190565b82601f106200016057805160ff191683800117855562000190565b8280016001018555821562000190579182015b828111156200019057825182559160200191906001019062000173565b506200019e929150620001a2565b5090565b5b808211156200019e5760008155600101620001a3565b600281046001821680620001ce57607f821691505b60208210811415620001f057634e487b7160e01b600052602260045260246000fd5b50919050565b61199280620002066000396000f3fe608060405234801561001057600080fd5b50600436106100f15760003560e01c806301ffc9a7146100f657806306fdde031461011f578063081812fc14610134578063095ea7b31461015457806318160ddd1461016957806323b872dd1461017e57806342842e0e146101915780634f8632ba146101a45780636352211e146101ac57806370a08231146101bf578063715018a6146101d25780638da5cb5b146101da57806395d89b41146101e2578063a22cb465146101ea578063b88d4fde146101fd578063c87b56dd14610210578063d0def52114610223578063e985e9c514610236578063f2fde38b14610249575b600080fd5b6101096101043660046111ed565b61025c565b60405161011691906112e9565b60405180910390f35b6101276102a4565b60405161011691906112f4565b610147610142366004611225565b610336565b6040516101169190611298565b6101676101623660046111c4565b610382565b005b61017161041a565b6040516101169190611802565b61016761018c366004611079565b61042b565b61016761019f366004611079565b610463565b61014761047e565b6101476101ba366004611225565b61048d565b6101716101cd36600461102d565b6104c2565b610167610506565b610147610551565b610127610560565b6101676101f836600461112c565b61056f565b61016761020b3660046110b4565b610585565b61012761021e366004611225565b6105c4565b610171610231366004611166565b6106e5565b610109610244366004611047565b61071a565b61016761025736600461102d565b610748565b60006001600160e01b031982166380ac58cd60e01b148061028d57506001600160e01b03198216635b5e139f60e01b145b8061029c575061029c826107b9565b90505b919050565b6060600080546102b39061187a565b80601f01602080910402602001604051908101604052809291908181526020018280546102df9061187a565b801561032c5780601f106103015761010080835404028352916020019161032c565b820191906000526020600020905b81548152906001019060200180831161030f57829003601f168201915b5050505050905090565b6000610341826107d2565b6103665760405162461bcd60e51b815260040161035d90611657565b60405180910390fd5b506000908152600460205260409020546001600160a01b031690565b600061038d8261048d565b9050806001600160a01b0316836001600160a01b031614156103c15760405162461bcd60e51b815260040161035d90611770565b806001600160a01b03166103d36107ef565b6001600160a01b031614806103ef57506103ef816102446107ef565b61040b5760405162461bcd60e51b815260040161035d90611498565b61041583836107f3565b505050565b60006104266009610861565b905090565b61043c6104366107ef565b82610865565b6104585760405162461bcd60e51b815260040161035d906117b1565b6104158383836108e2565b61041583838360405180602001604052806000815250610585565b6008546001600160a01b031681565b6000818152600260205260408120546001600160a01b03168061029c5760405162461bcd60e51b815260040161035d9061153a565b60006001600160a01b0382166104ea5760405162461bcd60e51b815260040161035d906114f0565b506001600160a01b031660009081526003602052604090205490565b61050e6107ef565b6001600160a01b031661051f610551565b6001600160a01b0316146105455760405162461bcd60e51b815260040161035d906116a3565b61054f60006109fd565b565b6007546001600160a01b031690565b6060600180546102b39061187a565b61058161057a6107ef565b8383610a4f565b5050565b6105966105906107ef565b83610865565b6105b25760405162461bcd60e51b815260040161035d906117b1565b6105be84848484610af2565b50505050565b60606105cf826107d2565b6105eb5760405162461bcd60e51b815260040161035d90611606565b600082815260066020526040812080546106049061187a565b80601f01602080910402602001604051908101604052809291908181526020018280546106309061187a565b801561067d5780601f106106525761010080835404028352916020019161067d565b820191906000526020600020905b81548152906001019060200180831161066057829003601f168201915b50505050509050600061068e610b25565b90508051600014156106a25750905061029f565b8151156106d45780826040516020016106bc929190611269565b6040516020818303038152906040529250505061029f565b6106dd84610b37565b949350505050565b60006106f16009610bb9565b60006106fd6009610861565b90506107098482610bc2565b6107138184610c8f565b9392505050565b6001600160a01b03918216600090815260056020908152604080832093909416825291909152205460ff1690565b6107506107ef565b6001600160a01b0316610761610551565b6001600160a01b0316146107875760405162461bcd60e51b815260040161035d906116a3565b6001600160a01b0381166107ad5760405162461bcd60e51b815260040161035d90611359565b6107b6816109fd565b50565b6001600160e01b031981166301ffc9a760e01b14919050565b6000908152600260205260409020546001600160a01b0316151590565b3390565b600081815260046020526040902080546001600160a01b0319166001600160a01b03841690811790915581906108288261048d565b6001600160a01b03167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92560405160405180910390a45050565b5490565b6000610870826107d2565b61088c5760405162461bcd60e51b815260040161035d9061144c565b60006108978361048d565b9050806001600160a01b0316846001600160a01b031614806108d25750836001600160a01b03166108c784610336565b6001600160a01b0316145b806106dd57506106dd818561071a565b826001600160a01b03166108f58261048d565b6001600160a01b03161461091b5760405162461bcd60e51b815260040161035d906116d8565b6001600160a01b0382166109415760405162461bcd60e51b815260040161035d906113d5565b61094c838383610415565b6109576000826107f3565b6001600160a01b0383166000908152600360205260408120805460019290610980908490611837565b90915550506001600160a01b03821660009081526003602052604081208054600192906109ae90849061180b565b909155505060008181526002602052604080822080546001600160a01b0319166001600160a01b03868116918217909255915184939187169160008051602061193d83398151915291a4505050565b600780546001600160a01b038381166001600160a01b0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b816001600160a01b0316836001600160a01b03161415610a815760405162461bcd60e51b815260040161035d90611419565b6001600160a01b0383811660008181526005602090815260408083209487168084529490915290819020805460ff1916851515179055517f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c3190610ae59085906112e9565b60405180910390a3505050565b610afd8484846108e2565b610b0984848484610cd3565b6105be5760405162461bcd60e51b815260040161035d90611307565b60408051602081019091526000815290565b6060610b42826107d2565b610b5e5760405162461bcd60e51b815260040161035d90611721565b6000610b68610b25565b90506000815111610b885760405180602001604052806000815250610713565b80610b9284610dee565b604051602001610ba3929190611269565b6040516020818303038152906040529392505050565b80546001019055565b6001600160a01b038216610be85760405162461bcd60e51b815260040161035d906115d1565b610bf1816107d2565b15610c0e5760405162461bcd60e51b815260040161035d9061139f565b610c1a60008383610415565b6001600160a01b0382166000908152600360205260408120805460019290610c4390849061180b565b909155505060008181526002602052604080822080546001600160a01b0319166001600160a01b038616908117909155905183929060008051602061193d833981519152908290a45050565b610c98826107d2565b610cb45760405162461bcd60e51b815260040161035d90611583565b6000828152600660209081526040909120825161041592840190610f0e565b6000610ce7846001600160a01b0316610f08565b15610de357836001600160a01b031663150b7a02610d036107ef565b8786866040518563ffffffff1660e01b8152600401610d2594939291906112ac565b602060405180830381600087803b158015610d3f57600080fd5b505af1925050508015610d6f575060408051601f3d908101601f19168201909252610d6c91810190611209565b60015b610dc9573d808015610d9d576040519150601f19603f3d011682016040523d82523d6000602084013e610da2565b606091505b508051610dc15760405162461bcd60e51b815260040161035d90611307565b805181602001fd5b6001600160e01b031916630a85bd0160e11b1490506106dd565b506001949350505050565b606081610e1357506040805180820190915260018152600360fc1b602082015261029f565b8160005b8115610e3d5780610e27816118b5565b9150610e369050600a83611823565b9150610e17565b6000816001600160401b03811115610e6557634e487b7160e01b600052604160045260246000fd5b6040519080825280601f01601f191660200182016040528015610e8f576020820181803683370190505b5090505b84156106dd57610ea4600183611837565b9150610eb1600a866118d0565b610ebc90603061180b565b60f81b818381518110610edf57634e487b7160e01b600052603260045260246000fd5b60200101906001600160f81b031916908160001a905350610f01600a86611823565b9450610e93565b3b151590565b828054610f1a9061187a565b90600052602060002090601f016020900481019282610f3c5760008555610f82565b82601f10610f5557805160ff1916838001178555610f82565b82800160010185558215610f82579182015b82811115610f82578251825591602001919060010190610f67565b50610f8e929150610f92565b5090565b5b80821115610f8e5760008155600101610f93565b60006001600160401b0380841115610fc157610fc1611910565b604051601f8501601f191681016020018281118282101715610fe557610fe5611910565b604052848152915081838501861015610ffd57600080fd5b8484602083013760006020868301015250509392505050565b80356001600160a01b038116811461029f57600080fd5b60006020828403121561103e578081fd5b61071382611016565b60008060408385031215611059578081fd5b61106283611016565b915061107060208401611016565b90509250929050565b60008060006060848603121561108d578081fd5b61109684611016565b92506110a460208501611016565b9150604084013590509250925092565b600080600080608085870312156110c9578081fd5b6110d285611016565b93506110e060208601611016565b92506040850135915060608501356001600160401b03811115611101578182fd5b8501601f81018713611111578182fd5b61112087823560208401610fa7565b91505092959194509250565b6000806040838503121561113e578182fd5b61114783611016565b91506020830135801515811461115b578182fd5b809150509250929050565b60008060408385031215611178578182fd5b61118183611016565b915060208301356001600160401b0381111561119b578182fd5b8301601f810185136111ab578182fd5b6111ba85823560208401610fa7565b9150509250929050565b600080604083850312156111d6578182fd5b6111df83611016565b946020939093013593505050565b6000602082840312156111fe578081fd5b813561071381611926565b60006020828403121561121a578081fd5b815161071381611926565b600060208284031215611236578081fd5b5035919050565b6000815180845261125581602086016020860161184e565b601f01601f19169290920160200192915050565b6000835161127b81846020880161184e565b83519083019061128f81836020880161184e565b01949350505050565b6001600160a01b0391909116815260200190565b6001600160a01b03858116825284166020820152604081018390526080606082018190526000906112df9083018461123d565b9695505050505050565b901515815260200190565b600060208252610713602083018461123d565b60208082526032908201527f4552433732313a207472616e7366657220746f206e6f6e20455243373231526560408201527131b2b4bb32b91034b6b83632b6b2b73a32b960711b606082015260800190565b60208082526026908201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160408201526564647265737360d01b606082015260800190565b6020808252601c908201527b115490cdcc8c4e881d1bdad95b88185b1c9958591e481b5a5b9d195960221b604082015260600190565b60208082526024908201527f4552433732313a207472616e7366657220746f20746865207a65726f206164646040820152637265737360e01b606082015260800190565b60208082526019908201527822a9219b99189d1030b8383937bb32903a379031b0b63632b960391b604082015260600190565b6020808252602c908201527f4552433732313a206f70657261746f7220717565727920666f72206e6f6e657860408201526b34b9ba32b73a103a37b5b2b760a11b606082015260800190565b60208082526038908201527f4552433732313a20617070726f76652063616c6c6572206973206e6f74206f776040820152771b995c881b9bdc88185c1c1c9bdd995908199bdc88185b1b60421b606082015260800190565b6020808252602a908201527f4552433732313a2062616c616e636520717565727920666f7220746865207a65604082015269726f206164647265737360b01b606082015260800190565b60208082526029908201527f4552433732313a206f776e657220717565727920666f72206e6f6e657869737460408201526832b73a103a37b5b2b760b91b606082015260800190565b6020808252602e908201527f45524337323155524953746f726167653a2055524920736574206f66206e6f6e60408201526d32bc34b9ba32b73a103a37b5b2b760911b606082015260800190565b6020808252818101527f4552433732313a206d696e7420746f20746865207a65726f2061646472657373604082015260600190565b60208082526031908201527f45524337323155524953746f726167653a2055524920717565727920666f72206040820152703737b732bc34b9ba32b73a103a37b5b2b760791b606082015260800190565b6020808252602c908201527f4552433732313a20617070726f76656420717565727920666f72206e6f6e657860408201526b34b9ba32b73a103a37b5b2b760a11b606082015260800190565b6020808252818101527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e6572604082015260600190565b60208082526029908201527f4552433732313a207472616e73666572206f6620746f6b656e2074686174206960408201526839903737ba1037bbb760b91b606082015260800190565b6020808252602f908201527f4552433732314d657461646174613a2055524920717565727920666f72206e6f60408201526e3732bc34b9ba32b73a103a37b5b2b760891b606082015260800190565b60208082526021908201527f4552433732313a20617070726f76616c20746f2063757272656e74206f776e656040820152603960f91b606082015260800190565b60208082526031908201527f4552433732313a207472616e736665722063616c6c6572206973206e6f74206f6040820152701ddb995c881b9bdc88185c1c1c9bdd9959607a1b606082015260800190565b90815260200190565b6000821982111561181e5761181e6118e4565b500190565b600082611832576118326118fa565b500490565b600082821015611849576118496118e4565b500390565b60005b83811015611869578181015183820152602001611851565b838111156105be5750506000910152565b60028104600182168061188e57607f821691505b602082108114156118af57634e487b7160e01b600052602260045260246000fd5b50919050565b60006000198214156118c9576118c96118e4565b5060010190565b6000826118df576118df6118fa565b500690565b634e487b7160e01b600052601160045260246000fd5b634e487b7160e01b600052601260045260246000fd5b634e487b7160e01b600052604160045260246000fd5b6001600160e01b0319811681146107b657600080fdfeddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3efa2646970667358221220ffe750039cd06e250896585c7ab0ab482a45f37bddc38bb61c0196d0dc2408b564736f6c63430008000033";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_GETAPPROVED = "getApproved";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_OWNEROF = "ownerOf";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_safeTransferFrom = "safeTransferFrom";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOKENURI = "tokenURI";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_USER = "user";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_MINT = "mint";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("13691", "0xa50a51c09a5c451C52BB714527E1974b686D8e77");
    }

    @Deprecated
    protected MyERC721(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MyERC721(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MyERC721(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MyERC721(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
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
                typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public List<ApprovalForAllEventResponse> getApprovalForAllEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVALFORALL_EVENT, transactionReceipt);
        ArrayList<ApprovalForAllEventResponse> responses = new ArrayList<ApprovalForAllEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ApprovalForAllEventResponse>() {
            @Override
            public ApprovalForAllEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVALFORALL_EVENT, log);
                ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVALFORALL_EVENT));
        return approvalForAllEventFlowable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
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
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String to, BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getApproved(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETAPPROVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> isApprovedForAll(String owner, String operator) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISAPPROVEDFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner), 
                new org.web3j.abi.datatypes.Address(operator)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> name() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> ownerOf(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNEROF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_safeTransferFrom, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId, byte[] _data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_safeTransferFrom, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setApprovalForAll(String operator, Boolean approved) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETAPPROVALFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(operator), 
                new org.web3j.abi.datatypes.Bool(approved)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> symbol() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> tokenURI(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOKENURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String from, String to, BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> user() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_USER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalSupply() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> mint(String marketplaceUser, String tokenURI) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(marketplaceUser), 
                new org.web3j.abi.datatypes.Utf8String(tokenURI)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static MyERC721 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyERC721(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MyERC721 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyERC721(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MyERC721 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MyERC721(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MyERC721 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MyERC721(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MyERC721> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MyERC721.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<MyERC721> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MyERC721.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MyERC721> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MyERC721.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MyERC721> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MyERC721.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String approved;

        public BigInteger tokenId;
    }

    public static class ApprovalForAllEventResponse extends BaseEventResponse {
        public String owner;

        public String operator;

        public Boolean approved;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger tokenId;
    }
}
