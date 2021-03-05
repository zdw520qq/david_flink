package david.java.flink.parameter_tool;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午2:41 2021/3/3
 */
public class ParameterToolDemo {
    public static void main(String[] args) throws IOException {
        String path = "/Users/jingshuo/code_repositive/david_flink/src/main/resources/application.properties";
        // String path = "src/main/resources/application.properties";


        /**
         * 读汉字会乱码
         */
        ParameterTool parameterTool = ParameterTool.fromPropertiesFile(path);
        System.out.println(parameterTool.get("name"));
        System.out.println(parameterTool.get("name1"));
        // System.out.println(parameterTool.getRequired("wifi"));
        System.out.println(parameterTool.get("wifi"));
        System.out.println(parameterTool.get("wifi", "zzzZZZ"));
        System.out.println(parameterTool.get("score", "100"));
        System.out.println("=================");


        /**
         * 读汉字会乱码
         */
        File file = new File(path);
        ParameterTool parameterTool1 = ParameterTool.fromPropertiesFile(file);
        System.out.println(parameterTool1.get("name"));
        System.out.println(parameterTool1.get("name1"));

        /**
         * 读汉字会乱码
         */
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        ParameterTool parameterTool2 = ParameterTool.fromPropertiesFile(fileInputStream);
        System.out.println(parameterTool2.get("name"));
        System.out.println(parameterTool2.get("name1"));


        /**
         * get from args ( --name 李四)
         */
        ParameterTool parameterTool3 = ParameterTool.fromArgs(args);
        System.out.println(parameterTool3.get("name"));





        /**
         * get from system properties
         */
        // ParameterTool parameterTool = ParameterTool.fromSystemProperties();
        // System.out.println(parameterTool.get("java.runtime.name"));
        // Properties properties = parameterTool.getProperties();
        // System.out.println(properties.getProperty("java.runtime.name"));


        /**
         * register the parameter globally
         */
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.getConfig().setGlobalJobParameters(parameterTool3);
        //使用的时候在算子内部
        //ParameterTool parameterTool = getRuntimeContext().getExecutionConfig().getGlobalJobParameters();

    }


}
