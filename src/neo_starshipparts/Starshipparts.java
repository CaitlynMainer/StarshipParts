package neo_starshipparts;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = Starshipparts.modid, name = "Neo's Starship Parts", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Starshipparts {
	public static final String modid = "neo_starshipparts";
	
	public static Block StarshipHullBlock;
	public static Block StarshipTMPWarpCore;
	public static Block StarshipHazardMarker;
	
	public static int WarpCoreTMPID;
	public static int ShipHull1ID;
	public static int HazardMarkerID;
	@EventHandler 
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		ShipHull1ID = config.getBlock("ShipHull1ID", 610).getInt();
		WarpCoreTMPID = config.getBlock("WarpCoreTMPID", 611).getInt();
		HazardMarkerID = config.getBlock("HazardMarkerID", 612).getInt();
		
		config.save();
	}
	
	
	@EventHandler 
	public void load(FMLInitializationEvent event)
	{
		StarshipHullBlock = new BlockStarshipHullBlock(ShipHull1ID, Material.iron);
		StarshipHullBlock.setResistance(6000000.0F);
		StarshipHullBlock.setHardness(6000000.0F);
		StarshipHullBlock.setUnlocalizedName("Duranium");
		GameRegistry.registerBlock(StarshipHullBlock, "Neo_StarShipHullBlock1");
		LanguageRegistry.addName(StarshipHullBlock,  "Duranium");
		
		
		
		StarshipTMPWarpCore = new BlockStarshipTMPWarpCoreBlock(WarpCoreTMPID, Material.iron);
		StarshipTMPWarpCore.setLightValue(1.0f);
		StarshipTMPWarpCore.setResistance(6000000.0F);
		StarshipTMPWarpCore.setHardness(6000000.0F);
		StarshipTMPWarpCore.setUnlocalizedName("Warp Core (TMP)");
		GameRegistry.registerBlock(StarshipTMPWarpCore, "Neo_StarShipTMPWarpCore1");
		LanguageRegistry.addName(StarshipTMPWarpCore ,  "Warp Core (TMP)");
		
		
		
		StarshipHazardMarker = new BlockStarshipHullBlock(HazardMarkerID, Material.iron);
		StarshipHazardMarker.setUnlocalizedName("Hazard Marker");
		GameRegistry.registerBlock(StarshipHazardMarker, "Neo_StarShipHazardMarker");
		LanguageRegistry.addName(StarshipHazardMarker, "Hazard Marker");
				
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabCustom", "en_US", "Starship Parts");
	}
	
	
    public static CreativeTabs tabCustom = new CreativeTabs("tabCustom") {
        public ItemStack getIconItemStack() {
                return new ItemStack(Item.eyeOfEnder, 1, 0);
        }
    };
}
