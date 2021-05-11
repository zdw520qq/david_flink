package david.java.practice.design_pattern.observe_pattren;

import java.util.List;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 上午10:13 2021/5/11
 */
public abstract class AbstractSubject {
    List<AbstractObserver> observers;

    abstract void attach(AbstractObserver observer);
    abstract void detach(AbstractObserver observer);
    abstract void notifyAllObservers();
}
