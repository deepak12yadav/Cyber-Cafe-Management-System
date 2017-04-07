/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icmf;

import java.awt.CardLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deepak
 */
public class Main_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Main_Frame
     */
    public Main_Frame() throws IOException {
        
        initComponents();
        Allocate_Memory();
        
        File f = new File("System_Info_File.dat");
        if(!(f.exists() && !f.isDirectory())) { 
            main_Panel1.jButton1.setEnabled(false);
            main_Panel1.jButton3.setEnabled(false);
            main_Panel1.jButton4.setEnabled(false);
            main_Panel1.jButton5.setEnabled(false);
            main_Panel1.jButton6.setEnabled(false);

        }
        else{
            
            icmf.System sys=new icmf.System();
            try {
                    FileInputStream fi = new FileInputStream(new File("System_Info_File.dat"));
                    ObjectInputStream oi = new ObjectInputStream(fi);

                    sys=(icmf.System) oi.readObject();
                    oi.close();
                    fi.close();

                } catch (FileNotFoundException e) {
                    java.lang.System.out.println("File not found");
                 }catch (IOException e) {
                    java.lang.System.out.println("Error initializing stream");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main_Panel.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            icmf.Teminal_Array ta = new icmf.Teminal_Array();
            icmf.Terminal t;
            for(int i=0;i<sys.no_Browsing;i++){
                t=new icmf.Terminal("B"+Integer.toString(i),0);
                ta.Terminal_Array.add(t);
            }
            for(int i=0;i<sys.no_acaedmic;i++){
                t=new icmf.Terminal("A"+Integer.toString(i),0);
                ta.Terminal_Array.add(t);
            }
            for(int i=0;i<sys.no_gaming;i++){
                t=new icmf.Terminal("G"+Integer.toString(i),0);
                ta.Terminal_Array.add(t);
            }
            for(int i=0;i<sys.no_color_printer;i++){
                t=new icmf.Terminal("CP"+Integer.toString(i),0);
                ta.Terminal_Array.add(t);
            }
            for(int i=0;i<sys.no_plain_printer;i++){
                t=new icmf.Terminal("PP"+Integer.toString(i),0);
                ta.Terminal_Array.add(t);
            }
            for(int i=0;i<sys.no_black_xerox;i++){
                t=new icmf.Terminal("BX"+Integer.toString(i),0);
                ta.Terminal_Array.add(t);
            }
            for(int i=0;i<sys.no_color_xerox;i++){
                t=new icmf.Terminal("CX"+Integer.toString(i),0);
                ta.Terminal_Array.add(t);
            }
            
            try {
                FileOutputStream fi = new FileOutputStream(new File("Terminal_Info_File.dat"));
		ObjectOutputStream o = new ObjectOutputStream(fi);
		o.writeObject(ta);
                o.close();
		fi.close();
                
                } catch (FileNotFoundException e) {
                    java.lang.System.out.println("File not found");
                } catch (IOException e) {
            	java.lang.System.out.println("Error initializing stream");
                }
            
        }
        f = new File("Customer_Info_File.dat");
        if(!(f.exists() && !f.isDirectory())) { 
            main_Panel1.jButton6.setEnabled(false);

        }
        f = new File("Sales_Info_File.dat");
        if(!(f.exists() && !f.isDirectory())) { 
            f.createNewFile();
            try {
                FileOutputStream f1 = new FileOutputStream(new File("Sales_Info_File.dat"));
		ObjectOutputStream o = new ObjectOutputStream(f1);
		o.writeObject(sales);
                o.close();
		f1.close();
            } catch (FileNotFoundException e) {
		java.lang.System.out.println("File not found");
            } catch (IOException e) {
		java.lang.System.out.println("Error initializing stream");
            }
        }
        else
        {
            icmf.Sales Sales1 = null;
            try {
		FileInputStream fi = new FileInputStream(new File("Sales_Info_File.dat"));
		ObjectInputStream oi = new ObjectInputStream(fi);

		Sales1=(icmf.Sales) oi.readObject();
                oi.close();
		fi.close();

                } catch (FileNotFoundException e) {
                    java.lang.System.out.println("File not found");
                }catch (IOException e) {
                    java.lang.System.out.println("Error initializing stream");
                } catch (ClassNotFoundException ex) {
                 Logger.getLogger(Main_Panel.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            if(!Sales1.check()){
                try {
                    FileOutputStream f1 = new FileOutputStream(new File("Sales_Info_File.dat"));
                    ObjectOutputStream o = new ObjectOutputStream(f1);
                    o.writeObject(sales);
                    o.close();
                    f1.close();
                    } catch (FileNotFoundException e) {
                       java.lang.System.out.println("File not found");
                    } catch (IOException e) {
                      java.lang.System.out.println("Error initializing stream");
                    }
            }
        }
        Initialize_Panels(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_Panel1 = new icmf.Main_Panel();
        customer_Details1 = new icmf.Customer_Details();
        customer_Requirements1 = new icmf.Customer_Requirements();
        customer_Bill1 = new icmf.Customer_Bill();
        customer_Information1 = new icmf.Customer_Information();
        system_Details1 = new icmf.System_Details();
        view_System_details1 = new icmf.View_System_details();
        todays_Sales1 = new icmf.Todays_Sales();
        session_Log_Directory1 = new icmf.Session_Log_Directory();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(610, 513));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                Closing_window(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(main_Panel1, "card2");
        getContentPane().add(customer_Details1, "card3");
        getContentPane().add(customer_Requirements1, "card4");
        getContentPane().add(customer_Bill1, "card5");
        getContentPane().add(customer_Information1, "card6");
        getContentPane().add(system_Details1, "card7");
        getContentPane().add(view_System_details1, "card8");
        getContentPane().add(todays_Sales1, "card9");
        getContentPane().add(session_Log_Directory1, "card10");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Closing_window(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_Closing_window
        // TODO add your handling code here:
        /*
            Handle even related to window close terminal finish
        */
        icmf.Closing_Parameter.x=1;
    }//GEN-LAST:event_Closing_window

    //Custom Coded Functions
    
    private void Initialize_Panels(){
        
        customer_Details1.initialize_parameters(customer,customer_Requirements1);
        customer_Requirements1.initialize_parameters(customer,customer_Bill1,customer_info1,main_Panel1.jButton6,system,main_Panel1.jButton2,Session_Array,session_Log_Directory1);
        customer_Bill1.initialize_parameters(customer);
        main_Panel1.initialize_parameters(system_Details1,view_System_details1,customer_Information1,customer_info1,todays_Sales1,system,customer_Requirements1,customer);
    }
    
    private void Allocate_Memory(){
        
        customer=new icmf.Customer();
        system=new icmf.System();
        customer_info1=new icmf.Customer_info();
        sales=new icmf.Sales();
        Session_Array = new ArrayList<icmf.Session>();
        Closing_Flag= new icmf.Closing_Parameter();
    }
    
   
    
    //End of Custom Coded Functions
    
    
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
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main_Frame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public icmf.Customer_Bill customer_Bill1;
    private icmf.Customer_Details customer_Details1;
    public icmf.Customer_Information customer_Information1;
    public icmf.Customer_Requirements customer_Requirements1;
    public icmf.Main_Panel main_Panel1;
    public icmf.Session_Log_Directory session_Log_Directory1;
    public icmf.System_Details system_Details1;
    public icmf.Todays_Sales todays_Sales1;
    public icmf.View_System_details view_System_details1;
    // End of variables declaration//GEN-END:variables
    

    // Variables declaration - Custom Code
    public icmf.Customer customer;
    public icmf.System system;
    public icmf.Customer_info customer_info1;
    public icmf.Sales sales;
    public ArrayList<icmf.Session> Session_Array;
    public icmf.Closing_Parameter Closing_Flag;
    // End of variables declaration 
}
