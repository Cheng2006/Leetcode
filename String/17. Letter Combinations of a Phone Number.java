public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] dic = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new LinkedList<String>();
        if(digits.length()==0){
            return result;
        }
        DFS(result,digits,0,new StringBuffer(),dic);
        return result;
    }
    public void DFS(List<String> result,String digits,int index,StringBuffer sb,String[] dic){
        if(index==digits.length()){
            result.add(sb.toString());
            return;
        }
        int num = Character.getNumericValue(digits.charAt(index));
        for(int i = 0;i<dic[num].length();i++){
            sb.append(dic[num].charAt(i));
            DFS(result,digits,index+1,sb,dic);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
