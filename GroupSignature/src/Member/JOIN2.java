/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Member;

import static Member.JOIN1.eps;
import static Member.JOIN1.getFile;
import static Member.JOIN1.k;
import static Member.JOIN1.lE;
import static Member.JOIN1.lX;
import static Member.JOIN1.le;
import static Member.JOIN1.lp;
import static Member.JOIN1.lx;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafal
 */
public class JOIN2 {
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
    private String alfabeta_;
    private final BigInteger alfa;
    private final BigInteger beta;
    private static BigInteger x1;
    
    public JOIN2(){
    try {
            sp_ = getFile("secureparam.txt");
        } catch (IOException ex) {
            Logger.getLogger(JOIN1.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(JOIN1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String gpsk[] = gpsk_.split("%");
        n = new BigInteger(gpsk[0] , 2);
        a = new BigInteger(gpsk[1] , 2);
        a_o = new BigInteger(gpsk[2] , 2);
        g_ = new BigInteger(gpsk[3] , 2);
        h = new BigInteger(gpsk[4] , 2);
        b = new BigInteger(gpsk[5] , 2);
        
         try {
            alfabeta_ = getFile("alfabeta.txt");
        } catch (IOException ex) {
            Logger.getLogger(JOIN2.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] alfabeta = alfabeta_.split("%");
        alfa = new BigInteger(alfabeta[0], 2);
        beta= new BigInteger(alfabeta[1], 2);
        
        x1 =TWO.pow(lx).add(alfa.multiply(x));
        
        
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
}
