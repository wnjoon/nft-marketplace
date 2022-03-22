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
import org.web3j.abi.datatypes.StaticStruct;
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
public class VoucherToken extends Contract {
    public static final String BINARY = "0x60806040523480156200001157600080fd5b50604080518082018252601681527f41727420776f726b20566f756368657220546f6b656e00000000000000000000602080830191825283518085019094526007845266417274776f726b60c81b90840152815191929162000076916000916200010a565b5080516200008c9060019060208401906200010a565b505050620000a9620000a3620000b460201b60201c565b620000b8565b600a600955620001ed565b3390565b600780546001600160a01b038381166001600160a01b0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b8280546200011890620001b0565b90600052602060002090601f0160209004810192826200013c576000855562000187565b82601f106200015757805160ff191683800117855562000187565b8280016001018555821562000187579182015b82811115620001875782518255916020019190600101906200016a565b506200019592915062000199565b5090565b5b808211156200019557600081556001016200019a565b600281046001821680620001c557607f821691505b60208210811415620001e757634e487b7160e01b600052602260045260246000fd5b50919050565b611c3480620001fd6000396000f3fe608060405234801561001057600080fd5b50600436106101075760003560e01c806301ffc9a71461010c57806306fdde0314610135578063081812fc1461014a578063095ea7b31461016a57806318160ddd1461017f57806323b872dd1461019457806342842e0e146101a75780636352211e146101ba57806364044156146101cd57806370a08231146101e0578063715018a6146101f35780638bae4418146101fb5780638da5cb5b1461020e57806395d89b4114610216578063a22cb4651461021e578063a574cea414610231578063b88d4fde14610251578063c87b56dd14610264578063e985e9c514610277578063f2fde38b1461028a578063fd268b451461029d575b600080fd5b61011f61011a366004611423565b6102b0565b60405161012c919061153b565b60405180910390f35b61013d6102f8565b60405161012c9190611546565b61015d61015836600461145b565b61038a565b60405161012c91906114ea565b61017d6101783660046113fa565b6103d6565b005b61018761046e565b60405161012c9190611aa4565b61017d6101a236600461125d565b61047f565b61017d6101b536600461125d565b6104b7565b61015d6101c836600461145b565b6104d2565b61017d6101db36600461125d565b610507565b6101876101ee366004611211565b610575565b61017d6105b9565b610187610209366004611298565b610604565b61015d6107ea565b61013d6107f9565b61017d61022c3660046113c0565b610808565b61024461023f36600461145b565b61081e565b60405161012c9190611a06565b61017d61025f3660046112f5565b61088f565b61013d61027236600461145b565b6108ce565b61011f61028536600461122b565b6109ef565b61017d610298366004611211565b610a1d565b61015d6102ab36600461145b565b610a8e565b60006001600160e01b031982166380ac58cd60e01b14806102e157506001600160e01b03198216635b5e139f60e01b145b806102f057506102f082610aac565b90505b919050565b60606000805461030790611b1c565b80601f016020809104026020016040519081016040528092919081815260200182805461033390611b1c565b80156103805780601f1061035557610100808354040283529160200191610380565b820191906000526020600020905b81548152906001019060200180831161036357829003601f168201915b5050505050905090565b600061039582610ac5565b6103ba5760405162461bcd60e51b81526004016103b19061185b565b60405180910390fd5b506000908152600460205260409020546001600160a01b031690565b60006103e1826104d2565b9050806001600160a01b0316836001600160a01b031614156104155760405162461bcd60e51b81526004016103b190611974565b806001600160a01b0316610427610ae2565b6001600160a01b03161480610443575061044381610285610ae2565b61045f5760405162461bcd60e51b81526004016103b1906116ea565b6104698383610ae6565b505050565b600061047a6008610b54565b905090565b61049061048a610ae2565b82610b58565b6104ac5760405162461bcd60e51b81526004016103b1906119b5565b610469838383610bd5565b6104698383836040518060200160405280600081525061088f565b6000818152600260205260408120546001600160a01b0316806102f05760405162461bcd60e51b81526004016103b19061178c565b61051283838361047f565b80826001600160a01b0316846001600160a01b03167f26c2a1ef1925c0e7d8b03a8493126372284aecf50fe3dc54fe815e43e5cbf883600a60008681526020019081526020016000206040516105689190611a57565b60405180910390a4505050565b60006001600160a01b03821661059d5760405162461bcd60e51b81526004016103b190611742565b506001600160a01b031660009081526003602052604090205490565b6105c1610ae2565b6001600160a01b03166105d26107ea565b6001600160a01b0316146105f85760405162461bcd60e51b81526004016103b1906118a7565b6106026000610cf0565b565b600061060e610ae2565b6001600160a01b031661061f6107ea565b6001600160a01b0316146106455760405162461bcd60e51b81526004016103b1906118a7565b600080866001600160a01b0316866040516024016106639190611aa4565b60408051601f198184030181529181526020820180516001600160e01b03166331a9108f60e11b17905251610698919061149f565b600060405180830381855afa9150503d80600081146106d3576040519150601f19603f3d011682016040523d82523d6000602084013e6106d8565b606091505b5091509150816106e757600080fd5b60006106f282610d42565b90506001600160a01b038116331461070957600080fd5b6107136008610d49565b600061071f6008610b54565b905061072b8a82610d52565b6107336111c5565b6001600160a01b039788168152958716602080880191825292881660408089019182529a891660608901908152608089019a8b5260095460a08a019081526000858152600a9096529b909420975188546001600160a01b0319908116918b1691909117895591516001890180548416918b16919091179055516002880180548316918a1691909117905591516003870180549093169716969096179055505092516004820155925160059093019290925550919050565b6007546001600160a01b031690565b60606001805461030790611b1c565b61081a610813610ae2565b8383610e1f565b5050565b6108266111c5565b506000908152600a6020908152604091829020825160c08101845281546001600160a01b0390811682526001830154811693820193909352600282015483169381019390935260038101549091166060830152600481015460808301526005015460a082015290565b6108a061089a610ae2565b83610b58565b6108bc5760405162461bcd60e51b81526004016103b1906119b5565b6108c884848484610ec2565b50505050565b60606108d982610ac5565b6108f55760405162461bcd60e51b81526004016103b19061180a565b6000828152600660205260408120805461090e90611b1c565b80601f016020809104026020016040519081016040528092919081815260200182805461093a90611b1c565b80156109875780601f1061095c57610100808354040283529160200191610987565b820191906000526020600020905b81548152906001019060200180831161096a57829003601f168201915b505050505090506000610998610ef5565b90508051600014156109ac575090506102f3565b8151156109de5780826040516020016109c69291906114bb565b604051602081830303815290604052925050506102f3565b6109e784610f07565b949350505050565b6001600160a01b03918216600090815260056020908152604080832093909416825291909152205460ff1690565b610a25610ae2565b6001600160a01b0316610a366107ea565b6001600160a01b031614610a5c5760405162461bcd60e51b81526004016103b1906118a7565b6001600160a01b038116610a825760405162461bcd60e51b81526004016103b1906115ab565b610a8b81610cf0565b50565b6000908152600a60205260409020600201546001600160a01b031690565b6001600160e01b031981166301ffc9a760e01b14919050565b6000908152600260205260409020546001600160a01b0316151590565b3390565b600081815260046020526040902080546001600160a01b0319166001600160a01b0384169081179091558190610b1b826104d2565b6001600160a01b03167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92560405160405180910390a45050565b5490565b6000610b6382610ac5565b610b7f5760405162461bcd60e51b81526004016103b19061169e565b6000610b8a836104d2565b9050806001600160a01b0316846001600160a01b03161480610bc55750836001600160a01b0316610bba8461038a565b6001600160a01b0316145b806109e757506109e781856109ef565b826001600160a01b0316610be8826104d2565b6001600160a01b031614610c0e5760405162461bcd60e51b81526004016103b1906118dc565b6001600160a01b038216610c345760405162461bcd60e51b81526004016103b190611627565b610c3f838383610469565b610c4a600082610ae6565b6001600160a01b0383166000908152600360205260408120805460019290610c73908490611ad9565b90915550506001600160a01b0382166000908152600360205260408120805460019290610ca1908490611aad565b909155505060008181526002602052604080822080546001600160a01b0319166001600160a01b038681169182179092559151849391871691600080516020611bdf83398151915291a4505050565b600780546001600160a01b038381166001600160a01b0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b6020015190565b80546001019055565b6001600160a01b038216610d785760405162461bcd60e51b81526004016103b1906117d5565b610d8181610ac5565b15610d9e5760405162461bcd60e51b81526004016103b1906115f1565b610daa60008383610469565b6001600160a01b0382166000908152600360205260408120805460019290610dd3908490611aad565b909155505060008181526002602052604080822080546001600160a01b0319166001600160a01b0386169081179091559051839290600080516020611bdf833981519152908290a45050565b816001600160a01b0316836001600160a01b03161415610e515760405162461bcd60e51b81526004016103b19061166b565b6001600160a01b0383811660008181526005602090815260408083209487168084529490915290819020805460ff1916851515179055517f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c3190610eb590859061153b565b60405180910390a3505050565b610ecd848484610bd5565b610ed984848484610f8a565b6108c85760405162461bcd60e51b81526004016103b190611559565b60408051602081019091526000815290565b6060610f1282610ac5565b610f2e5760405162461bcd60e51b81526004016103b190611925565b6000610f38610ef5565b90506000815111610f585760405180602001604052806000815250610f83565b80610f62846110a5565b604051602001610f739291906114bb565b6040516020818303038152906040525b9392505050565b6000610f9e846001600160a01b03166111bf565b1561109a57836001600160a01b031663150b7a02610fba610ae2565b8786866040518563ffffffff1660e01b8152600401610fdc94939291906114fe565b602060405180830381600087803b158015610ff657600080fd5b505af1925050508015611026575060408051601f3d908101601f191682019092526110239181019061143f565b60015b611080573d808015611054576040519150601f19603f3d011682016040523d82523d6000602084013e611059565b606091505b5080516110785760405162461bcd60e51b81526004016103b190611559565b805181602001fd5b6001600160e01b031916630a85bd0160e11b1490506109e7565b506001949350505050565b6060816110ca57506040805180820190915260018152600360fc1b60208201526102f3565b8160005b81156110f457806110de81611b57565b91506110ed9050600a83611ac5565b91506110ce565b6000816001600160401b0381111561111c57634e487b7160e01b600052604160045260246000fd5b6040519080825280601f01601f191660200182016040528015611146576020820181803683370190505b5090505b84156109e75761115b600183611ad9565b9150611168600a86611b72565b611173906030611aad565b60f81b81838151811061119657634e487b7160e01b600052603260045260246000fd5b60200101906001600160f81b031916908160001a9053506111b8600a86611ac5565b945061114a565b3b151590565b6040805160c081018252600080825260208201819052918101829052606081018290526080810182905260a081019190915290565b80356001600160a01b03811681146102f357600080fd5b600060208284031215611222578081fd5b610f83826111fa565b6000806040838503121561123d578081fd5b611246836111fa565b9150611254602084016111fa565b90509250929050565b600080600060608486031215611271578081fd5b61127a846111fa565b9250611288602085016111fa565b9150604084013590509250925092565b600080600080600060a086880312156112af578081fd5b6112b8866111fa565b94506112c6602087016111fa565b9350604086013592506112db606087016111fa565b91506112e9608087016111fa565b90509295509295909350565b6000806000806080858703121561130a578384fd5b611313856111fa565b935060206113228187016111fa565b93506040860135925060608601356001600160401b0380821115611344578384fd5b818801915088601f830112611357578384fd5b81358181111561136957611369611bb2565b604051601f8201601f191681018501838111828210171561138c5761138c611bb2565b60405281815283820185018b10156113a2578586fd5b81858501868301379081019093019390935250939692955090935050565b600080604083850312156113d2578182fd5b6113db836111fa565b9150602083013580151581146113ef578182fd5b809150509250929050565b6000806040838503121561140c578182fd5b611415836111fa565b946020939093013593505050565b600060208284031215611434578081fd5b8135610f8381611bc8565b600060208284031215611450578081fd5b8151610f8381611bc8565b60006020828403121561146c578081fd5b5035919050565b6000815180845261148b816020860160208601611af0565b601f01601f19169290920160200192915050565b600082516114b1818460208701611af0565b9190910192915050565b600083516114cd818460208801611af0565b8351908301906114e1818360208801611af0565b01949350505050565b6001600160a01b0391909116815260200190565b6001600160a01b038581168252841660208201526040810183905260806060820181905260009061153190830184611473565b9695505050505050565b901515815260200190565b600060208252610f836020830184611473565b60208082526032908201527f4552433732313a207472616e7366657220746f206e6f6e20455243373231526560408201527131b2b4bb32b91034b6b83632b6b2b73a32b960711b606082015260800190565b60208082526026908201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160408201526564647265737360d01b606082015260800190565b6020808252601c908201527b115490cdcc8c4e881d1bdad95b88185b1c9958591e481b5a5b9d195960221b604082015260600190565b60208082526024908201527f4552433732313a207472616e7366657220746f20746865207a65726f206164646040820152637265737360e01b606082015260800190565b60208082526019908201527822a9219b99189d1030b8383937bb32903a379031b0b63632b960391b604082015260600190565b6020808252602c908201527f4552433732313a206f70657261746f7220717565727920666f72206e6f6e657860408201526b34b9ba32b73a103a37b5b2b760a11b606082015260800190565b60208082526038908201527f4552433732313a20617070726f76652063616c6c6572206973206e6f74206f776040820152771b995c881b9bdc88185c1c1c9bdd995908199bdc88185b1b60421b606082015260800190565b6020808252602a908201527f4552433732313a2062616c616e636520717565727920666f7220746865207a65604082015269726f206164647265737360b01b606082015260800190565b60208082526029908201527f4552433732313a206f776e657220717565727920666f72206e6f6e657869737460408201526832b73a103a37b5b2b760b91b606082015260800190565b6020808252818101527f4552433732313a206d696e7420746f20746865207a65726f2061646472657373604082015260600190565b60208082526031908201527f45524337323155524953746f726167653a2055524920717565727920666f72206040820152703737b732bc34b9ba32b73a103a37b5b2b760791b606082015260800190565b6020808252602c908201527f4552433732313a20617070726f76656420717565727920666f72206e6f6e657860408201526b34b9ba32b73a103a37b5b2b760a11b606082015260800190565b6020808252818101527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e6572604082015260600190565b60208082526029908201527f4552433732313a207472616e73666572206f6620746f6b656e2074686174206960408201526839903737ba1037bbb760b91b606082015260800190565b6020808252602f908201527f4552433732314d657461646174613a2055524920717565727920666f72206e6f60408201526e3732bc34b9ba32b73a103a37b5b2b760891b606082015260800190565b60208082526021908201527f4552433732313a20617070726f76616c20746f2063757272656e74206f776e656040820152603960f91b606082015260800190565b60208082526031908201527f4552433732313a207472616e736665722063616c6c6572206973206e6f74206f6040820152701ddb995c881b9bdc88185c1c1c9bdd9959607a1b606082015260800190565b81516001600160a01b039081168252602080840151821690830152604080840151821690830152606080840151909116908201526080808301519082015260a0918201519181019190915260c00190565b81546001600160a01b03908116825260018301548116602083015260028301548116604083015260038301541660608201526004820154608082015260059091015460a082015260c00190565b90815260200190565b60008219821115611ac057611ac0611b86565b500190565b600082611ad457611ad4611b9c565b500490565b600082821015611aeb57611aeb611b86565b500390565b60005b83811015611b0b578181015183820152602001611af3565b838111156108c85750506000910152565b600281046001821680611b3057607f821691505b60208210811415611b5157634e487b7160e01b600052602260045260246000fd5b50919050565b6000600019821415611b6b57611b6b611b86565b5060010190565b600082611b8157611b81611b9c565b500690565b634e487b7160e01b600052601160045260246000fd5b634e487b7160e01b600052601260045260246000fd5b634e487b7160e01b600052604160045260246000fd5b6001600160e01b031981168114610a8b57600080fdfeddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3efa2646970667358221220a606187d005ca4acbf9065850afd5f068b5b7fbe340e4c0b3870b39c6b8a183564736f6c63430008000033";

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

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_PURCHASE = "purchase";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_GETMETADATA = "getMetadata";

