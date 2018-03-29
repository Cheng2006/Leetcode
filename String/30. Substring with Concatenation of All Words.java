public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<Integer>();
        if(words.length==0){
            return result;
        }
        int length = words[0].length();
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        Map<String,Integer> dic = new HashMap<String,Integer>();
        for(int i = 0;i<length;i++){
            dic.clear();
            int count = 0;
            for(int j = i;j<=s.length()-length;j = j+length){
                String key = s.substring(j,j+length);
                if(!map.containsKey(key)){
                    dic.clear();
                    count=0;
                }else if(map.get(key)>dic.getOrDefault(key,0)){
                    dic.put(key,dic.getOrDefault(key,0)+1);
                    count++;
                }else{
                    while(count>0){
                        String temp = s.substring(j-count*length,j-(count-1)*length);
                        if(temp.equals(key)){
                            break;
                        }
                        dic.put(temp,dic.get(temp)-1);
                        count--;
                    }
                }
                if(count==words.length){
                    result.add(j-(count-1)*length);
                    dic.put(s.substring(j-(count-1)*length,j-(count-2)*length),dic.get(s.substring(j-(count-1)*length,j-(count-2)*length))-1);
                    count--;
                }
            }
        }
        return result;
    }
}
