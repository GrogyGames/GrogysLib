package me.grogy.itembuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.potion.PotionEffect;

public class ItemBuilder {
	
	private String type = "";
	private Material material;
	private int itemAmount = 1;
	private String itemName = " ";
	private short damage = -1;
	private List<String> itemLore = new ArrayList<String>();
	private HashMap<Enchantment, Integer> enchants =  new HashMap<Enchantment, Integer>();
	private List<ItemFlag> itemFlags = new ArrayList<ItemFlag>();
	private Boolean unbreakable = false;
	private List<PotionEffect> potions = new ArrayList<PotionEffect>();
	private Color armorColor = Color.fromRGB(1, 2, 3);
	private Color potionColor = Color.fromRGB(1, 2, 3);
	private HashMap<Enchantment, Integer> storedEnchants = new HashMap<Enchantment, Integer>();
	
	public ItemBuilder (Material type) {
		this.material = type;
	}
	
	public ItemBuilder(Material type, int amount, String name, List<String> lore, HashMap<Enchantment, Integer> enchantments, List<ItemFlag> flags, boolean breakable, short damageAmount) {
		this.material = type;
		this.itemName = name;
		this.itemLore = lore;
		this.enchants = enchantments;
		this.itemFlags = flags;
		this.unbreakable = breakable;
		this.damage = damageAmount;
	}
	
	//potion builder
	public ItemBuilder(Material itemMaterial, String itemType, int amount, String name, List<String> lore, HashMap<Enchantment, Integer> enchantments, List<ItemFlag> flags, List<PotionEffect> potionEffects, Color color, short damageAmount) {
		this.material = itemMaterial;
		this.itemName = name;
		this.itemLore = lore;
		this.enchants = enchantments;
		this.itemFlags = flags;
		this.type = itemType;
		this.potions = potionEffects;
		this.potionColor = color;
		this.damage = damageAmount;
	}
	
	//leather armor builder
	public ItemBuilder(Material itemMaterial, String itemType, int amount, String name, List<String> lore, HashMap<Enchantment, Integer> enchantments, List<ItemFlag> flags, Color color, short damageAmount) {
		this.material = itemMaterial;
		this.itemName = name;
		this.itemLore = lore;
		this.enchants = enchantments;
		this.itemFlags = flags;
		this.type = itemType;
		this.armorColor = color;
		this.damage = damageAmount;
	}
	
	//enchanted book builder
	public ItemBuilder(Material type, int amount, String name, List<String> lore, HashMap<Enchantment, Integer> enchantments, List<ItemFlag> flags, boolean breakable, short damageAmount, HashMap<Enchantment, Integer> storedEnchantments) {
		this.material = type;
		this.itemName = name;
		this.itemLore = lore;
		this.enchants = enchantments;
		this.itemFlags = flags;
		this.unbreakable = breakable;
		this.damage = damageAmount;
		this.storedEnchants = storedEnchantments;
	}
	
	public ItemBuilder name(String name) {
		this.itemName = name;
		return this;
	}
	
	public ItemBuilder amount(int amount) {
		this.itemAmount = amount;
		return this;
	}
	
	public ItemBuilder addLore(String lore) {
		this.itemLore.add(lore);
		return this;
	}
	
	public ItemBuilder unbreakable(Boolean breakable) {
		this.unbreakable = breakable;
		return this;
	}
	
	public ItemBuilder setDamage(short damageAmount) {
		this.damage = damageAmount;
		return this;
	}
	
	public ItemBuilder addEnchant(Enchantment enchant, int lvl) {
		this.enchants.put(enchant, lvl);
		return this;
	}
	
	public ItemBuilder addFlag(ItemFlag flag) {
		this.itemFlags.add(flag);
		return this;
	}
	
	public ItemBuilder type(String itemType) {
		this.type = itemType;
		return this;
	}
	
	public ItemBuilder armorColor(Color color) {
		this.armorColor = color;
		return this;
	}
	
	public ItemBuilder addPotionEffect(PotionEffect effect) {
		this.potions.add(effect);
		return this;
	}
	
	public ItemBuilder potionColor(Color color) {
		this.potionColor = color;
		return this;
	}
	
	public ItemBuilder addStoredEnchant(Enchantment enchant, int lvl) {
		this.storedEnchants.put(enchant, lvl);
		return this;
	}
	
	public CustomItem build() {
		if (type.equals("potion")) return new CustomItem(material, itemAmount, itemName, unbreakable, itemLore, enchants, itemFlags, potions, potionColor,damage);
		else if (type.equals("leatherarmor")) return new CustomItem(material, itemAmount, itemName, unbreakable, itemLore, enchants, itemFlags, armorColor, damage);
		else if (type.equals("enchantedbook")) return new CustomItem(material, itemAmount, itemName, itemLore, enchants, itemFlags, unbreakable, damage, storedEnchants);
		else return new CustomItem(material, itemAmount, itemName, itemLore, enchants, itemFlags, unbreakable, damage);
	}
}
