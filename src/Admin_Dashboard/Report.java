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
/**
 *
 * @author Amit Kumar
 */
public class Report extends javax.swing.JFrame {
public static String empname,empid;    
Connection conn;
ResultSet rs;
PreparedStatement pst;
    /**
     * Creates new form History
     */
    public Report() {
        setIcon();
        initComponents();
        conn=MySqlConnect.ConnecrDb();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        try{
            int CSum=0,CPSum=0;
            String query="SELECT SUM(Quantity) AS ComSum, SUM(Final_Amount) AS PriComSum FROM product WHERE Desc_Type = 'Computer';";
            PreparedStatement statement = conn.prepareStatement(query);
            rs=statement.executeQuery();
            while(rs.next()){
                CSum = rs.getInt("ComSum");
                CPSum = rs.getInt("PriComSum");
                sComputer.setText(""+CSum);
                pComputer.setText(""+CPSum);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            int LSum=0,LPSum=0;
            String query="SELECT SUM(Quantity) AS LapSum, SUM(Final_Amount) AS PriLapSum FROM product WHERE Desc_Type = 'Laptop';";
            PreparedStatement statement = conn.prepareStatement(query);
            rs=statement.executeQuery();
            while(rs.next()){
                LSum = rs.getInt("LapSum");
                LPSum = rs.getInt("PriLapSum");
                sLaptop.setText(""+LSum);
                plaptop.setText(""+LPSum);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            int STSum=0,STPSum=0;
            String query="SELECT SUM(Quantity) AS STSum, SUM(Final_Amount) AS PriSTSum FROM product WHERE Desc_Type = 'Storage Media';";
            PreparedStatement statement = conn.prepareStatement(query);
            rs=statement.executeQuery();
            while(rs.next()){
                STSum = rs.getInt("STSum");
                STPSum = rs.getInt("PriSTSum");
                sstoragemedia.setText(""+STSum);
                pstoragemedia.setText(""+STPSum);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            int ODSum=0,ODPSum=0;
            String query="SELECT SUM(Quantity) AS ODSum, SUM(Final_Amount) AS PriODSum FROM product WHERE Desc_Type = 'Output Devices';";
            PreparedStatement statement = conn.prepareStatement(query);
            rs=statement.executeQuery();
            while(rs.next()){
                ODSum = rs.getInt("ODSum");
                ODPSum = rs.getInt("PriODSum");
                soutputdevices.setText(""+ODSum);
                poutputdevices.setText(""+ODPSum);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            int IDSum=0,IDPSum=0;
            String query="SELECT SUM(Quantity) AS IDSum, SUM(Final_Amount) AS PriIDSum FROM product WHERE Desc_Type = 'Input Devices';";
            PreparedStatement statement = conn.prepareStatement(query);
            rs=statement.executeQuery();
            while(rs.next()){
                IDSum = rs.getInt("IDSum");
                IDPSum = rs.getInt("PriIDSum");
                sinputdevices.setText(""+IDSum);
                pinputdevices.setText(""+IDPSum);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            int OtSum=0,OtPSum=0;
            String query="SELECT SUM(Quantity) AS OtSum, SUM(Final_Amount) AS PriOtSum FROM product WHERE Desc_Type = 'Other';";
            PreparedStatement statement = conn.prepareStatement(query);
            rs=statement.executeQuery();
            while(rs.next()){
                OtSum = rs.getInt("OtSum");
                OtPSum = rs.getInt("PriOtSum");
                sOther.setText(""+OtSum);
                pOther.setText(""+OtPSum);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            int CRepairIn=0;
            String query="SELECT COUNT(SNo) AS Countrin FROM repairin;";
            PreparedStatement statement = conn.prepareStatement(query);
            rs=statement.executeQuery();
            while(rs.next()){
                CRepairIn = rs.getInt("Countrin");
                repairin.setText(""+CRepairIn);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            int CRepairOut=0;
            String query="SELECT COUNT(SNo) AS Countrout FROM repairout;";
            PreparedStatement statement = conn.prepareStatement(query);
            rs=statement.executeQuery();
            while(rs.next()){
                CRepairOut = rs.getInt("Countrout");
                repairout.setText(""+CRepairOut);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            int CRepairinYes=0;
            String query="SELECT COUNT(Resolve_Problem) AS Countrinyes FROM repairin WHERE Resolve_Problem = 'YES';";
            PreparedStatement statement = conn.prepareStatement(query);
            rs=statement.executeQuery();
            while(rs.next()){
                CRepairinYes = rs.getInt("Countrinyes");
                yes.setText(""+CRepairinYes);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            int CRepairinNo=0;
            String query="SELECT COUNT(Resolve_Problem) AS Countrinno FROM repairin WHERE Resolve_Problem = 'NO';";
            PreparedStatement statement = conn.prepareStatement(query);
            rs=statement.executeQuery();
            while(rs.next()){
                CRepairinNo = rs.getInt("Countrinno");
                no.setText(""+CRepairinNo);
            }
        }catch(Exception e){
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        repairout = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        repairin = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        sComputer = new javax.swing.JLabel();
        pComputer = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        soutputdevices = new javax.swing.JLabel();
        poutputdevices = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        sLaptop = new javax.swing.JLabel();
        plaptop = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        sinputdevices = new javax.swing.JLabel();
        pinputdevices = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        sstoragemedia = new javax.swing.JLabel();
        pstoragemedia = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        sOther = new javax.swing.JLabel();
        pOther = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        yes = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        no = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setOpaque(false);

        jPanel10.setBackground(new java.awt.Color(204, 255, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Repair", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bookman Old Style", 0, 24))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Repair Out", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 18))); // NOI18N

        repairout.setBackground(new java.awt.Color(204, 204, 255));
        repairout.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        repairout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        repairout.setText("0");
        repairout.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(repairout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(repairout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Repair In", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 18))); // NOI18N

        repairin.setBackground(new java.awt.Color(204, 204, 255));
        repairin.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        repairin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        repairin.setText("0");
        repairin.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(repairin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(repairin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(204, 255, 204));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bookman Old Style", 0, 24))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Computer", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Bookman Old Style", 0, 18))); // NOI18N

        sComputer.setBackground(new java.awt.Color(204, 204, 255));
        sComputer.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        sComputer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sComputer.setText("0");
        sComputer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Quantity", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 14))); // NOI18N
        sComputer.setOpaque(true);

        pComputer.setBackground(new java.awt.Color(204, 204, 255));
        pComputer.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        pComputer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pComputer.setText("0");
        pComputer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Price", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 14))); // NOI18N
        pComputer.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pComputer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sComputer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sComputer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pComputer)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Output Devices", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Bookman Old Style", 0, 18))); // NOI18N

        soutputdevices.setBackground(new java.awt.Color(204, 204, 255));
        soutputdevices.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        soutputdevices.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        soutputdevices.setText("0");
        soutputdevices.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Quantity", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 14))); // NOI18N
        soutputdevices.setOpaque(true);

        poutputdevices.setBackground(new java.awt.Color(204, 204, 255));
        poutputdevices.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        poutputdevices.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poutputdevices.setText("0");
        poutputdevices.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Price", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 14))); // NOI18N
        poutputdevices.setOpaque(true);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(soutputdevices, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addComponent(poutputdevices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(soutputdevices)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(poutputdevices))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 153));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laptop", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Bookman Old Style", 0, 18))); // NOI18N

        sLaptop.setBackground(new java.awt.Color(204, 204, 255));
        sLaptop.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        sLaptop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sLaptop.setText("0");
        sLaptop.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Quantity", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 14))); // NOI18N
        sLaptop.setOpaque(true);

        plaptop.setBackground(new java.awt.Color(204, 204, 255));
        plaptop.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        plaptop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        plaptop.setText("0");
        plaptop.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Price", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 14))); // NOI18N
        plaptop.setOpaque(true);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sLaptop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plaptop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sLaptop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plaptop)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 153));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Devices", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Bookman Old Style", 0, 18))); // NOI18N

