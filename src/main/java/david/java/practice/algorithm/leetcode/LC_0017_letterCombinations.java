package david.java.practice.algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午5:18 2021/3/24
 */
public class LC_0017_letterCombinations {
    static HashMap<Character, String[]> map = new HashMap<Character, String[]>() {
        {
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }
    };

    /**
     * 功能描述: 非递归
     *
     * @param digits
     * @return:
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return result;
        }
        Deque<StringBuilder> list = new LinkedList<>();
        list.add(new StringBuilder());
        char[] chars = digits.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];
            int size = list.size();
            for (int i = 0; i < size; i++) {
                StringBuilder poll = list.poll();
                for (String s : map.get(c)) {
                    list.add(new StringBuilder().append(poll).append(s));
                }
            }
        }


        list.forEach(t -> result.add(t.toString()));
        return result;
    }


    private static void recursiveCombine(List<Character> digits, Deque<StringBuilder> deque) {
        if (digits == null || digits.isEmpty()) {
            return;
        }
        char c = digits.get(0);
        digits.remove(0);
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            StringBuilder poll = deque.poll();
            for (String s : map.get(c)) {
                deque.add(new StringBuilder().append(poll).append(s));
            }
        }
        recursiveCombine(digits, deque);
    }


    /**
     * 功能描述: 递归,就是个意思,懒的弄了
     *
     * @param digits
     * @return:
     */
    public static List<String> recursiveLetterCombinations(String digits) {
        ArrayList<Character> characters = new ArrayList<>();
        char[] chars = digits.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            characters.add(chars[i]);
        }
        LinkedList<StringBuilder> sbs = new LinkedList<>();
        sbs.add(new StringBuilder());
        recursiveCombine(characters, sbs);
        sbs.forEach(StringBuilder::toString);
        System.out.println(sbs);
        return null;
    }


    public static void main(String[] args) {

        List<String> strings = recursiveLetterCombinations("23");
        System.out.println(strings);


        char[] cs = new char[]{'1', '2', '3'};
        int[] ints = new int[]{1, 2, 3};
        List<Integer> collect = Arrays.stream(ints).mapToObj(t -> (Integer) t).collect(Collectors.toList());
        System.out.println(collect);
    }

}
