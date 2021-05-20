package david.java.practice.algorithm.meituan;

import david.java.practice.algorithm.DavidBase;

import java.util.HashMap;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午3:15 2021/5/17
 */
public class LC_0008_myAtoi extends DavidBase {

    public int myAtoi(String s) {
        HashMap<String, String[]> map = new HashMap<>();
        map.put("start", new String[]{"start", "sign", "number", "end"});
        map.put("sign", new String[]{"end", "end", "number", "end"});
        map.put("number", new String[]{"end", "end", "number", "end"});
        map.put("end", new String[]{"end", "end", "end", "end"});

        String state = "start";
        int sign = 1;
        long value = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("start".equals(map.get(state)[get(c)])) {
                continue;
            } else if ("sign".equals(map.get(state)[get(c)])) {
                state = map.get(state)[get(c)];
                sign = '+' == c ? 1 : -1;
            } else if ("number".equals(map.get(state)[get(c)])) {
                value = sign == 1 ? Math.min(Integer.MAX_VALUE, value * 10 + c - '0') : Math.max(Integer.MIN_VALUE, -(value * 10 + c - '0'));
            } else {
                break;
            }
        }

        return (int)(sign * value);
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
