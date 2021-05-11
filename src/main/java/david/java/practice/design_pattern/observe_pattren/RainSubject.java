package david.java.practice.design_pattern.observe_pattren;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 上午10:20 2021/5/11
 */
public class RainSubject extends AbstractSubject{

    public RainSubject() {
        observers = new ArrayList<>();
    }

    @Override
    void attach(AbstractObserver observer) {
        observers.add(observer);
    }

    @Override
    void detach(AbstractObserver observer) {
        observers.remove(observer);
    }

    @Override
    void notifyAllObservers() {
        for (AbstractObserver observer: observers) {
            observer.execute();
        }
    }

    public void rain(){
        System.out.println("打雷喽~~~ 下雨收衣服喽!!!");
        notifyAllObservers();
    }

}
