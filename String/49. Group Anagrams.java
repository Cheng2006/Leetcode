public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new LinkedList<List<String>>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                List<String> list = new LinkedList<String>();
                list.add(str);
                map.put(key,list);
            }
        }
        return new LinkedList<List<String>>(map.values());
    }
}
