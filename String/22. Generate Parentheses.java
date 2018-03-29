public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        DFS(result,n,n,0,0,new StringBuffer());
        return result;
    }
    public void DFS(List<String> result, int nl, int nr, int left, int right,StringBuffer sb){
        if(left<right || nl <0 || nr<0){
            return ;
        }
        if(nl == 0 && nr == 0){
            result.add(sb.toString());
            return;
        }
        DFS(result,nl-1,nr,left+1,right,sb.append('('));
        DFS(result,nl,nr-1,left,right+1,sb.deleteCharAt(sb.length()-1).append(')'));
        sb.deleteCharAt(sb.length()-1);
    }
}
