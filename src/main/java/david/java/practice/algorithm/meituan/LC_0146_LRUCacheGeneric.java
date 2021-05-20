package david.java.practice.algorithm.meituan;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 上午10:12 2021/5/20
 */
public class LC_0146_LRUCacheGeneric<K, V> {
    int capacity;
    Map<K, LRUEntry<K, V>> map = new HashMap<>();
    DoubleList<K, V> doubleList = new DoubleList<>();


    public LC_0146_LRUCacheGeneric(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        } else {
            LRUEntry<K, V> entry = map.get(key);
            doubleList.remove(entry);
            doubleList.addFirst(entry);
            return entry.value;
        }
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            doubleList.remove(map.get(key));
        } else {
            if (map.keySet().size() >= capacity) {
                doubleList.removeLast();
                map.remove(key);
            }
            LRUEntry<K, V> entry = new LRUEntry<>(key, value);
            doubleList.addFirst(entry);
            map.put(key, entry);
        }
    }

    class LRUEntry<K, V> {
        public K key;
        public V value;
        LRUEntry<K, V> pre;
        LRUEntry<K, V> next;

        public LRUEntry() {
        }

        public LRUEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            LRUEntry<K, V> tmp = this;
            StringBuilder sb = new StringBuilder();
            while (tmp != null) {
                sb.append("<").append(tmp.key).append(",").append(tmp.value).append(">").append(", ");
                tmp = tmp.next;
            }
            return sb.toString();
        }
    }

    class DoubleList<K, V> {
        int size;
        LRUEntry<K, V> dummyHead;
        LRUEntry<K, V> dummyTail;

        public DoubleList() {
            this.dummyHead = new LRUEntry<>();
            this.dummyTail = new LRUEntry<>();

            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
        }

        public int getSize() {
            return this.size;
        }

        public void addFirst(LRUEntry<K, V> entry) {
            dummyHead.next.pre = entry;
            entry.next = dummyHead.next;
            entry.pre = dummyHead;
            dummyHead.next = entry;
            size++;
        }


        public LRUEntry<K, V> removeLast() {
            if (size <= 0) {
                return null;
            }
            LRUEntry<K, V> pre = dummyTail.pre.pre;
            pre.next = dummyTail;
            dummyTail.pre = pre;
            size--;
            return  pre;
        }

        public void remove(LRUEntry<K, V> entry) {
            if (size <= 0) {
                return;
            }
            entry.next.pre = entry.pre;
            entry.pre.next = entry.next;
            size--;
        }

    }


    public static void main(String[] args) {
    }

}
