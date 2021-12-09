package github.stone98.netty.example.io.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author stone
 * @date 2021/10/15
 */
@Slf4j
public class BioClient {
    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter out = null;
        int port = 8080;
        try {
            socket = new Socket("127.0.0.1", port);
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("hello stone");
            log.info("客户端成功发送请求到服务端");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
