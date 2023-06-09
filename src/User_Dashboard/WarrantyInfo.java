/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_Dashboard;

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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amit Kumar
 */
public class WarrantyInfo extends javax.swing.JFrame {
public static String empname,empid;    
Connection conn;
ResultSet rs;
PreparedStatement pst;
    /**
     * Creates new form History
     */
    public WarrantyInfo() {
        setIcon();
        initComponents();
        conn=MySqlConnect.ConnecrDb();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // SHOW USER IN A TABLE
        DefaultTableModel model=(DefaultTableModel)all_table.getModel();
        model.setRowCount(0);
        try{
            String query1="select * from warranty;";
            PreparedStatement statement1 = conn.prepareStatement(query1);
            rs=statement1.executeQuery();
            while(rs.next())
            {
                String sno=rs.getString("SNo");
                String uniqueid=rs.getString("Unique_ID");
                String invoiceno=rs.getString("Invoice_No");
                String supplierid=rs.getString("Supplier_ID");
                String suppliername=rs.getString("Supplier_Name");
                String gstno=rs.getString("GST_No");
                String description=rs.getString("Description");
                String desctype=rs.getString("Desc_Type");
                String dateofpurchase=rs.getString("Date_Of_Purchase");
                String warrantyperiod=rs.getString("Warranty_period");
                String configuration=rs.getString("Configuration");                
                Object[] row = {sno,uniqueid,invoiceno,supplierid,suppliername,gstno,description,desctype,dateofpurchase,warrantyperiod,configuration};
                model.addRow(row);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        all_table = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        sortby = new javax.swing.JComboBox<String>();
        searchby = new javax.swing.JComboBox<String>();
        id = new javax.swing.JTextField();
        Clear = new javax.swing.JButton();
        searchid = new javax.swing.JComboBox<String>();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        adminname = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        timeshow = new javax.swing.JLabel();
        admibid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 255, 204));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Poor Richard", 0, 40)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Stock Management System");

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

        jButton15.setBackground(new java.awt.Color(152, 201, 45));
        jButton15.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home (3).png"))); // NOI18N
        jButton15.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home (1).png"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        all_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNo", "Unique ID", "Invoice No", "Supplier ID", "Supplier Name", "GST No", "Description", "Description Type", "Date Of Purchase", "Warranty", "Configuration"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        all_table.setFocusable(false);
        all_table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        all_table.setRowHeight(25);
        all_table.setSelectionBackground(new java.awt.Color(232, 57, 95));
        all_table.setShowVerticalLines(false);
        all_table.getTableHeader().setReorderingAllowed(false);
        all_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(all_table);

        jLabel15.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Search By :-");

        jLabel17.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Sort By :-");

