package net.kalyptien.lithopedion.block.entity;

import com.google.common.collect.Lists;
import net.kalyptien.lithopedion.item.ModItems;
import net.kalyptien.lithopedion.recipe.SculptureTableRecipe;
import net.kalyptien.lithopedion.screen.SculptureTableMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class SculptureTableBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(12);

    public int levels;

    private static final int OUTPUT_SLOT = 0;

    private final List<Integer> buttonStates = Lists.newArrayList();

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;

    private int Craftprogress = 0;
    private int CraftmaxProgress = 78;

    private int InfuseRprogress = 0;
    private int InfuseRmaxProgress = 78;

    private int InfuseLprogress = 0;
    private int InfuseLmaxProgress = 78;

    public SculptureTableBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.SCULPTURE_TABLE_BE.get(), pPos, pBlockState);

        this.data = new ContainerData() {

            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> SculptureTableBlockEntity.this.Craftprogress;
                    case 1 -> SculptureTableBlockEntity.this.CraftmaxProgress;
                    case 2 -> SculptureTableBlockEntity.this.InfuseRprogress;
                    case 3 -> SculptureTableBlockEntity.this.InfuseRmaxProgress;
                    case 4 -> SculptureTableBlockEntity.this.InfuseLprogress;
                    case 5 -> SculptureTableBlockEntity.this.InfuseLmaxProgress;
                    default -> 0;
                };
            }


            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> SculptureTableBlockEntity.this.Craftprogress = pValue;
                    case 1 -> SculptureTableBlockEntity.this.CraftmaxProgress = pValue;
                    case 2 -> SculptureTableBlockEntity.this.InfuseRprogress = pValue;
                    case 3 -> SculptureTableBlockEntity.this.InfuseRmaxProgress = pValue;
                    case 4 -> SculptureTableBlockEntity.this.InfuseLprogress = pValue;
                    case 5 -> SculptureTableBlockEntity.this.InfuseLmaxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 6;
            }

        };
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.lithopedion.sculpture_table");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new SculptureTableMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("sculpture_table_station.Craftprogress", Craftprogress);
        pTag.putInt("sculpture_table_station.Craftmaxprogress", CraftmaxProgress);
        pTag.putInt("sculpture_table_station.InfuseRprogress", InfuseRprogress);
        pTag.putInt("sculpture_table_station.InfuseRmaxProgress", InfuseRmaxProgress);
        pTag.putInt("sculpture_table_station.InfuseLprogress", InfuseLprogress);
        pTag.putInt("sculpture_table_station.InfuseLmaxProgress", InfuseLmaxProgress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        Craftprogress = pTag.getInt("sculpture_table_station.Craftprogress");
        CraftmaxProgress = pTag.getInt("sculpture_table_station.Craftmaxprogress");
        InfuseRprogress = pTag.getInt("sculpture_table_station.InfuseRprogress");
        InfuseRmaxProgress = pTag.getInt("sculpture_table_station.InfuseRmaxProgress");
        InfuseLprogress = pTag.getInt("sculpture_table_station.InfuseLprogress");
        InfuseLmaxProgress = pTag.getInt("sculpture_table_station.InfuseLmaxProgress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(hasRecipe()) {
            increaseCraftingProgress();
            setChanged(pLevel, pPos, pState);

            if(hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        Craftprogress = 0;
        InfuseRprogress = 0;
        InfuseLprogress = 0;
    }

    private void craftItem() {
        Optional<SculptureTableRecipe> recipe = getCurrentRecipe();
        ItemStack result = recipe.get().getResultItem(null);

        for (int i = 1; i < 12; i++){
            this.itemHandler.extractItem(i, 1, false);
        }

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private boolean hasRecipe() {
        Optional<SculptureTableRecipe> recipe = getCurrentRecipe();

        if(recipe.isEmpty()) {
            return false;
        }
        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private Optional<SculptureTableRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(SculptureTableRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean hasProgressFinished() {
        return Craftprogress >= CraftmaxProgress;
    }

    private void increaseCraftingProgress() {
        if((InfuseRprogress >= InfuseRmaxProgress) && (InfuseLprogress >= InfuseLmaxProgress)){
            Craftprogress++;
        }
        else{
            if(!(InfuseRprogress >= InfuseRmaxProgress)){
                InfuseRprogress++;
            }
            if(!(InfuseLprogress >= InfuseLmaxProgress)){
                InfuseLprogress++;
            }
        }
    }
}