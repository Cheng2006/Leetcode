public class Solution {
//     public int strStr(String haystack, String needle) 
//     {
//         if(needle==null || needle.length()==0){
//             return 0;
//         }
//         int right[] = new int[256];
//         for(int i=0;i<256;i++){
//             right[i] =-1;
//         }
//         for(int i=0;i<needle.length();i++){
//             right[needle.charAt(i)] =i;
//         }
//         int result = search(right,haystack,needle);
//         return result;
//     }
//     public int search(int[] right, String haystack,String needle)
//     {
//         int n = haystack.length();
//         int m = needle.length();
//         int skip = 0;
//         for(int i=0; i<=n-m; i+=skip)
//         {
//             skip = 0;
//             for(int j=m-1;j>=0;j--)
//             {
//                 if(needle.charAt(j)!=haystack.charAt(i+j))
//                 {
//                     skip = j-right[haystack.charAt(j+i)];
//                     skip = skip<0?1:skip;
//                     break;
//                 }
//             }
//             if(skip == 0){
//                 return i;
//             }
//         }
//         return -1;
    
//     }
    
    
    public int strStr(String haystack, String needle) {
        //KMP
        if(needle.length()==0){
            return 0;
        }
        int[] next = getPrefix(needle.toCharArray());
        int k = -1;
        for(int i = 0;i<haystack.length();i++){
            while(k>=0 && haystack.charAt(i)!=needle.charAt(k+1)){
                k = next[k];
            }
            if(haystack.charAt(i)==needle.charAt(k+1)){
                k++;
            }
            if(k==needle.length()-1){
                return i-k;
            }
        }
        return -1;
        
    }
    public int[] getPrefix(char[] needles) {
        int[] prefix = new int[needles.length];
        prefix[0] = -1;
        int k = -1;
        for(int i = 1;i<needles.length;i++){
            while(k>=0 && needles[i]!=needles[k+1]){
                k = prefix[k];
            }
            if(needles[i]==needles[k+1]){
                k++;
            }
            prefix[i] = k;
        }
        return prefix;
    }
}
