package david.java.practice.algorithm.niuke;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: david
 * @Date: Create in 下午7:36 2020/12/30
 */
public class NC78_SingleReverseLinkedList {

    public static void main(String[] args) {
        LinkedNode<Integer> list = new LinkedNode<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);

        LinkedNode<Integer> reverse = reverse(list);
        System.out.println(reverse);

        // Node<Integer> tail = reverse(list.first);
        // System.out.println(tail.value);


    }


    /**
     * 翻转列表
     */
    public static <T> LinkedNode<T> reverse(LinkedNode<T> linkedNode) {
        //如果是空的或者只有一个node ,也是不需要reverse的
        if (linkedNode.length <= 1) {
            return linkedNode;
        }

        Node<T> pre = null;
        Node<T> cur = linkedNode.first;
        //用来保存cur的next,避免cur的next指向pre后, 原来链断裂
        Node<T> next;

        //当cur为null的时候说明已经循环好了
        while (cur != null) {
            next = cur.next;
            cur.next = pre;

            //时刻更新first的位置
            linkedNode.first = cur;
            pre = cur;
            cur = next;
        }
        return linkedNode;
    }

    /**
     * 翻转列表
     */
    public static <T> Node<T> reverse(Node<T> head) {
        //如果是空的或者只有一个node ,也是不需要reverse的
        if (head == null) {
            return head;
        }

        Node<T> pre = null;
        Node<T> cur = head;
        //用来保存cur的next,避免cur的next指向pre后, 原来链断裂
        Node<T> next;

        //cursor指向第二个开始
        while (cur != null) {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        //pre就是最后一个节点,因为翻转了,所以pre也就是head了
        return pre;
    }

    static class LinkedNode<T> {
        int length = 0;
        Node<T> first;
        Node<T> last;

        public boolean add(T element) {
            Node<T> tail = last;
            Node<T> node = new Node<T>(element);
            last = node;
            if (length == 0) {
                first = node;
            } else {
                tail.next = node;
            }
            length++;
            return true;
        }

        public int size() {
            return length;
        }

        @Override
        public String toString() {
            ArrayList<T> list = new ArrayList<>();
            Node<T> cursor = first;
            if (length == 0) {
                return list.toString();
            }
            list.add(cursor.value);
            while (cursor.next != null) {
                cursor = cursor.next;
                list.add(cursor.value);
            }
            return list.toString();
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T element) {
            this.value = element;
        }

    }
}

