Instructions:

1. Given a string of letters and a dictionary, the function longestWord should find the longest word or words in the dictionary that can be made from the letters
     Input: letters = "oet", dictionary = {"to","toe","toes"}
     Output: {"toe"}
     Only lowercase letters will occur in the dictionary and the letters
     The length of letters will be between 1 and 10 characters
     The solution should work well for a dictionary of over 100,000 words
2. Run this code in the REPL to observe its behaviour. The execution entry point is main(). 
3. Consider adding some additional tests in doTestsPass(). 
4. Implement the longestWord() method correctly. 
5. If time permits, introduce '?' which can represent any letter.  "to?" could match to "toe", "ton" etc


    import java.util.*;

    class Dictionary {

      private String[] entries;

      public Dictionary(String[] entries) {
         this.entries = entries;
      }

      public boolean contains(String word) {
         return Arrays.asList(entries).contains(word);
      }

      public String [] getEntries() {
         return entries;
      }
    }

    public class Solution {
        public static Set<String> longestWord(String letters, Dictionary dict) {
            Set<String> result = new HashSet<String>();    
            return result;

        public static boolean doTestsPass() {
            Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});
            boolean result = new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
            result = result && new HashSet<String>(Arrays.asList("toes", "dogs")).equals(longestWord("osetdg", dict));
            return result;
        }
    
        public static boolean doTestsPass2() {
            Dictionary dict = new Dictionary(new String[]{"toes"});
            boolean result = new HashSet<String>(Arrays.asList("toes")).equals(longestWord("toes", dict));
            return result;   
        }
    
        public static boolean doTestsPass3() {
            Dictionary dict = new Dictionary(new String[]{"toes", "to"}); 
            boolean result = new HashSet<String>(Arrays.asList("toes")).equals(longestWord("toes", dict));
            return result;   
        }
    
        public static boolean doTestsPass4() {
            Dictionary dict = new Dictionary(new String[]{"toes", "to", "toess"});
            boolean result = new HashSet<String>(Arrays.asList("toes")).equals(longestWord("toes", dict));
            return result;   
        }
    
        /**
          * Execution entry point.
        */
        public static void main(String[] args) {
            if(doTestsPass() && doTestsPass2() && doTestsPass3() && doTestsPass4()) {
                System.out.println("All tests pass");
            } else {
                System.err.println("There are test failures");
            }
        }
    }
