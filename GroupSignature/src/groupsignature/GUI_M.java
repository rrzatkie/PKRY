/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupsignature;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
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
public class GUI_M extends javax.swing.JFrame {

    public static int lp;
    public static int k;
    public static int lx;
    public static int le;
    public static int lE;
    public static int lX;
    public static double eps;

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
    private static String sp_, gpsk_;

    private static BigInteger t1;
    private static BigInteger t2;
    private static BigInteger D;
    private static BigInteger c;
    private static BigInteger s1;
    private static BigInteger s2;

    private static BigInteger c_;
    private static String U_;
    private String alfabeta_;
    private BigInteger alfa;
    private BigInteger beta;
    private static BigInteger x1;
    private static BigInteger C2;
    private static BigInteger v;
    private static BigInteger r_1;
    private static BigInteger d_1;
    private static BigInteger c_11;
    private static BigInteger s_1;
    private static BigInteger V;
    private static BigInteger r1;
    private static BigInteger r2;
    private static BigInteger r3;
    private static BigInteger d1;
    private static BigInteger d2;
    private static BigInteger c_22;
    private static BigInteger s11;
    private static BigInteger s22;
    private static BigInteger s33;
    private String cridentials_;
    private static BigInteger A;
    private static BigInteger e;

    private static String msk;
    private static String bsn = "11";
    private static BigInteger f;
    private static BigInteger w1;
    private static BigInteger w2;
    private static BigInteger w3;
    private static BigInteger T1;
    private static BigInteger T2;
    private static BigInteger T3;
    private static BigInteger T4;

