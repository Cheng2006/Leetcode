public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<String>();
        if(words.length==0) {
            return result;
        }
        int lastLen = words[0].length();
        int index = 0;
        for(int i = 1;i<words.length;i++){
            if(lastLen+1+words[i].length()>maxWidth){
                result.add(assembleString(words,index,i-index,maxWidth-lastLen,maxWidth,false));
                index = i;
                lastLen = words[i].length();
            }else{
                lastLen += 1+words[i].length();
            }
        }
        result.add(assembleString(words,index,words.length-index,maxWidth-lastLen,maxWidth,true));
        return result;
    }
    private String assembleString(String[] words,int index, int length,int extraBlank,int maxWidth, boolean leftJust){
        int div = leftJust?1:(length<=1?0:1+extraBlank/(length-1));
        int mod = leftJust?0:(length<=1?0:extraBlank%(length-1));
        StringBuffer sb = new StringBuffer();
        for(int i = index;i<index+length-1;i++){
            sb.append(words[i]);
            int count = div+(mod-->0?1:0);
            while(count-->0){
                sb.append(" ");
            }
        }
        sb.append(words[index+length-1]);
        while(sb.length()<maxWidth){
            sb.append(" ");
        }
        return sb.toString();
    }
}
