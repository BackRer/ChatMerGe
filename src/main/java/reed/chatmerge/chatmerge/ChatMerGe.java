package reed.chatmerge.chatmerge;

import org.bukkit.plugin.java.JavaPlugin;
import reed.chatmerge.chatmerge.Bukkit.Chat;
import reed.chatmerge.chatmerge.Bukkit.cmg;
import reed.chatmerge.chatmerge.MultipleThreads.MerGe;

public final class ChatMerGe extends JavaPlugin {

    @Override
    public void onEnable() {
        //保存config文件
        saveDefaultConfig();
        //建立连接
        MerGe.SocketConnect();
        //注册指令
        getCommand("cmg").setExecutor(new cmg());
        //注册监听
        getServer().getPluginManager().registerEvents(new Chat(),this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
