public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return new String();
        }
        int count = 0;
        boolean mark = true;
        while(mark){
            char c = '*';
            for(int i = 0;i<strs.length;i++){
                if(strs[i].length()<=count || i!=0 && strs[i].charAt(count)!=c){
                    mark = false;
                    break;
                }
                if(i==0){
                    c = strs[i].charAt(count);
                }
                
            }
            count += (mark==true)?1:0;
        }
        return strs[0].substring(0,count);
    }
}
