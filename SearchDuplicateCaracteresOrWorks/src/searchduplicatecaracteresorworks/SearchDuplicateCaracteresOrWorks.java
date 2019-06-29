/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchduplicatecaracteresorworks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Vinicius
 */
public class SearchDuplicateCaracteresOrWorks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String aux="";
        System.out.println( "result: a" );  
        System.out.println( aux=searchDuplicateCharacterOrWorks( "abcdeafghi" ) );
        System.out.println( aux.equals("a") );
        System.out.println( "\nresult: forja"  );
        System.out.println( aux=searchDuplicateCharacterOrWorks( "forjabcvfgrtforja" ) );
        System.out.println( aux.equals("forja") );         
        System.out.println( "\nresult: trem" );  
        System.out.println( aux=searchDuplicateCharacterOrWorks( "abctremdeaftremghi" ) );
        System.out.println( aux.equals("trem") );        
        System.out.println( "\nresult: hh" );
        System.out.println( aux=searchDuplicateCharacterOrWorks( "abcdhheafghhi" ) );
        System.out.println( aux.equals("hh") );        
        System.out.println( "\nresult: palavragrande" );
        System.out.println( aux=searchDuplicateCharacterOrWorks( "palavragrandepalavragrandeabcdeafghi" ) );
        System.out.println( aux.equals("palavragrande") );          
        System.out.println( "\nresult: palavraGrandeNoMeio" ); 
        System.out.println( aux=searchDuplicateCharacterOrWorks( "abcdepalavraGrandeNoMeioafgpalavraGrandeNoMeiohi" ) );
        System.out.println( aux.equals("palavraGrandeNoMeio") );          
        System.out.println( "\nresult: " );
        System.out.println( aux=searchDuplicateCharacterOrWorks( "" ) );
        System.out.println( aux.equals("") );         
        System.out.println( "\nresult: i");  
        System.out.println( aux=searchDuplicateCharacterOrWorks( "iabcdeafghi" ) );
        System.out.println( aux.equals("i") );          
        System.out.println( "\nresult: ccc" );
        System.out.println( aux=searchDuplicateCharacterOrWorks( "abcccdcecacccfcghi" ) );
        System.out.println( aux.equals("ccc") );          
        System.out.println( "\nresult: final" );  
        System.out.println( aux=searchDuplicateCharacterOrWorks( "abcdeafghifinalfinal" ) );
        System.out.println( aux.equals("final") ); 
        System.out.println( "\nresult: gangue ter" );  
        System.out.println( aux=searchDuplicateCharacterOrWorks( "abcdgangue tereafggangue terhi" ) );
        System.out.println( aux.equals("gangue ter") );
        
    }

    private static String searchDuplicateCharacterOrWorks(String input) {
        String response="";
        for( int count=0,i=0; i < input.length(); i++ ){
         for( int j=0; (input.length()-j) >= i; j++, count=0 ){
          String aux = input.substring(i, input.length()-j);
          Matcher m = Pattern.compile( aux ).matcher(input);
          while( m.find() ) count++;
          if(count > 1)
           if( response.length() < aux.length() ) response=aux;
         }
        }
        return response;
    }
    
}