    /**
     * Creates new form GUI_M
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        fileList = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setBackground(new java.awt.Color(255, 255, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("JOIN1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("JOIN2");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("SIGN");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("EXIT");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel1.setText("LOG:");

        jButton5.setText("CHECK");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        String path = "./messages/";
        File folder = new File(path);
        StringBuilder files_ = new StringBuilder();
        File[] filesArray = folder.listFiles();
        for(File file : filesArray)
        {
            files_.append("%").append(file.getName());
        }
        String[] files_string_array = files_.toString().split("%");
        fileList.setModel(new javax.swing.DefaultComboBoxModel<>( files_string_array ));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(fileList, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fileList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public GUI_M() {

        //jList1.setList(filesArray);
        initComponents();
        this.setVisible(true);
        this.setTitle("Member");
    }
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        jTextArea1.append("---------------JOIN1---------------\n\n");
        try {
            sp_ = getFile("secureparam.txt");
        } catch (IOException ex) {
            Logger.getLogger(GUI_M.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sp[] = sp_.split("%");
        lp = Integer.parseInt(sp[0], 2);
        k = Integer.parseInt(sp[1], 2);
        lx = Integer.parseInt(sp[2], 2);
        le = Integer.parseInt(sp[3], 2);
        lE = Integer.parseInt(sp[4], 2);
        lX = Integer.parseInt(sp[5], 2);
        eps = Double.parseDouble(sp[6]);

        try {
            gpsk_ = getFile("gpsk.txt");
        } catch (IOException ex) {
            Logger.getLogger(GUI_M.class.getName()).log(Level.SEVERE, null, ex);
        }

        String gpsk[] = gpsk_.split("%");
        n = new BigInteger(gpsk[0], 2);
        a = new BigInteger(gpsk[1], 2);
        a_o = new BigInteger(gpsk[2], 2);
        g_ = new BigInteger(gpsk[3], 2);
        h = new BigInteger(gpsk[4], 2);
        b = new BigInteger(gpsk[5], 2);

        jTextArea1.append("Uruchomiono generację parametrów x oraz r!\n");
        x = genX(lx);
        r = genR(n);
        jTextArea1.append("x= " + x + "\n");
        jTextArea1.append("r= " + r + "\n");

        jTextArea1.append("Wygenerowano C1!\n");

        C1 = (g_.modPow(x, n)
                .multiply(h.modPow(r, n)))
                .mod(n);

        jTextArea1.append("C1= " + C1 + "\n");
        
        jTextArea1.append("Uruchomiono generację proof of knowledge U reprezentacji (x,r)\n");
        t1 = genT1(lx, k, eps);
        t2 = genT2(lp, k, eps);

        D = (g_.modPow(t1, n)
                .multiply(h.modPow(t2, n)))
                .mod(n);

        byte[] g_Bytes = g_.toByteArray();
        byte[] hBytes = h.toByteArray();
        byte[] C1Bytes = C1.toByteArray();
        byte[] DBytes = D.toByteArray();
        byte[] cBytes = new byte[g_Bytes.length + hBytes.length + C1Bytes.length + DBytes.length];

        System.arraycopy(g_Bytes, 0, cBytes, 0, g_Bytes.length);
        System.arraycopy(hBytes, 0, cBytes, g_Bytes.length, hBytes.length);
        System.arraycopy(C1Bytes, 0, cBytes, g_Bytes.length + hBytes.length, C1Bytes.length);
        System.arraycopy(DBytes, 0, cBytes, g_Bytes.length + hBytes.length + C1Bytes.length, DBytes.length);
        System.out.println("cBytes = " + cBytes.length);

        MessageDigest mda = null;

        try {
            mda = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GUI_M.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] coded = mda.digest(cBytes);

        s1 = t1.subtract(new BigInteger(coded).multiply(x));
        s2 = t2.subtract(new BigInteger(coded).multiply(r));

        StringBuilder U = new StringBuilder();
        U.append(new BigInteger(coded).toString(2)).append("%")
                .append(s1.toString(2)).append("%")
                .append(s2.toString(2));

        StringBuilder proof = new StringBuilder();
        proof.append(U.toString()).append("#")
                .append(C1.toString(2));

        try {
            createFile(proof.toString(), "proof.txt");
        } catch (IOException ex) {
            Logger.getLogger(GUI_M.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTextArea1.append("Przesłano proof of knowledge U do GM! (proof.txt)\n");
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        jTextArea1.append("---------------JOIN2---------------\n\n");
        try {
            alfabeta_ = getFile("alfabeta.txt");
        } catch (IOException ex) {
            Logger.getLogger(GUI_M.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] alfabeta = alfabeta_.split("%");
        alfa = new BigInteger(alfabeta[0], 2);
        beta = new BigInteger(alfabeta[1], 2);
        jTextArea1.append("Otrzymano alfa oraz beta!\n");
        jTextArea1.append("Uruchomiono generację x1 oraz C2!\n");
        
        x1 = TWO.pow(lX).add(((alfa.multiply(x).mod(TWO.pow(lx))).add(beta.mod(TWO.pow(lx)))).mod(TWO.pow(lx)));
        C2 = a.modPow(x1, n);
        
        jTextArea1.append("Wygenerowano x1 oraz C2!\n");
        jTextArea1.append("x1 = " + x1 + "\n");
        jTextArea1.append("C2 = " + C2 + "\n");
// v do POPRAWY !!!!
        v = (alfa.multiply(x).add(beta))
                .modPow((TWO.pow(lx).subtract(BigInteger.ONE)).divide(TWO), TWO.pow(lx));
        r_1 = genR_1(lx, k, eps);
        d_1 = a.modPow(r_1, n);
        jTextArea1.append("Uruchomiono generację proof of knowledge V!\n");

        byte[] aBytes = a.toByteArray();

        byte[] g_Bytes = g_.toByteArray();

        byte[] C2Bytes = C2.toByteArray();

        byte[] d_1Bytes = d_1.toByteArray();

        byte[] c_1Bytes = new byte[g_Bytes.length + aBytes.length + C2Bytes.length + d_1Bytes.length];

        System.arraycopy(aBytes, 0, c_1Bytes, 0, aBytes.length);
        System.out.println(Arrays.toString(c_1Bytes));
        System.arraycopy(g_Bytes, 0, c_1Bytes, aBytes.length, g_Bytes.length);
        System.out.println(Arrays.toString(c_1Bytes));
        System.arraycopy(C2Bytes, 0, c_1Bytes, aBytes.length + g_Bytes.length, C2Bytes.length);
        System.out.println(Arrays.toString(c_1Bytes));
        System.arraycopy(d_1Bytes, 0, c_1Bytes, aBytes.length + g_Bytes.length + C2Bytes.length, d_1Bytes.length);
        System.out.println(Arrays.toString(c_1Bytes));
        MessageDigest mda = null;

        try {
            mda = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GUI_M.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] coded = mda.digest(c_1Bytes);
        c_11 = new BigInteger(coded);
        
        BigInteger temp1, temp2, temp3;
        temp1 = x1.subtract(TWO.pow(lX));
        temp2 = c_11.multiply(temp1);
        temp3 = r_1.subtract(temp2);
        s_1 = temp3;
        //s_1 = r_1.subtract(c_11.multiply((x1.subtract(TWO.pow(lX)))));
        
        StringBuilder V_ = new StringBuilder();
        V_.append(c_11.toString(2)).append("%")
                .append(s_1.toString(2));
        jTextArea1.append("Wygenerowano proof of knowledge V! \n");
        jTextArea1.append("Uruchomiono generację proof of knowledge W! \n");
        r1 = genR1(lx, k, eps);
        r2 = genR2(lx, k, eps);
        r3 = genR3(lp, lx, k, eps);

        d1 = a.modPow(r1, n);
        d2 = (g_.modPow(r1, n)
                .multiply(g_.modPow((TWO.pow(lx)).multiply(r2), n))
                .multiply(h.modPow(r3, n)))
                .mod(n);
        byte[] hBytes = h.toByteArray();
        byte[] C1Bytes = C1.toByteArray();
        byte[] d1Bytes = d1.toByteArray();
        byte[] d2Bytes = d2.toByteArray();
        byte[] c_2Bytes = new byte[aBytes.length + g_Bytes.length + hBytes.length
                + C1Bytes.length + C2Bytes.length + d1Bytes.length + d2Bytes.length];
        System.arraycopy(aBytes, 0, c_2Bytes, 0, aBytes.length);
        System.arraycopy(g_Bytes, 0, c_2Bytes, aBytes.length, g_Bytes.length);
        System.arraycopy(hBytes, 0, c_2Bytes, aBytes.length + g_Bytes.length, hBytes.length);
        System.arraycopy(C1Bytes, 0, c_2Bytes, aBytes.length + g_Bytes.length + hBytes.length, C1Bytes.length);
        System.arraycopy(C2Bytes, 0, c_2Bytes, aBytes.length + g_Bytes.length + hBytes.length + C1Bytes.length, C2Bytes.length);
        System.arraycopy(d1Bytes, 0, c_2Bytes, aBytes.length + g_Bytes.length + hBytes.length + C1Bytes.length + C2Bytes.length, d1Bytes.length);
        System.arraycopy(d2Bytes, 0, c_2Bytes, aBytes.length + g_Bytes.length + hBytes.length + C1Bytes.length + C2Bytes.length + d1Bytes.length, d2Bytes.length);

        MessageDigest mda2 = null;
        try {
            mda2 = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GUI_M.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] coded2 = mda2.digest(c_2Bytes);
        c_22 = new BigInteger(coded2);
       
        s11 = r1.subtract(c_22.multiply(x1.subtract(TWO.pow(lX))));
        s22 = r2.subtract(c_22.multiply(v));
        s33 = r3.subtract(c_22.multiply(alfa.multiply(r)));

        StringBuilder W_ = new StringBuilder();
        W_.append(c_22.toString(2)).append("%")
                .append(s11.toString(2)).append("%")
                .append(s22.toString(2)).append("%")
                .append(s33.toString(2));
        jTextArea1.append("Wygenerowano proof of knowledge W! \n");
        StringBuilder proof2_ = new StringBuilder();
        proof2_.append(C2.toString(2)).append("#")
                .append(V_.toString()).append("#")
                .append(W_.toString());
        try {
            createFile(proof2_.toString(), "proof2.txt");
        } catch (IOException ex) {
            Logger.getLogger(GUI_M.class.getName()).log(Level.SEVERE, null, ex);
        }

         jTextArea1.append("Wysłano C2 , V oraz W do GM! (proof2.txt) \n");

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        jTextArea1.append("---------------CHECK---------------\n\n");
        try {
            msk = getFile("msk.txt");
        } catch (IOException ex) {
            Logger.getLogger(GUI_M.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] cridentials = msk.split("%");
        A = new BigInteger(cridentials[0], 2);
        e = new BigInteger(cridentials[1], 2);
        jTextArea1.append("Odebrano e oraz A. Uruchomiono sprawdzanie!\n");
        StringBuilder msk2 = new StringBuilder();
        msk2.append(A.toString(2)).append("%")
                .append(e.toString(2)).append("%")
                .append(x1.toString(2));
        try {
            createFile(msk2.toString(), "msk2.txt");
            jTextArea1.append("Sukces, masz poprawnie wygenerowany klucz!\n");
            // zbyt duze liczby - liczy sie bardzo dlugo
//         if (A.pow(e.intValue()) == (a_o.mod(n).multiply(a_o.modPow(x1, n))).mod(n))
//             jTextArea1.append("Bajlando");
//         else
//             jTextArea1.append("NIE bajlando \n A^e = " + A.pow(e.intValue()) 
//                     + "\n drugie = " + (a_o.mod(n).multiply(a_o.modPow(x1, n))).mod(n));
        } catch (IOException ex) {
            Logger.getLogger(GUI_M.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextArea1.append("Sukces, uzyskano poświadczenia (A,e,x)! (msk2.txt)\n");


    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
         jTextArea1.append("---------------SIGN---------------\n\n");
        String msk = null;
        try {
            msk = getFile("msk2.txt");
        } catch (IOException ex) {
            Logger.getLogger(GUI_M.class.getName()).log(Level.SEVERE, null, ex);
        }
        String membersk[] = msk.split("%");
        A = new BigInteger(membersk[0], 2);
        e = new BigInteger(membersk[1], 2);
        x = new BigInteger(membersk[2], 2);
        MessageDigest mda = null;
        try {
            mda = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GUI_M.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] coded = mda.digest(bsn.toString().getBytes());
        //    
        byte[] slice = Arrays.copyOfRange(coded, 0, 3);
        
        jTextArea1.append("Rozpoczęto generację f !\n ");
        BigInteger hsh = new BigInteger(slice);
        
        /**
         * wartosci wczytane to teraz generujemy nasze liczby
         */

