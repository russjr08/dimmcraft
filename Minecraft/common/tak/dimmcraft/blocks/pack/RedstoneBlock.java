package tak.dimmcraft.blocks.pack;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraftforge.common.MinecraftForge;
import tak.dimmcraft.CommonProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RedstoneBlock extends Block {
	
	/* Loads the block against BlockLoader */
	public static void loadBlock (FMLInitializationEvent event) {
		
		final Block redstoneBlock = new RedstoneBlock(502, 2, Material.ground)
		.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
		.setBlockName("redstoneBlock").setCreativeTab(CreativeTabs.tabDecorations);
		
		LanguageRegistry.addName(redstoneBlock, "Redstone Block");
		MinecraftForge.setBlockHarvestLevel(redstoneBlock, "shovel", 0);
		GameRegistry.registerBlock(redstoneBlock);
		
		crafting(redstoneBlock);
	}
	
	/* Handles crafting up to this tier */
	public static void crafting (Block redstoneBlock) {
		
		ItemStack redstoneStack = new ItemStack(Item.redstone);
		ItemStack redstoneBlockStack = new ItemStack(redstoneBlock);
		
		GameRegistry.addShapelessRecipe(redstoneBlockStack,
				redstoneStack, redstoneStack, redstoneStack,
				redstoneStack);
		
		GameRegistry.addShapelessRecipe(new ItemStack(Item.redstone, 4), redstoneBlockStack);
	}
	
	/* Constructs the block against Block */
	public RedstoneBlock (int id, int texture, Material material) {
		super(id, texture, material);
	}
	
	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCKS_PNG;
	}
}
