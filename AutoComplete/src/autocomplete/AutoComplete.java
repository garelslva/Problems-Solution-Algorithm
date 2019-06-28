/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomplete;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class AutoComplete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] input = {"avião", "Aeroporto", "amora", "aerofolio", "aerado", "aqlqcoisa", "aeaeae", "Maçã", "Bola", "barro", "caminhão", "dado"};
	System.out.println(autocompletar("ae",input));
    }
    
    public static List<String> autocompletar(String ref, String[] strCadeia){ 
		List<String> response = new ArrayList<String>();
		for(String s: strCadeia){
			if(s.toLowerCase().startsWith(ref.toLowerCase())) response.add(s);
			if(response.size() == 5) break;
		}
		return response;  
    }
}