    public static final String FUNC_GETVOUCHERTOKENOWNER = "getVoucherTokenOwner";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event PURCHASE_EVENT = new Event("Purchase", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Metadata>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("13691", "0x4261D524bc701dA4AC49339e5F8b299977045eA5");
    }

    @Deprecated
    protected VoucherToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected VoucherToken(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected VoucherToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected VoucherToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public List<PurchaseEventResponse> getPurchaseEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PURCHASE_EVENT, transactionReceipt);
        ArrayList<PurchaseEventResponse> responses = new ArrayList<PurchaseEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PurchaseEventResponse typedResponse = new PurchaseEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse._metadata = (Metadata) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PurchaseEventResponse> purchaseEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PurchaseEventResponse>() {
            @Override
            public PurchaseEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PURCHASE_EVENT, log);
                PurchaseEventResponse typedResponse = new PurchaseEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                typedResponse._metadata = (Metadata) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<PurchaseEventResponse> purchaseEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PURCHASE_EVENT));
        return purchaseEventFlowable(filter);
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

    public RemoteFunctionCall<BigInteger> totalSupply() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> purchase(String seller, String buyer, BigInteger voucherTokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PURCHASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(seller), 
                new org.web3j.abi.datatypes.Address(buyer), 
                new org.web3j.abi.datatypes.generated.Uint256(voucherTokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> mint(String _to, String _artworkAddress, BigInteger _artworkId, String _startDate, String _endDate) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.Address(_artworkAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_artworkId), 
                new org.web3j.abi.datatypes.Address(_startDate), 
                new org.web3j.abi.datatypes.Address(_endDate)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Metadata> getMetadata(BigInteger _tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETMETADATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Metadata>() {}));
        return executeRemoteCallSingleValueReturn(function, Metadata.class);
    }

    public RemoteFunctionCall<String> getVoucherTokenOwner(BigInteger _tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETVOUCHERTOKENOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static VoucherToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new VoucherToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static VoucherToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new VoucherToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static VoucherToken load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new VoucherToken(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static VoucherToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new VoucherToken(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<VoucherToken> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(VoucherToken.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<VoucherToken> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(VoucherToken.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<VoucherToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(VoucherToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<VoucherToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(VoucherToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class Metadata extends StaticStruct {
        public String startDate;

        public String endDate;

        public String tokenOwner;

        public String artworkAddress;

        public BigInteger artworkId;

        public BigInteger usageFeeRate;

        public Metadata(String startDate, String endDate, String tokenOwner, String artworkAddress, BigInteger artworkId, BigInteger usageFeeRate) {
            super(new org.web3j.abi.datatypes.Address(startDate),new org.web3j.abi.datatypes.Address(endDate),new org.web3j.abi.datatypes.Address(tokenOwner),new org.web3j.abi.datatypes.Address(artworkAddress),new org.web3j.abi.datatypes.generated.Uint256(artworkId),new org.web3j.abi.datatypes.generated.Uint256(usageFeeRate));
            this.startDate = startDate;
            this.endDate = endDate;
            this.tokenOwner = tokenOwner;
            this.artworkAddress = artworkAddress;
            this.artworkId = artworkId;
            this.usageFeeRate = usageFeeRate;
        }

        public Metadata(Address startDate, Address endDate, Address tokenOwner, Address artworkAddress, Uint256 artworkId, Uint256 usageFeeRate) {
            super(startDate,endDate,tokenOwner,artworkAddress,artworkId,usageFeeRate);
            this.startDate = startDate.getValue();
            this.endDate = endDate.getValue();
            this.tokenOwner = tokenOwner.getValue();
            this.artworkAddress = artworkAddress.getValue();
            this.artworkId = artworkId.getValue();
            this.usageFeeRate = usageFeeRate.getValue();
        }
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

    public static class PurchaseEventResponse extends BaseEventResponse {
        public String _from;

        public String _to;

        public BigInteger _tokenId;

        public Metadata _metadata;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger tokenId;
    }
}
