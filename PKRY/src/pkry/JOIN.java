/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkry;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JOIN
{
    
     public static int lp; 
    public static int k; 
    public static int lx;
    public static int le;
    public static int lE;
    public static int lX;
    public static int eps;

    
    private static final BigInteger TWO = new BigInteger("2");
    private final BigInteger p_;
    private final BigInteger q_;
    
    private static BigInteger n;
    private static BigInteger a;
    private static BigInteger a_o;
    private static BigInteger g_;
    private static BigInteger h;
    private static BigInteger b;
    private static BigInteger x;
    private static BigInteger r;
    private static BigInteger C1;
    private static String sp_ , gpsk_ , proof_ , gmsk_;
    
    private static BigInteger t1;
    private static BigInteger t2;
    private static BigInteger D;
    private static BigInteger c;
    private static BigInteger s1;
    private static BigInteger s2;
    
    
    private static String c_;
    private static String U;
    
    
    
    public JOIN()
    {
        try {
            gmsk_ = getFile("gmsk.txt");
        } catch (IOException ex) {
            Logger.getLogger(JOIN.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] gmsk = gmsk_.split("%");
        p_ = new BigInteger(gmsk[0] , 2);
        q_ = new BigInteger(gmsk[1] , 2);
        
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
        
         try {
            proof_ = getFile("proof.txt");
        } catch (IOException ex) {
            Logger.getLogger(JOIN.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        String proof[] = proof_.split("#");
        C1 = new BigInteger(proof[1] , 16);
        
        String[] U = proof[0].split("%");
        c = new BigInteger(U[0] , 16);
        s1 = new BigInteger(U[1] , 16);
        s2 = new BigInteger(U[2] , 16);
        
        if (checkIfQRn(C1 , p_ , q_) == true)
        {
            System.out.println("C1 nalezy do QR(n)");
        }
        else 
            System.out.println("C1 nie należy do QR(n)");
        
        System.out.println("p_= " + p_);
        System.out.println("q_= " + q_);
        System.out.println("C1= " + C1); 
        System.out.println("c= " + c);
        System.out.println("s1= " + s1);
        System.out.println("s2= " + s2);
        
        
        
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

    private boolean checkIfQRn(BigInteger C1, BigInteger p, BigInteger q_) {
        
        if(C1.gcd(p_).equals(BigInteger.ONE) && C1.gcd(q_).equals(BigInteger.ONE))
            return true;
        else 
        {System.out.println("NWD(C1,p_)= " + C1.gcd(p_));
        System.out.println("NWD(C1,q_)= " + C1.gcd(q_));
            return false;
        }
    }
    
}
