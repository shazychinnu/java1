import java.util.LinkedList; 
  
public class Gfc
 { 
    // Main method 
    public static void main(String[] args) 
    { 
  
        // Creating a LinkedList object to represent a stack. 
        LinkedList<String> stack = new LinkedList<>(); 
  
        // Pushing an element in the stack 
        stack.push("Geeks"); 
  
        // Pushing an element in the stack 
        stack.push("for"); 
  
        // Pop an element from stack 
        String s = stack.pop(); 
  
        // Printing the popped element. 
        System.out.println(s); 
  
        // Pushing an element in the stack 
        stack.push("Geeks"); 
  
        // Printing the complete stack. 
        System.out.println(stack); 
    } 
} 
