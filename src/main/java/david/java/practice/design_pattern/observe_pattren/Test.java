package david.java.practice.design_pattern.observe_pattren;

import org.apache.commons.lang3.concurrent.ConcurrentUtils;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 上午10:29 2021/5/11
 */
public class Test {
    public static void main(String[] args) {
        RainSubject rainSubject = new RainSubject();
        RainObserver1 o1 = new RainObserver1("小明",rainSubject);
        RainObserver2 o2 = new RainObserver2("小红",rainSubject);

        rainSubject.rain();

        o1.detach();
        rainSubject.rain();

        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        map.values();

    }
}
