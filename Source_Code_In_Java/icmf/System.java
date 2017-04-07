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
public class System implements Serializable{
    
    public int no_Browsing;
    public int no_gaming;
    public int no_acaedmic;
    public int no_color_printer;
    public int no_plain_printer;
    public int no_black_xerox;
    public int no_color_xerox;
    public int no_Browsing_r;
    public int no_gaming_r;
    public int no_acaedmic_r;
    public int no_color_printer_r;
    public int no_plain_printer_r;
    public int no_black_xerox_r;
    public int no_color_xerox_r; 
    
    System(){
        no_Browsing=0;
        no_gaming=0;
        no_acaedmic=0;
        no_color_printer=0;
        no_plain_printer=0;
        no_black_xerox=0;
        no_color_xerox=0;
        no_Browsing_r=0;
        no_gaming_r=0;
        no_acaedmic_r=0;
        no_color_printer_r=0;
        no_plain_printer_r=0;
        no_black_xerox_r=0;
        no_color_xerox_r=0;
    }
    @Override
    public String toString() {
	return "";
    }
}
