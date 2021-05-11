package david.java.practice.design_pattern.observe_pattren;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 上午10:14 2021/5/11
 */
public abstract class AbstractObserver {

    String name;
    AbstractSubject sub;

    public AbstractObserver(String name, AbstractSubject sub) {
        this.name = name;
        this.sub = sub;
        sub.attach(this);
    }

    public abstract void execute();

    public void detach() {
        sub.detach(this);
    }
}
