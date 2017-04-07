/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icmf;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author deepak
 */
public class Customer_info implements Serializable{
    public ArrayList<icmf.Customer> Customer_Array;
    public int ID;
    Customer_info(){
        Customer_Array = new ArrayList<icmf.Customer>();
        ID=0;
    }
    @Override
    public String toString() {
        
        StringBuffer s = new StringBuffer("");
        long si=Customer_Array.size();
        icmf.Customer c;
        for(int i=0;i<si;i++){
            
            c=Customer_Array.get(i);
            s.append("ID: ").append(Integer.toString(c.ID)).append("\n" + "Name : ").append(c.name).append("\n" + "Age: ").append(Integer.toString(c.Age)).append("\n" + "Sex: ").append(c.Sex).append("\n" + "Mobile No: ").append(c.Mobile_No).append("\n" + "Email Address: ").append(c.Email_Address).append("\n" + "Address: ").append(c.Address).append("\n\n");
        }
	return s.toString();
    }
}
