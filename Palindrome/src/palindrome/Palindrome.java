/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

/**
 *
 * @author Vinicius
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(isPalindrome("abcba"));
    }
    
    public static boolean isPalindrome(String input){
        char[] s = input.toCharArray();
        for (int i = 0, j=s.length-1; i < s.length/2; i++, j--)
         if(s[i] != s[j]) return false;                
        return true;
    }
}
