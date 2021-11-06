import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import Project.ConnectionProvider;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 

/**
 *
 * @author Shubham
 */
public class QuizExam extends javax.swing.JFrame {
    
    public String questionId="1";
    public String answer;
    public int min=0;
    public int sec=0;
    public int marks=0;
  
    public void answerCheck(){
    String studentAnswer="";
    if(jRadioButton1.isSelected())
    {
    studentAnswer=jRadioButton1.getText();
    
    }
    else if(jRadioButton2.isSelected())
    {
    studentAnswer=jRadioButton2.getText();
    
    }
    else if(jRadioButton3.isSelected())
    {
    studentAnswer=jRadioButton3.getText();
    
    }
    else{
    
    studentAnswer=jRadioButton4.getText();
    
    }
    
    if(studentAnswer.equals(answer))
    {
    marks=marks+1;
    String marks1=String.valueOf(marks);
    jLabel17.setText(marks1);
    }
    
    //question id changes
    int questionId1=Integer.parseInt(questionId);
    questionId1=questionId1+1;
    questionId=String.valueOf(questionId1);
    
    //clear RadioBUTTON
    jRadioButton4.setSelected(false);
    jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton1.setSelected(false);
    
    //last question hide next button save
    if(questionId.equals("10")){
    jButton1.setVisible(false);
    }
    
    
    }
    
    public void questionexam()
    {
    try{
        
            Connection con = ConnectionProvider.getCon();
            Statement st=con.createStatement();
            
            ResultSet rs1=st.executeQuery("Select * from question where id='"+questionId+"'");
            while(rs1.next()){
                jLabel15.setText(rs1.getString(1));
                jLabel18.setText(rs1.getString(2));
                jRadioButton1.setText(rs1.getString(3));
                jRadioButton2.setText(rs1.getString(4));
                jRadioButton3.setText(rs1.getString(5));
                jRadioButton4.setText(rs1.getString(6));
                answer=rs1.getString(7);
            }
            
        }
        catch(Exception e){
      
                JOptionPane.showMessageDialog(null,e);
                
        }
       
    
    
    }
    
    public void submit()
    
   {
       String rollno=jLabel9.getText();
       answerCheck();
       
       try{
            Connection con = ConnectionProvider.getCon();
            Statement st=con.createStatement();
            
            st.executeUpdate("Update student set marks='"+marks+"' where rollNo='"+rollno+"'");
            String marks1=String.valueOf(marks);
           setVisible(false);
           new successfullysubmitted(marks1).setVisible(true);
       
       }
       catch(Exception e)
       
       {
       
       JOptionPane.showMessageDialog(null, e);
       }
   
   
   
   
   
   
   
   
   }
    /**
     * Creates new form QuizExam
     */
    public QuizExam() {
        initComponents();
    }
    Timer time;
public QuizExam(String rollNo) {
        initComponents();
        jLabel9.setText(rollNo);
        //date
        
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date =new Date();
        jLabel3.setText(dFormat.format(date));
       try{
        
            Connection con = ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where rollno ='"+rollNo+"'");
            while(rs.next()){
                jLabel11.setText(rs.getString(1));
                
            }
            ResultSet rsl=st.executeQuery("Select * from question where id='"+questionId+"'");
            while(rsl.next()){
                jLabel15.setText(rsl.getString(1));
                jLabel18.setText(rsl.getString(2));
                jRadioButton1.setText(rsl.getString(3));
                jRadioButton2.setText(rsl.getString(4));
                jRadioButton3.setText(rsl.getString(5));
                jRadioButton4.setText(rsl.getString(6));
                answer=rsl.getString(7);
            }
            
        }
        catch(Exception e){
      
                JOptionPane.showMessageDialog(null,e);
                
        }
       
       setLocationRelativeTo(this);
       time=new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                jLabel7.setText(String.valueOf(sec));
                 jLabel19.setText(String.valueOf(min));
                 if(sec==60){
                 sec=0;
                 min++;
                 if(min==1){
                     time.stop();
                     answerCheck();
                     submit();
                 }
                 }
                 sec++;
                 
            }
       });
       
       time.start();
       
       
     
        
        
        
        
        
        
        
        
        
        
        
        
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/index student.png"))); // NOI18N
        jLabel1.setText("WELCOME");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 19, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Date:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Total Time");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(885, 11, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("10 Min");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1063, 11, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Time Taken:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(885, 51, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 0, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("00");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 50, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("00");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel8.setText("Roll No:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 48, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel9.setText("100");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 48, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel10.setText("Name:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 112, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel11.setText("shanmukh");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 112, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel12.setText("Total Question:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 176, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel13.setText("10");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 176, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel14.setText("Question No:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 240, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel15.setText("00");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 240, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel16.setText("Marks Scored:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 300, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel17.setText("00");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 300, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 320, 660));

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, -1, -1));

        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, -1));

        jRadioButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setText("Question Demo");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 132, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Next.png"))); // NOI18N
        jButton1.setText("NEXT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 627, 160, 48));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        jButton2.setText("SUBMIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 627, 185, 48));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        answerCheck();
        questionexam();
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int a= JOptionPane.showConfirmDialog(null,"Do you want to submit","Select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
           answerCheck();
           submit();
        }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        
        if(jRadioButton1.isSelected())
        {
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton2.isSelected())
        {
        jRadioButton1.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton3.isSelected())
        {
        jRadioButton2.setSelected(false);
        jRadioButton1.setSelected(false);
        jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton4.isSelected())
        {
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton1.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(QuizExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizExam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}
