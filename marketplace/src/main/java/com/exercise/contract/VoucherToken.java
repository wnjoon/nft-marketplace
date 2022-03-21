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
    public static final String BINARY = "0x60806040523480156200001157600080fd5b50604080518082018252601681527f41727420776f726b20566f756368657220546f6b656e00000000000000000000602080830191825283518085019094526007845266417274776f726b60c81b90840152815191929162000076916000916200010a565b5080516200008c9060019060208401906200010a565b505050620000a9620000a3620000b460201b60201c565b620000b8565b600a600955620001ed565b3390565b600780546001600160a01b038381166001600160a01b0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b8280546200011890620001b0565b90600052602060002090601f0160209004810192826200013c576000855562000187565b82601f106200015757805160ff191683800117855562000187565b8280016001018555821562000187579182015b82811115620001875782518255916020019190600101906200016a565b506200019592915062000199565b5090565b5b808211156200019557600081556001016200019a565b600281046001821680620001c557607f821691505b60208210811415620001e757634e487b7160e01b600052602260045260246000fd5b50919050565b611bfb80620001fd6000396000f3fe608060405234801561001057600080fd5b50600436106100fc5760003560e01c806301ffc9a71461010157806306fdde031461012a578063081812fc1461013f578063095ea7b31461015f57806323b872dd1461017457806342842e0e146101875780636352211e1461019a57806364044156146101ad57806370a08231146101c0578063715018a6146101e05780638bae4418146101e85780638da5cb5b146101fb57806395d89b4114610203578063a22cb4651461020b578063a574cea41461021e578063b88d4fde1461023e578063c87b56dd14610251578063e985e9c514610264578063f2fde38b14610277578063fd268b451461028a575b600080fd5b61011461010f3660046113ea565b61029d565b6040516101219190611502565b60405180910390f35b6101326102e5565b604051610121919061150d565b61015261014d366004611422565b610377565b60405161012191906114b1565b61017261016d3660046113c1565b6103c3565b005b610172610182366004611224565b61045b565b610172610195366004611224565b610493565b6101526101a8366004611422565b6104ae565b6101726101bb366004611224565b6104e3565b6101d36101ce3660046111d8565b610551565b6040516101219190611a6b565b610172610595565b6101d36101f636600461125f565b6105e0565b6101526107b1565b6101326107c0565b610172610219366004611387565b6107cf565b61023161022c366004611422565b6107e5565b60405161012191906119cd565b61017261024c3660046112bc565b610856565b61013261025f366004611422565b610895565b6101146102723660046111f2565b6109b6565b6101726102853660046111d8565b6109e4565b610152610298366004611422565b610a55565b60006001600160e01b031982166380ac58cd60e01b14806102ce57506001600160e01b03198216635b5e139f60e01b145b806102dd57506102dd82610a73565b90505b919050565b6060600080546102f490611ae3565b80601f016020809104026020016040519081016040528092919081815260200182805461032090611ae3565b801561036d5780601f106103425761010080835404028352916020019161036d565b820191906000526020600020905b81548152906001019060200180831161035057829003601f168201915b5050505050905090565b600061038282610a8c565b6103a75760405162461bcd60e51b815260040161039e90611822565b60405180910390fd5b506000908152600460205260409020546001600160a01b031690565b60006103ce826104ae565b9050806001600160a01b0316836001600160a01b031614156104025760405162461bcd60e51b815260040161039e9061193b565b806001600160a01b0316610414610aa9565b6001600160a01b03161480610430575061043081610272610aa9565b61044c5760405162461bcd60e51b815260040161039e906116b1565b6104568383610aad565b505050565b61046c610466610aa9565b82610b1b565b6104885760405162461bcd60e51b815260040161039e9061197c565b610456838383610b98565b61045683838360405180602001604052806000815250610856565b6000818152600260205260408120546001600160a01b0316806102dd5760405162461bcd60e51b815260040161039e90611753565b6104ee83838361045b565b80826001600160a01b0316846001600160a01b03167f26c2a1ef1925c0e7d8b03a8493126372284aecf50fe3dc54fe815e43e5cbf883600a60008681526020019081526020016000206040516105449190611a1e565b60405180910390a4505050565b60006001600160a01b0382166105795760405162461bcd60e51b815260040161039e90611709565b506001600160a01b031660009081526003602052604090205490565b61059d610aa9565b6001600160a01b03166105ae6107b1565b6001600160a01b0316146105d45760405162461bcd60e51b815260040161039e9061186e565b6105de6000610cb3565b565b60006105ea610aa9565b6001600160a01b03166105fb6107b1565b6001600160a01b0316146106215760405162461bcd60e51b815260040161039e9061186e565b600080866001600160a01b03168660405160240161063f9190611a6b565b60408051601f198184030181529181526020820180516001600160e01b03166331a9108f60e11b179052516106749190611466565b600060405180830381855afa9150503d80600081146106af576040519150601f19603f3d011682016040523d82523d6000602084013e6106b4565b606091505b5091509150816106c357600080fd5b60006106ce82610d05565b90506106da6008610d0c565b60006106e66008610d15565b90506106f28a82610d19565b6106fa61118c565b6001600160a01b039788168152958716602080880191825292881660408089019182529a891660608901908152608089019a8b5260095460a08a019081526000858152600a9096529b909420975188546001600160a01b0319908116918b1691909117895591516001890180548416918b16919091179055516002880180548316918a1691909117905591516003870180549093169716969096179055505092516004820155925160059093019290925550919050565b6007546001600160a01b031690565b6060600180546102f490611ae3565b6107e16107da610aa9565b8383610de6565b5050565b6107ed61118c565b506000908152600a6020908152604091829020825160c08101845281546001600160a01b0390811682526001830154811693820193909352600282015483169381019390935260038101549091166060830152600481015460808301526005015460a082015290565b610867610861610aa9565b83610b1b565b6108835760405162461bcd60e51b815260040161039e9061197c565b61088f84848484610e89565b50505050565b60606108a082610a8c565b6108bc5760405162461bcd60e51b815260040161039e906117d1565b600082815260066020526040812080546108d590611ae3565b80601f016020809104026020016040519081016040528092919081815260200182805461090190611ae3565b801561094e5780601f106109235761010080835404028352916020019161094e565b820191906000526020600020905b81548152906001019060200180831161093157829003601f168201915b50505050509050600061095f610ebc565b9050805160001415610973575090506102e0565b8151156109a557808260405160200161098d929190611482565b604051602081830303815290604052925050506102e0565b6109ae84610ece565b949350505050565b6001600160a01b03918216600090815260056020908152604080832093909416825291909152205460ff1690565b6109ec610aa9565b6001600160a01b03166109fd6107b1565b6001600160a01b031614610a235760405162461bcd60e51b815260040161039e9061186e565b6001600160a01b038116610a495760405162461bcd60e51b815260040161039e90611572565b610a5281610cb3565b50565b6000908152600a60205260409020600201546001600160a01b031690565b6001600160e01b031981166301ffc9a760e01b14919050565b6000908152600260205260409020546001600160a01b0316151590565b3390565b600081815260046020526040902080546001600160a01b0319166001600160a01b0384169081179091558190610ae2826104ae565b6001600160a01b03167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92560405160405180910390a45050565b6000610b2682610a8c565b610b425760405162461bcd60e51b815260040161039e90611665565b6000610b4d836104ae565b9050806001600160a01b0316846001600160a01b03161480610b885750836001600160a01b0316610b7d84610377565b6001600160a01b0316145b806109ae57506109ae81856109b6565b826001600160a01b0316610bab826104ae565b6001600160a01b031614610bd15760405162461bcd60e51b815260040161039e906118a3565b6001600160a01b038216610bf75760405162461bcd60e51b815260040161039e906115ee565b610c02838383610456565b610c0d600082610aad565b6001600160a01b0383166000908152600360205260408120805460019290610c36908490611aa0565b90915550506001600160a01b0382166000908152600360205260408120805460019290610c64908490611a74565b909155505060008181526002602052604080822080546001600160a01b0319166001600160a01b038681169182179092559151849391871691600080516020611ba683398151915291a4505050565b600780546001600160a01b038381166001600160a01b0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b6020015190565b80546001019055565b5490565b6001600160a01b038216610d3f5760405162461bcd60e51b815260040161039e9061179c565b610d4881610a8c565b15610d655760405162461bcd60e51b815260040161039e906115b8565b610d7160008383610456565b6001600160a01b0382166000908152600360205260408120805460019290610d9a908490611a74565b909155505060008181526002602052604080822080546001600160a01b0319166001600160a01b0386169081179091559051839290600080516020611ba6833981519152908290a45050565b816001600160a01b0316836001600160a01b03161415610e185760405162461bcd60e51b815260040161039e90611632565b6001600160a01b0383811660008181526005602090815260408083209487168084529490915290819020805460ff1916851515179055517f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c3190610e7c908590611502565b60405180910390a3505050565b610e94848484610b98565b610ea084848484610f51565b61088f5760405162461bcd60e51b815260040161039e90611520565b60408051602081019091526000815290565b6060610ed982610a8c565b610ef55760405162461bcd60e51b815260040161039e906118ec565b6000610eff610ebc565b90506000815111610f1f5760405180602001604052806000815250610f4a565b80610f298461106c565b604051602001610f3a929190611482565b6040516020818303038152906040525b9392505050565b6000610f65846001600160a01b0316611186565b1561106157836001600160a01b031663150b7a02610f81610aa9565b8786866040518563ffffffff1660e01b8152600401610fa394939291906114c5565b602060405180830381600087803b158015610fbd57600080fd5b505af1925050508015610fed575060408051601f3d908101601f19168201909252610fea91810190611406565b60015b611047573d80801561101b576040519150601f19603f3d011682016040523d82523d6000602084013e611020565b606091505b50805161103f5760405162461bcd60e51b815260040161039e90611520565b805181602001fd5b6001600160e01b031916630a85bd0160e11b1490506109ae565b506001949350505050565b60608161109157506040805180820190915260018152600360fc1b60208201526102e0565b8160005b81156110bb57806110a581611b1e565b91506110b49050600a83611a8c565b9150611095565b6000816001600160401b038111156110e357634e487b7160e01b600052604160045260246000fd5b6040519080825280601f01601f19166020018201604052801561110d576020820181803683370190505b5090505b84156109ae57611122600183611aa0565b915061112f600a86611b39565b61113a906030611a74565b60f81b81838151811061115d57634e487b7160e01b600052603260045260246000fd5b60200101906001600160f81b031916908160001a90535061117f600a86611a8c565b9450611111565b3b151590565b6040805160c081018252600080825260208201819052918101829052606081018290526080810182905260a081019190915290565b80356001600160a01b03811681146102e057600080fd5b6000602082840312156111e9578081fd5b610f4a826111c1565b60008060408385031215611204578081fd5b61120d836111c1565b915061121b602084016111c1565b90509250929050565b600080600060608486031215611238578081fd5b611241846111c1565b925061124f602085016111c1565b9150604084013590509250925092565b600080600080600060a08688031215611276578081fd5b61127f866111c1565b945061128d602087016111c1565b9350604086013592506112a2606087016111c1565b91506112b0608087016111c1565b90509295509295909350565b600080600080608085870312156112d1578384fd5b6112da856111c1565b935060206112e98187016111c1565b93506040860135925060608601356001600160401b038082111561130b578384fd5b818801915088601f83011261131e578384fd5b81358181111561133057611330611b79565b604051601f8201601f191681018501838111828210171561135357611353611b79565b60405281815283820185018b1015611369578586fd5b81858501868301379081019093019390935250939692955090935050565b60008060408385031215611399578182fd5b6113a2836111c1565b9150602083013580151581146113b6578182fd5b809150509250929050565b600080604083850312156113d3578182fd5b6113dc836111c1565b946020939093013593505050565b6000602082840312156113fb578081fd5b8135610f4a81611b8f565b600060208284031215611417578081fd5b8151610f4a81611b8f565b600060208284031215611433578081fd5b5035919050565b60008151808452611452816020860160208601611ab7565b601f01601f19169290920160200192915050565b60008251611478818460208701611ab7565b9190910192915050565b60008351611494818460208801611ab7565b8351908301906114a8818360208801611ab7565b01949350505050565b6001600160a01b0391909116815260200190565b6001600160a01b03858116825284166020820152604081018390526080606082018190526000906114f89083018461143a565b9695505050505050565b901515815260200190565b600060208252610f4a602083018461143a565b60208082526032908201527f4552433732313a207472616e7366657220746f206e6f6e20455243373231526560408201527131b2b4bb32b91034b6b83632b6b2b73a32b960711b606082015260800190565b60208082526026908201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160408201526564647265737360d01b606082015260800190565b6020808252601c908201527b115490cdcc8c4e881d1bdad95b88185b1c9958591e481b5a5b9d195960221b604082015260600190565b60208082526024908201527f4552433732313a207472616e7366657220746f20746865207a65726f206164646040820152637265737360e01b606082015260800190565b60208082526019908201527822a9219b99189d1030b8383937bb32903a379031b0b63632b960391b604082015260600190565b6020808252602c908201527f4552433732313a206f70657261746f7220717565727920666f72206e6f6e657860408201526b34b9ba32b73a103a37b5b2b760a11b606082015260800190565b60208082526038908201527f4552433732313a20617070726f76652063616c6c6572206973206e6f74206f776040820152771b995c881b9bdc88185c1c1c9bdd995908199bdc88185b1b60421b606082015260800190565b6020808252602a908201527f4552433732313a2062616c616e636520717565727920666f7220746865207a65604082015269726f206164647265737360b01b606082015260800190565b60208082526029908201527f4552433732313a206f776e657220717565727920666f72206e6f6e657869737460408201526832b73a103a37b5b2b760b91b606082015260800190565b6020808252818101527f4552433732313a206d696e7420746f20746865207a65726f2061646472657373604082015260600190565b60208082526031908201527f45524337323155524953746f726167653a2055524920717565727920666f72206040820152703737b732bc34b9ba32b73a103a37b5b2b760791b606082015260800190565b6020808252602c908201527f4552433732313a20617070726f76656420717565727920666f72206e6f6e657860408201526b34b9ba32b73a103a37b5b2b760a11b606082015260800190565b6020808252818101527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e6572604082015260600190565b60208082526029908201527f4552433732313a207472616e73666572206f6620746f6b656e2074686174206960408201526839903737ba1037bbb760b91b606082015260800190565b6020808252602f908201527f4552433732314d657461646174613a2055524920717565727920666f72206e6f60408201526e3732bc34b9ba32b73a103a37b5b2b760891b606082015260800190565b60208082526021908201527f4552433732313a20617070726f76616c20746f2063757272656e74206f776e656040820152603960f91b606082015260800190565b60208082526031908201527f4552433732313a207472616e736665722063616c6c6572206973206e6f74206f6040820152701ddb995c881b9bdc88185c1c1c9bdd9959607a1b606082015260800190565b81516001600160a01b039081168252602080840151821690830152604080840151821690830152606080840151909116908201526080808301519082015260a0918201519181019190915260c00190565b81546001600160a01b03908116825260018301548116602083015260028301548116604083015260038301541660608201526004820154608082015260059091015460a082015260c00190565b90815260200190565b60008219821115611a8757611a87611b4d565b500190565b600082611a9b57611a9b611b63565b500490565b600082821015611ab257611ab2611b4d565b500390565b60005b83811015611ad2578181015183820152602001611aba565b8381111561088f5750506000910152565b600281046001821680611af757607f821691505b60208210811415611b1857634e487b7160e01b600052602260045260246000fd5b50919050565b6000600019821415611b3257611b32611b4d565b5060010190565b600082611b4857611b48611b63565b500690565b634e487b7160e01b600052601160045260246000fd5b634e487b7160e01b600052601260045260246000fd5b634e487b7160e01b600052604160045260246000fd5b6001600160e01b031981168114610a5257600080fdfeddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3efa26469706673582212207989457c173ac7349fff455e0a09bebbdd7188b48f894f564917eb77bbc8708764736f6c63430008000033";

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
        _addresses.put("13691", "0x9a3DBCa554e9f6b9257aAa24010DA8377C57c17e");
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
