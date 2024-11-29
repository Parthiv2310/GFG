//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        int carry  = 0;
        int i = s1.length()-1,j = s2.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0 || carry>0){
            int val1 = i>=0? s1.charAt(i) - '0':0;
            int val2 = j>=0? s2.charAt(j) - '0':0;
            int num = val1 + val2 + carry;
            int res = num % 2;
            carry = num/2;
            sb.append(res);
            i--;
            j--;
        }
        int k = sb.length()-1;
        while(k>=0){
            if(sb.charAt(k) == '1'){
                break;
            }
            k--;
        }
        sb.setLength(k+1);
        return sb.reverse().toString();
    }
}