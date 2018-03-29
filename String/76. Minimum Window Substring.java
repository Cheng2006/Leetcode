public class Solution {
    //int[] map = new int[256]; //////////NOTICING!!!!!!!!!!
    public String minWindow(String s, String t) {
        Map<Character,Integer> dic = new HashMap<Character,Integer>();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char item:t.toCharArray()){
            dic.put(item,dic.getOrDefault(item,0)+1);
        }
        int j = 0;
        int i = 0;
        int index = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        while(j<s.length()){
            char c = s.charAt(j);
            if(dic.containsKey(c)){
                map.put(c, map.getOrDefault(c,0)+1);
            }
            if(map.getOrDefault(c,0)<=dic.getOrDefault(c,-1)){
                count++;
            }
            if(count==t.length()){
                while(map.getOrDefault(s.charAt(i),0)>dic.getOrDefault(s.charAt(i),-1)){
                    if(map.containsKey(s.charAt(i))){
                        map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    }
                    i++;
                }
                minLength = Math.min(minLength,j-i+1);
                index = (minLength==j-i+1)?i:index;
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
                count--;
            }
            j++;
        }
        return minLength==Integer.MAX_VALUE?"":s.substring(index,index+minLength);
    }
}