        f = hsh.modPow(TWO, n);
        jTextArea1.append("f = " + f + "\n");
        w1 = genRandom(1, 2 * lp, 0, 0, 0);
        w2 = genRandom(1, 2 * lp, 0, 0, 0);
        w3 = genRandom(1, 2 * lp, 0, 0, 0);
        T1 = (A.mod(n).multiply(b.modPow(w1, n))).mod(n);
        jTextArea1.append("Rozpoczęto generację T1-T4!\n");
       
        T2 = (g_.modPow(w1, n).multiply(h.modPow(w2, n))).mod(n);
        T3 = (g_.modPow(e, n).multiply(h.modPow(w3, n))).mod(n);
        T4 = f.modPow(x, n);
        jTextArea1.append("T1 = " + T1 + " \n" + "T2 = " + T2 + " \n " + "T3 = " + T3 + " \n" + "T4= " + T4 + "\n");

        /**
         * gererujemy r-y ktore przydadza sie przy liczeniu parametrĂłw d
         */
        BigInteger r11 = genRandom(eps, 0, k, 0, le);
        BigInteger r2 = genRandom(eps, 0, k, lx, 0);
        BigInteger r3 = genRandom(eps, 2 * lp, k, 0, 0);
        BigInteger r4 = genRandom(eps, 2 * lp, k, 0, 0);
        BigInteger r5 = genRandom(eps, 2 * lp, k, 0, 0);
        BigInteger r9 = genRandom(eps, 2 * lp, k, 0, le);
        BigInteger r10 = genRandom(eps, 2 * lp, k, 0, le);

