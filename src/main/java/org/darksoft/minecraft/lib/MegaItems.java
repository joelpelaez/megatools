package org.darksoft.minecraft.lib;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

/**
 * Class with various methods to create enchantment items.
 * 
 * @author Joel Pelaez Jorge
 * @since 1.1b
 * @version 1.1b
 */
public class MegaItems {
	/**
	 * Set to <code>item</code> a <code>enchantment</code> with the max level
	 * 
	 * @param item
	 *            A {@link ItemStack} object
	 * @param enchantment
	 *            A {@link Enchantment} to apply the item
	 */
	protected static void setMaxEnchantment(ItemStack item,
			Enchantment enchantment) {
		item.addEnchantment(enchantment, enchantment.getMaxLevel());
	}

	/**
	 * Create a new {@link Material#DIAMOND_SWORD Diamond Sword}
	 * {@link ItemStack item} and enchant it.
	 * 
	 * @param fire
	 *            If set true the Bow will be enchanted with
	 *            {@link Enchantment#FIRE_ASPECT Fire Aspect} or false to will
	 *            be skipped.
	 * 
	 * @return A new {@link ItemStack Diamond Sword}
	 */
	public static ItemStack getMegaSword(boolean fire) {
		ItemStack mSword = new ItemStack(Material.DIAMOND_SWORD);
		setMaxEnchantment(mSword, Enchantment.DAMAGE_ALL);
		setMaxEnchantment(mSword, Enchantment.DAMAGE_ARTHROPODS);
		setMaxEnchantment(mSword, Enchantment.DAMAGE_UNDEAD);
		setMaxEnchantment(mSword, Enchantment.DURABILITY);
		if (fire)
			setMaxEnchantment(mSword, Enchantment.FIRE_ASPECT);
		setMaxEnchantment(mSword, Enchantment.KNOCKBACK);
		setMaxEnchantment(mSword, Enchantment.LOOT_BONUS_MOBS);
		return mSword;
	}

	/**
	 * Create a new {@link Material#DIAMOND_AXE Diamond Axe} {@link ItemStack
	 * item} and enchant it.
	 * 
	 * @param looting
	 *            If set true the Axe will be enchanted with
	 *            {@link Enchantment#LOOT_BONUS_BLOCKS Fortune} or false to will
	 *            be enchanted with {@link Enchantment#SILK_TOUCH Silk Touch}
	 * @return A new {@link ItemStack Diamond Axe}
	 */
	public static ItemStack getMegaAxe(boolean looting) {
		ItemStack mAxe = new ItemStack(Material.DIAMOND_AXE);
		setMaxEnchantment(mAxe, Enchantment.DAMAGE_ALL);
		setMaxEnchantment(mAxe, Enchantment.DAMAGE_ARTHROPODS);
		setMaxEnchantment(mAxe, Enchantment.DAMAGE_UNDEAD);
		setMaxEnchantment(mAxe, Enchantment.DURABILITY);
		if (looting)
			setMaxEnchantment(mAxe, Enchantment.LOOT_BONUS_BLOCKS);
		else
			setMaxEnchantment(mAxe, Enchantment.SILK_TOUCH);
		setMaxEnchantment(mAxe, Enchantment.DIG_SPEED);
		return mAxe;
	}

	/**
	 * Create a new {@link Material#DIAMOND_PICKAXE Diamond Pickaxe}
	 * {@link ItemStack item} and enchant it.
	 * 
	 * @param looting
	 *            If set true the Pickaxe will be enchanted with
	 *            {@link Enchantment#LOOT_BONUS_BLOCKS Fortune} or false to will
	 *            be enchanted with {@link Enchantment#SILK_TOUCH Silk Touch}
	 * @return A new {@link ItemStack Diamond Pickaxe}
	 */
	public static ItemStack getMegaPickaxe(boolean looting) {
		ItemStack mPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
		setMaxEnchantment(mPickaxe, Enchantment.DURABILITY);
		if (looting)
			setMaxEnchantment(mPickaxe, Enchantment.LOOT_BONUS_BLOCKS);
		else
			setMaxEnchantment(mPickaxe, Enchantment.SILK_TOUCH);
		setMaxEnchantment(mPickaxe, Enchantment.DIG_SPEED);
		return mPickaxe;
	}

	/**
	 * Create a new {@link Material#DIAMOND_SPADE Diamond Shovel}
	 * {@link ItemStack item} and enchant it.
	 * 
	 * @param looting
	 *            If set true the Shovel will be enchanted with
	 *            {@link Enchantment#LOOT_BONUS_BLOCKS Fortune} or false to will
	 *            be enchanted with {@link Enchantment#SILK_TOUCH Silk Touch}
	 * @return A new {@link ItemStack Diamond Shovel}
	 */
	public static ItemStack getMegaShovel(boolean looting) {
		ItemStack mShovel = new ItemStack(Material.DIAMOND_SPADE);
		setMaxEnchantment(mShovel, Enchantment.DURABILITY);
		if (looting)
			setMaxEnchantment(mShovel, Enchantment.LOOT_BONUS_BLOCKS);
		else
			setMaxEnchantment(mShovel, Enchantment.SILK_TOUCH);
		setMaxEnchantment(mShovel, Enchantment.DIG_SPEED);
		return mShovel;
	}

