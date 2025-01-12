//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
        int size=arr.length;
        int leftToRightGreaterElements[] = new int[size];
        int rightToLeftGreaterElements[] = new int[size];
        leftToRightGreaterElements[0] = arr[0];
        for(int i=1;i<size;i++)
        {
            leftToRightGreaterElements[i] = Math.max(leftToRightGreaterElements[i-1],arr[i]);
        }
        
        rightToLeftGreaterElements[size-1] =  arr[size-1];
        for(int i=size-2; i>= 0; i--)
        {
            rightToLeftGreaterElements[i] = Math.max(rightToLeftGreaterElements[i+1],arr[i]);
        }
        int totalWaterTrapped=0;
        for(int i=0;i<size;i++)
        {
            int waterTrappedAtThisPosition=Math.min(rightToLeftGreaterElements[i], leftToRightGreaterElements[i])
            -arr[i];
            totalWaterTrapped+= waterTrappedAtThisPosition;
        }
        
        return totalWaterTrapped;
    }
}

