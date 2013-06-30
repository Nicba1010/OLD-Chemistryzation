package nicba1010.chemistryzation.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import nicba1010.chemistryzation.common.blocks.*;
import nicba1010.chemistryzation.common.guis.*;
import nicba1010.chemistryzation.common.items.*;
import nicba1010.chemistryzation.common.tileEntitys.*;
import nicba1010.chemistryzation.common.worldGeneration.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Chemistryzation.modid, name = "chemistryzation", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {
		"Chemistryzation", "Chemistryzation1", "Chemistryzation2" }, packetHandler = PacketHandler.class)
public class Chemistryzation {
	public static final String modid = "chemistryzation";
	public static Block NaClBlock, BunsenBurner, CuFeS2;
	public static Item NaClItem, NaClInBucketSolid, NaClInBucketMelted,
			TestTube, NaClInTestTubeSolid;
	public static WorldGeneration WorldGen = new WorldGeneration();

	public static CreativeTabs tabChemistryzation = new CreativeTabs(
			"tabChemistryzation") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Chemistryzation.TestTube);
		}
	};

	@Instance(modid)
	public static Chemistryzation instance;

	@Init
	public void load(FMLInitializationEvent event) {
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup.tabChemistryzation", "en_US", "Chemistryzation");

		BunsenBurner = new BlockBunsenBurner(501, Material.rock)
				.setUnlocalizedName("BunsenBurner").setCreativeTab(
						tabChemistryzation);
		GameRegistry.registerBlock(BunsenBurner, modid + "BunsenBurner");
		LanguageRegistry.addName(BunsenBurner, "BunsenBurner");
		GameRegistry.registerTileEntity(TileEntityBunsenBurner.class,
				"ContainerBunsenBurner");

		GameRegistry.registerWorldGenerator(WorldGen);

		NaClBlock = new BlockNaClBlock(500, Material.rock).setUnlocalizedName(
				"NaClBlock").setCreativeTab(tabChemistryzation);
		GameRegistry.registerBlock(NaClBlock, modid + "NaClBlock");
		LanguageRegistry.addName(NaClBlock, "Salt");

		CuFeS2 = new BlockCuFeS2(502, Material.rock).setUnlocalizedName(
				"CuFeS2").setCreativeTab(tabChemistryzation);
		GameRegistry.registerBlock(CuFeS2, modid + "CuFeS2");
		LanguageRegistry.addName(CuFeS2, "CuFeS2");

		NaClItem = new ItemNaClItem(5000).setUnlocalizedName("NaClItem")
				.setCreativeTab(tabChemistryzation);
		LanguageRegistry.addName(NaClItem, "NaCl");

		NaClInBucketSolid = new NaClInBucketSolid(5001).setUnlocalizedName(
				"NaClInBucketSolid").setCreativeTab(tabChemistryzation);
		LanguageRegistry.addName(NaClInBucketSolid, "NaCl");

		NaClInBucketMelted = new NaClInBucketMelted(5002).setUnlocalizedName(
				"NaClInBucketMelted").setCreativeTab(tabChemistryzation);
		LanguageRegistry.addName(NaClInBucketMelted, "NaCl");

		TestTube = new TestTube(5003).setUnlocalizedName("TestTube")
				.setCreativeTab(tabChemistryzation);
		LanguageRegistry.addName(TestTube, "Test Tube");

		NaClInTestTubeSolid = new NaClInTestTubeSolid(5004).setUnlocalizedName(
				"NaClInTestTubeSolid").setCreativeTab(tabChemistryzation);
		LanguageRegistry.addName(NaClInTestTubeSolid, "NaCl");

		GameRegistry.addRecipe(new ItemStack(Chemistryzation.TestTube, 8),
				"XYX", "X X", " X ", Character.valueOf('X'), new ItemStack(
						Block.glass), Character.valueOf('Y'), Item.slimeBall);

		ItemStack NaClItemStack = new ItemStack(Chemistryzation.NaClItem);
		GameRegistry.addShapelessRecipe(new ItemStack(NaClInBucketSolid),
				new Object[] { NaClItemStack, NaClItemStack, NaClItemStack,
						NaClItemStack, NaClItemStack, NaClItemStack,
						NaClItemStack, NaClItemStack,
						new ItemStack(Item.bucketEmpty) });
		GameRegistry
				.addShapelessRecipe(new ItemStack(NaClInTestTubeSolid),
						new Object[] { NaClItemStack, NaClItemStack,
								NaClItemStack, NaClItemStack,
								new ItemStack(Chemistryzation.TestTube) });
		FurnaceRecipes.smelting().addSmelting(
				Chemistryzation.NaClInBucketSolid.itemID, 0,
				new ItemStack(Chemistryzation.NaClInBucketMelted), 0.1F);
	}

	@PostInit
	@SideOnly(Side.CLIENT)
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new GuiChemistryLevel(Minecraft
				.getMinecraft()));
	}

	@ServerStarting
	public void onServerStarting(FMLServerStartingEvent event) {
		GameRegistry.registerPlayerTracker(new PlayerTracker());
	}

}
