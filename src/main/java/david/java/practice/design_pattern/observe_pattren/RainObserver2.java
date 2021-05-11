package david.java.practice.design_pattern.observe_pattren;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 上午10:28 2021/5/11
 */
public class RainObserver2 extends AbstractObserver {

    public RainObserver2(String name, AbstractSubject sub) {
        super(name, sub);
    }

    @Override
    public void execute() {
        System.out.println(name + " -> 我要回家了!");
    }
}
