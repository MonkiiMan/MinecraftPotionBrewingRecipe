package net.monkiiman.shounenmod.util;


import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;

public class BetterBrewingRecipe2 implements IBrewingRecipe {
    private final Potion input;
    private final Potion ingredient;
    private final Potion output;

    public BetterBrewingRecipe2(Potion input, Potion ingredient, Potion output) {
        this.input = input;
        this.ingredient = ingredient;
        this.output = output;
    }


    @Override
    public boolean isInput(ItemStack input) {
        return PotionUtils.getPotion(input) == this.input;
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        return PotionUtils.getPotion(ingredient) == this.ingredient;
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        if(!this.isInput(input) || !this.isIngredient(ingredient)) {
            return ItemStack.EMPTY;
        }


        ItemStack itemStack = new ItemStack(input.getItem());
        itemStack.setTag(new CompoundTag());
        PotionUtils.setPotion(itemStack, this.output);
        return itemStack;
    }
}
