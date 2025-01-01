//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

ArrayList<Integer> search(String pat, String txt) {
        char[]t = txt.toCharArray();
        
        int n = t.length, m = pat.length();
        ArrayList<Integer>res = new ArrayList<>();
        for(int i =0; i<=(n-m); i++){
            if((txt.substring(i, i+m)).equals(pat))res.add(i);
            
        }
        
        return res;
    }
}