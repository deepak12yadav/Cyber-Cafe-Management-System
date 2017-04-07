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
public class Teminal_Array implements Serializable{
    public ArrayList<icmf.Terminal> Terminal_Array;
    Teminal_Array(){
        Terminal_Array = new ArrayList<icmf.Terminal>();
    }
    @Override
    public String toString() {
	return "";
    }
}
