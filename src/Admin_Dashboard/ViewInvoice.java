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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Amit Kumar
 */
public class ViewInvoice extends javax.swing.JFrame {
public static String empname,empid;    
Connection conn;
ResultSet rs;
PreparedStatement pst;
    /**
     * Creates new form NewJFrame
     */
    public ViewInvoice() {
        setIcon();
        initComponents();
        conn=MySqlConnect.ConnecrDb();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //code for show supplier in combobox        
        try{
            String query="select * from supplier;";
            PreparedStatement statement = conn.prepareStatement(query);
            rs=statement.executeQuery(); 
            while(rs.next())
            {
                Suppliername.addItem(rs.getString("Shop_Name"));
            }
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        }
        
        //code for show supplier invoice
        DefaultTableModel model=(DefaultTableModel)all_table.getModel();
        model.setRowCount(0);        
        try{
            String query="select * from invoice;";
            PreparedStatement statement = conn.prepareStatement(query);
            rs=statement.executeQuery(); 
            while(rs.next())
            {
                String sno=rs.getString("SNo");
                String invoice_no=rs.getString("Invoice_No");
                String supplier_id=rs.getString("Supplier_ID");
                String supplier_name=rs.getString("Supplier_Name");
                String gst_no=rs.getString("GST_No");
                String date_of_purchase=rs.getString("Date_Of_Purchase");
                String total_quantity=rs.getString("Total_Quantity");
                String total_rate=rs.getString("Total_Rate");
                String cgst_tax_per=rs.getString("CGST_Tax_Per");
                String cgst_tax_amt=rs.getString("CGST_Tax_Amt");
                String sgst_tax_per=rs.getString("SGST_Tax_Per");
                String sgst_tax_amt=rs.getString("SGST_Tax_Amt");
                String total_tax_per=rs.getString("Total_Tax_Per");
                String total_tax=rs.getString("Total_Tax");
                String discount_per=rs.getString("Discount_Per");
                String total_discount=rs.getString("Total_Discount");
                String final_amount=rs.getString("Final_Amount");
                String payment_type=rs.getString("Mode_of_Payment");
                String balance=rs.getString("Balance");
                
                Object[] row = {sno, invoice_no, supplier_id, supplier_name, gst_no, date_of_purchase, total_quantity, total_rate, cgst_tax_per, 
                cgst_tax_amt, sgst_tax_per, sgst_tax_amt, total_tax_per, total_tax, discount_per, total_discount, final_amount, payment_type, balance};
                model.addRow(row);
            }
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        }        
    }
    
/*        //total Final amount of billing.
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
        double qtytotal = 0;
        for (int i = 0; i < qtyofrow; i++) {
            double qtyvalue = Double.valueOf(all_table.getValueAt(i, 3).toString());
            qtytotal += qtyvalue ;
        }
        tot_qty.setText(Double.toString(qtytotal));
        
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
    }*/
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
        Suppliername = new javax.swing.JComboBox<String>();
        jLabel13 = new javax.swing.JLabel();
        GSTno = new javax.swing.JTextField();
        Invoiceno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        DateOfPurchase = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        all_table = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        bill_tot = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
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
        jLabel8 = new javax.swing.JLabel();
        tot_tax_a = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        tot_tax_p = new javax.swing.JLabel();
        tot_qty = new javax.swing.JLabel();
        tot_amt = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home (3).png"))); // NOI18N
        jButton14.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home (1).png"))); // NOI18N
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

        Suppliername.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        Suppliername.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT HERE" }));
        Suppliername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppliernameActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel13.setText("GST No :");

        GSTno.setEditable(false);
        GSTno.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        GSTno.setEnabled(false);
        GSTno.setOpaque(false);

        Invoiceno.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel14.setText("Date Of Purchase :");

