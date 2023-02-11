package reed.chatmerge.chatmerge.MultipleThreads;

import org.bukkit.Bukkit;
import reed.chatmerge.chatmerge.method;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class MerGe {
    public static void SocketConnect(){
        try {
            method.socket = new Socket(method.ip,method.port);


            //建立发送线程池
            WriteDataWithMultipleThreads writer = new WriteDataWithMultipleThreads(1);
            method.outputStream = method.socket.getOutputStream();
            String data = "SendServer:"+method.config.getString("Send.Server.name");
            writer.writeData(method.outputStream,data);
            //关闭
            writer.shutdown();
            method.outputStream.flush();
            //method.outputStream.close();
            method.ConnectInfo = true;
            //建立监听线程池
            method.inputStream = method.socket.getInputStream();
            ReadDataWithMultipleThreads reader = new ReadDataWithMultipleThreads(5);
            reader.readData(method.inputStream);

            Bukkit.broadcastMessage(method.prefix+"§e§lConnection established successfully!");



        } catch (IOException e) {
            method.ConnectInfo = false;
            method.plugin.getLogger().info(method.prefix+"§cFailed to establish a connection with the server!");
            //throw new RuntimeException(e);
        }
    }
}