        /**
         * obliczamy d1-d5
         */
         jTextArea1.append("Rozpoczęto generację d1-d5!\n");
        BigInteger d5 = f.modPow(r2, n);
        BigInteger d4 = (g_.modPow(r11, n).multiply(h.modPow(r5, n))).mod(n);
        BigInteger d3 = (g_.modPow(r3, n).multiply(h.modPow(r4, n)).mod(n));

        //d2=T1^r1/(a^r2b^r9)mod(n)
        BigInteger mian = (a.modPow(r2.negate(), n).multiply(b.modPow(r9.negate(), n))).mod(n);
        BigInteger d2 = (T1.modPow(r11, n).multiply(mian)).mod(n);

        //TODO d1
        BigInteger mian2 = (g_.modPow(r9.negate(), n).multiply(h.modPow(r10.negate(), n))).mod(n);
        BigInteger d1 = (T2.modPow(r11, n).multiply(mian2)).mod(n);

        jTextArea1.append("d1= " + d1 + " \n" + "d2= " + d2 + " \n" + "d3= " + d3 + " \n" + "d4= " + d4 + " \n" + "d5= " + d5 + "\n");
        StringBuilder c = new StringBuilder();

        try {
            c.append(a).append(a_o.toString()).append(g_.toString()).append(h.toString())
                    .append(T1.toString()).append(T3.toString()).append(T4.toString())
                    .append(d1.toString()).append(d2.toString()).append(d3.toString())
                    .append(d4.toString()).append(d5.toString())
                    .append(getFile(fileList.getSelectedItem().toString()));
        } catch (IOException ex) {
            Logger.getLogger(GUI_M.class.getName()).log(Level.SEVERE, null, ex);
        }

