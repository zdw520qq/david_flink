package david.java.flink.datasources;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * @Author: Zhaodawei
 * @Date: Create in 上午10:21 2020/12/14
 */
public class SocketDatasource {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);

        while (true) {
            Socket socket = null;
            socket = serverSocket.accept();

        }

    }
}
