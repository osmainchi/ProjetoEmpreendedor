/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author user
 */
public class ValidaData {
    
    public static boolean isValidDate(String inDate) throws ParseException {
        String regexStr = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        if(inDate.matches(regexStr)){
        Date today = new Date();        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
            } catch (ParseException pe) {
            return false;
        }
        if(dateFormat.parse(inDate).after(today)){
            return false;
        }else
        if (inDate.equals(today)){
            return false;
        }else
        
        return true;
        }
        else return false;
    }
    
    public static boolean isValidDateEntrega(String inDate) throws ParseException {
        String regexStr2 = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        if(inDate.matches(regexStr2)){
        Date today = new Date();        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
            } catch (ParseException pe) {
            return false;
        }
        if(dateFormat.parse(inDate).before(today)){
            return false;
        }else
        if (inDate.equals(today)){
            return false;
        }else
        
        return true;
        }
        else return false;
    }
    
}