        DateOfPurchase.setDateFormatString("dd MMM, yyyy");
        DateOfPurchase.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Suppliername, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GSTno, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Invoiceno, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateOfPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Suppliername, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateOfPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Invoiceno)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(GSTno, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addContainerGap())
        );

        DateOfPurchase.setMaxSelectableDate(new Date());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        all_table.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        all_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNo", "Invoice No", "Supplier ID", "Supplier Name", "GST No", "Date Of Purchase", "Total Quantity", "Total Rate", "CGST %", "CGST Amt", "SGST %", "SGST Amt", "Total Tax %", "Total Tax Amt", "Discount %", "Discount Amt", "Final Amt", "Payment Type", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bill_tot.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        bill_tot.setText("00.00");
        bill_tot.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Final Amount :");

        jLabel11.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Balance/Due :");

        balance.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        balance.setText("00.00");
        balance.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(balance, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(bill_tot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bill_tot, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(balance, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tot_cgst_per.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_cgst_per.setText("00.00");
        tot_cgst_per.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel30.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("CGST %");

        jLabel31.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("CGST Amt");

        tot_cgst_amt.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_cgst_amt.setText("00.00");
        tot_cgst_amt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel32.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("SGST %");

        jLabel33.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("SGST Amt");

        tot_sgst_per.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_sgst_per.setText("00.00");
        tot_sgst_per.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tot_sgst_amt.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_sgst_amt.setText("00.00");
        tot_sgst_amt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel34.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Discount %");

        jLabel35.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Discount Amt");

        tot_discount_per.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_discount_per.setText("00.00");
        tot_discount_per.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tot_discount_amt.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_discount_amt.setText("00.00");
        tot_discount_amt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel8.setText("Tax Amt");

        tot_tax_a.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_tax_a.setText("00.00");
        tot_tax_a.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel36.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel36.setText("Tax %");

        tot_tax_p.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_tax_p.setText("00.00");
        tot_tax_p.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tot_qty.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_qty.setText("00");

        tot_amt.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        tot_amt.setText("00.00");

        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Total Amt :");

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Total Qty :");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tot_qty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tot_amt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tot_tax_a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tot_tax_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tot_qty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tot_amt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tot_cgst_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tot_sgst_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tot_discount_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tot_tax_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tot_cgst_amt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tot_sgst_amt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tot_discount_amt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        Admin_Dashboard ad = new Admin_Dashboard();
        ad.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void SuppliernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppliernameActionPerformed
        // TODO add your handling code here:
        try {
            String query = "select * from supplier WHERE Shop_Name = '"+ Suppliername.getSelectedItem()+"'";
            PreparedStatement statement = conn.prepareStatement(query);
            rs=statement.executeQuery() ;
            while (rs.next()) {
                String gst  = rs.getString("GST_No");
                GSTno.setText(gst);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }        
    }//GEN-LAST:event_SuppliernameActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Suppliername.setSelectedItem("SELECT HERE");
        GSTno.setText("");
        Invoiceno.setText("");
        DateOfPurchase.setDate(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void all_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_tableMouseClicked
        // TODO add your handling code here:
        try{
            int i =all_table.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel)all_table.getModel();           
            String rid[]=new String[6];
            rid[0]=model.getValueAt (i,1).toString();
            rid[1]=model.getValueAt (i,2).toString();
            rid[2]=model.getValueAt (i,3).toString();
            rid[3]=model.getValueAt (i,4).toString();
            rid[4]=admibid.getText();
            rid[5]=adminname.getText();
            UpdateInvoice.main(rid);
            this.setVisible(false);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_all_tableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    empid= args[0];
    empname=args[1];     
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
                new ViewInvoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateOfPurchase;
    private javax.swing.JTextField Description6;
    private javax.swing.JTextField GSTno;
    private javax.swing.JTextField Invoiceno;
    private javax.swing.JComboBox<String> Suppliername;
    private javax.swing.JLabel admibid;
    private javax.swing.JLabel adminname;
    private javax.swing.JTable all_table;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel bill_tot;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KGradientPanel kGradientPanel1;
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
    // End of variables declaration//GEN-END:variables
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/trending 512.png")));
    }
}
