/* You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window. */

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    Stack <Integer> st=new Stack<>();
    int[] nge=new int[arr.length];
    st.push(arr.length-1);
    nge[arr.length-1]=arr.length;
    for(int i=arr.length-2;i>=0;i--){
        while(st.size()>0 && arr[i]>=arr[st.peek()]){
            st.pop();
        }
        if(st.size()==0)
        {
            nge[i]=arr.length;
        }else{
            nge[i]=st.peek();
        }
        st.push(i);
    }
    int j=0;
    for(int i=0;i<=arr.length-k;i++){
        //enter the loop to find the max of window starting at i
        if(j<i){
            j=i;
        }
        while(nge[j]<i+k){//if nge is inside the window
            j=nge[j];// jump to next greater
        }
        System.out.println(arr[j]);
    }
    
 }
}