         jTextArea1.append("Rozpoczęto generację s1-s10!\n");
        byte[] hashed = mda.digest(c.toString().getBytes());
        BigInteger hshm = new BigInteger(hashed);
        System.out.println(hshm);
        BigInteger s1 = r11.subtract(hshm.multiply(e.subtract(TWO.pow(lE))));
        BigInteger s2 = r2.subtract(hshm.multiply(x.subtract(TWO.pow(lX))));
        BigInteger s3 = r3.subtract(hshm.multiply(w1));
        BigInteger s4 = r4.subtract(hshm.multiply(w2));
        BigInteger s5 = r5.subtract(hshm.multiply(w3));
        BigInteger s9 = r9.subtract(hshm.multiply(hshm.multiply(e).multiply(w1)));
        BigInteger s10 = r10.subtract(hshm.multiply(hshm.multiply(e).multiply(w2)));
        String signature = genSignature(hshm, s1, s2, s3, s4, s5, s9, s10, T1, T2, T3, T4);
        try {
            createFile(signature, "signature.txt");
        } catch (IOException ex) {
            Logger.getLogger(GUI_M.class.getName()).log(Level.SEVERE, null, ex);
        }
         jTextArea1.append("Wygenerowano sygnaturę = (c, s1,s2,s3,s4,s5,s9,s10) ! (signature.txt) \n");
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButton4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_M.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_M.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_M.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_M.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_M().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> fileList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

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

        do {
            temp = new BigInteger(lx, new Random());
        } while (!((temp.compareTo(TWO.pow(lx).subtract(BigInteger.ONE))) <= 0)
                && !(temp.compareTo(BigInteger.ZERO) >= 0));

