package david.java.algorithm;

import java.util.*;

/**
 * @Description: https://www.nowcoder.com/practice/e3769a5f49894d49b871c09cadd13a61?tpId=191&&tqId=36124&rp=1&ru=/ta/job-code-high-algorithm&qru=/ta/job-code-high-algorithm/question-ranking
 * <p>
 * 题目描述
 * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * [要求]
 * set和get方法的时间复杂度为O(1)
 * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 * 对于每个操作2，输出一个答案
 * <p>
 * 示例1
 * 输入
 * 复制
 * [[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
 * 返回值
 * 复制
 * [1,-1]
 * 说明
 * 第一次操作后：最常使用的记录为("1", 1)
 * 第二次操作后：最常使用的记录为("2", 2)，("1", 1)变为最不常用的
 * 第三次操作后：最常使用的记录为("3", 2)，("1", 1)还是最不常用的
 * 第四次操作后：最常用的记录为("1", 1)，("2", 2)变为最不常用的
 * 第五次操作后：大小超过了3，所以移除此时最不常使用的记录("2", 2)，加入记录("4", 4)，并且为最常使用的记录，然后("3", 2)变为最不常使用的记录
 * @Author: David
 * @Date: Create in 上午9:23 2021/1/6
 */
public class LRU {
    public static void main(String[] args) {
        int[][] data = new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1, 0}, {1, 4, 4}, {2, 2, 0}};
        int num = 3;

        // int[] ints = lru(data, num);

        Solution solution = new Solution();
        int[] ints = solution.lru(data, 3);


        System.out.print("[");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
            System.out.print(",");
        }
        System.out.print("]");

    }


    /**
     * use linkedHashMap
     *
     * @param operators
     * @param k
     * @return
     */
    public static int[] lru(int[][] operators, int k) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> values = new ArrayList<>();
        for (int[] ints : operators) {
            int opt = ints[0];
            switch (opt) {
                case 1: {
                    if (map.size() >= k) {
                        Iterator<Integer> it = map.keySet().iterator();
                        map.remove(it.next());
                    }
                    map.put(ints[1], ints[2]);
                    break;
                }
                case 2: {
                    int key = ints[1];
                    if (map.containsKey(key)) {
                        int value = map.get(ints[1]);
                        map.remove(ints[1]);
                        map.put(ints[1], value);
                        values.add(value);
                    } else {
                        values.add(-1);
                    }

                    break;
                }
                default:
                    break;
            }
        }
        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }
        return result;
    }


    static class Solution {
        /**
         * 使用hash查找 ,以达到速度达到O(1)
         */
        private Map<Integer, Node> map = new HashMap<>();
        // 固定head和tail 避免移除 末尾的时候,
        private Node head ;
        private Node tail ;
        private int capacity;


        /**
         * 使用链表和map, 当超过k的时候,将tail的去掉
         *
         * @param operators
         * @param k
         * @return
         */
        public int[] lru(int[][] operators, int k) {
            this.capacity = k;
            List<Integer> list = new ArrayList<>();

            for (int[] ints : operators) {
                int key = ints[1];
                switch (ints[0]) {
                    case 1: {
                        set(key, ints[2]);
                        break;
                    }
                    case 2: {
                        int i = get(key);
                        list.add(i);
                        break;
                    }
                    default:

                }
            }

            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }

            return result;
        }


        private void set(int key, int value) {
            Node node;
            if (map.containsKey(key)) {
                node = map.get(key);
                node.value = value;
                move2Head(node);

            } else {
                node = new Node(key, value);
                if (map.isEmpty()) {
                    head = node;
                    tail = node;
                } else {
                    head.prev = node;
                    node.next = head;
                    head = node;
                }
                map.put(key, node);


                if (map.size() > capacity) {
                    dropTail();
                }
            }

        }


        private int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);
            move2Head(node);

            return node.value;
        }


        private void move2Head(Node node) {
            if (null != node.prev) {
                Node prev = node.prev;
                Node next = node.next;

                if (tail == node) {
                    tail = prev;
                    tail.next = null;
                } else {
                    prev.next = next;
                    next.prev = prev;
                }

                node.next = head;
                head.prev = node;
                head = node;

                node.prev = null;
            }
        }

        private void dropTail() {
            int key = tail.key;
            tail = tail.prev;
            tail.next = null;
            map.remove(key);
        }


        private class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }


    }

}
