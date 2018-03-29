public class Solution {
    public String countAndSay(int n) {
        StringBuffer sb = new StringBuffer();
        sb.append(1);
        while(n-->1){
            int count = 1;
            StringBuffer curr = new StringBuffer();
            for(int i = 1;i<sb.length();i++){
                if(sb.charAt(i)!=sb.charAt(i-1)){
                    curr.append(count).append(sb.charAt(i-1));
                    count = 1;
                }else{
                    count++;
                }
            }
            curr.append(count).append(sb.charAt(sb.length()-1));
            sb = curr;
        }
        return sb.toString();
    }
}
