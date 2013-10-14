package neo_starshipparts;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockStarshipHazardBlock extends Block {

	public BlockStarshipHazardBlock(int id, Material par2Material) {
		super(id, par2Material);
		this.setCreativeTab(Starshipparts.tabCustom);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(Starshipparts.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}