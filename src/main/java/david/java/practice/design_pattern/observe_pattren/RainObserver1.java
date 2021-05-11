package david.java.practice.design_pattern.observe_pattren;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 上午10:23 2021/5/11
 */
public class RainObserver1 extends AbstractObserver{

    public RainObserver1(String name, AbstractSubject sub) {
        super(name, sub);
    }

    @Override
    public void execute() {
        System.out.println(name + " -> 我要收衣服了!");
    }
}
