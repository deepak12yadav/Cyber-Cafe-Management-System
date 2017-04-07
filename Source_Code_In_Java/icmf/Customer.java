/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icmf;

import java.io.Serializable;

/**
 *
 * @author deepak
 */
public class Customer implements Serializable{
    
    private static final long serialVersionUID = 1L;
    public  int ID;
    public String name;
    public int Age;
    public String Sex;
    public String Mobile_No;
    public String Email_Address;
    public String Address;
    public String System;
    public String Printer;
    public String Xerox;
    public int duration;
    public int no_print;
    public int no_xerox;
    public String System_TNO;
    public int System_waiting_time;
    public String Printer_TNO;
    public String Xerox_TNO;
    public int System_cost;
    public int Printer_cost;
    public int Xerox_cost;
    public int Total_cost;
    
    Customer(){
        name="";
        Age=0;
        Sex="";
        Mobile_No="";
        Email_Address="";
        Address="";
        System="";
        Printer="";
        Xerox="";
        duration=0;
        no_print=0;
        no_xerox=0;
        System_TNO="None";
        System_waiting_time=0;
        Printer_TNO="None";
        Xerox_TNO="None";
        System_cost=0;
        Printer_cost=0;
        Xerox_cost=0;
        Total_cost=0;
    }
    @Override
    public String toString() {
	return "";
    }
    
    
}
