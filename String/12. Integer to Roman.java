public class Solution {
    public String intToRoman(int num) {
        int[] dig = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] rom = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuffer sb = new StringBuffer();
        int curr = num;
        for(int i = dig.length-1;i>=0 && curr>0;i--){
            int count = curr/dig[i];
            while(count-->0){
                sb.append(rom[i]);
            }
            curr = curr%dig[i];
        }
        return sb.toString();
    }
}
