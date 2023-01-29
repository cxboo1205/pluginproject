package com.cxgaming.project2;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ReplyCommand implements CommandExecutor {
    private Main main;
    public ReplyCommand(Main main){
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length >= 1) {
                if(main.getRecentMessages().containsKey(player.getUniqueId())){
                    UUID uuid = main.getRecentMessages().get(player.getUniqueId());
                    if(Bukkit.getPlayer(uuid) != null) {
                        Player target = Bukkit.getPlayer(uuid);

                        StringBuilder builder = new StringBuilder();
                        for (int i = 0; i < args.length; i++) {
                            builder.append(args[i]).append(" ");
                        }

                        player.sendMessage("You -> " + target.getName() + ": " + builder);
                        target.sendMessage(player.getName() + "-> You:" + builder);

                    } else {
                        player.sendMessage("Player went offline!");
                    }
                } else {
                    player.sendMessage("You haven't message anybody yet!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid command usage!");
            }

        }
        return false;
    }
}
