/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkry_m;

import java.io.File;
import java.io.IOException;
import static java.lang.Integer.valueOf;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafal
 */



public class JOIN {
    public static int lp; 
    public static int k; 
    public static int lx;
    public static int le;
    public static int lE;
    public static int lX;
    public static int eps;

    
    private static final BigInteger TWO = new BigInteger("2");
    
    private static BigInteger n;
    private static BigInteger a;
    private static BigInteger a_o;
    private static BigInteger g_;
    private static BigInteger h;
    private static BigInteger b;
    private static BigInteger x;
    private static BigInteger r;
    private static BigInteger C1;
    private static String sp_ , gpsk_;
    
    private static BigInteger t1;
    private static BigInteger t2;
    private static BigInteger D;
    private static BigInteger c;
    private static BigInteger s1;
    private static BigInteger s2;
    
    private static BigInteger c_;
    private static String U_;
    
    
    
    
    public static void main(String[] args)
    {
        System.out.println("JOIN");
        
    }
    
    public JOIN(){
    try {
            sp_ = getFile("secureparam.txt");
        } catch (IOException ex) {
            Logger.getLogger(JOIN.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sp[] = sp_.split("%");
        lp = Integer.parseInt(sp[0] , 2);
        k = Integer.parseInt(sp[1] , 2);
        lx = Integer.parseInt(sp[2] , 2);
        le = Integer.parseInt(sp[3] , 2);
        lE = Integer.parseInt(sp[4] , 2);
        lX = Integer.parseInt(sp[5] , 2);
        eps = Integer.parseInt(sp[6] , 2);
        
        try {
            gpsk_ = getFile("gpsk.txt");
        } catch (IOException ex) {
            Logger.getLogger(JOIN.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String gpsk[] = gpsk_.split("%");
        n = new BigInteger(gpsk[0] , 2);
        a = new BigInteger(gpsk[1] , 2);
        a_o = new BigInteger(gpsk[2] , 2);
        g_ = new BigInteger(gpsk[3] , 2);
        h = new BigInteger(gpsk[4] , 2);
        b = new BigInteger(gpsk[5] , 2);
        
        
        x = genX(lx);
        r = genR(n);
        
        
        
        
       
        C1 = (g_.modPow(x, n)
                .multiply(h.modPow(r, n)))
                .mod(n);
        t1 = genT1(lx , k, eps);
        t2 = genT2(lp , k , eps);
        
     
        D = (g_.modPow(t1, n)
                .multiply(h.modPow(t2, n)))
                .mod(n);
        
        StringBuilder c = new StringBuilder();
        
        c.append(g_.toString(2))
                .append(h.toString(2))
                .append(C1.toString(2))
                .append(D.toString(2));
        
        MessageDigest mda = null;
      
        try {
            mda = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(JOIN.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        byte[] coded = mda.digest(c.toString().getBytes());
       
        s1 = t1.subtract(new BigInteger(coded).multiply(x));
        s2 = t2.subtract(new BigInteger(coded).multiply(r));
        
        StringBuilder U = new StringBuilder();
        U.append(new BigInteger(coded).toString(16)).append("%")
                .append(s1.toString(16)).append("%")
                .append(s2.toString(16));
        
        StringBuilder proof = new StringBuilder();
        proof.append(U.toString()).append("#")
                .append(C1.toString(16));
        
        try {
            createFile(proof.toString() , "proof.txt" );
        } catch (IOException ex) {
            Logger.getLogger(JOIN.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        System.out.println("x= " + x);
        System.out.println("r= " + r);
        System.out.println("c= " + c);
        System.out.println("C1= " + C1);
        System.out.println("c_= " + c_ );
        System.out.println("t1= " + t1);
        System.out.println("t2= " + t2);
        System.out.println("s1= " + s1);
        System.out.println("s2= " + s2);
        System.out.println("coded= " + new BigInteger(coded));
        
        
        
    }
    
    public static String tohexstring(byte[] coded)
    {
        StringBuffer hexString = new StringBuffer();
        
        for (int i = 0; i < coded.length; i++) {
            if ((0xff & coded[i]) < 0x10) {
            hexString.append("0" + Integer.toHexString((0xFF & coded[i])));
            } 
            else {
                hexString.append(Integer.toHexString(0xFF & coded[i]));
            }
        }
        
        return hexString.toString();
    }
    
    public static void createFile(String data, String fileName) throws IOException {
        File file = new File(fileName);
        Files.write(file.toPath(), data.getBytes());
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

    private static BigInteger genX(int lx) {
        BigInteger temp = null;
        
        do{
            temp = new BigInteger(lx, new Random());
        }
        while(!((temp.compareTo(TWO.pow(lx).subtract(BigInteger.ONE))) <= 0 )
                && !(temp.compareTo(BigInteger.ZERO) >= 0));
        
        return temp;
    }

    private static BigInteger genR(BigInteger n) {
        BigInteger temp = null;
        do{
            temp = new BigInteger(n.bitLength(), new Random());
        }
        while(!(temp.compareTo(TWO.multiply(n).subtract(BigInteger.ONE)) <= 0 )
                && !(temp.compareTo(BigInteger.ZERO)== 1));
        return temp;
    }
    private static BigInteger genT1(int lx, int k, int eps)
    {
        BigInteger temp = null;
        int pow = eps*(lx + k);
       
        do{
            temp = new BigInteger(pow, new Random());
        }
        while(!((temp.compareTo(TWO.pow(pow).subtract(BigInteger.ONE))) <= 0 )
                && !(temp.compareTo(BigInteger.ZERO) >= 0));
        
        return temp;
    }
    
    private static BigInteger genT2(int lp, int k, int eps)
    {
        BigInteger temp = null;
        int pow = eps*(lp + k + 1);
       
        do{
            temp = new BigInteger(pow, new Random());
        }
        while(!((temp.compareTo(TWO.pow(pow).subtract(BigInteger.ONE))) <= 0 )
                && !(temp.compareTo(BigInteger.ZERO) >= 0));
        
        return temp;
    }
}
