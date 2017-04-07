/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icmf;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author deepak
 */
public class Terminal implements Serializable{
    public String Id;
    public Date date_busy;
    Terminal(){
        Id="";
        date_busy=new Date();
    }
    public  void update_to_now(){
        date_busy=new Date();
    }
    public  Date addMinutesToDate(long minutes, Date beforeTime){
        final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

        long curTimeInMs = beforeTime.getTime();
        Date afterAddingMins = new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
        return afterAddingMins;
    }
    Terminal(String s,int time){
        Id=s;
        date_busy=new Date();
        date_busy=addMinutesToDate(time,date_busy);
    }
    @Override
    public String toString() {
	return "";
    }
}
