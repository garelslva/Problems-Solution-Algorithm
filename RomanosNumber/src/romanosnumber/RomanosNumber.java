/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package romanosnumber;

/**
 *
 * @author Vinicius
 */
public class RomanosNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println( romanosNumber(1) );
        System.out.println( romanosNumber(10) );
        System.out.println( romanosNumber(100) );
        System.out.println( romanosNumber(1000) );
        System.out.println( romanosNumber(8) );
        System.out.println( romanosNumber(13) );
    }
    
    public static String romanosNumber( int integerNumber ){
        String[] r={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
           int[] i={1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String   roma = "";
        for(int cont=12,vlr=integerNumber;cont>-1;cont--){
        while (vlr>=i[cont]){ roma += r[cont];
               vlr -= i[cont];
             }
        }
        return roma;
    }
}
