public class Solution {
    public String convert(String s, int numRows) {
        StringBuffer[] sbs = new StringBuffer[numRows];
        for(int i = 0;i<sbs.length;i++){
            sbs[i] = new StringBuffer();
        }
        int i = 0;
        while(i<s.length()){
            for(int j = 0;j<numRows && i<s.length();j++){
                sbs[j].append(s.charAt(i++));
            }
            for(int j = numRows-2;j>0 && i<s.length();j--){
                sbs[j].append(s.charAt(i++));
            }
        }
        for(int j = 1;j<numRows;j++){
            sbs[0].append(sbs[j]);
        }
        return sbs[0].toString();
    }
}