	/**
	 * Create a new {@link Material#DIAMOND_SPADE Diamond Shovel}
	 * {@link ItemStack item} and enchant it.
	 * 
	 * @param fire
	 *            If set true the Bow will be enchanted with
	 *            {@link Enchantment#ARROW_FIRE Fire} or false to will be
	 *            skipped.
	 * @return A new {@link ItemStack Diamond Shovel}
	 */
	public static ItemStack getMegaBow(boolean fire) {
		ItemStack mBow = new ItemStack(Material.BOW);
		setMaxEnchantment(mBow, Enchantment.DURABILITY);
		if (fire)
			setMaxEnchantment(mBow, Enchantment.ARROW_FIRE);
		setMaxEnchantment(mBow, Enchantment.ARROW_DAMAGE);
		setMaxEnchantment(mBow, Enchantment.ARROW_INFINITE);
		setMaxEnchantment(mBow, Enchantment.ARROW_KNOCKBACK);
		return mBow;
	}

	/**
	 * Create a new {@link Material#DIAMOND_HELMET Diamond Helmet}
	 * {@link ItemStack item} and enchant it.
	 * 
	 * @return A new {@link ItemStack Diamond Helmet}
	 */
	public static ItemStack getMegaHelmet() {
		ItemStack mHelmet = new ItemStack(Material.DIAMOND_HELMET);
		setMaxEnchantment(mHelmet, Enchantment.PROTECTION_ENVIRONMENTAL);
		setMaxEnchantment(mHelmet, Enchantment.PROTECTION_EXPLOSIONS);
		setMaxEnchantment(mHelmet, Enchantment.PROTECTION_FIRE);
		setMaxEnchantment(mHelmet, Enchantment.PROTECTION_PROJECTILE);
		setMaxEnchantment(mHelmet, Enchantment.THORNS);
		setMaxEnchantment(mHelmet, Enchantment.OXYGEN);
		setMaxEnchantment(mHelmet, Enchantment.WATER_WORKER);
		setMaxEnchantment(mHelmet, Enchantment.DURABILITY);
		return mHelmet;
	}

	/**
	 * Create a new {@link Material#DIAMOND_CHESTPLATE Diamond Chestplate}
	 * {@link ItemStack item} and enchant it.
	 * 
	 * @return A new {@link ItemStack Diamond Chestplate}
	 */
	public static ItemStack getMegaChestplate() {
		ItemStack mChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		setMaxEnchantment(mChestplate, Enchantment.PROTECTION_ENVIRONMENTAL);
		setMaxEnchantment(mChestplate, Enchantment.PROTECTION_EXPLOSIONS);
		setMaxEnchantment(mChestplate, Enchantment.PROTECTION_FIRE);
		setMaxEnchantment(mChestplate, Enchantment.PROTECTION_PROJECTILE);
		setMaxEnchantment(mChestplate, Enchantment.THORNS);
		setMaxEnchantment(mChestplate, Enchantment.DURABILITY);
		return mChestplate;
	}

/**
	 * Create a new {@link Material#DIAMOND_LEGGINGS Diamond Leggings
	 * 
	 * @link ItemStack item} and enchant it.
	 * 
	 * @return A new {@link ItemStack Diamond Leggings}
	 */
	public static ItemStack getMegaLeggings() {
		ItemStack mLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		setMaxEnchantment(mLeggings, Enchantment.PROTECTION_ENVIRONMENTAL);
		setMaxEnchantment(mLeggings, Enchantment.PROTECTION_EXPLOSIONS);
		setMaxEnchantment(mLeggings, Enchantment.PROTECTION_FIRE);
		setMaxEnchantment(mLeggings, Enchantment.PROTECTION_PROJECTILE);
		setMaxEnchantment(mLeggings, Enchantment.THORNS);
		setMaxEnchantment(mLeggings, Enchantment.DURABILITY);
		return mLeggings;
	}

	/**
	 * Create a new {@link Material#DIAMOND_BOOTS Diamond Boots}
	 * {@link ItemStack item} and enchant it.
	 * 
	 * @return A new {@link ItemStack Diamond Boots}
	 */
	public static ItemStack getMegaBoots() {
		ItemStack mBoots = new ItemStack(Material.DIAMOND_BOOTS);
		setMaxEnchantment(mBoots, Enchantment.PROTECTION_ENVIRONMENTAL);
		setMaxEnchantment(mBoots, Enchantment.PROTECTION_EXPLOSIONS);
		setMaxEnchantment(mBoots, Enchantment.PROTECTION_FALL);
		setMaxEnchantment(mBoots, Enchantment.PROTECTION_FIRE);
		setMaxEnchantment(mBoots, Enchantment.PROTECTION_PROJECTILE);
		setMaxEnchantment(mBoots, Enchantment.THORNS);
		setMaxEnchantment(mBoots, Enchantment.DURABILITY);
		return mBoots;
	}

	/**
	 * Create a new {@link Material#FLINT_AND_STEEL Flint and Steel}
	 * {@link ItemStack item} and enchant it.
	 * 
	 * @return A new {@link ItemStack Flint and Steel}
	 */
	public static ItemStack getMegaFlintAndSteel() {
		ItemStack mBoots = new ItemStack(Material.FLINT_AND_STEEL);
		setMaxEnchantment(mBoots, Enchantment.DURABILITY);
		return mBoots;
	}

	/**
	 * Create a new {@link Material#Shears Shears}
	 * {@link ItemStack item} and enchant it.
	 * 
	 * @return A new {@link ItemStack Shears}
	 */
	public static ItemStack getMegaShears() {
		ItemStack mBoots = new ItemStack(Material.SHEARS);
		setMaxEnchantment(mBoots, Enchantment.DIG_SPEED);
		setMaxEnchantment(mBoots, Enchantment.SILK_TOUCH);
		setMaxEnchantment(mBoots, Enchantment.DURABILITY);
		return mBoots;
	}
}
