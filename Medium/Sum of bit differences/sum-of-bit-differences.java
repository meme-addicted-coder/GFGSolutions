//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().sumBitDifferences(arr, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

//Time Comp: O(n^2)

/*class Solution {
    long sumBitDifferences(int[] arr, int n) {
         long ans = 0; // Initialize result

        for(int i=0; i<n ;i++){
            for(int j=i+1; j<n ;j++){
                if(arr[i]!=arr[j])
                ans += hammingDistance(arr[i], arr[j]) *2;
            }
        }
        return ans;
        
    }
    int hammingDistance(int x, int y) {
      
      int ans=0;
        while(x>0 || y>0)
        {
            if((y&1) != (x&1))
                ans++;
          
            y=y/2; // or y>>=1;
            x=x/2;
        }       
        return ans;
    }
}*/


//Time Complexity: O(1)
class Solution {
    long sumBitDifferences(int[] arr, int n) {
         long ans = 0; 

        for (int i = 0; i < 32; i++) {
           
            long cnt=0; 
            for (int j = 0; j < n; j++)
                if ((arr[j] & (1 << i)) != 0) 
                    cnt++;
            ans +=  (cnt*(n-cnt)*2);
        }

        return ans;
    }
}