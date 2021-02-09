package david.java.practice.algorithm.niuke;


import java.util.ArrayList;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午9:39 2021/1/1
 */
public class NC78_DoubleReverseLinkedList {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);

        System.out.println("========= asc =========");
        Node<Integer> first = list.first;
        while (first != null) {
            System.out.println(first.value);
            first = first.next;
        }

        System.out.println("========= desc =========");
        Node<Integer> last = list.last;
        while (last != null) {
            System.out.println(last.value);
            last = last.pre;
        }

        DoubleLinkedList<Integer> reverse = reverse(list);
        System.out.println(reverse);

        // System.out.println("===== reverse =====");
        // Node<Integer> tail = reverse(list.first);
        // while (tail != null) {
        //     System.out.println(tail.value);
        //     tail = tail.next;
        // }
    }

    /**链表翻转*/
    static <T> DoubleLinkedList<T> reverse(DoubleLinkedList<T> list) {
        if (list.length <= 1) {
            return list;
        }

        Node<T> pre = null;
        Node<T> cur = list.first;

        Node<T> next;

        while (cur != null) {
            //先保存cur的next,防止断链
            // oldPre = cur.pre;
            next = cur.next;

            cur.next = pre;
            cur.pre = next;

            //更新list的first
            list.first = cur;

            //cursor下移
            pre = cur;
            cur = next;
        }

        return list;
    }
    
    /**翻转链表*/
    static <T> Node<T> reverse(Node<T> head) {
        Node<T> pre = null;
        Node<T> cur = head;
        Node<T> next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            cur.pre = next;

            pre = cur;
            cur = next;
        }

        return pre;
    }

    static class DoubleLinkedList<T> {
        int length;
        Node<T> first;
        Node<T> last;

        boolean add(T element) {
            Node<T> lastBeforeAdd = last;
            Node<T> node = new Node<>(element);
            last = node;
            if (length == 0) {
                first = node;
            } else {
                lastBeforeAdd.next = node;
                node.pre = lastBeforeAdd;
            }
            length++;

            return true;
        }




 
        @Override
        public String toString() {
            ArrayList<T> ts = new ArrayList<>();
            Node<T> node = first;
            while (node != null) {
                ts.add(node.value);
                node = node.next;
            }

            return ts.toString();
        }
    }

    static class Node<T> {
        T value;
        Node<T> pre;
        Node<T> next;

        public Node(T vale) {
            this.value = vale;
        }
    }


}
