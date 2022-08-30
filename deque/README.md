Instructions:

1. Implement a double-ended queue (abbreviated to deque) that stores strings.
   A deque is a data structure that has characteristics of both a queue and a stack. Elements can be added or removed from either the front or back.
 
2. Consider adding some additional tests in doTestsPass()


    public class Solution {
       static class Deque {
          public void addFirst(String data) {
            throw new RuntimeException("method not implemented");
          }
   
          public void addLast(String data) {
            throw new RuntimeException("method not implemented");
          }
      
          public String removeFirst() {
            throw new RuntimeException("method not implemented");
          }
      
          public String removeLast() {
            throw new RuntimeException("method not implemented");
          }
      
          public String peekFirst() {
            throw new RuntimeException("method not implemented");
          }
      
          public String peekLast() {
            throw new RuntimeException("method not implemented");
          }
      
          public int size() {
            throw new RuntimeException("method not implemented");
          }
       }
   
       public static void main(String[] args) {
           try {
               doTestsPass();
               System.out.println("All tests passed");
           } catch (Exception ex) {
               System.out.println("Test failed");
               ex.printStackTrace();
           }
       }
   
       private static void doTestsPass() throws Exception {
           final Deque deque = new Deque();
           // enqueue
           deque.addLast("a");
           deque.addLast("b");
           assertTrue(deque.size() == 2, "Test failed, size should be 2");
           assertTrue("a".equals(deque.peekFirst()), "First element should be 'a'"); 
           //TODO: add your test cases here
       };
   
       private static void assertTrue(boolean condition, String message) throws Exception {
           if (!condition)
           throw new Exception(message);
       }
    }
