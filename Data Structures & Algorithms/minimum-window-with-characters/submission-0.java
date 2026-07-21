class Solution {

    public String minWindow(String s, String t) {

        while(s.length() < t.length()){
            return "";
        }

        HashMap<Character,Integer> target = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        // freq count of t
        for(char ch : t.toCharArray()){
            target.put(ch, target.getOrDefault(ch,0)+1);
        }


       while (right < s.length()) {
        char ch = s.charAt(right);
        window.put(ch, window.getOrDefault(ch, 0) + 1);
        right++;
      
       // Expand window
     while (isValid(window, target)) {

        // Update minimum window
        if (right - left < minLen) {
            minLen = right - left;
            start = left;
        }

        // Remove left character
        char leftChar = s.charAt(left);
        //decrease the frequency ==
        window.put(leftChar, window.get(leftChar) - 1);
        if (window.get(leftChar) == 0) {
            window.remove(leftChar);
        }

        left++;
    }
}
    if (minLen == Integer.MAX_VALUE)
    return "";

    return s.substring(start, start + minLen);
    }

    // ✅ Outside minWindow()
    private boolean isValid(HashMap<Character,Integer> window, HashMap<Character,Integer> target){

        for(char ch : target.keySet()){

            if(window.getOrDefault(ch,0) < target.get(ch)){
                return false;
            }
        }

        return true;
    }
}