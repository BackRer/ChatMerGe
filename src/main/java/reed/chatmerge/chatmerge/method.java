package reed.chatmerge.chatmerge;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class method {
    public static boolean ConnectInfo = false;
    public static Plugin plugin = ChatMerGe.getPlugin(ChatMerGe.class); //获取Plugin
    public static FileConfiguration config = ChatMerGe.getPlugin(ChatMerGe.class).getConfig();  //获取config

    public static String prefix = config.getString("prefix");

    public static String ip = config.getString("Server.IP");
    public static int port = config.getInt("Server.port");

    public static Socket socket;    //创建socket
    public static InputStream inputStream;
    public static OutputStream outputStream;
}
