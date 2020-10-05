//A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

//Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

//A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

//By this logic, we say a sequence of brackets is balanced if the following conditions are met:

//It contains no unmatched brackets.
//The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
//Given n strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return True. Otherwise, return False.

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        
        Stack <Character> st= new Stack<> ();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else if(ch==')'){
                boolean val= handleclosing(st,'(');
                if(val==false){
                    System.out.println(val);
                    return;
                }
                
            }else if(ch=='}'){
               boolean val= handleclosing(st,'{');
               if(val==false){
                    System.out.println(val);
                    return;
                }
            }else if(ch==']'){
               boolean val= handleclosing(st,'[');
               if(val==false){
                    System.out.println(val);
                    return;
                }
            }
        
        }
    if(st.size()==0){
        System.out.println(true);
    }else{
        System.out.println(false);
    }
        

    }
    
    public static boolean handleclosing(Stack<Character> st,char corresoh){
        if(st.size()==0){
                    return false;
                }if(st.peek() != corresoh){
                    return false;
                }else{
                    st.pop();
                    return true;
                }
    }

}
