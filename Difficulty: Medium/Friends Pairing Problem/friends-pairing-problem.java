//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long countFriendsPairings(int n) 
    { 
        int mod=1000000007;
         long dp[]=new long[n+1];
         for(int i=0;i<=n;i++){
             if(i<=2){
                 dp[i]=i;
             }
             else{
                 dp[i]= (dp[i-1] + (i-1) * dp[i-2])%mod;
             }
         }
         return dp[n];
    }
}    