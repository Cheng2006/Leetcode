public class Solution {
    // public int lengthOfLongestSubstring(String s) {
    //     Map<Character,Integer> map = new HashMap<Character,Integer>();
    //     int result = 0;
    //     for(int i = 0,j=0;i<s.length();i++){
    //         if(map.containsKey(s.charAt(i))){
    //             j = Math.max(j,map.get(s.charAt(i))+1);
    //         }
    //         map.put(s.charAt(i),i);
    //         result = Math.max(result,i-j+1);
    //     }
    //     return result;
    // }
    
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        //may use int[256] instead of HeshMap!!!!!!!!!!!!
        int result = 0;
        int i = 0;
        for(int j = 0;j<s.length();j++){
            if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j))>=i){
                result = Math.max(result,j-i);
                i = map.get(s.charAt(j))+1;
            }
            map.put(s.charAt(j),j);
        }
        return Math.max(result,s.length()-i);
    }
    //just test 
    
}
