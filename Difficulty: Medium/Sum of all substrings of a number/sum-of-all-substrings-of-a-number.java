class Solution {
    public static int sumSubstrings(String s) {
        int ans=0;
        
        int len = s.length();
        
        for(int i=0;i<len;i++){
            
            int fac = i+1, size = len-i;
            
            int num = s.charAt(i)-'0';
            
            int sum = (int) (Math.pow(10,size)-1)/(9);
            
            ans+=num*fac*sum;
            
        }
        
        return ans;
    }
}