package david.java.practice.reflect;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午4:55 2021/5/14
 */
public class Singleton {
    private String name;
    private Integer age;
    private static Singleton singLeton;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Singleton(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static Singleton getInstance() {
        if (singLeton == null) {
            synchronized (Singleton.class) {
                if (singLeton == null) {
                    singLeton = new Singleton("singleton", 18);
                }
            }
        }
        return singLeton;
    }


}
