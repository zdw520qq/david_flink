package david.java.practice.algorithm.leetcode;

import java.util.HashMap;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午3:00 2021/5/20
 */
class LC_0146_LRUCache {
    private int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    DoubleList doubleList = new  DoubleList();

    public LC_0146_LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int value = node.value;
            doubleList.remove(node);
            doubleList.addFirst(node);
            return value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);

        if (map.containsKey(key)) {
            doubleList.remove(map.get(key));
            doubleList.addFirst(node);
            map.put(key, node);
        } else {
            if (map.keySet().size() >= capacity) {
                doubleList.removeLast();
                map.remove(key);
            }
            doubleList.addFirst(node);
            map.put(key, node);
        }
    }


    class Node {
        public int key;
        public int value;
        public Node pre, next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList {
        int size;
        public Node head;
        public Node tail;

        public DoubleList() {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.pre = head;
        }

        public void addFirst(Node node){
            head.next.pre = node;
            node.next = head.next;
            node.pre = head;
            head.next = node;
            size++;
        }


        public void remove(Node node) {
            if (size > 0) {
                node.next.pre = node.pre;
                node.pre.next = node.next;
                size --;
            }
        }


        public Node removeLast() {
            if (size > 0) {
                Node last = tail.pre;
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                size --;
                return last;
            }
            return null;
        }
    }

    public static void main(String[] args) {

        // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

        LC_0146_LRUCache cache = new LC_0146_LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);

        cache.get(2);

    }
}
