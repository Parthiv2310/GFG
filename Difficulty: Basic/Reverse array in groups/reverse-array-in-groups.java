//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    // Function to reverse every sub-array group of size k.
        void reverseInGroups(ArrayList<Long> arr, int k) {
        
        if(k>arr.size()){
            Collections.reverse(arr);
            return ;
        }
        else{
            
            int loop = arr.size()/k;
            int start = 0;
            int end = k;
            while(loop!=0){
                Collections.reverse(arr.subList(start,end));
                start = end;
                end = end + k;
                loop--;
            }
            Collections.reverse(arr.subList(end-k,arr.size()));
        }
    }
}

//{ Driver Code Starts.

public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine(); // consume the newline
            String input = sc.nextLine();
            ArrayList<Long> arr = new ArrayList<>();
            Scanner ss = new Scanner(input);
            while (ss.hasNextLong()) {
                arr.add(ss.nextLong());
            }
            Solution ob = new Solution();
            ob.reverseInGroups(arr, k);
            for (long num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends