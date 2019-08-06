package io.github.MrDiamond123.diamondsmod;

import io.github.MrDiamond123.diamondsmod.lists.BlockList;
import io.github.MrDiamond123.diamondsmod.lists.ItemList;
import io.github.MrDiamond123.diamondsmod.lists.ToolMaterialList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("diamondsmod")
public class DiamondsMod {
    public static DiamondsMod instance;
    public static final String modid = "diamondsmod";
    private static final Logger logger = LogManager.getLogger(modid);

    public static final ItemGroup diamond = new DiamondItemGroup();

    public DiamondsMod() {
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
    }
    private void setup(final FMLCommonSetupEvent event) {
        logger.info("Setup method registered");
    }
    private void clientRegistries(final FMLClientSetupEvent event) {
        logger.info("Client registries was registered");
    }
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(
                    ItemList.crystaline_shard = new Item(new Item.Properties().group(diamond)).setRegistryName(new ResourceLocation(modid, "crystaline_shard")),

                    ItemList.crystaline_crystals = new Item(new Item.Properties().group(diamond)).setRegistryName(new ResourceLocation(modid, "crystaline_crystals")),

                    ItemList.crystaline_block = new BlockItem(BlockList.crystaline_block, new Item.Properties().group(diamond)).setRegistryName(BlockList.crystaline_block.getRegistryName()),

                    ItemList.crystaline_ore = new BlockItem(BlockList.crystaline_ore, new Item.Properties().group(diamond)).setRegistryName(BlockList.crystaline_ore.getRegistryName()),

                    ItemList.crystaline_axe = new AxeItem(ToolMaterialList.crystaline, 4.0f, -3.2f, new Item.Properties().group(diamond)).setRegistryName(modid, "crystaline_axe"),

                    ItemList.crystaline_hoe = new HoeItem(ToolMaterialList.crystaline, 1.0f, new Item.Properties().group(diamond)).setRegistryName(modid, "crystaline_hoe"),

                    ItemList.crystaline_pickaxe = new PickaxeItem(ToolMaterialList.crystaline, 1, -2.8f, new Item.Properties().group(diamond)).setRegistryName(modid, "crystaline_pickaxe"),

                    ItemList.crystaline_shovel = new ShovelItem(ToolMaterialList.crystaline, 1.5f, -2.4f, new Item.Properties().group(diamond)).setRegistryName(modid, "crystaline_shovel"),

                    ItemList.crystaline_sword = new SwordItem(ToolMaterialList.crystaline, 3, -2.4f, new Item.Properties().group(diamond)).setRegistryName(modid, "crystaline_sword")
            );
            logger.info("Items registered");
        }
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll(
                    BlockList.crystaline_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(3).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)).setRegistryName(modid, "crystaline_block"),
                    BlockList.crystaline_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(3).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)).setRegistryName(modid, "crystaline_ore")
            );
            logger.info("Blocks registered");
        }
    }
}
