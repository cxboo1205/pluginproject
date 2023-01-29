package com.cxgaming.guicreation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            Inventory inv = Bukkit.createInventory(player,45, ChatColor.RED + "Tool Manu");


            // Teleport
            ItemStack teleport = new ItemStack(Material.ENDER_PEARL);
            ItemMeta teleportMeta = teleport.getItemMeta();
            teleportMeta.setDisplayName(ChatColor.GREEN + "Random Teleport");
            teleportMeta.setLore(Arrays.asList(ChatColor.GRAY + "Teleports to a random player"));
            teleport.setItemMeta(teleportMeta);

            inv.setItem(20,teleport);

            // Suicide
            ItemStack suicide = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta suicideMeta = suicide.getItemMeta();
            suicideMeta.setDisplayName(ChatColor.GREEN + "Suicide");
            suicideMeta.setLore(Arrays.asList(ChatColor.GRAY + "Kills you!"));
            suicide.setItemMeta(suicideMeta);

            inv.setItem(22,suicide);

            // Rebirth
            ItemStack rebirth = new ItemStack(Material.BUCKET);
            ItemMeta rebirthMeta = rebirth.getItemMeta();
            rebirthMeta.setDisplayName(ChatColor.GREEN + "Rebirth");
            rebirthMeta.setLore(Arrays.asList(ChatColor.GRAY + "Clear your inventory."));
            rebirth.setItemMeta(rebirthMeta);

            inv.setItem(24,rebirth);

            // Close Button
            ItemStack close = new ItemStack(Material.BARRIER);
            ItemMeta closeMeta = close.getItemMeta();
            closeMeta.setDisplayName(ChatColor.RED + "Close");
            close.setItemMeta(closeMeta);

            inv.setItem(0,close);

            // Frame
            ItemStack frame = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            for(int i : new int[]{1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,37,38,39,40,41,42,43,44}) {
                inv.setItem(i,frame);
            }

            player.openInventory(inv);
        }

        return false;
    }
}
