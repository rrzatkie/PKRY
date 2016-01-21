/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkry;

import pkry.prime.AKS;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafal
 */
public class SETUP {

    public static int lp = 16;
    public static int k = 3;
    public static int lx = 3;
    public static int le = 3;
    public static int lE = 7;
    public static int lX = 6;
    public static int eps = 1;
    

    private static final BigInteger TWO = new BigInteger("2");

    private static BigInteger p_;
    private static BigInteger q_;
    private static BigInteger p;
    private static BigInteger q;
    private static BigInteger n;
    private static BigInteger g;
    private static BigInteger a;
    private static BigInteger a_o;
    private static BigInteger g_;
    private static BigInteger h;
    private static BigInteger b;
    
    public static void main(String[] args) {
//        SETUP setup = new SETUP();
        JOIN join = new JOIN();
    }
    
    
    public SETUP()
    {
          
        p_=genP_(lp);
        q_=genQ_(lp);
        p =  p_.multiply(TWO).add(BigInteger.ONE);
        q =  q_.multiply(TWO).add(BigInteger.ONE);
        n = p.multiply(q);
        g = genG(n, lp);
        a = g.modPow(TWO, n);
        a_o = genA_0(lp, a);
        g_= genG_(lp, a, a_o);
        h = genH(lp, a, a_o, g_);
        b = genB(lp, a, a_o, g_, h);
        
        StringBuilder sp = new StringBuilder();
        sp.append(Integer.toBinaryString(lp)).append("%")
                .append(Integer.toBinaryString(k)).append("%")
                .append(Integer.toBinaryString(lx)).append("%")
                .append(Integer.toBinaryString(le)).append("%")
                .append(Integer.toBinaryString(lE)).append("%")
                .append(Integer.toBinaryString(lX)).append("%")
                .append(Integer.toBinaryString(eps)).append("%");
        try {
            createFile(sp.toString() , "secureparam.txt");
        } catch (IOException ex) {
            Logger.getLogger(SETUP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        StringBuilder gpsk = new StringBuilder();
        gpsk.append(n.toString(2)).append("%")
                .append(a.toString(2)).append("%")
                .append(a_o.toString(2)).append("%")
                .append(g_.toString(2)).append("%")
                .append(h.toString(2)).append("%")
                .append(b.toString(2)).append("%");
        StringBuilder gmsk = new StringBuilder();
        
        gmsk.append(p_.toString(2)).append("%")
                .append(q_.toString(2)).append("%");
        
        try {
            createFile(gpsk.toString() , "gpsk.txt");
        } catch (IOException ex) {
            Logger.getLogger(SETUP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            createFile(gmsk.toString() , "gmsk.txt");
        } catch (IOException ex) {
            Logger.getLogger(SETUP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        System.out.println("p_= " + p_);
        System.out.println("q_= " + q_);
        System.out.println("p= " + p);
        System.out.println("q= " + q);
        System.out.println("n= " + n);
        System.out.println("g= " + g);
        System.out.println("a= " + a);
        System.out.println("a_o= " + a_o);
        System.out.println("g_= " + g_);
        System.out.println("h= " + h);
        System.out.println("b= " + b);
    }
    
    public static void createFile(String data, String fileName) throws IOException {
        File file = new File(fileName);
        Files.write(file.toPath(), data.getBytes());
    }
    public static BigInteger genG(BigInteger n, int l)
    {
        BigInteger temp = null;
        do { temp = new BigInteger(l , new Random());
}
        while(!(n.gcd(temp.add(BigInteger.ONE)).equals(BigInteger.ONE)) &&
                n.gcd(temp.subtract(BigInteger.ONE))!= BigInteger.ONE &&
                !(temp.compareTo(n.subtract(BigInteger.ONE)) <= 0) );
        
        return temp;
    }
    public static BigInteger genP_(int l)
    {
        BigInteger rnd = null;
        boolean isPrime = false;

        while (!isPrime) {
            rnd = new BigInteger(l, 100, new Random());
            AKS IsPrimeTest = new AKS(rnd);
            isPrime = IsPrimeTest.isPrime();
        }
        return rnd; 
    }
    public static BigInteger genQ_(int l)
    {
        BigInteger rnd = null;
        boolean isPrime = false;

        while (!isPrime) {
            rnd = new BigInteger(l, 100, new Random());
            AKS IsPrimeTest = new AKS(rnd);
            isPrime = IsPrimeTest.isPrime();
        }
        return rnd; 
    }

    private static BigInteger genA_0(int l, BigInteger a) {
      BigInteger temp = null;
        do { temp = new BigInteger(l , new Random());}
        while(!(n.gcd(temp.add(BigInteger.ONE)).equals(BigInteger.ONE)) &&
                n.gcd(temp.subtract(BigInteger.ONE))!= BigInteger.ONE &&
                !(temp.compareTo(n.subtract(BigInteger.ONE)) <= 0) &&
                temp.equals(a));
                
       
        return temp;
    }

    private static BigInteger genG_(int l, BigInteger a, BigInteger a_o) {
        BigInteger temp = null;
        do { temp = new BigInteger(l , new Random());}
        while(!(n.gcd(temp.add(BigInteger.ONE)).equals(BigInteger.ONE)) &&
                n.gcd(temp.subtract(BigInteger.ONE))!= BigInteger.ONE &&
                !(temp.compareTo(n.subtract(BigInteger.ONE)) <= 0) &&
                temp.equals(a) && temp.equals(a_o));
        
        return temp;
        
    }

    private static BigInteger genH(int l, BigInteger a, BigInteger a_o, BigInteger g_) {
     BigInteger temp = null;
        do { temp = new BigInteger(l , new Random());}
        while(!(n.gcd(temp.add(BigInteger.ONE)).equals(BigInteger.ONE)) &&
                n.gcd(temp.subtract(BigInteger.ONE))!= BigInteger.ONE &&
                !(temp.compareTo(n.subtract(BigInteger.ONE)) <= 0) &&
                temp.equals(a) && temp.equals(a_o) && temp.equals(g_));       
        
        return temp;
        
        
    }

    private static BigInteger genB(int l, BigInteger a, BigInteger a_o, BigInteger g_, BigInteger h) {
      BigInteger temp = null;
        do { temp = new BigInteger(l , new Random());}
        while(!(n.gcd(temp.add(BigInteger.ONE)).equals(BigInteger.ONE)) &&
                n.gcd(temp.subtract(BigInteger.ONE))!= BigInteger.ONE &&
                !(temp.compareTo(n.subtract(BigInteger.ONE)) <= 0) &&
                temp.equals(a) && temp.equals(a_o) && temp.equals(g_) && temp.equals(h));

        
        return temp;
        
         
    }
    
    
    
    
}
