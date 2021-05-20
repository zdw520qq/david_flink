package david.java.practice.reflect;


/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午9:19 2021/5/14
 */
public enum SingletonEnum {
    /***/
    INSTANCE;

    private Resource res;

    SingletonEnum() {
        res = new Resource();
    }

    public Resource getInstance() {
        return res;
    }

}

class Resource{

}
