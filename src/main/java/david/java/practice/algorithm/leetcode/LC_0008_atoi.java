package david.java.practice.algorithm.leetcode;

import java.util.HashMap;

/**
 * @Description: 字符串转换整数 (atoi)
 * 
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
 * 返回整数作为最终结果。
 * 
 * @Author: David
 * @Date: Create in 下午2:38 2021/3/12
 */
public class LC_0008_atoi {


    /**
     * 题解:
     * 使用自动机, 把每种情况都列出来,然后
     *
     * 	            ' '	        +/-	        number	    other
     * -------------------------------------------------------
     * start	 |   start	    signed	    in_number	end
     * signed	 |   end	      end	    in_number	end
     * in_number |	 end	      end	    in_number	end
     * end	     |   end	      end	    end	        end
     *
     *
     */
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
