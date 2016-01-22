package pkry_m;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
//TODO generowanie f, liczb r i d, skrótu, liczb s i podpisu sigma
/**
 *
 * @author emonsko
 */
public class SIGN {
    private static final BigInteger TWO = new BigInteger("2");
    /** security parameters*/
        public static int lp; 
    public static int k; 
    public static int lx;
    public static int le;
    public static int lE;
    public static int lX;
    public static int eps;
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
     private  static BigInteger f;
     private static BigInteger w1, w2, w3;
     private static BigInteger T1, T2, T3, T4;
    private static BigInteger s1, s2, s3, s4, s5, s9, s10;
    private static String gprk;
    private static String s_;
    public SIGN()
    {
        try {
            s_ = getFile("secureparam.txt");
        } catch (IOException ex) {
            Logger.getLogger(JOIN.class.getName()).log(Level.SEVERE, null, ex);
        }
        String si[] = s_.split("%");
        lp = Integer.parseInt(si[0] , 2);
        k = Integer.parseInt(si[1] , 2);
        lx = Integer.parseInt(si[2] , 2);
        le = Integer.parseInt(si[3] , 2);
        lE = Integer.parseInt(si[4] , 2);
        lX = Integer.parseInt(si[5] , 2);
        eps = Integer.parseInt(si[6] , 2);
        
                try {
            gprk = getFile("gpsk.txt");
        } catch (IOException ex) {
            Logger.getLogger(JOIN.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String gpsk[] = gprk.split("%");
        n = new BigInteger(gpsk[0] , 2);
        a = new BigInteger(gpsk[1] , 2);
        a_o = new BigInteger(gpsk[2] , 2);
        g_ = new BigInteger(gpsk[3] , 2);
        h = new BigInteger(gpsk[4] , 2);
        b = new BigInteger(gpsk[5] , 2);
       // bsn=new BigInteger(u[2], 16);
       
       /**wartosci wczytane to teraz generujemy nasze liczby*/
       //f=(H(bsn))^2 mod(n)
       w1=genRandom(1,2*lp, 0,0,0);
       w2=genRandom(1,2*lp, 0,0,0);
       w3=genRandom(1,2*lp, 0,0,0);
       T1=Ag.multiply(b.modPow(w1,n));
       T2=(g_.modPow(w1,BigInteger.ONE).multiply(h.modPow(w2,BigInteger.ONE))).mod(n);
       T3=(g_.modPow(e,BigInteger.ONE).multiply(h.modPow(w3,BigInteger.ONE))).mod(n);
       T4=f.modPow(x, n);
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
        public static String getFile(String filePath) throws IOException {
        Path file = Paths.get(filePath);
        if (file.toFile().exists()) {
            byte[] encoded = Files.readAllBytes(file);
            return new String(encoded, StandardCharsets.UTF_8);
        } else {
            return null;
        }
    }
    
}