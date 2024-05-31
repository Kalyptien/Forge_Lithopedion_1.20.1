package net.kalyptien.lithopedion.datagen;

import net.kalyptien.lithopedion.LithopedionMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.kalyptien.lithopedion.block.ModBlocks;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LithopedionMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.JADE_BLOCK.get(),
                        ModBlocks.DEEPSLATE_JADE_ORE.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.JADE_BLOCK.get(),
                        ModBlocks.DEEPSLATE_JADE_ORE.get());

    }
}
