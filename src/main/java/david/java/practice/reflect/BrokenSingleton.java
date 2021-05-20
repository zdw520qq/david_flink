package david.java.practice.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午5:18 2021/5/14
 */
public class BrokenSingleton {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        System.out.println(singleton == singleton1);

        Singleton broker = brokeSingleton("broker", 999);
        Singleton broker1 = brokeSingleton("broker", 999);
        System.out.println(broker.getName());

        System.out.println(singleton == broker);
        System.out.println(broker1 == broker);

    }

    public static Singleton brokeSingleton(String name, Integer age) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Singleton> singletonClass = Singleton.class;
        Constructor<Singleton> declaredConstructor = singletonClass.getDeclaredConstructor(String.class, Integer.class);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(name, age);
    }
}
