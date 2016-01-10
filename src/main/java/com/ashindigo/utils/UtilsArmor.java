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
public class UtilsArmor extends ItemArmor {
	
	static ArrayList listitem = new ArrayList();
	static int runtime = 0;
	public static int multiplier = 1;
	public static ArrayList armorlist = new ArrayList();
	static String MODID;
	public static String textureName;
	static Item armor;
	public static ArrayList itemlists = new ArrayList();
	static Item Material;
	
	/**
	 * Default constructor used for declaring a default varible
	 * @param armormaterial An armor material doesnt matter what it is.
	 * @param int1 Dunno
	 * @param int2 Dunno
	 */
	public UtilsArmor(ArmorMaterial armormaterial, int int1, int int2) {
		super(armormaterial, int1, int2);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param unlocalizedName The name of the armor
	 * @param material The armor material for the set
	 * @param type The type of armor 
	 * @param modid The modid of your mod
	 * @param mat The item used for crafting the armor
	 */
	public UtilsArmor(String unlocalizedName, ArmorMaterial material, int type, String modid, Item mat) {
	    super(material, 0, type);
	    textureName = unlocalizedName;
	    this.setUnlocalizedName(modid + "_" + unlocalizedName);
	    setCreativeTab(CreativeTabs.tabCombat);
	    listitem.add(unlocalizedName);
	    Material = mat;
	    armor = this;
	    MODID = modid;
	    itemlists.add(this);
	}
	
	public static void registerRecipes(){
		try{
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
	    	 * Method that starts the automatic registration of armor.
	    	 * Call in init method
	    	 * See:{@link UtilsMain.init}
	    	 * Version 1.1
	    	 */
	    	public static void register() {
	    		try{
	    		while(runtime < listitem.size()){
	    		GameRegistry.registerItem((Item) itemlists.get(runtime), ("indigoapiarmor" + MODID + runtime));
	    		runtime++;
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