        return temp;
    }

    private static BigInteger genR(BigInteger n) {
        BigInteger temp = null;
        do {
            temp = new BigInteger(n.bitLength(), new Random());
            System.out.println("n.bit =" + n.bitLength());
        } while (!(temp.compareTo(TWO.multiply(n).subtract(BigInteger.ONE)) <= 0)
                && !(temp.compareTo(BigInteger.ZERO) == 1));
        return temp;
    }

    private static BigInteger genT1(int lx, int k, double eps) {
        BigInteger temp = null;
        int pow = (int) (eps * (lx + k));

        do {
            temp = new BigInteger(pow, new Random());
        } while (!((temp.compareTo(TWO.pow(pow).subtract(BigInteger.ONE))) <= 0)
                && !(temp.compareTo(BigInteger.ZERO) >= 0));

        return temp;
    }

    private static BigInteger genT2(int lp, int k, double eps) {
        BigInteger temp = null;
        int pow = (int) (eps * (2 * lp + k + 1));

        do {
            temp = new BigInteger(pow, new Random());
        } while (!((temp.compareTo(TWO.pow(pow).subtract(BigInteger.ONE))) <= 0)
                && !(temp.compareTo(BigInteger.ZERO) >= 0));

        return temp;
    }

    private BigInteger genR_1(int lx, int k, double eps) {
        BigInteger temp = null;
        int pow = (int) (eps * (lx + k));

        do {
            temp = new BigInteger(pow, new Random());
        } while (!((temp.compareTo(TWO.pow(pow).subtract(BigInteger.ONE))) <= 0)
                && !(temp.compareTo(BigInteger.ZERO) >= 0));

        return temp;
    }

    private BigInteger genR1(int lx, int k, double eps) {
        BigInteger temp = null;
        int pow = (int) (eps * (lx + k));

        do {
            temp = new BigInteger(pow, new Random());
        } while (!((temp.compareTo(TWO.pow(pow).subtract(BigInteger.ONE))) <= 0)
                && !(temp.compareTo(BigInteger.ZERO) >= 0));

        return temp;
    }

    private BigInteger genR2(int lx, int k, double eps) {
        BigInteger temp = null;
        int pow = (int) (eps * (lx + k));

        do {
            temp = new BigInteger(pow, new Random());
        } while (!((temp.compareTo(TWO.pow(pow).subtract(BigInteger.ONE))) <= 0)
                && !(temp.compareTo(BigInteger.ZERO) >= 0));

        return temp;
    }

    private BigInteger genR3(int lp, int lx, int k, double eps) {
        BigInteger temp = null;
        int pow = (int) (eps * (2 * lp + k + lx + 1));

        do {
            temp = new BigInteger(pow, new Random());
        } while (!((temp.compareTo(TWO.pow(pow).subtract(BigInteger.ONE))) <= 0)
                && !(temp.compareTo(BigInteger.ZERO) >= 0));

        return temp;
    }

    public static String genSignature(BigInteger c, BigInteger s1, BigInteger s2,
            BigInteger s3, BigInteger s4, BigInteger s5, BigInteger s9, BigInteger s10,
            BigInteger T1, BigInteger T2, BigInteger T3, BigInteger T4) {
        StringBuilder signbuilder = new StringBuilder();
        signbuilder.append(c.toString()).append("%").append(s1.toString())
                .append("%").append(s2.toString()).append("%").append(s3.toString())
                .append("%").append(s4.toString()).append("%").append(s5.toString())
                .append("%").append(s9.toString()).append("%").append(s10.toString())
                .append("%").append(T1.toString()).append("%").append(T2.toString())
                .append("%").append(T3.toString()).append("%").append(T4.toString());
        String signat = signbuilder.toString();
        return signat;
    }

    private static BigInteger genRandom(double eps, int lp, int k, int lx, int le) {
        BigInteger temp = null;
        int pow = (int) eps * (lp + k + le + lx);

        do {
            temp = new BigInteger(pow, new Random());
        } while (!((temp.compareTo(TWO.pow(pow).subtract(BigInteger.ONE))) <= 0)
                && !(temp.compareTo(BigInteger.ZERO) >= 0));

        return temp;

    }

    class TextFileFilter implements FileFilter {

        @Override
        public boolean accept(File pathname) {
            String name = pathname.getName();
            return name.length() < 28 && name.endsWith(".txt");
        }
    }
}
