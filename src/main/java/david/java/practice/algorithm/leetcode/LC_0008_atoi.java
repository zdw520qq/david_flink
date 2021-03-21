package david.java.practice.algorithm.leetcode;

import java.util.HashMap;

/**
 * @Description: 字符串转换整数 (atoi)
 * @Author: David
 * @Date: Create in 下午2:38 2021/3/12
 */
public class LC_0008_atoi {


    public static int myAtoi(String s) {
        int sign = 1;
        // 用long的原因是为了和防止int 溢出,导致和integer.maxvalue比较不准
        long value = 0;
        // " ", +/-, num, other
        String state = "start";
        HashMap<String, String[]> map = new HashMap<>();
        map.put("start", new String[]{"start", "sign", "number", "end"});
        map.put("sign", new String[]{"end", "end", "number", "end"});
        map.put("number", new String[]{"end", "end", "number", "end"});
        map.put("end", new String[]{"end", "end", "end", "end"});

        char[] chars = s.toCharArray();
        for (char c : chars) {
            state = map.get(state)[get(c)];
            if ("sign".equals(state)) {
                sign = '+' == c ? 1 : -1;
            } else if ("number".equals(state)) {
                // 减 '0' 的目的是, 不需要找 '1' 对应的数字是几, 因为 '1' 比'0' 肯定 大1
                value = sign == 1 ? Math.min(Integer.MAX_VALUE, value * 10 + c - '0') : -Math.max(Integer.MIN_VALUE, -(value * 10 + c - '0'));
            } else if ("end".equals(state)) {
                break;
            }
        }

        return (int) value * sign;
    }

    private static int get(char s) {
        if (' ' == s) {
            return 0;
        }
        if ('+' == s || '-' == s) {
            return 1;
        }
        if (Character.isDigit(s)) {
            return 2;
        }

        return 3;
    }


}
