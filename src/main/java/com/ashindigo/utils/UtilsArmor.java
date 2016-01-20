package com.ashindigo.utils;

import java.util.ArrayList;

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
// TODO Add insta-create without the number stuff.
public class UtilsArmor extends ItemArmor {
	
	static int runtime = 0;
	public static int multiplier = 1;
	public static ArrayList armorlist = new ArrayList();
	static String MODID;
	public static String textureName;
	static Item armor;
	static Item Material;
	
	/**
	 * Default constructor used for declaring a default variable
	 * @param armormaterial An armor material doesnt matter what it is.
	 * @param int1 Dunno
	 * @param int2 Dunno
	 */
	public UtilsArmor(ArmorMaterial armormaterial, int int1, int int2) {
		super(armormaterial, int1, int2);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Auto creates an entire armor set.
	 * @param unlocalizedName The name of the armor
	 * @param material The armor material for the set
	 * @param modid The modid of your mod
	 * @param mat The item used for crafting the armor
	 */
	public static void createArmorSet(String unlocalizedName, ArmorMaterial material, String modid, Item mat) {
		UtilsArmor dummyhelmet = new UtilsArmor(unlocalizedName + "helmet", material, 0, modid, mat);
		UtilsArmor dummychestplate = new UtilsArmor(unlocalizedName + "chestplate", material, 1, modid, mat);
		UtilsArmor dummyleggings = new UtilsArmor(unlocalizedName + "leggings", material, 2, modid, mat);
		UtilsArmor dummyboots = new UtilsArmor(unlocalizedName + "boots", material, 3, modid, mat);
	}
	
	/**
	 * For auto recipe creation please add all 4 pieces of armor in order: Helmet - Chestplate - Leggings - Boots.
	 * @param unlocalizedName The name of the armor
	 * @param material The armor material for the set
	 * @param type The type of armor 
	 * @param modid The modid of your mod
	 * @param mat The item used for crafting the armor
	 */
	public UtilsArmor(String unlocalizedName, ArmorMaterial material, int type, String modid, Item mat) {
	    super(material, 0, type);
	    GameRegistry.registerItem(this, unlocalizedName);
	    textureName = unlocalizedName;
	    this.setUnlocalizedName(modid + "_" + unlocalizedName);
	    setCreativeTab(CreativeTabs.tabCombat);
	    canRepair = true;
	    armorlist.add(this);
	    Material = mat;
	    armor = this;
	    MODID = modid;
	}
	
	//Might be buggy TODO
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	        return Material == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}

	public static void registerRecipes(){
		try {
		int armorruntime = 0;
		while(armorruntime < armorlist.size() / 4){
			
		GameRegistry.addRecipe(new ItemStack((Item) armorlist.get(0 * multiplier), 1), new Object[]{
		        "AAA",
		        "A A",
		        "   ",
		        'A', Material
		    });
		GameRegistry.addRecipe(new ItemStack((Item) armorlist.get(1 * multiplier), 1), new Object[]{
	        	"A A",
	        	"AAA",
	        	"AAA",
	        	'A', Material
	    	});
	    	GameRegistry.addRecipe(new ItemStack((Item) armorlist.get(2 * multiplier), 1), new Object[]{
	        	"AAA",
	        	"A A",
	        	"A A",
	        	'A', Material
	    	});
	    	GameRegistry.addRecipe(new ItemStack((Item) armorlist.get(3 * multiplier), 1), new Object[]{
		        "   ",
		        "A A",
		        "A A",
		        'A', Material
		    });
	    	multiplier++;
	    	armorruntime++;
	}
		}
		catch(IndexOutOfBoundsException e){
			
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
}
