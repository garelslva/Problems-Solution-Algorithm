/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeconversionsouthamerica;

/**
 *
 * @author Vinicius
 */
public class TimeConversionSouthAmerica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(timeConversion("11:05:04PM"));
        System.out.println(timeConversion("11:05:04AM"));
        System.out.println(timeConversion("01:05:04PM"));
        System.out.println(timeConversion("01:05:04AM"));
        System.out.println(timeConversion("09:05:04PM"));
        System.out.println(timeConversion("09:05:04AM"));
    }
    
    static String timeConversion(String s) {
        int h= Integer.parseInt(s.replaceAll("(^\\d{1,2}).*","$1"));
        if(s.toLowerCase().endsWith("am")) 
         return ((h == 12)?"00":(h<10?"0"+h:h))+ s.replaceAll("(^\\d{2})(.*)([a-zA-Z]{2})","$2");
        else if(s.toLowerCase().endsWith("pm")) 
         return s.replaceAll("(^\\d{2})(.*)([a-zA-Z]{2})", String.valueOf(h+12)+"$2"); 
        return "";
    }
}
