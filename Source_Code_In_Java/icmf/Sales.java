/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icmf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author deepak
 */
public class Sales implements Serializable{
    
    Date date;
    public int total;
    public int no_Browsing_s;
    public int no_gaming_s;
    public int no_acaedmic_s;
    public int no_color_printer_s;
    public int no_plain_printer_s;
    public int no_black_xerox_s;
    public int no_color_xerox_s; 
    
    Sales()
    {
        date=new Date();
        total=0;
        no_Browsing_s=0;
        no_gaming_s=0;
        no_acaedmic_s=0;
        no_color_printer_s=0;
        no_plain_printer_s=0;
        no_black_xerox_s=0;
        no_color_xerox_s=0; 
    }
    
    public Date removeTime(Date date) {    
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);  
        return cal.getTime(); 
    }
    
    public boolean check(){
        Date date1=new Date();
        return removeTime(date1).equals(removeTime(date));
        
    }
    @Override
    public String toString() {
	return "";
    }
    
}
