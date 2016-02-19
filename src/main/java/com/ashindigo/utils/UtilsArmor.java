package com.ashindigo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Class used for making armor with the added functionality of automatically registering the armor and adding recipes.
 * @author 19jasonides_a
 */
public class UtilsArmor extends ItemArmor implements IItemMethods {
	
	static int runtime = 0;
	public static int multiplier = 1;
	public static ArrayList armorlist = new ArrayList();
	static String MODID;
	public static String textureName;
	static Item armor;
	static Item Material;
	static Map<Item, Item> helmmap = new HashMap<Item, Item>();
	static Map<Item, Item> chestmap = new HashMap<Item, Item>();
	static Map<Item, Item> legmap = new HashMap<Item, Item>();
	static Map<Item, Item> bootmap = new HashMap<Item, Item>();
	public static ArrayList armorNameList = new ArrayList();
	private static ArrayList materialList = new ArrayList();
	private static int multiplier4 = 0;
	
	/**
	 * Default constructor used for declaring a default variable
	 * @param armormaterial An armor material doesnt matter what it is.
	 * @param renderIndex Set to whatever you want
	 * @param armorType Set to whatever you want
	 */
	public UtilsArmor(ArmorMaterial armormaterial, int renderIndex, int armorType) {
		super(armormaterial, renderIndex, armorType);
	}
	
	/**
	 * Auto creates an entire armor set.
	 * @param unlocalizedName The name of the armor
	 * @param material The armor material for the set
	 * @param modid The modid of your mod
	 * @param mat The item used for crafting the armor
	 */
	//TODO Only lets creation of one recipe set
	// Possibly add another recipe set for this using an ArrayList
	// Use the ArmorInit class for more data in a map
	public static void createArmorSet(String unlocalizedName, ArmorMaterial material, String modid, Item mat) {
		UtilsArmor dummyhelmet = new UtilsArmor(unlocalizedName + "helmet", material, 0, modid, mat, "");
		UtilsArmor dummychestplate = new UtilsArmor(unlocalizedName + "chestplate", material, 1, modid, mat, "");
		UtilsArmor dummyleggings = new UtilsArmor(unlocalizedName + "leggings", material, 2, modid, mat, "");
		UtilsArmor dummyboots = new UtilsArmor(unlocalizedName + "boots", material, 3, modid, mat, "");
	}
	
	/**
	 * For auto recipe creation please add all 4 pieces of armor in order: Helmet - Chestplate - Leggings - Boots.
	 * @param unlocalizedName The name of the armor
	 * @param material The armor material for the set
	 * @param type The type of armor 
	 * @param modid The modid of your mod
	 * @param mat The item used for crafting the armor
	 */
	public UtilsArmor(String unlocalizedName, ArmorMaterial material, int type, String modid, Item mat, String translatedName) {
	    super(material, 0, type);
	    GameRegistry.registerItem(this, unlocalizedName);
	    textureName = unlocalizedName;
	    this.setUnlocalizedName(modid + "_" + unlocalizedName);
	    setCreativeTab(CreativeTabs.tabCombat);
	    canRepair = true;
	    armorNameList.add(unlocalizedName);
	    armorlist.add(this);
	    UtilsItemBlockLoader.itemreg.add(this);
	    UtilsItem.modItems.put(modid, this);
	    UtilsItem.itemNameList.put(this, unlocalizedName);
	    UtilsItem.translatedNameList.put(this, translatedName);
	    materialList.add(mat);
	    armor = this;
	    MODID = modid;
	    // Switch Block for inserting correct items in maps
	    switch (type) {
	    case 0: helmmap.put(Material, this); break;
	    case 1: chestmap.put(Material, this); break;
	    case 2: legmap.put(Material, this); break;
	    case 3: bootmap.put(Material, this); break;
	    }
	}
	
	// TODO? Simplify
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		if (par1ItemStack.getItem() == helmmap.get(par2ItemStack.getItem())) {
	        return par2ItemStack.getItem() == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
		if (par1ItemStack.getItem() == chestmap.get(par2ItemStack.getItem())) {
	        return par2ItemStack.getItem() == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
		if (par1ItemStack.getItem() == legmap.get(par2ItemStack.getItem())) {
	        return par2ItemStack.getItem() == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
		if (par1ItemStack.getItem() == bootmap.get(par2ItemStack.getItem())) {
	        return par2ItemStack.getItem() == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
		return false;
	}

	// TODO Modify so a full set isnt forced created
	public static void registerRecipes(){
		try {
		int armorruntime = 0;
		while(armorruntime < armorlist.size() / 4) {
		GameRegistry.addRecipe(new ItemStack((Item) armorlist.get(0 + multiplier4), 1), new Object[]{
		        "AAA",
		        "A A",
		        "   ",
		        'A', (Item) materialList.get(0 + multiplier4)
		    });
		GameRegistry.addRecipe(new ItemStack((Item) armorlist.get(1 + multiplier4), 1), new Object[]{
	        	"A A",
	        	"AAA",
	        	"AAA",
	        	'A', (Item) materialList.get(0 + multiplier4)
	    	});
	    	GameRegistry.addRecipe(new ItemStack((Item) armorlist.get(2 + multiplier4), 1), new Object[]{
	        	"AAA",
	        	"A A",
	        	"A A",
	        	'A', (Item) materialList.get(0 + multiplier4)
	    	});
	    	GameRegistry.addRecipe(new ItemStack((Item) armorlist.get(3 + multiplier4), 1), new Object[]{
		        "   ",
		        "A A",
		        "A A",
		        'A', (Item) materialList.get(0 + multiplier4)
		    });
	    	armorruntime++;
	    	multiplier++; 
	    	multiplier4 = multiplier4 + 4;
	}
		}
		catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}
	}
	/**
	 * Armor texture method
	 */
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
	    return MODID + ":armor/" + textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}

	@Override
	public String getName() {
		return textureName;
	}
}
