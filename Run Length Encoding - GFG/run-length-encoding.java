//{ Driver Code Starts
import java.util.*;
 
class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}


// } Driver Code Ends


class GfG {
	String encode(String str) {
        StringBuilder res = new StringBuilder();
        
        int left = 0, right = 0;
        while(left < str.length()){
            char ch = str.charAt(left);
            int freq = 0;
            
            while(right < str.length() && str.charAt(right) == ch){
                freq++; right++;
            }
            
            res.append(ch);
            res.append(freq);
            left = right;
        }
        
        return res.toString();
	}
	
 }