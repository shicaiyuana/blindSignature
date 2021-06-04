import java.math.BigInteger;
/**
 * 盲签名相关
 */
public class blindSignature {
    public static void main(String[] args){
        System.out.println("这里是盲签名测试");

        BigInteger e = new BigInteger("32663");
        BigInteger d = new BigInteger("23");
        BigInteger n = new BigInteger("42167");

            BigInteger m = new BigInteger("1");       //签名的消息
        System.out.println("需要签名的信息为"+m);
        BigInteger factor = new BigInteger("37");   //盲因子

        BigInteger blindMsg = blindHideMsg(m, factor, e, n);
        System.out.println("盲化后的信息="+blindMsg);
        BigInteger blindSig = blindSignature(blindMsg, d, n);
        System.out.println("签名后的盲化信息="+blindSig);
        BigInteger sig = blindRetriveSig(blindSig, factor, n);
        System.out.println("盲签名 = " + sig);
        BigInteger realSig = m.modPow(d, n);
        System.out.println("原签名 = " + realSig);
    }

    /**盲签名-盲化*/
    public static BigInteger blindHideMsg(BigInteger msg, BigInteger factor, BigInteger e, BigInteger n){
        BigInteger hideMsg = msg.multiply(factor.modPow(e, n)).mod(n);
        return hideMsg;
    }

    /**盲签名-签名*/
    public static BigInteger blindSignature(BigInteger blindMsg, BigInteger d, BigInteger n){
        BigInteger blindSig = blindMsg.modPow(d, n);
        return blindSig;
    }

    /**盲签名-解盲得到签名*/
    public static BigInteger blindRetriveSig(BigInteger blindSig, BigInteger factor, BigInteger n){
        BigInteger signature = blindSig.multiply(factor.modInverse(n)).mod(n);
        return signature;
    }

}
