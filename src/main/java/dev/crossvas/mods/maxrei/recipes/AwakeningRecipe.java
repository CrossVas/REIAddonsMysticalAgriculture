package dev.crossvas.mods.maxrei.recipes;

import com.blakebr0.cucumber.helper.StackHelper;
import com.blakebr0.mysticalagriculture.api.crafting.IAwakeningRecipe;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class AwakeningRecipe {

    private final List<List<ItemStack>> INPUTS;
    private final ItemStack OUTPUT;

    public AwakeningRecipe(IAwakeningRecipe recipe) {
        this.INPUTS = toItemStackLists(recipe);
        this.OUTPUT = recipe.getResultItem();
    }

    public List<List<ItemStack>> getInputs() {
        return this.INPUTS;
    }

    public ItemStack getOutput() {
        return this.OUTPUT;
    }

    private static List<List<ItemStack>> toItemStackLists(IAwakeningRecipe recipe) {
        var requirements = recipe.getEssenceRequirements();
        var ingredients = recipe.getIngredients();

        return List.of(
                List.of(ingredients.get(0).getItems()),
                List.of(StackHelper.withSize(ingredients.get(1).getItems()[0], requirements.air(), false)),
                List.of(ingredients.get(2).getItems()),
                List.of(StackHelper.withSize(ingredients.get(3).getItems()[0], requirements.earth(), false)),
                List.of(ingredients.get(4).getItems()),
                List.of(StackHelper.withSize(ingredients.get(5).getItems()[0], requirements.water(), false)),
                List.of(ingredients.get(6).getItems()),
                List.of(StackHelper.withSize(ingredients.get(7).getItems()[0], requirements.fire(), false)),
                List.of(ingredients.get(8).getItems())
        );
    }
}
