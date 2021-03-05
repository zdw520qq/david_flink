import scala.App;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午9:11 2021/1/10
 */
public class Test {
    public static void main(String[] args) {
       Apple apple = new Apple();
        Apple  a1 = apple;
        Apple  a2 = apple;
        System.out.println(a1 == a2);



    }

    static class Apple{
        int age;
    }


}
