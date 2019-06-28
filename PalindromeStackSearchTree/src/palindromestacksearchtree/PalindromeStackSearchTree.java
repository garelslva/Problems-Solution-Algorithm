/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromestacksearchtree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Vinicius
 */
public class PalindromeStackSearchTree {
    
    Stack<Character> stack;
    Queue<Character> queue; 
    
    PalindromeStackSearchTree(){
        stack = new Stack<Character>();
        queue =  new ArrayDeque<Character>();
    }
    public void pushCharacter(Character c){
        stack.push(c);
    }
    public Character popCharacter(){
        return stack.pop();
    }
    public Character dequeueCharacter(){
         return queue.poll();
    }
    public void enqueueCharacter(Character c){
        queue.add(c);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println( isPalindrome("abcba") );
    }
    
    public static boolean isPalindrome(String input){
        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        PalindromeStackSearchTree p = new PalindromeStackSearchTree();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }
        
        for (int i = 0; i < s.length/2; i++) 
         if( p.popCharacter() !=  p.dequeueCharacter() )return false;
        return true;
    }
}
