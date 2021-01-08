package net.darktree.fading;

import net.darktree.fading.block.ExtinguishedLanternBlock;
import net.darktree.fading.block.ExtinguishedTorchBlock;
import net.darktree.fading.block.ExtinguishedWallTorchBlock;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.WallStandingBlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Fading implements ModInitializer, ClientModInitializer {

    public static Settings SETTINGS = new Settings();

    public static final Block EXTINGUISHED_WALL_TORCH = new ExtinguishedWallTorchBlock( AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().breakInstantly().sounds(BlockSoundGroup.WOOD) );
    public static final Block EXTINGUISHED_TORCH = new ExtinguishedTorchBlock( AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().breakInstantly().sounds(BlockSoundGroup.WOOD) );
    public static final Block EXTINGUISHED_LANTERN = new ExtinguishedLanternBlock( AbstractBlock.Settings.of(Material.METAL).requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).nonOpaque() );
    public static final Block EXTINGUISHED_WALL_SOUL_TORCH = new ExtinguishedWallTorchBlock( AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().breakInstantly().sounds(BlockSoundGroup.WOOD) );
    public static final Block EXTINGUISHED_SOUL_TORCH = new ExtinguishedTorchBlock( AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().breakInstantly().sounds(BlockSoundGroup.WOOD) );
    public static final Block EXTINGUISHED_SOUL_LANTERN = new ExtinguishedLanternBlock( AbstractBlock.Settings.of(Material.METAL).requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).nonOpaque() );

    @Override
    public void onInitialize() {
        Registry.register( Registry.BLOCK, new Identifier("extinguished_wall_torch"), EXTINGUISHED_WALL_TORCH);
        Registry.register( Registry.BLOCK, new Identifier("extinguished_torch"), EXTINGUISHED_TORCH);
        Registry.register( Registry.ITEM, new Identifier("extinguished_torch"), new WallStandingBlockItem(EXTINGUISHED_TORCH, EXTINGUISHED_WALL_TORCH, new Item.Settings().group(ItemGroup.DECORATIONS) ));
        Registry.register( Registry.BLOCK, new Identifier("extinguished_lantern"), EXTINGUISHED_LANTERN);
        Registry.register( Registry.ITEM, new Identifier("extinguished_lantern"), new BlockItem(EXTINGUISHED_LANTERN, new Item.Settings().group(ItemGroup.DECORATIONS) ));
        Registry.register( Registry.BLOCK, new Identifier("extinguished_wall_soul_torch"), EXTINGUISHED_WALL_SOUL_TORCH);
        Registry.register( Registry.BLOCK, new Identifier("extinguished_soul_torch"), EXTINGUISHED_SOUL_TORCH);
        Registry.register( Registry.ITEM, new Identifier("extinguished_soul_torch"), new WallStandingBlockItem(EXTINGUISHED_SOUL_TORCH, EXTINGUISHED_WALL_SOUL_TORCH, new Item.Settings().group(ItemGroup.DECORATIONS) ));
        Registry.register( Registry.BLOCK, new Identifier("extinguished_soul_lantern"), EXTINGUISHED_SOUL_LANTERN);
        Registry.register( Registry.ITEM, new Identifier("extinguished_soul_lantern"), new BlockItem(EXTINGUISHED_SOUL_LANTERN, new Item.Settings().group(ItemGroup.DECORATIONS) ));
    }

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                EXTINGUISHED_WALL_TORCH,
                EXTINGUISHED_TORCH,
                EXTINGUISHED_LANTERN,
                EXTINGUISHED_WALL_SOUL_TORCH,
                EXTINGUISHED_SOUL_TORCH,
                EXTINGUISHED_SOUL_LANTERN
        );
    }

}
