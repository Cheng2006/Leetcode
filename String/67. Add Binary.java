public class Solution {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int carries = 0;
        int indexA = a.length()-1;
        int indexB = b.length()-1;
        while(indexA>=0 || indexB>=0 || carries>0){
            int left = indexA>=0?Character.getNumericValue(a.charAt(indexA--)):0;
            int right = indexB>=0?Character.getNumericValue(b.charAt(indexB--)):0;
            int temp = left ^ right ^ carries;
            carries = (left & right & carries)^temp^(left|right|carries);//did not know why,just 
            sb.insert(0,temp);
        }
        return sb.toString();
    }
}
