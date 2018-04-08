public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<String>();
        DFS(result,s,0,0,new LinkedList<Integer>());
        return result;
    }
    public void DFS(List<String> result,String s, int index,int count,List<Integer> prev){
        if(index>s.length() || count>4 || (4-count)*3 <s.length()-index){
            return;
        }
        if(count==4 && index==s.length()){
            StringBuffer sb = new StringBuffer();
            for(int item:prev){
                sb.append('.').append(item);
            }
            result.add(sb.delete(0,1).toString());
            return;
        }
        for(int i = 1;i<=3 && index+i<=s.length();i++){
            int curr = Integer.valueOf(s.substring(index,index+i));
            if(curr<=255 && (i==1||s.charAt(index)!='0')){
                prev.add(curr);
                DFS(result,s,index+i,count+1,prev);
                prev.remove(prev.size()-1);
            }
        }
    }
}
