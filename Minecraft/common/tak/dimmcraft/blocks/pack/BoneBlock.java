package tak.dimmcraft.blocks.pack;

import tak.dimmcraft.CommonProxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraftforge.common.MinecraftForge;

public class BoneBlock extends Block {
	
	/* Loads the block against BlockLoader */
	public static void loadBlock (FMLInitializationEvent event) {
		
		final Block boneBlock = new BoneBlock(501, 1, Material.ground)
		.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
		.setBlockName("boneBlock").setCreativeTab(CreativeTabs.tabDecorations);
		
		LanguageRegistry.addName(boneBlock, "Bone Block");
		MinecraftForge.setBlockHarvestLevel(boneBlock, "shovel", 0);
		GameRegistry.registerBlock(boneBlock);
		
		crafting(boneBlock);
	}
	
	/* Handles crafting up to this tier */
	public static void crafting (Block boneBlock) {
		
		ItemStack boneStack = new ItemStack(Item.bone);
		ItemStack boneBlockStack = new ItemStack(boneBlock);
		
		GameRegistry.addShapelessRecipe(boneBlockStack,
				boneStack, boneStack, boneStack,
				boneStack);
		
		GameRegistry.addShapelessRecipe(new ItemStack(Item.bone, 4), boneBlockStack);
	}
	
	/* Constructs the block against Block */
	public BoneBlock (int id, int texture, Material material) {
		super(id, texture, material);
	}
	
	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCKS_PNG;
	}
}
