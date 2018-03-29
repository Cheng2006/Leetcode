public class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<String>();
        StringBuffer sb = new StringBuffer();
        for(String item:paths){
            if("..".equals(item)){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(item.length()!=0 && !".".equals(item)){
                stack.push(item);
            }
        }
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop()).insert(0,'/');
        }
        return sb.length()==0?"/":sb.toString();
    }
}
