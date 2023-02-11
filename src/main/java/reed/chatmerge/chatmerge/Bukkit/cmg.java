package reed.chatmerge.chatmerge.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import reed.chatmerge.chatmerge.MultipleThreads.MerGe;
import reed.chatmerge.chatmerge.method;

public class cmg implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("ChatMerGe.ct")){
            if (!method.ConnectInfo){
                MerGe.SocketConnect();
            }else {
                sender.sendMessage(method.prefix+"当前连接已建立!");
            }
        }
        return false;
    }
}