        sortby.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        sortby.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT HERE", "NIL", "Warranty Over", "3 Months", "6 Months", "1 Year", "2 Years", "3 Years", "4 Years", "5 Years", "6 Years" }));
        sortby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortbyActionPerformed(evt);
            }
        });

        searchby.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        searchby.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT HERE", "Computer", "Laptop", "Storage Media", "Input Devices", "Output Devices", "Other" }));
        searchby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbyActionPerformed(evt);
            }
        });

        id.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idKeyReleased(evt);
            }
        });

        Clear.setBackground(new java.awt.Color(255, 255, 255));
        Clear.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        searchid.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        searchid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Unique_ID", "Invoice_No" }));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchid, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sortby, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(id)
                    .addComponent(searchid)
                    .addComponent(searchby)
                    .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sortby))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
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
        jLabel18.setText("USER -");

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
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            String inserttask =( "LogOut By This User:- "+admibid.getText()+" "+adminname.getText());
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

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        Dashboard ad = new Dashboard();
        ad.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        searchby.setSelectedItem("SELECT HERE");
        sortby.setSelectedItem("SELECT HERE");
        searchid.setSelectedItem("Unique_ID");
        id.setText("");
        DefaultTableModel model=(DefaultTableModel)all_table.getModel();
        model.setRowCount(0);
        try{
            String query1="select * from warranty;";
            PreparedStatement statement1 = conn.prepareStatement(query1);
            rs=statement1.executeQuery();
            while(rs.next())
            {
                String sno=rs.getString("SNo");
                String uniqueid=rs.getString("Unique_ID");
                String invoiceno=rs.getString("Invoice_No");
                String supplierid=rs.getString("Supplier_ID");
                String suppliername=rs.getString("Supplier_Name");
                String gstno=rs.getString("GST_No");
                String description=rs.getString("Description");
                String desctype=rs.getString("Desc_Type");
                String dateofpurchase=rs.getString("Date_Of_Purchase");
                String warrantyperiod=rs.getString("Warranty_period");
                String configuration=rs.getString("Configuration");                
                Object[] row = {sno,uniqueid,invoiceno,supplierid,suppliername,gstno,description,desctype,dateofpurchase,warrantyperiod,configuration};
                model.addRow(row);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_ClearActionPerformed

    private void searchbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbyActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)all_table.getModel();
        model.setRowCount(0);
        try{
            String query1="select * from warranty where Desc_Type = '"+searchby.getSelectedItem()+"'";
            PreparedStatement statement1 = conn.prepareStatement(query1);
            rs=statement1.executeQuery();
            while(rs.next())
            {
                String sno=rs.getString("SNo");
                String uniqueid=rs.getString("Unique_ID");
                String invoiceno=rs.getString("Invoice_No");
                String supplierid=rs.getString("Supplier_ID");
                String suppliername=rs.getString("Supplier_Name");
                String gstno=rs.getString("GST_No");
                String description=rs.getString("Description");
                String desctype=rs.getString("Desc_Type");
                String dateofpurchase=rs.getString("Date_Of_Purchase");
                String warrantyperiod=rs.getString("Warranty_period");
                String configuration=rs.getString("Configuration");                
                Object[] row = {sno,uniqueid,invoiceno,supplierid,suppliername,gstno,description,desctype,dateofpurchase,warrantyperiod,configuration};
                model.addRow(row);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }        
    }//GEN-LAST:event_searchbyActionPerformed

    private void idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)all_table.getModel();
        model.setRowCount(0);
        try{
            String query1="select * from warranty where "+searchid.getSelectedItem()+" LIKE \""+id.getText()+"%\";";
            PreparedStatement statement1 = conn.prepareStatement(query1);
            rs=statement1.executeQuery();
            while(rs.next())
            {
                String sno=rs.getString("SNo");
                String uniqueid=rs.getString("Unique_ID");
                String invoiceno=rs.getString("Invoice_No");
                String supplierid=rs.getString("Supplier_ID");
                String suppliername=rs.getString("Supplier_Name");
                String gstno=rs.getString("GST_No");
                String description=rs.getString("Description");
                String desctype=rs.getString("Desc_Type");
                String dateofpurchase=rs.getString("Date_Of_Purchase");
                String warrantyperiod=rs.getString("Warranty_period");
                String configuration=rs.getString("Configuration");                
                Object[] row = {sno,uniqueid,invoiceno,supplierid,suppliername,gstno,description,desctype,dateofpurchase,warrantyperiod,configuration};
                model.addRow(row);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }         
    }//GEN-LAST:event_idKeyReleased

    private void sortbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortbyActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)all_table.getModel();
        model.setRowCount(0);
        try{
            String query1="select * from warranty where Warranty_period = '"+sortby.getSelectedItem()+"'";
            PreparedStatement statement1 = conn.prepareStatement(query1);
            rs=statement1.executeQuery();
            while(rs.next())
            {
                String sno=rs.getString("SNo");
                String uniqueid=rs.getString("Unique_ID");
                String invoiceno=rs.getString("Invoice_No");
                String supplierid=rs.getString("Supplier_ID");
                String suppliername=rs.getString("Supplier_Name");
                String gstno=rs.getString("GST_No");
                String description=rs.getString("Description");
                String desctype=rs.getString("Desc_Type");
                String dateofpurchase=rs.getString("Date_Of_Purchase");
                String warrantyperiod=rs.getString("Warranty_period");
                String configuration=rs.getString("Configuration");                
                Object[] row = {sno,uniqueid,invoiceno,supplierid,suppliername,gstno,description,desctype,dateofpurchase,warrantyperiod,configuration};
                model.addRow(row);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }         
    }//GEN-LAST:event_sortbyActionPerformed

    private void all_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_tableMouseClicked
        // TODO add your handling code here:
        try{
            int i =all_table.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel)all_table.getModel();
            String uniqueid = model.getValueAt (i,1).toString();
            String invoiceno = model.getValueAt (i,2).toString();
            String supplierid = model.getValueAt (i,3).toString();
            String desctype = model.getValueAt (i,7).toString();
            String dateofpurchase = model.getValueAt (i,8).toString();
            System.out.println(uniqueid);
            String WarrantyUpdate[] = {"Warranty Over", "3 Months", "6 Months", "1 Year", "2 Years", "3 Years", "4 Years", "5 Years", "6 Years"};
            JComboBox cb = new JComboBox(WarrantyUpdate);
            int input = JOptionPane.showConfirmDialog(this, cb, "Warranty Period Update", JOptionPane.DEFAULT_OPTION);
            String str = (String)cb.getSelectedItem();
            if(input == JOptionPane.OK_OPTION){
                String data[] ={"ONLY ONE", "ALL"};
                JComboBox cb2 = new JComboBox(data);
                int input2 = JOptionPane.showConfirmDialog(this, cb2, "Choose Update Warranty Period", JOptionPane.DEFAULT_OPTION);
                String str2 = (String)cb2.getSelectedItem();
                if(str2 == "ONLY ONE"){
                    String ooquery = "UPDATE warranty SET Warranty_period='"+str+"' where Unique_ID = '"+uniqueid+"'";
                    pst =conn.prepareStatement(ooquery);
                    pst.executeUpdate();
                    String ooquery1 = "UPDATE product SET Warranty_period='"+str+"' where Invoice_No = '"+invoiceno+"' and Date_Of_Purchase = '"+dateofpurchase+"' and Supplier_ID = '"+supplierid+"' and Desc_Type ='"+desctype+"'";
                    pst =conn.prepareStatement(ooquery1);
                    int status=pst.executeUpdate();
                    if(status > 0) {
                        String inserttask =("The warranty (Unique ID)"+uniqueid+" are updated by this user :- "+adminname.getText());
                        String userinsert = "insert into history (sno, User_Id, User_Name, Date_Time, User_Task) values(null,'"+admibid.getText()+"','"+adminname.getText()+"','"+timeshow.getText()+"','"+inserttask+"')";
                        pst = conn.prepareStatement(userinsert);
                        pst.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null,"Warranty Period Update Successfully...");
                        WarrantyInfo wi = new WarrantyInfo();
                        wi.setVisible(true);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"ERROR FOUND.");
                    }
                }
                else if(str2 == "ALL"){
                    String aquery = "UPDATE warranty SET Warranty_period='"+str+"' where  Invoice_No = '"+invoiceno+"' and Desc_Type ='"+desctype+"' and Supplier_ID = '"+supplierid+"'";
                    pst =conn.prepareStatement(aquery);
                    pst.executeUpdate();
                    String aquery1 = "UPDATE product SET Warranty_period='"+str+"' where Invoice_No = '"+invoiceno+"' and Date_Of_Purchase = '"+dateofpurchase+"' and Supplier_ID = '"+supplierid+"' and Desc_Type ='"+desctype+"'";
                    pst =conn.prepareStatement(aquery1);
                    int status=pst.executeUpdate();
                    if(status > 0) {
                        JOptionPane.showMessageDialog(null,"Warranty Period Update Successfully...");
                            WarrantyInfo wi = new WarrantyInfo();
                            wi.setVisible(true);
                            dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"ERROR FOUND.");
                    }
                }else{
                        JOptionPane.showMessageDialog(null,"ERROR FOUND.");
                }         
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        } 
    }//GEN-LAST:event_all_tableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    empid=args[0];
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
            java.util.logging.Logger.getLogger(WarrantyInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WarrantyInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WarrantyInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WarrantyInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WarrantyInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JLabel admibid;
    private javax.swing.JLabel adminname;
    private javax.swing.JTable all_table;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton15;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JComboBox<String> searchby;
    private javax.swing.JComboBox<String> searchid;
    private javax.swing.JComboBox<String> sortby;
    private javax.swing.JLabel timeshow;
    // End of variables declaration//GEN-END:variables
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/trending 512.png")));
    }
}