        sinputdevices.setBackground(new java.awt.Color(204, 204, 255));
        sinputdevices.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        sinputdevices.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sinputdevices.setText("0");
        sinputdevices.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Quantity", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 14))); // NOI18N
        sinputdevices.setOpaque(true);

        pinputdevices.setBackground(new java.awt.Color(204, 204, 255));
        pinputdevices.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        pinputdevices.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pinputdevices.setText("0");
        pinputdevices.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Price", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 14))); // NOI18N
        pinputdevices.setOpaque(true);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sinputdevices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pinputdevices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(sinputdevices)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pinputdevices))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 153));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Storage Media", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Bookman Old Style", 0, 18))); // NOI18N

        sstoragemedia.setBackground(new java.awt.Color(204, 204, 255));
        sstoragemedia.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        sstoragemedia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sstoragemedia.setText("0");
        sstoragemedia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Quantity", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 14))); // NOI18N
        sstoragemedia.setOpaque(true);

        pstoragemedia.setBackground(new java.awt.Color(204, 204, 255));
        pstoragemedia.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        pstoragemedia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pstoragemedia.setText("0");
        pstoragemedia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Price", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 14))); // NOI18N
        pstoragemedia.setOpaque(true);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sstoragemedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pstoragemedia, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sstoragemedia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pstoragemedia)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 153));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Other", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Bookman Old Style", 0, 18))); // NOI18N

        sOther.setBackground(new java.awt.Color(204, 204, 255));
        sOther.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        sOther.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sOther.setText("0");
        sOther.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Quantity", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 14))); // NOI18N
        sOther.setOpaque(true);

        pOther.setBackground(new java.awt.Color(204, 204, 255));
        pOther.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        pOther.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pOther.setText("0");
        pOther.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Price", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 14))); // NOI18N
        pOther.setOpaque(true);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sOther, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pOther, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(sOther)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pOther))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 195, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        jPanel15.setBackground(new java.awt.Color(204, 255, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resolve Problem", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bookman Old Style", 0, 24))); // NOI18N

        jPanel7.setBackground(new java.awt.Color(255, 255, 153));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "YES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 18))); // NOI18N

        yes.setBackground(new java.awt.Color(204, 204, 255));
        yes.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        yes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yes.setText("0");
        yes.setOpaque(true);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(yes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(yes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 153));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 18))); // NOI18N

        no.setBackground(new java.awt.Color(204, 204, 255));
        no.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        no.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no.setText("0");
        no.setOpaque(true);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

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
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
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
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admibid;
    private javax.swing.JLabel adminname;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel no;
    private javax.swing.JLabel pComputer;
    private javax.swing.JLabel pOther;
    private javax.swing.JLabel pinputdevices;
    private javax.swing.JLabel plaptop;
    private javax.swing.JLabel poutputdevices;
    private javax.swing.JLabel pstoragemedia;
    private javax.swing.JLabel repairin;
    private javax.swing.JLabel repairout;
    private javax.swing.JLabel sComputer;
    private javax.swing.JLabel sLaptop;
    private javax.swing.JLabel sOther;
    private javax.swing.JLabel sinputdevices;
    private javax.swing.JLabel soutputdevices;
    private javax.swing.JLabel sstoragemedia;
    private javax.swing.JLabel timeshow;
    private javax.swing.JLabel yes;
    // End of variables declaration//GEN-END:variables
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/trending 512.png")));
    }
}
