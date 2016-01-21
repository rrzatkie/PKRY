package pkry;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author emonsko
 */
public class SIGN {
    private static final BigInteger TWO = new BigInteger("2");
    /** klucz publiczny grupy*/
     public  static BigInteger n;
     public  static BigInteger a;
    public  static BigInteger a_o;
     public  static BigInteger g_;
     public  static BigInteger h;
     public  static BigInteger b;
    /**klucz prywatny członka*/
    public static BigInteger e;
     public  static BigInteger x;
    /** w standardzie A*/
     public  static BigInteger Ag;
    /**linking base*/
     private  static BigInteger bsn;
     private static BigInteger w1, w2, w3;
     private static BigInteger T1, T2, T3, T4;
    private static BigInteger s1, s2, s3, s4, s5, s9, s10;
    
    public SIGN()
    {
       // bsn=new BigInteger(u[2], 16);
    }
    /**metoda do generowania randomowej liczby z przedziału [0, 2^(eps*(2lp+k+le +lx))-1]*/
    private static BigInteger genRandom(int eps, int lp, int k, int lx, int le)
    {
        BigInteger temp = null;
        int pow = eps*(lp + k + le +lx);
       
        do{
            temp = new BigInteger(pow, new Random());
        }
        while(!((temp.compareTo(TWO.pow(pow).subtract(BigInteger.ONE))) <= 0 )
                && !(temp.compareTo(BigInteger.ZERO) >= 0));
        
        return temp;
        
    }
    
    
}