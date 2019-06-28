/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversionintegerlistnotauxiliaryvariable;

/**
 *
 * @author Vinicius
 */
public class ReversionIntegerListNotAuxiliaryVariable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] values = {10,9,22,11,45,6,7};
        
        System.out.println("No reverse:");
        for(int v : values )
        System.out.println( v );
        
        System.out.println("\nReverse:");
        for(int v : reverseIntegerListNotAuxiliaryVariable( values ) )
        System.out.println( v );
    }
    
    public static int[] reverseIntegerListNotAuxiliaryVariable(int[] v){
        int i = v.length;
        for(int cont = 0;cont<i/2;cont++){  
            v[cont] = v[cont]+ v[i-cont-1];
            v[i-cont-1] = v[cont] - v[i-cont-1];
            v[cont] = v[cont] - v[i-cont-1];
        }
        return v;
    }
}
