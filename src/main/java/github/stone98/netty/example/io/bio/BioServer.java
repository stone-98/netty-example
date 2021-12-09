package github.stone98.netty.example.io.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author stone
 * @date 2021/10/15
 */
@Slf4j
public class BioServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            int port = 8080;
            serverSocket = new ServerSocket(port);
            log.info("服务端启动完成,暴露【{}】端口", port);
            Socket socket = serverSocket.accept();
            log.info("成功建立连接，等待客户端发送请求");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 因为是阻塞I/O，所以readLine方法会阻塞，直到内核准备好数据，才进行响应
            String requestContent = in.readLine();
            log.info("成功建立请求之后，成功接收客户端的请求，请求内容为:【{}】", requestContent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
