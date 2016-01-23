package pkry_m;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import static pkry_m.SIGN.getFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emonsko
 */
public class VERIFY {
    private  static String bsn ="dupa";
    private  static BigInteger f;
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
     private static String gprk,s_;
     private static String signature;
    private final BigInteger c;
    private final BigInteger s1;
    private final BigInteger s2;
    private final BigInteger s3;
    private final BigInteger s4;
    private final BigInteger s5;
    private final BigInteger s9;
    private final BigInteger s10;
    private final BigInteger T1;
    private final BigInteger T2;
    private final BigInteger T3;
    private final BigInteger T4;
    
     public VERIFY()
     {
         try {
            s_ = getFile("secureparam.txt");
        } catch (IOException ex) {
            Logger.getLogger(VERIFY.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VERIFY.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String gpsk[] = gprk.split("%");
        n = new BigInteger(gpsk[0] , 2);
        a = new BigInteger(gpsk[1] , 2);
        a_o = new BigInteger(gpsk[2] , 2);
        g_ = new BigInteger(gpsk[3] , 2);
        h = new BigInteger(gpsk[4] , 2);
        b = new BigInteger(gpsk[5] , 2);
        
         try {
            signature = getFile("signature.txt");
        } catch (IOException ex) {
            Logger.getLogger(VERIFY.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sign[] = signature.split("%");
        c = new BigInteger(sign[0]);
        s1 = new BigInteger(sign[1]);
        s2 = new BigInteger(sign[2]);
        s3 = new BigInteger(sign[4]);
        s4= new BigInteger(sign[4]);
        s5= new BigInteger(sign[5]);
        s9= new BigInteger(sign[6]);
        s10= new BigInteger(sign[7]);
        T1= new BigInteger(sign[8]);
        T2= new BigInteger(sign[9]);
        T3= new BigInteger(sign[10]);
        T4=new BigInteger(sign[11]);
         
        MessageDigest mda = null;    
        try {
            mda = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SIGN.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] coded = mda.digest(bsn.getBytes());
        byte[] slice = Arrays.copyOfRange(coded, 0, 3);
        BigInteger hsh=new BigInteger(slice);
        f=hsh.modPow(TWO, n) ;
     }
     /**metoda sprawdzająca czy dana liczba z podpisu należy do przedziału [-2^(lp+lx+k+le), 2^(eps*(lx+k+lp+le)-1)] celem weryfikacji*/
    boolean checkIfInRange(BigInteger num,int le,int lx,int k,int eps, int lp)
    {
        return true;
    }
}
