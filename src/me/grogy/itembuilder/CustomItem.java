package me.grogy.itembuilder;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

public class CustomItem extends ItemStack {
	
	public CustomItem(Material type, int amount, String name, List<String> lore, HashMap<Enchantment, Integer> enchantments, List<ItemFlag> flags, boolean breakable, short damageAmount) {
		this.setType(type);
		this.setAmount(amount);
		ItemMeta meta = this.getItemMeta();
		if (!name.equals(" ")) meta.setDisplayName(name);
		if (!lore.isEmpty()) meta.setLore(lore);
		if (!flags.isEmpty()) for (ItemFlag flag : flags) meta.addItemFlags(flag);
		meta.setUnbreakable(breakable);
		if (meta instanceof Damageable)
		if (damageAmount != -1) {
			Damageable damageable = (Damageable) meta;
			damageable.setDamage(damageAmount);
			this.setItemMeta((ItemMeta) damageable);
		}
		for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) if (entry.getKey() != null && entry.getValue() != null) 
			meta.addEnchant(entry.getKey(), entry.getValue(), true);
		this.setItemMeta(meta);
	}
	
	//potion builder
	public CustomItem(Material type, int amount, String name, boolean breakable, List<String> lore, HashMap<Enchantment, Integer> enchantments, List<ItemFlag> flags, List<PotionEffect> potionEffects, Color color, short damageAmount) {
		this.setType(type);
		this.setAmount(amount);
		ItemMeta meta = this.getItemMeta();
		if (!name.equals(" ")) meta.setDisplayName(name);
		if (!lore.isEmpty()) meta.setLore(lore);
		if (!flags.isEmpty()) for (ItemFlag flag : flags) meta.addItemFlags(flag);
		meta.setUnbreakable(breakable);
		if (meta instanceof Damageable)
		if (damageAmount != -1) {
			Damageable damageable = (Damageable) meta;
			damageable.setDamage(damageAmount);
			this.setItemMeta((ItemMeta) damageable);
		}
		for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) if (entry.getKey() != null && entry.getValue() != null) 
			meta.addEnchant(entry.getKey(), entry.getValue(), true);
		this.setItemMeta(meta);
		PotionMeta meta2 = (PotionMeta) meta;
		if (!potionEffects.isEmpty()) for (PotionEffect effect : potionEffects) meta2.addCustomEffect(effect, true);
		if (!color.equals(Color.fromRGB(1, 2, 3))) meta2.setColor(color);
		this.setItemMeta(meta2);
	}
	
	//leather armor builder
	public CustomItem(Material type, int amount, String name, boolean breakable, List<String> lore, HashMap<Enchantment, Integer> enchantments, List<ItemFlag> flags, Color color, short damageAmount) {
		this.setType(type);
		this.setAmount(amount);
		ItemMeta meta = this.getItemMeta();
		if (!name.equals(" ")) meta.setDisplayName(name);
		if (!lore.isEmpty()) meta.setLore(lore);
		if (!flags.isEmpty()) for (ItemFlag flag : flags) meta.addItemFlags(flag);
		meta.setUnbreakable(breakable);
		if (meta instanceof Damageable)
		if (damageAmount != -1) {
			Damageable damageable = (Damageable) meta;
			damageable.setDamage(damageAmount);
			this.setItemMeta((ItemMeta) damageable);
		}
		for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) if (entry.getKey() != null && entry.getValue() != null) 
			meta.addEnchant(entry.getKey(), entry.getValue(), true);
		this.setItemMeta(meta);
		LeatherArmorMeta meta2 = (LeatherArmorMeta) meta;
		if (!color.equals(Color.fromRGB(1, 2, 3))) meta2.setColor(color);
		this.setItemMeta(meta2);
	}
	
	//enchanted book builder
	public CustomItem(Material type, int amount, String name, List<String> lore, HashMap<Enchantment, Integer> enchantments, List<ItemFlag> flags, boolean breakable, short damageAmount, HashMap<Enchantment, Integer> storedEnchantments) {
		this.setType(type);
		this.setAmount(amount);
		ItemMeta meta = this.getItemMeta();
		if (!name.equals(" ")) meta.setDisplayName(name);
		if (!lore.isEmpty()) meta.setLore(lore);
		if (!flags.isEmpty()) for (ItemFlag flag : flags) meta.addItemFlags(flag);
		meta.setUnbreakable(breakable);
		if (meta instanceof Damageable)
		if (damageAmount != -1) {
			Damageable damageable = (Damageable) meta;
			damageable.setDamage(damageAmount);
			this.setItemMeta((ItemMeta) damageable);
		}
		for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) if (entry.getKey() != null && entry.getValue() != null) 
			meta.addEnchant(entry.getKey(), entry.getValue(), true);
		this.setItemMeta(meta);
		EnchantmentStorageMeta meta2 = (EnchantmentStorageMeta) meta;
		for (Map.Entry<Enchantment, Integer> entry : storedEnchantments.entrySet()) if (entry.getKey() != null && entry.getValue() != null) 
			meta2.addStoredEnchant(entry.getKey(), entry.getValue(), true);
		this.setItemMeta(meta2);
	}
}
