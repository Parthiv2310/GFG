class Solution {
    static int[][] dp;
    static int minDeletions(String s) {
       dp = new int[s.length()][s.length()];
       for(int [] arr : dp)
        Arrays.fill(arr , -1);
       return solve(0 , s.length() - 1 , s);
        
    }
    
    public static int solve(int i , int j , String s){
        if(i > j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s.charAt(i) == s.charAt(j))
         dp[i][j] =  solve(i + 1 , j - 1 , s);
        else
         dp[i][j] =  1 + Math.min(solve(i + 1 , j , s) , solve(i , j- 1 , s));
    
        return dp[i][j];
    }
}