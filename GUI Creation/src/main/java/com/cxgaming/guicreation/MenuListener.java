package com.cxgaming.guicreation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Random;

public class MenuListener implements Listener {

    @EventHandler
    public void onCLick(InventoryClickEvent e) {
        if (ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(ChatColor.RED + "Tool Manu")
            && e.getCurrentItem() != null) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();

            switch (e.getRawSlot()) {
                case 0:
                    break;
                case 20:
                    Random random = new Random();
                    Player target = (Player) Bukkit.getOnlinePlayers().toArray()[random.nextInt(Bukkit.getOnlinePlayers().size())];
                    player.teleport(target);
                    player.sendMessage("You have teleported to " + target.getName() + "!");
                    break;
                case 22:
                    player.setHealth(0);
                    player.sendMessage("You committed suicide :(");
                    break;
                case 24:
                    player.closeInventory();
                    player.getInventory().clear();
                    player.sendMessage("Inventory cleared!");
                    break;
                default:
                    return;
            }


            player.closeInventory();
        }
    }
}
