class Solution {

    public boolean checkInclusion(String s1, String s2) {


        int freq[] = new int[26];
        int windowFreq[] = new int[26];

            if (s1.length() > s2.length()) {
                return false;
            }

        // s1 freq ready
        for(int i = 0; i <s1.length(); i++){
            int currentIndex = s1.charAt(i) - 'a';
            freq[currentIndex]++;

        }
        // first window freq ready
        for(int j =0; j < s1.length(); j++){
            int windowIndex = s2.charAt(j)-'a';
            windowFreq[windowIndex]++;
        }

        // if( freq[currentIndex] ==  windowFreq[windowIndex]){
        //     return true;
        // }

          // Compare first window
        if (Arrays.equals(freq, windowFreq)) {
            return true;
        }



       
        // So sliding part becomes:
        for(int i = s1.length(); i < s2.length(); i++){
            //remove left
            int leftIndex = s2.charAt(i - s1.length()) - 'a';
            windowFreq[leftIndex]--;

            // add right
            int rightIndex = s2.charAt(i) - 'a';
            windowFreq[rightIndex]++; 

             if(Arrays.equals(freq, windowFreq)){
              return true;
        }

        }

        return false;





        

       
    }
}
