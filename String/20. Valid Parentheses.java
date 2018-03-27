public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char item : s.toCharArray()){
            if("({[".indexOf(item)!=-1){
                stack.push(item);
            }else{
                if(stack.isEmpty() || !isMatch(stack.pop(),item)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public boolean isMatch(char a,char b){
        return a=='(' && b==')' || a=='[' && b==']' || a=='{' && b=='}';
    }
}
