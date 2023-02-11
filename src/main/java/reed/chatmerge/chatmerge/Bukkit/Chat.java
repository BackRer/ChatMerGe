package reed.chatmerge.chatmerge.Bukkit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import reed.chatmerge.chatmerge.MultipleThreads.WriteDataWithMultipleThreads;
import reed.chatmerge.chatmerge.method;

public class Chat implements Listener {
    private WriteDataWithMultipleThreads writeDataWithMultipleThreads = new WriteDataWithMultipleThreads(5);
    @EventHandler
    public void PlayerChat(AsyncPlayerChatEvent e){
        if (method.ConnectInfo){
            writeDataWithMultipleThreads.writeData(method.outputStream,StringLL(method.config.getString("Send.QQ"),e.getPlayer(),e.getMessage()));
        }
    }
    public String StringLL(String str, Player player,String Chat){
        str = str.replaceAll("%player%",player.getName());
        str = str.replaceAll("%Chat%",Chat);
        return str;
    }
}
