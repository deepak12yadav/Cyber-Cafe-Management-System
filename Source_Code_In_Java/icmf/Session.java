/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icmf;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author deepak
 */
public class Session implements Runnable{
    
    private final Thread t;
    private final icmf.Session_Log_Directory S;
    private final Date start;
    private final Date end;
    private final String ter;
    
    Session(icmf.Session_Log_Directory S,Date start,Date end,String ter){
        t = new Thread(this, "Session");
        this.S=S;
        this.start=start;
        this.end=end;
        this.ter=ter;
        t.start();
    }
    
    
    @Override
    public void run() {
        while(new Date().compareTo(start)==-1 && icmf.Closing_Parameter.x==0)
        {
            
        }
        synchronized(S){
            S.jTextArea1.append(start.toString()+":: Session at Termianl "+ter+" -->Started\n");
        }
        
        while(new Date().compareTo(end)==-1 && icmf.Closing_Parameter.x==0)
        {
            
        }
        
        synchronized(S){
            S.jTextArea1.append(end.toString()+":: Session at Termianl "+ter+" -->Ended\n");
        }
        if(icmf.Closing_Parameter.x==0)
            JOptionPane.showMessageDialog(null, "Session at :"+"Termianl "+ter+" -->Ended", "InfoBox: " + "Session End Notification", JOptionPane.INFORMATION_MESSAGE);
    }
}
