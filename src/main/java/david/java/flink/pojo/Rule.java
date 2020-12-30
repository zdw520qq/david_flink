package david.java.flink.pojo;

import java.util.HashMap;

/**
 * @Description:
 * @Author: Zhaodawei
 * @Date: Create in 上午9:58 2020/12/23
 */
public class Rule {
    public String name;
    public Shape first;
    public Shape second;

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("a", 1);
        String  a = String.valueOf( map.get("a"));
        System.out.println(a);

    }
}
