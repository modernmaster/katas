package uk.co.jamesmcguigan.dequeue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DequeueTests {

    private Deque deque;

    @Before
    public void setUp(){
        deque = new Deque();
    }

    @Test
    public void testShouldEnqueueCorrectlyWhenAddingLast() {
        deque.addLast("a");
        deque.addLast("b");
        assertEquals("Test failed, size should be 2", 2, deque.size());
        assertEquals("First element should be 'a'", "a", deque.peekFirst());
        assertEquals("First element should be 'a'", "b", deque.peekLast());
    }

    @Test
    public void testShouldEnqueueCorrectlyWhenAddingFirst() {
        deque.addFirst("b");
        deque.addFirst("a");
        assertEquals("Test failed, size should be 2", 2, deque.size());
        assertEquals("First element should be 'a'", "a", deque.peekFirst());
        assertEquals("First element should be 'a'", "b", deque.peekLast());
    }

    @Test
    public void testShouldDequeueCorrectlyWhenRemovingFromFirst() {
        deque.addFirst("b");
        deque.addFirst("a");
        assertEquals("Test failed, size should be 1", 2, deque.size());
        String value = deque.removeFirst();
        assertEquals("Test failed, value should be 'a'", "a", value);
        assertEquals("Test failed, size should be 1", 1, deque.size());
        assertEquals("First element should be 'b'", "b", deque.peekFirst());
        assertEquals("First element should be 'b'", "b", deque.peekLast());
    }

    @Test
    public void testShouldDequeueCorrectlyWhenRemovingFromEnd() {
        deque.addFirst("b");
        deque.addFirst("a");
        String value = deque.removeLast();
        assertEquals("Test failed, value should be 'b'", "b", value);
        assertEquals("Test failed, size should be 1", 1, deque.size());
        assertEquals("First element should be 'a'", "a", deque.peekFirst());
        assertEquals("Last element should be 'a'", "a", deque.peekLast());
    }


}
