/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_Dashboard;
import College_Inventory_DB.MySqlConnect;
import College_Inventory_Login.Login;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Amit Kumar
 */
public class UpdateInvoice extends javax.swing.JFrame {
public static String empname,empid,isid,isuppname,igst,iinvono;    
Connection conn;
ResultSet rs;
PreparedStatement pst;
    /**
     * Creates new form NewJFrame
     */
    public UpdateInvoice() {
        setIcon();
        initComponents();
        conn=MySqlConnect.ConnecrDb();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
        //total Final amount of billing.
        public void cart_total(){
        int famtofrow = all_table.getRowCount();
        double famttotal = 0;
        for (int i = 0; i < famtofrow; i++) {
            double famtvalue = Double.valueOf(all_table.getValueAt(i, 14).toString());
            famttotal += famtvalue ;
        }
        bill_tot.setText(String.format("%.2f",famttotal));

        /// total qty count 
        int qtyofrow = all_table.getRowCount();
        int qtytotal = 0;
        for (int i = 0; i < qtyofrow; i++) {
            int qtyvalue = Integer.valueOf(all_table.getValueAt(i, 3).toString());
            qtytotal += qtyvalue ;
        }
        tot_qty.setText(Integer.toString(qtytotal));
        
        /// total amount count 
        int amtofrow = all_table.getRowCount();
        double amttotal = 0;
        for (int i = 0; i < amtofrow; i++) {
            double amtvalue = Double.valueOf(all_table.getValueAt(i, 5).toString());
            amttotal += amtvalue ;
        }
        tot_amt.setText(String.format("%.2f",amttotal));
       
        /// total CGST% count 
        int cgstofrow = all_table.getRowCount();
        double cgsttotal = 0;
        for (int i = 0; i < cgstofrow; i++) {
            double cgstvalue = Double.valueOf(all_table.getValueAt(i, 6).toString());
            cgsttotal += cgstvalue ;
        }
        tot_cgst_per.setText(String.format("%.2f",cgsttotal));
       
        /// total CGST Amount count 
        int cgstaofrow = all_table.getRowCount();
        double cgstatotal = 0;
        for (int i = 0; i < cgstaofrow; i++) {
            double cgstavalue = Double.valueOf(all_table.getValueAt(i, 7).toString());
            cgstatotal += cgstavalue ;
        }
        tot_cgst_amt.setText(String.format("%.2f",cgstatotal));
       
        /// total SGST% count 
        int sgstofrow = all_table.getRowCount();
        double sgsttotal = 0;
        for (int i = 0; i < sgstofrow; i++) {
            double sgstvalue = Double.valueOf(all_table.getValueAt(i, 8).toString());
            sgsttotal += sgstvalue ;
        }
        tot_sgst_per.setText(String.format("%.2f",sgsttotal));
       
        /// total SGST Amount count 
        int sgstaofrow = all_table.getRowCount();
        double sgstatotal = 0;
        for (int i = 0; i < sgstaofrow; i++) {
            double cgstavalue = Double.valueOf(all_table.getValueAt(i, 9).toString());
            sgstatotal += cgstavalue ;
        }
        tot_sgst_amt.setText(String.format("%.2f",sgstatotal));
       
        /// total Discount% count 
        int discofrow = all_table.getRowCount();
        double disctotal = 0;
        for (int i = 0; i < discofrow; i++) {
            double discvalue = Double.valueOf(all_table.getValueAt(i, 10).toString());
            disctotal += discvalue ;
        }
        tot_discount_per.setText(String.format("%.2f",disctotal));
       
        /// total Discount Amount count 
        int discaofrow = all_table.getRowCount();
        double discatotal = 0;
        for (int i = 0; i < discaofrow; i++) {
            double discavalue = Double.valueOf(all_table.getValueAt(i, 11).toString());
            discatotal += discavalue ;
        }
        tot_discount_amt.setText(String.format("%.2f",discatotal));
        
        /// total Discount Amount count 
        double tottax_per = cgsttotal + sgsttotal;
        double tottax_amt = cgstatotal + sgstatotal;
        tot_tax_a.setText(String.format("%.2f",tottax_amt));
        tot_tax_p.setText(String.format("%.2f",tottax_per));
   }

    //show balance
    public void tot(){
        Double paid = Double.valueOf(paid_amt.getText());
        Double tot = Double.valueOf(bill_tot.getText());
        Double due ;
        String getpaid =paid_amt.getText();
        float paidlength=getpaid.length();
        if(paidlength > 0){
            due =  paid - tot ;
        }
        else{
            due =  0 - tot ;
        }balance.setText(String.format("%.2f",due));  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel23 = new javax.swing.JLabel();
        Description6 = new javax.swing.JTextField();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        GSTno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        DateOfPurchase = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        Supplierid = new javax.swing.JTextField();
        Invoiceno = new javax.swing.JTextField();
        Suppliername = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Description = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        hsnsac = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cgst = new javax.swing.JTextField();
        sgst = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        amt = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        config = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cgstamt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sgstamt = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        finalamt = new javax.swing.JTextField();
        disc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        discamt = new javax.swing.JTextField();
        rate = new javax.swing.JTextField();
        warranty = new javax.swing.JComboBox<String>();
        DescType = new javax.swing.JComboBox<String>();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        bill_tot = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tot_qty = new javax.swing.JLabel();
        tot_amt = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tot_tax_a = new javax.swing.JLabel();
        tot_tax_p = new javax.swing.JLabel();
        tot_cgst_per = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        tot_cgst_amt = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        tot_sgst_per = new javax.swing.JLabel();
        tot_sgst_amt = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        tot_discount_per = new javax.swing.JLabel();
        tot_discount_amt = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        all_table = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        paid_amt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel38 = new javax.swing.JLabel();
        paymentmode = new javax.swing.JComboBox<String>();
        jSeparator3 = new javax.swing.JSeparator();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        adminname = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        timeshow = new javax.swing.JLabel();
        admibid = new javax.swing.JLabel();

        jLabel23.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel23.setText("DISC%");

        Description6.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 204));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Poor Richard", 0, 40)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Stock Management System");

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/College_Inventory_Icon/logout.png"))); // NOI18N
        jButton10.setText("Log Out");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(152, 201, 45));
        jButton14.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/undo.png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(250, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel3.setText("Invoice No :");

        jLabel12.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel12.setText("Supplier :");

        jLabel13.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel13.setText("GST No :");

        GSTno.setEditable(false);
        GSTno.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        GSTno.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel14.setText("Date Of Purchase :");

        DateOfPurchase.setDateFormatString("dd MMM, yyyy");
        DateOfPurchase.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jButton4.setText("SEARCH");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel37.setText("ID");

        Supplierid.setEditable(false);
        Supplierid.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        Supplierid.setEnabled(false);

        Invoiceno.setEditable(false);
        Invoiceno.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        Invoiceno.setEnabled(false);

        Suppliername.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        Suppliername.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Suppliername, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Supplierid, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GSTno, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Invoiceno, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateOfPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Invoiceno)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GSTno, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateOfPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Supplierid)
                    .addComponent(Suppliername))
                .addContainerGap())
        );

        GSTno.setText(""+igst);
        DateOfPurchase.setMaxSelectableDate(new Date());
        Supplierid.setText(""+isid);
        Invoiceno.setText(iinvono);
        Suppliername.setText(isuppname);

        jPanel3.setBackground(new java.awt.Color(255, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(51, 51, 255)));

        jLabel15.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel15.setText("Description :");

        Description.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel17.setText("HSN/SAC :");

        hsnsac.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel19.setText("QTY :");

        qty.setEditable(false);
        qty.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        qty.setEnabled(false);
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qtyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel20.setText("RATE :");

        jLabel21.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel21.setText("DISC %");

        jLabel22.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel22.setText("CGST %");

        cgst.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        cgst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cgstKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cgstKeyReleased(evt);
            }
        });

        sgst.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        sgst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sgstKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sgstKeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel24.setText("SGST %");

        jLabel25.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel25.setText("Amount :");

        amt.setEditable(false);
        amt.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        amt.setEnabled(false);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel26.setText("Description Type :");

        config.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        config.setText("NIL");

        jLabel27.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel27.setText("Configration :");

        jLabel28.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel28.setText("Warranty :");

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        jLabel4.setText("/");

        cgstamt.setEditable(false);
        cgstamt.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        cgstamt.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        jLabel5.setText("/");

        sgstamt.setEditable(false);
        sgstamt.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        sgstamt.setEnabled(false);

        jLabel29.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel29.setText("Final Amount :");

        finalamt.setEditable(false);
        finalamt.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        finalamt.setEnabled(false);

        disc.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        disc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                discKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        jLabel6.setText("/");

        discamt.setEditable(false);
        discamt.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        discamt.setEnabled(false);

        rate.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        rate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rateKeyReleased(evt);
            }
        });

        warranty.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        warranty.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NIL", "3 Months", "6 Months", "1 Year", "2 Years", "3 Years", "4 Years", "5 Years", "6 Years" }));

        DescType.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        DescType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT HERE", "Computer", "Laptop", "Storage Media", "Input Devices", "Output Devices", "Other" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DescType, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hsnsac, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amt, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cgst, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cgstamt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sgst, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(sgstamt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disc, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(discamt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finalamt, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(warranty, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(config)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Description, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(qty)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hsnsac)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(amt)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DescType, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sgstamt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cgstamt)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sgst)
                    .addComponent(cgst)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(discamt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(disc)
                    .addComponent(config, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(warranty)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(finalamt)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bill_tot.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        bill_tot.setText("0.00");
        bill_tot.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Final Amount :");

        jLabel11.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Balance/Due :");

        balance.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        balance.setText("0.00");
        balance.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Total Qty :");

        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Total Amt :");

        tot_qty.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_qty.setText("0.0");
        tot_qty.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tot_amt.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_amt.setText("0.00");
        tot_amt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tot_amt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tot_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bill_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tot_qty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tot_amt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bill_tot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(balance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel36.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel36.setText("Tax %");

        jLabel8.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel8.setText("Tax Amt");

        tot_tax_a.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_tax_a.setText("0.00");
        tot_tax_a.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tot_tax_p.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_tax_p.setText("0.00");
        tot_tax_p.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tot_cgst_per.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_cgst_per.setText("0.00");
        tot_cgst_per.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel30.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("CGST %");

        jLabel31.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("CGST Amt");

        tot_cgst_amt.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_cgst_amt.setText("0.00");
        tot_cgst_amt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel32.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("SGST %");

        jLabel33.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("SGST Amt");

        tot_sgst_per.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_sgst_per.setText("0.00");
        tot_sgst_per.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tot_sgst_amt.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_sgst_amt.setText("0.00");
        tot_sgst_amt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel34.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Discount %");

        jLabel35.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Discount Amt");

        tot_discount_per.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_discount_per.setText("0.00");
        tot_discount_per.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tot_discount_amt.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_discount_amt.setText("0.00");
        tot_discount_amt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tot_cgst_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tot_cgst_amt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tot_sgst_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tot_sgst_amt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tot_tax_a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tot_tax_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tot_discount_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tot_discount_amt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tot_cgst_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tot_sgst_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tot_discount_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tot_cgst_amt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tot_sgst_amt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tot_discount_amt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tot_tax_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tot_tax_a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        all_table.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        all_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "Desc Type", "HSN / SAC", "QTY", "Rate", "Amount", "CGST %", "CGST Amt", "SGST %", "SGST Amt", "DISC %", "DISC Amt", "Warranty", "Configration", "Final Amt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        all_table.setFocusable(false);
        all_table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        all_table.setRowHeight(25);
        all_table.setSelectionBackground(new java.awt.Color(232, 57, 95));
        all_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        all_table.setShowVerticalLines(false);
        all_table.getTableHeader().setReorderingAllowed(false);
        all_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(all_table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(204, 255, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), new java.awt.Color(51, 255, 0)));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jButton1.setText("Add to Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jButton3.setText("Remove All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Paid Amount :");

        paid_amt.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        paid_amt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paid_amtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paid_amtKeyReleased(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel38.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Mode of Payment");

        paymentmode.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        paymentmode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Wallet/UPI", "Cheque", "Debit Card", "Credit Card" }));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Baskerville Old Face", 0, 17)); // NOI18N
        jButton7.setText("Update Record");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jSeparator3)))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(paymentmode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addComponent(paid_amt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addGap(0, 0, 0)
                .addComponent(paymentmode, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(paid_amt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel16.setText("Logged in As :-");

        adminname.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        adminname.setForeground(new java.awt.Color(255, 0, 0));
        adminname.setText("Amit Kumar");

        jLabel18.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        jLabel18.setText("ADMIN -");

        timeshow.setBackground(new java.awt.Color(255, 255, 255));
        timeshow.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        timeshow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/time.png"))); // NOI18N
        timeshow.setText("EEEE, d MMMM yyyy hh:mm:ss:aa");

        admibid.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        admibid.setForeground(new java.awt.Color(255, 0, 0));
        admibid.setText("Amit Kumar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admibid, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(adminname, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timeshow)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(adminname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(timeshow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(admibid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        adminname.setText(""+empname);
        Timer timer;
        ActionListener actionListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Date date = new Date();
                DateFormat timeFormat = new SimpleDateFormat("EEEE, d MMMM yyyy hh:mm:ss:aa");
                String times = timeFormat.format(date);
                timeshow.setText(times);
            }
        };
        timer = new Timer(1000, actionListener);
        timer.setInitialDelay(0);
        timer.start();
        admibid.setText(""+empid);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        // TODO add your handling code here:
        jButton10.setBackground(Color.RED);
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
        // TODO add your handling code here:
        jButton10.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jButton10MouseExited

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        try{
            String inserttask =( "LogOut By This Admin:- "+admibid.getText()+" "+adminname.getText());
            String userinsert = "insert into history (sno, User_Id, User_Name, Date_Time, User_Task) values(null,'"+admibid.getText()+"','"+adminname.getText()+"','"+timeshow.getText()+"','"+inserttask+"')";
            pst = conn.prepareStatement(userinsert);
            pst.executeUpdate(); 
            Login l = new Login();
            l.setVisible(true);
            dispose();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        ViewInvoice vi = new ViewInvoice();
        vi.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)all_table.getModel();
        model.setRowCount(0);
        try {
            String query = "select * from product WHERE Supplier_Name = '"+ Suppliername.getText()+"' or Supplier_ID = '"+ Supplierid.getText()+"' or Invoice_No = '"+ Invoiceno.getText()+"' or GST_No = '"+ GSTno.getText()+"'";
            PreparedStatement statement = conn.prepareStatement(query);
            rs=statement.executeQuery() ;
            while (rs.next()) {
                String desc=rs.getString("Description");
                String desc_t=rs.getString("Desc_Type");
                String hsn_sac=rs.getString("HSN_SAC");
                String qty=rs.getString("Quantity");
                String per_unit_rate=rs.getString("Per_Unit_Rate");
                String total_amt=rs.getString("Total_Amount");       
                String cgst_per=rs.getString("CGST_Rate");
                String cgst_amt=rs.getString("CGST_Amt");
                String sgst_per=rs.getString("SGST_Rate");
                String sgst_amt=rs.getString("SGST_Amt");
                String disc_per=rs.getString("Discount_Rate");
                String disc_amt=rs.getString("Discount_Amt");
                String warr_per=rs.getString("Warranty_period");                
                String Config=rs.getString("Configuration");
                String payment_type=rs.getString("Mode_of_Payment");
                paymentmode.setSelectedItem(payment_type);
                String f_amt=rs.getString("Final_Amount");

                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("Date_Of_Purchase"));
                DateOfPurchase.setDate(date);
                
                Object[] row = {desc, desc_t, hsn_sac, qty, per_unit_rate, total_amt, cgst_per, cgst_amt, sgst_per, sgst_amt, 
                disc_per, disc_amt, warr_per, Config, f_amt};
                model.addRow(row);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        cart_total();
        tot();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Description.setText("");
        DescType.setSelectedItem("SELECT HERE");
        warranty.setSelectedItem("NIL");
        Description.setText("");
        DescType.setSelectedItem("SELECT HERE");
        warranty.setSelectedItem("NIL");
        hsnsac.setText("");
        qty.setText("");
        rate.setText("");
        disc.setText("");
        discamt.setText("");
        cgst.setText("");
        cgstamt.setText("");
        sgst.setText("");        
        sgstamt.setText("");
        amt.setText("");
        finalamt.setText("");        
        config.setText("NIL");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void rateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateKeyReleased
        // TODO add your handling code here:
        String l=rate.getText();
        float length=l.length();
        if(length > 0){        
            float  totqty=Float.parseFloat(qty.getText());
            float  perunit=Float.parseFloat(rate.getText());
            float totamt=totqty*perunit;
            amt.setText(String.format("%.2f",totamt));
            finalamt.setText(String.format("%.2f",totamt));
            float cgstper=Float.parseFloat(cgst.getText());
            float sgstper=Float.parseFloat(sgst.getText());
            float discper=Float.parseFloat(disc.getText());

            float totcgst=totamt*cgstper/100;
            cgstamt.setText(String.format("%.2f",totcgst));
            float totsgst=totamt*sgstper/100;
            sgstamt.setText(String.format("%.2f",totsgst));
            float totdisc=totamt*discper/100;
            discamt.setText(String.format("%.2f",totdisc));

            float finaltotal=(totamt+totcgst+totsgst)-totdisc;
            finalamt.setText(String.format("%.2f",finaltotal));
        }
        else{
            float  totqty=Float.parseFloat(qty.getText());
            float  perunit=0;
            float totamt=totqty*perunit;
            amt.setText(String.format("%.2f",totamt));
            finalamt.setText(String.format("%.2f",totamt));
            float cgstper=Float.parseFloat(cgst.getText());
            float sgstper=Float.parseFloat(sgst.getText());
            float discper=Float.parseFloat(disc.getText());

            float totcgst=totamt*cgstper/100;
            cgstamt.setText(String.format("%.2f",totcgst));
            
            float totsgst=totamt*sgstper/100;
            sgstamt.setText(String.format("%.2f",totsgst));
            
            float totdisc=totamt*discper/100;
            discamt.setText(String.format("%.2f",totdisc));

            float finaltotal=(totamt+totcgst+totsgst)-totdisc;
            finalamt.setText(String.format("%.2f",finaltotal));
        }
    }//GEN-LAST:event_rateKeyReleased

    private void cgstKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cgstKeyReleased
        // TODO add your handling code here:
        String l=cgst.getText();
        int cl=Integer.parseInt(l);
        float length=l.length();
        if(length > 0){
            if(cl<=9){
                float totqty=Float.parseFloat(qty.getText());
                float perunit=Float.parseFloat(rate.getText());
                float totamt=totqty*perunit;
                amt.setText(String.format("%.2f",totamt));
                finalamt.setText(String.format("%.2f",totamt));

                float cgstper=Float.parseFloat(cgst.getText());
                float totcgst=totamt*cgstper/100;
                cgstamt.setText(String.format("%.2f",totcgst));

                String b=sgst.getText();
                float blen=b.length();
                float totsgst=0;
                if(blen>0){
                    float sgstper=Float.parseFloat(sgst.getText());
                    totsgst=totamt*sgstper/100;
                }else{
                    float sgstper=0;
                    totsgst=totamt*sgstper/100;               
                }sgstamt.setText(String.format("%.2f",totsgst));

                String c=disc.getText();
                float clen=c.length();
                float totdisc=0;
                if(blen>0){
                    float discper=Float.parseFloat(disc.getText());    
                    totdisc=totamt*discper/100;
                }else{
                    float discper=0;    
                    totdisc=totamt*discper/100;
                }discamt.setText(String.format("%.2f",totdisc));

                float totfinal=(totamt+totcgst+totsgst)-totdisc;
                finalamt.setText(String.format("%.2f",totfinal));
            }else{
                JOptionPane.showMessageDialog(null,"CGST can't be exceed 9%.");
                cgst.setText("0");
            }
        }else{
            float totqty=Float.parseFloat(qty.getText());
            float perunit=Float.parseFloat(rate.getText());
            float totamt=totqty*perunit;
            amt.setText(String.format("%.2f",totamt));
            finalamt.setText(String.format("%.2f",totamt));

            float cgstper=0;
            float totcgst=totamt*cgstper/100;
            cgstamt.setText(String.format("%.2f",totcgst));

            float sgstper=Float.parseFloat(sgst.getText());
            float totsgst=totamt*sgstper/100;
            sgstamt.setText(String.format("%.2f",totsgst));

            float discper=Float.parseFloat(disc.getText());       
            float totdisc=totamt*discper/100;
            discamt.setText(String.format("%.2f",totdisc)); 

            float totfinal=(totamt+totcgst+totsgst)-totdisc;
            finalamt.setText(String.format("%.2f",totfinal));
        }
    }//GEN-LAST:event_cgstKeyReleased

    private void sgstKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sgstKeyReleased
        // TODO add your handling code here:
        String l=sgst.getText();
        int sl=Integer.parseInt(l);
        float length=l.length();
        if(length > 0){
            if(sl<=9){               
                float totqty=Float.parseFloat(qty.getText());
                float perunit=Float.parseFloat(rate.getText());
                float totamt=totqty*perunit;
                amt.setText(String.format("%.2f",totamt));
                finalamt.setText(String.format("%.2f",totamt));

                String a=cgst.getText();
                float alen=a.length();
                float totcgst=0;
                if(alen>0){
                    float cgstper=Float.parseFloat(cgst.getText());
                    totcgst=totamt*cgstper/100;
                }else{
                    float cgstper=0;
                    totcgst=totamt*cgstper/100;              
                }cgstamt.setText(String.format("%.2f",totcgst));

                float sgstper=Float.parseFloat(sgst.getText());
                float totsgst=totamt*sgstper/100;
                sgstamt.setText(String.format("%.2f",totsgst));

                String c=disc.getText();
                float clen=c.length();
                float totdisc=0;
                if(clen>0){
                    float discper=Float.parseFloat(disc.getText());    
                    totdisc=totamt*discper/100;
                }else{
                    float discper=0;    
                    totdisc=totamt*discper/100;
                }discamt.setText(String.format("%.2f",totdisc));

                float totfinal=(totamt+totcgst+totsgst)-totdisc;
                finalamt.setText(String.format("%.2f",totfinal));
            }else{
                JOptionPane.showMessageDialog(null,"SGST can't be exceed 9%.");
                sgst.setText("0");
            }
        }else{
            float totqty=Float.parseFloat(qty.getText());
            float perunit=Float.parseFloat(rate.getText());
            float totamt=totqty*perunit;
            amt.setText(String.format("%.2f",totamt));
            finalamt.setText(String.format("%.2f",totamt));

            float cgstper=Float.parseFloat(cgst.getText());
            float totcgst=totamt*cgstper/100;
            cgstamt.setText(String.format("%.2f",totcgst));

            float sgstper=0;
            float totsgst=totamt*sgstper/100;
            sgstamt.setText(String.format("%.2f",totsgst));

            float discper=Float.parseFloat(disc.getText());   
            float totdisc=totamt*discper/100;
            discamt.setText(String.format("%.2f",totdisc));

            float totfinal=(totamt+totcgst+totsgst)-totdisc;
            finalamt.setText(String.format("%.2f",totfinal));
        }
    }//GEN-LAST:event_sgstKeyReleased

    private void discKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discKeyReleased
        // TODO add your handling code here:
        String l=disc.getText();
        int dl=Integer.parseInt(l);
        float length=l.length();
        if(length > 0){
            if(dl<=100){
                float totqty=Float.parseFloat(qty.getText());
                float perunit=Float.parseFloat(rate.getText());
                float totamt=totqty*perunit;
                amt.setText(String.format("%.2f",totamt));
                finalamt.setText(String.format("%.2f",totamt));

                String a=cgst.getText();
                float alen=a.length();
                float totcgst=0;
                if(alen>0){
                    float cgstper=Float.parseFloat(cgst.getText());
                    totcgst=totamt*cgstper/100;
                }else{
                    float cgstper=0;
                    totcgst=totamt*cgstper/100;              
                }cgstamt.setText(String.format("%.2f",totcgst));

                String b=sgst.getText();
                float blen=b.length();
                float totsgst=0;
                if(blen>0){
                    float sgstper=Float.parseFloat(sgst.getText());
                    totsgst=totamt*sgstper/100;
                }else{
                    float sgstper=0;
                    totsgst=totamt*sgstper/100;              
                }sgstamt.setText(String.format("%.2f",totsgst));

                float discper=Float.parseFloat(disc.getText());
                float totdisc=totamt*discper/100;
                discamt.setText(String.format("%.2f",totdisc));

                float totfinal=(totamt+totcgst+totsgst)-totdisc;
                finalamt.setText(String.format("%.2f",totfinal));
            }else{
                JOptionPane.showMessageDialog(null,"Discount can't be exceed 100%.");
                disc.setText("0");
            }
        }else{
            float totqty=Float.parseFloat(qty.getText());
            float perunit=Float.parseFloat(rate.getText());
            float totamt=totqty*perunit;
            amt.setText(String.format("%.2f",totamt));
            finalamt.setText(String.format("%.2f",totamt));

            float cgstper=Float.parseFloat(cgst.getText());
            float totcgst=totamt*cgstper/100;
            cgstamt.setText(String.format("%.2f",totcgst));

            float sgstper=Float.parseFloat(sgst.getText());
            float totsgst=totamt*sgstper/100;
            sgstamt.setText(String.format("%.2f",totsgst));

            float discper=0;
            float totdisc=totamt*discper/100;
            discamt.setText(String.format("%.2f",totdisc));

            float totfinal=(totamt+totcgst+totsgst)-totdisc;
            finalamt.setText(String.format("%.2f",totfinal));
        }
    }//GEN-LAST:event_discKeyReleased

    private void qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyReleased
        // TODO add your handling code here:
        String l=qty.getText();
        int length=l.length();
        if(length > 0){
            float totqty=Float.parseFloat(qty.getText());
            float perunit=Float.parseFloat(rate.getText());
            float totamt=totqty*perunit;
            amt.setText(String.format("%.2f",totamt));
            finalamt.setText(String.format("%.2f",totamt));

            float cgstper=Float.parseFloat(cgst.getText());
            float sgstper=Float.parseFloat(sgst.getText());
            float discper=Float.parseFloat(disc.getText());

            float totcgst=totamt*cgstper/100;
            cgstamt.setText(String.format("%.2f",totcgst));
            float totsgst=totamt*sgstper/100;
            sgstamt.setText(String.format("%.2f",totsgst));
            float totdisc=totamt*discper/100;
            discamt.setText(String.format("%.2f",totdisc)); 

            float totfinal=(totamt+totcgst+totsgst)-totdisc;
            finalamt.setText(String.format("%.2f",totfinal));
        }else{
            float totqty=0;
            float perunit=Float.parseFloat(rate.getText());
            float totamt=totqty*perunit;
            amt.setText(String.format("%.2f",totamt));
            finalamt.setText(String.format("%.2f",totamt));

            float cgstper=Float.parseFloat(cgst.getText());
            float sgstper=Float.parseFloat(sgst.getText());
            float discper=Float.parseFloat(disc.getText());

            float totcgst=totamt*cgstper/100;
            cgstamt.setText(String.format("%.2f",totcgst));

            float totsgst=totamt*sgstper/100;
            sgstamt.setText(String.format("%.2f",totsgst));

            float totdisc=totamt*discper/100;
            discamt.setText(String.format("%.2f",totdisc)); 

            float totfinal=(totamt+totcgst+totsgst)-totdisc;
            finalamt.setText(String.format("%.2f",totfinal));            
        }
    }//GEN-LAST:event_qtyKeyReleased

    private void qtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyPressed
        // TODO add your handling code here:
        String value = qty.getText();
        int l = value.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            qty.setEditable(true);
            //label.setText("");
        }
        else {
            qty.setEditable(false);
            JOptionPane.showMessageDialog(null, "* Enter only numeric digits(0-9)");
        }
    }//GEN-LAST:event_qtyKeyPressed

    private void rateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateKeyPressed
        // TODO add your handling code here:
        String value = rate.getText();
        int l = value.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar() == '.' || evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            rate.setEditable(true);
            //label.setText("");
        }
        else {
            rate.setEditable(false);
            JOptionPane.showMessageDialog(null, "* Enter only numeric digits(0-9)");
        }        
    }//GEN-LAST:event_rateKeyPressed

    private void cgstKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cgstKeyPressed
        // TODO add your handling code here:
        String value = cgst.getText();
        int l = value.length();
        
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar() == '.'|| evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            cgst.setEditable(true);
            //label.setText("");
        }
        else {
            cgst.setEditable(false);
            JOptionPane.showMessageDialog(null, "* Enter only numeric digits(0-9)");
        }        
    }//GEN-LAST:event_cgstKeyPressed

    private void sgstKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sgstKeyPressed
        // TODO add your handling code here:
        String value = sgst.getText();
        int l = value.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar() == '.'|| evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            sgst.setEditable(true);
            //label.setText("");
        }
        else {
            sgst.setEditable(false);
            JOptionPane.showMessageDialog(null, "* Enter only numeric digits(0-9)");
        }        
    }//GEN-LAST:event_sgstKeyPressed

    private void discKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discKeyPressed
        // TODO add your handling code here:
        String value = disc.getText();
        int l = value.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar() == '.'|| evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            disc.setEditable(true);
            //label.setText("");
        }
        else {
            disc.setEditable(false);
            JOptionPane.showMessageDialog(null, "* Enter only numeric digits(0-9)");
        }        
    }//GEN-LAST:event_discKeyPressed

    private void all_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_tableMouseClicked
        // TODO add your handling code here:
        try{
            int i =all_table.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel)all_table.getModel();
            Description.setText(model.getValueAt (i,0).toString());
            DescType.setSelectedItem(model.getValueAt (i,1).toString());
            hsnsac.setText(model.getValueAt (i,2).toString());
            qty.setText(model.getValueAt (i,3).toString());
            rate.setText(model.getValueAt (i,4).toString());
            amt.setText(model.getValueAt (i,5).toString());
            cgst.setText(model.getValueAt (i,6).toString());
            cgstamt.setText(model.getValueAt (i,7).toString());
            sgst.setText(model.getValueAt (i,8).toString());
            sgstamt.setText(model.getValueAt (i,9).toString());
            disc.setText(model.getValueAt (i,10).toString());
            discamt.setText(model.getValueAt (i,11).toString());
            warranty.setSelectedItem(model.getValueAt (i,12).toString());            
            config.setText(model.getValueAt (i,13).toString());
            finalamt.setText(model.getValueAt (i,14).toString());
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }         
    }//GEN-LAST:event_all_tableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dt = (DefaultTableModel) all_table.getModel();
        Vector v = new Vector();
        v.add(Description.getText());
        v.add(DescType.getSelectedItem().toString());
        v.add(hsnsac.getText());
        v.add(qty.getText());
        v.add(rate.getText());
        v.add(amt.getText());
        v.add(cgst.getText());
        v.add(cgstamt.getText());
        v.add(sgst.getText());
        v.add(sgstamt.getText());
        v.add(disc.getText());
        v.add(discamt.getText());
        v.add(warranty.getSelectedItem().toString());
        v.add(config.getText());
        v.add(finalamt.getText());
        dt.addRow(v);

        cart_total();
        tot();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel dt = (DefaultTableModel) all_table.getModel();
            int rw = all_table.getSelectedRow();
            dt.removeRow(rw);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Please Select record from cart");
        }
        cart_total();
        tot();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dt = (DefaultTableModel) all_table.getModel();
        dt.setRowCount(0);
        cart_total();
        tot();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Suppliername.setText("SELECT HERE");
        Supplierid.setText("");
        DescType.setSelectedItem("SELECT HERE");
        warranty.setSelectedItem("NIL");
        GSTno.setText("");
        Invoiceno.setText("");
        DateOfPurchase.setDate(null);
        Description.setText("");
        hsnsac.setText("");
        qty.setText("");
        rate.setText("");
        disc.setText("");
        discamt.setText("");
        cgst.setText("");
        cgstamt.setText("");
        sgst.setText("");
        sgstamt.setText("");
        amt.setText("");
        finalamt.setText("");
        paid_amt.setText("0");
        tot_qty.setText("0");
        bill_tot.setText("0.00");
        balance.setText("0.00");
        config.setText("NIL");
        DefaultTableModel dt = (DefaultTableModel) all_table.getModel();
        dt.setRowCount(0);
        cart_total();
        tot();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void paid_amtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paid_amtKeyPressed
        // TODO add your handling code here:
        String value = paid_amt.getText();
        int l = value.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyChar() == '.' || evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            paid_amt.setEditable(true);
            //label.setText("");
        }
        else {
            paid_amt.setEditable(false);
            JOptionPane.showMessageDialog(null, "* Enter only numeric digits(0-9)");
        }
    }//GEN-LAST:event_paid_amtKeyPressed

    private void paid_amtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paid_amtKeyReleased
        // TODO add your handling code here:
        String pamt=paid_amt.getText();
        int paid_length=pamt.length();
        if(paid_length > 0){
            tot();
        }else{
            balance.setText("0.00");
        }
    }//GEN-LAST:event_paid_amtKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try {
            Double ctot = Double.valueOf(bill_tot.getText());
            Double cpid = Double.valueOf(paid_amt.getText());
            Double bal = Double.valueOf(balance.getText());
            String Status = null;
            if (cpid.equals(0.0)) {
                Status = "UnPaid ";
            }else if (ctot>cpid) {
                Status = "Partial "+bal;

            }else if (ctot<=cpid) {
                Status = "Full Paid";
            }
            SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
            String idop = Date_Format.format(DateOfPurchase.getDate());
            String iquery = "INSERT INTO invoice(SNo, Invoice_No, Supplier_ID, Supplier_Name, GST_No, Date_Of_Purchase, Total_Quantity, Total_Rate, CGST_Tax_Per, CGST_Tax_Amt, SGST_Tax_Per, SGST_Tax_Amt, Total_Tax_Per, Total_Tax, Discount_Per, Total_Discount, Final_Amount, Mode_of_Payment, Balance) "
            + "VALUES (null,'"+Invoiceno.getText()+"','"+Supplierid.getText()+"','"+Suppliername.getText()+"','"+GSTno.getText()+"','"+idop+"',"+tot_qty.getText()+","+tot_amt.getText()+","+tot_cgst_per.getText()+","+tot_cgst_amt.getText()+","+tot_sgst_per.getText()+","+tot_sgst_amt.getText()+","+tot_tax_p.getText()+","+tot_tax_a.getText()+","+tot_discount_per.getText()+","+tot_discount_amt.getText()+","+bill_tot.getText()+",'"+paymentmode.getSelectedItem()+"','"+Status+"')";
            pst = conn.prepareStatement(iquery);
            pst.executeUpdate();

            DefaultTableModel dt = (DefaultTableModel) all_table.getModel();
            int rc = dt.getRowCount();
            for (int i = 0; i < rc; i++) {
                String gen = dt.getValueAt(i, 1).toString();
                if(gen=="Computer"){
                    String idesc = dt.getValueAt(i, 0).toString();
                    String idesctype = dt.getValueAt(i, 1).toString();
                    String ihsn = dt.getValueAt(i, 2).toString();
                    String iqty = dt.getValueAt(i, 3).toString();
                    String irate = dt.getValueAt(i, 4).toString();
                    String iamount = dt.getValueAt(i, 5).toString();
                    String icgst = dt.getValueAt(i, 6).toString();
                    String icgstamt = dt.getValueAt(i, 7).toString();
                    String isgst = dt.getValueAt(i, 8).toString();
                    String isgstamt = dt.getValueAt(i, 9).toString();
                    String idisc = dt.getValueAt(i, 10).toString();
                    String idiscamt = dt.getValueAt(i, 11).toString();
                    String ifinalamt = dt.getValueAt(i, 14).toString();
                    String iwarranty = dt.getValueAt(i, 12).toString();
                    String iconfigration = dt.getValueAt(i, 13).toString();

                    String pquery = "INSERT INTO product(SNo, Invoice_No, Supplier_ID, Supplier_Name, GST_No, Date_Of_Purchase, Description, Desc_Type, HSN_SAC, Quantity, Per_Unit_Rate, Total_Amount, CGST_Rate, CGST_Amt, SGST_Rate, SGST_Amt, Discount_Rate, Discount_Amt, Final_Amount, Mode_of_Payment, Warranty_period, Configuration)"
                    + "VALUES (null,'"+Invoiceno.getText()+"','"+Supplierid.getText()+"','"+Suppliername.getText()+"','"+GSTno.getText()+"','"+idop+"','"+idesc+"','"+idesctype+"','"+ihsn+"',"+iqty+","+irate+","+iamount+","+icgst+","+icgstamt+","+isgst+","+isgstamt+","+idisc+","+idiscamt+","+ifinalamt+",'"+paymentmode.getSelectedItem()+"','"+iwarranty+"','"+iconfigration+"')";
                    pst  = conn.prepareStatement(pquery);
                    pst.executeUpdate();

                    for(int cl=1;cl<=Integer.parseInt(iqty);cl++){
                        String query1="select * from temp_invoice;";
                        PreparedStatement statement1 = conn.prepareStatement(query1);
                        rs=statement1.executeQuery();
                        rs.last();{
                            String cno=rs.getString("computer");
                            String idno=rs.getString("input_devices");
                            String lno=rs.getString("laptop");
                            String oino=rs.getString("other_items");
                            String odno=rs.getString("output_devices");
                            String smno=rs.getString("storage_media");
                            String rno=rs.getString("Repair_ID");
                            String sid=rs.getString("Supplier_ID");
                            String eid=rs.getString("emp_id");
                            int inno=Integer.parseInt(cno);
                            int value1=inno+1;
                            String id=( "COM-"+ value1);
                            String insertcom = "insert into temp_invoice (sno, computer, input_devices, laptop, other_items, output_devices, storage_media, Repair_ID, Supplier_ID, emp_id) values(null,"+value1+","+idno+","+lno+","+oino+","+odno+","+smno+","+rno+","+sid+","+eid+")";
                            pst = conn.prepareStatement(insertcom);
                            pst.executeUpdate();

                            String wquery = "INSERT INTO warranty(SNo, Unique_ID, Invoice_No, Supplier_ID, Supplier_Name, GST_No, Description, Desc_Type, Date_Of_Purchase, Warranty_period, Configuration) "
                            + "VALUES (null,'"+id+"','"+Invoiceno.getText()+"','"+Supplierid.getText()+"','"+Suppliername.getText()+"','"+GSTno.getText()+"','"+idesc+"','"+idesctype+"','"+idop+"','"+iwarranty+"','"+iconfigration+"');";
                            pst = conn.prepareStatement(wquery);
                            pst.executeUpdate();
                        }
                    }
                }
                else if(gen=="Laptop"){
                    String idesc = dt.getValueAt(i, 0).toString();
                    String idesctype = dt.getValueAt(i, 1).toString();
                    String ihsn = dt.getValueAt(i, 2).toString();
                    String iqty = dt.getValueAt(i, 3).toString();
                    String irate = dt.getValueAt(i, 4).toString();
                    String iamount = dt.getValueAt(i, 5).toString();
                    String icgst = dt.getValueAt(i, 6).toString();
                    String icgstamt = dt.getValueAt(i, 7).toString();
                    String isgst = dt.getValueAt(i, 8).toString();
                    String isgstamt = dt.getValueAt(i, 9).toString();
                    String idisc = dt.getValueAt(i, 10).toString();
                    String idiscamt = dt.getValueAt(i, 11).toString();
                    String ifinalamt = dt.getValueAt(i, 14).toString();
                    String iwarranty = dt.getValueAt(i, 12).toString();
                    String iconfigration = dt.getValueAt(i, 13).toString();

                    String pquery = "INSERT INTO product(SNo, Invoice_No, Supplier_ID, Supplier_Name, GST_No, Date_Of_Purchase, Description, Desc_Type, HSN_SAC, Quantity, Per_Unit_Rate, Total_Amount, CGST_Rate, CGST_Amt, SGST_Rate, SGST_Amt, Discount_Rate, Discount_Amt, Final_Amount, Mode_of_Payment, Warranty_period, Configuration)"
                    + "VALUES (null,'"+Invoiceno.getText()+"','"+Supplierid.getText()+"','"+Suppliername.getText()+"','"+GSTno.getText()+"','"+idop+"','"+idesc+"','"+idesctype+"','"+ihsn+"',"+iqty+","+irate+","+iamount+","+icgst+","+icgstamt+","+isgst+","+isgstamt+","+idisc+","+idiscamt+","+ifinalamt+",'"+paymentmode.getSelectedItem()+"','"+iwarranty+"','"+iconfigration+"')";
                    pst  = conn.prepareStatement(pquery);
                    pst.executeUpdate();

                    for(int ll=1;ll<=Integer.parseInt(iqty);ll++){
                        String query1="select * from temp_invoice;";
                        PreparedStatement statement1 = conn.prepareStatement(query1);
                        rs=statement1.executeQuery();
                        rs.last();{
                            String cno=rs.getString("computer");
                            String idno=rs.getString("input_devices");
                            String lno=rs.getString("laptop");
                            String oino=rs.getString("other_items");
                            String odno=rs.getString("output_devices");
                            String smno=rs.getString("storage_media");
                            String rno=rs.getString("Repair_ID");
                            String sid=rs.getString("Supplier_ID");
                            String eid=rs.getString("emp_id");
                            int inno=Integer.parseInt(lno);
                            int value1=inno+1;
                            String id=( "LAP-"+ value1);
                            String insertcom = "insert into temp_invoice (sno, computer, input_devices, laptop, other_items, output_devices, storage_media, Repair_ID, Supplier_ID, emp_id) values(null,"+cno+","+idno+","+value1+","+oino+","+odno+","+smno+","+rno+","+sid+","+eid+")";
                            pst = conn.prepareStatement(insertcom);
                            pst.executeUpdate();

                            String wquery = "INSERT INTO warranty(SNo, Unique_ID, Invoice_No, Supplier_ID, Supplier_Name, GST_No, Description, Desc_Type, Date_Of_Purchase, Warranty_period, Configuration) "
                            + "VALUES (null,'"+id+"','"+Invoiceno.getText()+"','"+Supplierid.getText()+"','"+Suppliername.getText()+"','"+GSTno.getText()+"','"+idesc+"','"+idesctype+"','"+idop+"','"+iwarranty+"','"+iconfigration+"');";
                            pst = conn.prepareStatement(wquery);
                            pst.executeUpdate();
                        }
                    }
                }
                else if(gen=="Storage Media"){
                    String idesc = dt.getValueAt(i, 0).toString();
                    String idesctype = dt.getValueAt(i, 1).toString();
                    String ihsn = dt.getValueAt(i, 2).toString();
                    String iqty = dt.getValueAt(i, 3).toString();
                    String irate = dt.getValueAt(i, 4).toString();
                    String iamount = dt.getValueAt(i, 5).toString();
                    String icgst = dt.getValueAt(i, 6).toString();
                    String icgstamt = dt.getValueAt(i, 7).toString();
                    String isgst = dt.getValueAt(i, 8).toString();
                    String isgstamt = dt.getValueAt(i, 9).toString();
                    String idisc = dt.getValueAt(i, 10).toString();
                    String idiscamt = dt.getValueAt(i, 11).toString();
                    String ifinalamt = dt.getValueAt(i, 14).toString();
                    String iwarranty = dt.getValueAt(i, 12).toString();
                    String iconfigration = dt.getValueAt(i, 13).toString();

                    String pquery = "INSERT INTO product(SNo, Invoice_No, Supplier_ID, Supplier_Name, GST_No, Date_Of_Purchase, Description, Desc_Type, HSN_SAC, Quantity, Per_Unit_Rate, Total_Amount, CGST_Rate, CGST_Amt, SGST_Rate, SGST_Amt, Discount_Rate, Discount_Amt, Final_Amount, Mode_of_Payment, Warranty_period, Configuration)"
                    + "VALUES (null,'"+Invoiceno.getText()+"','"+Supplierid.getText()+"','"+Suppliername.getText()+"','"+GSTno.getText()+"','"+idop+"','"+idesc+"','"+idesctype+"','"+ihsn+"',"+iqty+","+irate+","+iamount+","+icgst+","+icgstamt+","+isgst+","+isgstamt+","+idisc+","+idiscamt+","+ifinalamt+",'"+paymentmode.getSelectedItem()+"','"+iwarranty+"','"+iconfigration+"')";
                    pst  = conn.prepareStatement(pquery);
                    pst.executeUpdate();

                    for(int sml=1;sml<=Integer.parseInt(iqty);sml++){
                        String query1="select * from temp_invoice;";
                        PreparedStatement statement1 = conn.prepareStatement(query1);
                        rs=statement1.executeQuery();
                        rs.last();{
                            String cno=rs.getString("computer");
                            String idno=rs.getString("input_devices");
                            String lno=rs.getString("laptop");
                            String oino=rs.getString("other_items");
                            String odno=rs.getString("output_devices");
                            String smno=rs.getString("storage_media");
                            String rno=rs.getString("Repair_ID");
                            String sid=rs.getString("Supplier_ID");
                            String eid=rs.getString("emp_id");
                            int inno=Integer.parseInt(smno);
                            int value1=inno+1;
                            String id=( "SM-"+ value1);
                            String insertcom = "insert into temp_invoice (sno, computer, input_devices, laptop, other_items, output_devices, storage_media, Repair_ID, Supplier_ID, emp_id) values(null,"+cno+","+idno+","+lno+","+oino+","+odno+","+value1+","+rno+","+sid+","+eid+")";
                            pst = conn.prepareStatement(insertcom);
                            pst.executeUpdate();

                            String wquery = "INSERT INTO warranty(SNo, Unique_ID, Invoice_No, Supplier_ID, Supplier_Name, GST_No, Description, Desc_Type, Date_Of_Purchase, Warranty_period, Configuration) "
                            + "VALUES (null,'"+id+"','"+Invoiceno.getText()+"','"+Supplierid.getText()+"','"+Suppliername.getText()+"','"+GSTno.getText()+"','"+idesc+"','"+idesctype+"','"+idop+"','"+iwarranty+"','"+iconfigration+"');";
                            pst = conn.prepareStatement(wquery);
                            pst.executeUpdate();
                        }
                    }
                }
                else if(gen=="Input Devices"){
                    String idesc = dt.getValueAt(i, 0).toString();
                    String idesctype = dt.getValueAt(i, 1).toString();
                    String ihsn = dt.getValueAt(i, 2).toString();
                    String iqty = dt.getValueAt(i, 3).toString();
                    String irate = dt.getValueAt(i, 4).toString();
                    String iamount = dt.getValueAt(i, 5).toString();
                    String icgst = dt.getValueAt(i, 6).toString();
                    String icgstamt = dt.getValueAt(i, 7).toString();
                    String isgst = dt.getValueAt(i, 8).toString();
                    String isgstamt = dt.getValueAt(i, 9).toString();
                    String idisc = dt.getValueAt(i, 10).toString();
                    String idiscamt = dt.getValueAt(i, 11).toString();
                    String ifinalamt = dt.getValueAt(i, 14).toString();
                    String iwarranty = dt.getValueAt(i, 12).toString();
                    String iconfigration = dt.getValueAt(i, 13).toString();

                    String pquery = "INSERT INTO product(SNo, Invoice_No, Supplier_ID, Supplier_Name, GST_No, Date_Of_Purchase, Description, Desc_Type, HSN_SAC, Quantity, Per_Unit_Rate, Total_Amount, CGST_Rate, CGST_Amt, SGST_Rate, SGST_Amt, Discount_Rate, Discount_Amt, Final_Amount, Mode_of_Payment, Warranty_period, Configuration)"
                    + "VALUES (null,'"+Invoiceno.getText()+"','"+Supplierid.getText()+"','"+Suppliername.getText()+"','"+GSTno.getText()+"','"+idop+"','"+idesc+"','"+idesctype+"','"+ihsn+"',"+iqty+","+irate+","+iamount+","+icgst+","+icgstamt+","+isgst+","+isgstamt+","+idisc+","+idiscamt+","+ifinalamt+",'"+paymentmode.getSelectedItem()+"','"+iwarranty+"','"+iconfigration+"')";
                    pst  = conn.prepareStatement(pquery);
                    pst.executeUpdate();

                    for(int idl=1;idl<=Integer.parseInt(iqty);idl++){
                        String query1="select * from temp_invoice;";
                        PreparedStatement statement1 = conn.prepareStatement(query1);
                        rs=statement1.executeQuery();
                        rs.last();{
                            String cno=rs.getString("computer");
                            String idno=rs.getString("input_devices");
                            String lno=rs.getString("laptop");
                            String oino=rs.getString("other_items");
                            String odno=rs.getString("output_devices");
                            String smno=rs.getString("storage_media");
                            String rno=rs.getString("Repair_ID");
                            String sid=rs.getString("Supplier_ID");
                            String eid=rs.getString("emp_id");
                            int inno=Integer.parseInt(idno);
                            int value1=inno+1;
                            String id=( "ID-"+ value1);
                            String insertcom = "insert into temp_invoice (sno, computer, input_devices, laptop, other_items, output_devices, storage_media, Repair_ID, Supplier_ID, emp_id) values(null,"+cno+","+value1+","+lno+","+oino+","+odno+","+smno+","+rno+","+sid+","+eid+")";
                            pst = conn.prepareStatement(insertcom);
                            pst.executeUpdate();

                            String wquery = "INSERT INTO warranty(SNo, Unique_ID, Invoice_No, Supplier_ID, Supplier_Name, GST_No, Description, Desc_Type, Date_Of_Purchase, Warranty_period, Configuration) "
                            + "VALUES (null,'"+id+"','"+Invoiceno.getText()+"','"+Supplierid.getText()+"','"+Suppliername.getText()+"','"+GSTno.getText()+"','"+idesc+"','"+idesctype+"','"+idop+"','"+iwarranty+"','"+iconfigration+"');";
                            pst = conn.prepareStatement(wquery);
                            pst.executeUpdate();
                        }
                    }
                }
                else if(gen=="Output Devices"){
                    String idesc = dt.getValueAt(i, 0).toString();
                    String idesctype = dt.getValueAt(i, 1).toString();
                    String ihsn = dt.getValueAt(i, 2).toString();
                    String iqty = dt.getValueAt(i, 3).toString();
                    String irate = dt.getValueAt(i, 4).toString();
                    String iamount = dt.getValueAt(i, 5).toString();
                    String icgst = dt.getValueAt(i, 6).toString();
                    String icgstamt = dt.getValueAt(i, 7).toString();
                    String isgst = dt.getValueAt(i, 8).toString();
                    String isgstamt = dt.getValueAt(i, 9).toString();
                    String idisc = dt.getValueAt(i, 10).toString();
                    String idiscamt = dt.getValueAt(i, 11).toString();
                    String ifinalamt = dt.getValueAt(i, 14).toString();
                    String iwarranty = dt.getValueAt(i, 12).toString();
                    String iconfigration = dt.getValueAt(i, 13).toString();

                    String pquery = "INSERT INTO product(SNo, Invoice_No, Supplier_ID, Supplier_Name, GST_No, Date_Of_Purchase, Description, Desc_Type, HSN_SAC, Quantity, Per_Unit_Rate, Total_Amount, CGST_Rate, CGST_Amt, SGST_Rate, SGST_Amt, Discount_Rate, Discount_Amt, Final_Amount, Mode_of_Payment, Warranty_period, Configuration)"
                    + "VALUES (null,'"+Invoiceno.getText()+"','"+Supplierid.getText()+"','"+Suppliername.getText()+"','"+GSTno.getText()+"','"+idop+"','"+idesc+"','"+idesctype+"','"+ihsn+"',"+iqty+","+irate+","+iamount+","+icgst+","+icgstamt+","+isgst+","+isgstamt+","+idisc+","+idiscamt+","+ifinalamt+",'"+paymentmode.getSelectedItem()+"','"+iwarranty+"','"+iconfigration+"')";
                    pst  = conn.prepareStatement(pquery);
                    pst.executeUpdate();

                    for(int odl=1;odl<=Integer.parseInt(iqty);odl++){
                        String query1="select * from temp_invoice;";
                        PreparedStatement statement1 = conn.prepareStatement(query1);
                        rs=statement1.executeQuery();
                        rs.last();{
                            String cno=rs.getString("computer");
                            String idno=rs.getString("input_devices");
                            String lno=rs.getString("laptop");
                            String oino=rs.getString("other_items");
                            String odno=rs.getString("output_devices");
                            String smno=rs.getString("storage_media");
                            String rno=rs.getString("Repair_ID");
                            String sid=rs.getString("Supplier_ID");
                            String eid=rs.getString("emp_id");
                            int inno=Integer.parseInt(odno);
                            int value1=inno+1;
                            String id=( "OD-"+ value1);
                            String insertcom = "insert into temp_invoice (sno, computer, input_devices, laptop, other_items, output_devices, storage_media, Repair_ID, Supplier_ID, emp_id) values(null,"+cno+","+idno+","+lno+","+oino+","+value1+","+smno+","+rno+","+sid+","+eid+")";
                            pst = conn.prepareStatement(insertcom);
                            pst.executeUpdate();

                            String wquery = "INSERT INTO warranty(SNo, Unique_ID, Invoice_No, Supplier_ID, Supplier_Name, GST_No, Description, Desc_Type, Date_Of_Purchase, Warranty_period, Configuration) "
                            + "VALUES (null,'"+id+"','"+Invoiceno.getText()+"','"+Supplierid.getText()+"','"+Suppliername.getText()+"','"+GSTno.getText()+"','"+idesc+"','"+idesctype+"','"+idop+"','"+iwarranty+"','"+iconfigration+"');";
                            pst = conn.prepareStatement(wquery);
                            pst.executeUpdate();
                        }
                    }
                }
                else if(gen=="Other"){
                    String idesc = dt.getValueAt(i, 0).toString();
                    String idesctype = dt.getValueAt(i, 1).toString();
                    String ihsn = dt.getValueAt(i, 2).toString();
                    String iqty = dt.getValueAt(i, 3).toString();
                    String irate = dt.getValueAt(i, 4).toString();
                    String iamount = dt.getValueAt(i, 5).toString();
                    String icgst = dt.getValueAt(i, 6).toString();
                    String icgstamt = dt.getValueAt(i, 7).toString();
                    String isgst = dt.getValueAt(i, 8).toString();
                    String isgstamt = dt.getValueAt(i, 9).toString();
                    String idisc = dt.getValueAt(i, 10).toString();
                    String idiscamt = dt.getValueAt(i, 11).toString();
                    String ifinalamt = dt.getValueAt(i, 14).toString();
                    String iwarranty = dt.getValueAt(i, 12).toString();
                    String iconfigration = dt.getValueAt(i, 13).toString();

                    String pquery = "INSERT INTO product(SNo, Invoice_No, Supplier_ID, Supplier_Name, GST_No, Date_Of_Purchase, Description, Desc_Type, HSN_SAC, Quantity, Per_Unit_Rate, Total_Amount, CGST_Rate, CGST_Amt, SGST_Rate, SGST_Amt, Discount_Rate, Discount_Amt, Final_Amount, Mode_of_Payment, Warranty_period, Configuration)"
                    + "VALUES (null,'"+Invoiceno.getText()+"','"+Supplierid.getText()+"','"+Suppliername.getText()+"','"+GSTno.getText()+"','"+idop+"','"+idesc+"','"+idesctype+"','"+ihsn+"',"+iqty+","+irate+","+iamount+","+icgst+","+icgstamt+","+isgst+","+isgstamt+","+idisc+","+idiscamt+","+ifinalamt+",'"+paymentmode.getSelectedItem()+"','"+iwarranty+"','"+iconfigration+"')";
                    pst  = conn.prepareStatement(pquery);
                    pst.executeUpdate();

                    for(int ol=1;ol<=Integer.parseInt(iqty);ol++){
                        String query1="select * from temp_invoice;";
                        PreparedStatement statement1 = conn.prepareStatement(query1);
                        rs=statement1.executeQuery();
                        rs.last();{
                            String cno=rs.getString("computer");
                            String idno=rs.getString("input_devices");
                            String lno=rs.getString("laptop");
                            String oino=rs.getString("other_items");
                            String odno=rs.getString("output_devices");
                            String smno=rs.getString("storage_media");
                            String rno=rs.getString("Repair_ID");
                            String sid=rs.getString("Supplier_ID");
                            String eid=rs.getString("emp_id");
                            int inno=Integer.parseInt(oino);
                            int value1=inno+1;
                            String id=( "OTH-"+ value1);
                            String insertcom = "insert into temp_invoice (sno, computer, input_devices, laptop, other_items, output_devices, storage_media, Repair_ID, Supplier_ID, emp_id) values(null,"+cno+","+idno+","+lno+","+value1+","+odno+","+smno+","+rno+","+sid+","+eid+")";
                            pst = conn.prepareStatement(insertcom);
                            pst.executeUpdate();

                            String wquery = "INSERT INTO warranty(SNo, Unique_ID, Invoice_No, Supplier_ID, Supplier_Name, GST_No, Description, Desc_Type, Date_Of_Purchase, Warranty_period, Configuration) "
                            + "VALUES (null,'"+id+"','"+Invoiceno.getText()+"','"+Supplierid.getText()+"','"+Suppliername.getText()+"','"+GSTno.getText()+"','"+idesc+"','"+idesctype+"','"+idop+"','"+iwarranty+"','"+iconfigration+"');";
                            pst = conn.prepareStatement(wquery);
                            pst.executeUpdate();
                        }
                    }
                }
            }
            
            String inserttask =("The record (Invoice No)"+Invoiceno.getText()+" are updated by this Admin :- "+adminname.getText());
            String userinsert = "insert into history (sno, User_Id, User_Name, Date_Time, User_Task) values(null,'"+admibid.getText()+"','"+adminname.getText()+"','"+timeshow.getText()+"','"+inserttask+"')";
            pst = conn.prepareStatement(userinsert);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Records Add successfully");
            Invoice iv = new Invoice();
            iv.setVisible(true);
            dispose();
        } catch (Exception e) {
            //System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    //empid= args[0];
    //empname=args[1];
    iinvono=args[0];
    isid=args[1];
    isuppname=args[2];
    igst=args[3];
    empid=args[4];
    empname=args[5];

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
            java.util.logging.Logger.getLogger(ViewInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>



        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateInvoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateOfPurchase;
    private javax.swing.JComboBox<String> DescType;
    private javax.swing.JTextField Description;
    private javax.swing.JTextField Description6;
    private javax.swing.JTextField GSTno;
    private javax.swing.JTextField Invoiceno;
    private javax.swing.JTextField Supplierid;
    private javax.swing.JTextField Suppliername;
    private javax.swing.JLabel admibid;
    private javax.swing.JLabel adminname;
    private javax.swing.JTable all_table;
    private javax.swing.JTextField amt;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel bill_tot;
    private javax.swing.JTextField cgst;
    private javax.swing.JTextField cgstamt;
    private javax.swing.JTextField config;
    private javax.swing.JTextField disc;
    private javax.swing.JTextField discamt;
    private javax.swing.JTextField finalamt;
    private javax.swing.JTextField hsnsac;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField paid_amt;
    private javax.swing.JComboBox<String> paymentmode;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField rate;
    private javax.swing.JTextField sgst;
    private javax.swing.JTextField sgstamt;
    private javax.swing.JLabel timeshow;
    private javax.swing.JLabel tot_amt;
    private javax.swing.JLabel tot_cgst_amt;
    private javax.swing.JLabel tot_cgst_per;
    private javax.swing.JLabel tot_discount_amt;
    private javax.swing.JLabel tot_discount_per;
    private javax.swing.JLabel tot_qty;
    private javax.swing.JLabel tot_sgst_amt;
    private javax.swing.JLabel tot_sgst_per;
    private javax.swing.JLabel tot_tax_a;
    private javax.swing.JLabel tot_tax_p;
    private javax.swing.JComboBox<String> warranty;
    // End of variables declaration//GEN-END:variables
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/trending 512.png")));
    }
}
