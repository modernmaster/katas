package uk.co.jamesmcguigan.dequeue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Deque {

    private Node first = null;
    private Node last = null;

    public void addFirst(String data) {
        Node node = new Node(data);
        if (first == null && last == null) {
            last = node;
        } else {
            first.setPrev(node);
            node.setNext(first);
        }
        first = node;
    }

    public void addLast(String data) {
        Node node = new Node(data);
        if (first == null && last == null) {
            first = node;
        } else {
            last.setNext(node);
            node.setPrev(last);
        }
        last = node;
    }

    public String removeFirst() {
        if (first == null) {
            throw new NullPointerException();
        } else if (first == last) {
            first = null;
            last = null;
        }
        String value = first.getValue();
        first = first.getNext();
        return value;
    }

    public String removeLast() {
        if (last == null) {
            throw new NullPointerException();
        } else if (first == last) {
            first = null;
            last = null;
        }
        String value = last.getValue();
        last = last.getPrev();
        return value;
    }

    public String peekFirst() {
        if (first != null) {
            return first.getValue();
        }
        throw new NullPointerException();
    }

    public String peekLast() {
        if (last != null) {
            return last.getValue();
        }
        throw new NullPointerException();
    }

    public int size() {
        int count = 0;
        if (last == null) {
            return count;
        }
        count++;
        Node curr = last;
        while (first != curr) {
            curr = curr.getPrev();
            count++;
        }
        return count;
    }

    @Getter
    @RequiredArgsConstructor
    static class Node {

        private final String value;
        private Node next;
        private Node prev;

        void setNext(Node node) {
            next = node;
        }

        void setPrev(Node node) {
            prev = node;
        }
    }
}
