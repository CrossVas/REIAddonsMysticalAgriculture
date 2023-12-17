package dev.crossvas.mods.maxrei.displays;

import dev.crossvas.mods.maxrei.MAREIPlugin;
import dev.crossvas.mods.maxrei.recipes.AwakeningRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AwakeningDisplay extends BasicDisplay {

    private AwakeningRecipe RECIPE;

    public AwakeningDisplay(AwakeningRecipe recipe) {
        this(Arrays.asList(
                EntryIngredients.ofItemStacks(recipe.getInputs().get(0)),
                EntryIngredients.ofItemStacks(recipe.getInputs().get(1)),
                EntryIngredients.ofItemStacks(recipe.getInputs().get(2)),
                EntryIngredients.ofItemStacks(recipe.getInputs().get(3)),
                EntryIngredients.ofItemStacks(recipe.getInputs().get(4)),
                EntryIngredients.ofItemStacks(recipe.getInputs().get(5)),
                EntryIngredients.ofItemStacks(recipe.getInputs().get(6)),
                EntryIngredients.ofItemStacks(recipe.getInputs().get(7)),
                EntryIngredients.ofItemStacks(recipe.getInputs().get(8))),
                Collections.singletonList(EntryIngredients.of(recipe.getOutput())));
        this.RECIPE = recipe;
    }

    public AwakeningDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    public AwakeningRecipe getRecipe() {
        return this.RECIPE;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return MAREIPlugin.AWAKENING_ID;
    }
}
