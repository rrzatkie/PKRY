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
    
    private static String m="chujnia";
    
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
        System.out.println(a);
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
        s3 = new BigInteger(sign[3]);
        s4= new BigInteger(sign[4]);
        s5= new BigInteger(sign[5]);
        s9= new BigInteger(sign[6]);
        s10= new BigInteger(sign[7]);
        T1= new BigInteger(sign[8]);
        T2= new BigInteger(sign[9]);
        T3= new BigInteger(sign[10]);
        T4=new BigInteger(sign[11]);
         System.out.println(T1 + " " + T2 + " " +T3 + " " +T4 );
        MessageDigest mda = null;    
        try {
            mda = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SIGN.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] coded = mda.digest(bsn.getBytes());
        byte[] slice = Arrays.copyOfRange(coded, 0, 3);
        BigInteger hsh=new BigInteger(slice);
        System.out.println(hsh);
        f=hsh.modPow(TWO, n) ;
        /**arametry t*/
        //t1
        BigInteger mian1=(a.modPow((s2.subtract(c.multiply(TWO.pow(lX)))).negate(), n).multiply(b.modPow(s9.negate(),n))).mod(n);
        BigInteger mian=(g_.modPow(s9.negate(), n).multiply(h.modPow(s10.negate(),n))).mod(n);
        BigInteger t1=(T1.modPow(s1.subtract(c.multiply(TWO.pow(lE))), n).multiply(a_o.modPow(c,n)).multiply(mian)).mod(n);
        BigInteger t2=(T2.modPow(s1.subtract(c.multiply(TWO.pow(lE))), n).multiply(mian)).mod(n);
        BigInteger t3=((T2.modPow(c,n).multiply(g_.modPow(s3, n)).multiply(h.modPow(s4, n)))).mod(n);   
        BigInteger t4=((T3.modPow(c,n).multiply(g_.modPow(s1.subtract(c.multiply(TWO.pow(lE))), n)).multiply(h.modPow(s5, n)))).mod(n); 
        BigInteger t5=(T4.modPow(c, n).multiply(f.modPow(s2.subtract(c.multiply(TWO.pow(lX))),n))).mod(n);
        System.out.println(t1 + " " + t2 + " " +t3 + " " +t4 + " " +t5 );
        StringBuilder cbdr=new StringBuilder();
        cbdr.append(a.toString()).append(a_o.toString()).append(g_.toString()).append(h.toString()).append(T1.toString()).append(T3.toString()).append(T4.toString()).append(t1.toString()).append(t2.toString()).append(t3.toString()).append(t4.toString()).append(t5.toString()).append(m);
        System.out.println(cbdr);
        byte[] hashed = mda.digest(cbdr.toString().getBytes());
        BigInteger cprim= new BigInteger( hashed);
        System.out.println(cprim);
     }
     /**metoda sprawdzająca czy dana liczba z podpisu należy do przedziału [-2^(lp+lx+k+le), 2^(eps*(lx+k+lp+le)-1)] celem weryfikacji*/
    boolean checkIfInRange(BigInteger num,int le,int lx,int k,int eps, int lp)
    {
        if (((num.compareTo(TWO.pow(eps*(lp+lx+lp+k)).subtract(BigInteger.ONE))) <= 0 ) && !(num.compareTo(TWO.negate().pow(lp+lx+le+k)) >= 0))
            return true;
        else
            return false;
    }
}
