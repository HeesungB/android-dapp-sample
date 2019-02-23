package info.panicrooms.dapp_sample;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
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
 * <p>Generated with web3j version 4.1.1.
 */
public class Mail extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b50610883806100206000396000f3fe608060405260043610610062576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063778e75161461006757806378864351146100d35780637b95f6b8146101ba578063bd875fee146102a1575b600080fd5b34801561007357600080fd5b5061007c610389565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156100bf5780820151818401526020810190506100a4565b505050509050019250505060405180910390f35b3480156100df57600080fd5b5061010c600480360360208110156100f657600080fd5b810190808035906020019092919050505061041e565b604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001828103825283818151815260200191508051906020019080838360005b8381101561017e578082015181840152602081019050610163565b50505050905090810190601f1680156101ab5780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b3480156101c657600080fd5b506101f3600480360360208110156101dd57600080fd5b8101908080359060200190929190505050610509565b604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001828103825283818151815260200191508051906020019080838360005b8381101561026557808201518184015260208101905061024a565b50505050905090810190601f1680156102925780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b3480156102ad57600080fd5b50610387600480360360408110156102c457600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019064010000000081111561030157600080fd5b82018360208201111561031357600080fd5b8035906020019184600183028401116401000000008311171561033557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050610613565b005b6060600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002080548060200260200160405190810160405280929190818152602001828054801561041457602002820191906000526020600020905b815481526020019060010190808311610400575b5050505050905090565b60008181548110151561042d57fe5b90600052602060002090600202016000915090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690806001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104ff5780601f106104d4576101008083540402835291602001916104ff565b820191906000526020600020905b8154815290600101906020018083116104e257829003601f168201915b5050505050905082565b6000606060008381548110151561051c57fe5b906000526020600020906002020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1660008481548110151561055d57fe5b9060005260206000209060020201600101808054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106035780601f106105d857610100808354040283529160200191610603565b820191906000526020600020905b8154815290600101906020018083116105e657829003601f168201915b5050505050905091509150915091565b600080805490509050600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819080600181540180825580915050906001820390600052602060002001600090919290919091505550600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819080600181540180825580915050906001820390600052602060002001600090919290919091505550600060408051908101604052803373ffffffffffffffffffffffffffffffffffffffff168152602001848152509080600181540180825580915050906001820390600052602060002090600202016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010190805190602001906107a99291906107b2565b50505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106107f357805160ff1916838001178555610821565b82800160010185558215610821579182015b82811115610820578251825591602001919060010190610805565b5b50905061082e9190610832565b5090565b61085491905b80821115610850576000816000905550600101610838565b5090565b9056fea165627a7a723058205adf320fdf04a9128b5fb8787e2f5d6ca0ac2a4929c3eeb09857ce0d3fa844950029";

    public static final String FUNC_MAILBOX = "mailBox";

    public static final String FUNC_SENDMAIL = "sendMail";

    public static final String FUNC_GETRECEIVEMAILBOX = "getReceiveMailBox";

    public static final String FUNC_GETMAILCONTENT = "getMailContent";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1550896279955", "0x46456a5B9221C4433A87b1836f15443d30123413");
        _addresses.put("1544698244435", "0x595c7e27fa9f5755de0d4b9d54f6958fa46a9be9");
        _addresses.put("1544682865409", "0xf9c3c3c64c2270949f5f164bfc1b72eddfccd5a5");
        _addresses.put("1545034281781", "0xebb0dc44108d4cc61ac2e902dea0882d6ecde37d");
        _addresses.put("1545277580740", "0xc5bc71e0946e23d818d1e2c8883ae06f581cc8bf");
        _addresses.put("1547128364799", "0xb637b49403907762fe62f7a9f2bfe09a1ef9defe");
        _addresses.put("1544712389717", "0xc0aac329e57fe2271362aa4212c4cbae312671b6");
        _addresses.put("1550885088612", "0xf34b8d691BEadd9A155E0cf9DB7D7F9b50acE2F9");
        _addresses.put("1547432664580", "0x4e977643b616b92e45dCDf14a33C761EB914CdEB");
        _addresses.put("1547190298880", "0xe75f495b5c9f0c70b57c65f2ffe920e7886aad08");
    }

    @Deprecated
    protected Mail(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Mail(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Mail(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Mail(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Tuple2<String, String>> mailBox(BigInteger param0) {
        final Function function = new Function(FUNC_MAILBOX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple2<String, String>>(
                new Callable<Tuple2<String, String>>() {
                    @Override
                    public Tuple2<String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> sendMail(String _receiver, String _content) {
        final Function function = new Function(
                FUNC_SENDMAIL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_receiver), 
                new org.web3j.abi.datatypes.Utf8String(_content)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<List> getReceiveMailBox() {
        final Function function = new Function(FUNC_GETRECEIVEMAILBOX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<Tuple2<String, String>> getMailContent(BigInteger _idx) {
        final Function function = new Function(FUNC_GETMAILCONTENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_idx)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple2<String, String>>(
                new Callable<Tuple2<String, String>>() {
                    @Override
                    public Tuple2<String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    @Deprecated
    public static Mail load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Mail(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Mail load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Mail(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Mail load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Mail(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Mail load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Mail(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Mail> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Mail.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Mail> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Mail.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Mail> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Mail.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Mail> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Mail.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
