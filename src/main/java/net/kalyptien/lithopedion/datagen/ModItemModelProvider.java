package net.kalyptien.lithopedion.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.kalyptien.lithopedion.item.ModItems;
import net.kalyptien.lithopedion.LithopedionMod;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider  extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LithopedionMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.JADE);

        simpleItem(ModItems.GOBLIN_HEART);
        simpleItem(ModItems.ONI_HEART);
        simpleItem(ModItems.MERMAID_HEART);
        simpleItem(ModItems.TENGU_HEART);
        simpleItem(ModItems.NAGA_HEART);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LithopedionMod.MODID,"item/" + item.getId().getPath()));
    }
}
