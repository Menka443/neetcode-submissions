class Solution {

    public int characterReplacement(String s, int k) {

        int i = 0; 
   
        int maxFreq = 0;
        int ans = 0;
HashMap<Character, Integer> map = new HashMap<>();
       for(int j = 0; j  < s.length(); j++){
        // get current char
        char ch = s.charAt(j);

        // upadte freq
        map.put(ch, map.getOrDefault(ch ,0)+1);
        //update maxfreq
        maxFreq = Math.max(maxFreq, map.get(ch));

        int windowSize = j - i + 1;

        //Invalid window
       while ((j - i + 1) - maxFreq > k) {
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            i++;
        }
        ans = Math.max(ans, j - i + 1);
       }
       return ans;

        
        
    }
}
