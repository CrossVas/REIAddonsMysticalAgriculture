package dev.crossvas.mods.maxrei.displays;

import com.blakebr0.mysticalagriculture.api.crafting.IReprocessorRecipe;
import dev.crossvas.mods.maxrei.MAREIPlugin;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;

import java.util.Collections;
import java.util.List;

public class SeedProcessorDisplay extends BasicDisplay {

    private IReprocessorRecipe RECIPE;

    public SeedProcessorDisplay(IReprocessorRecipe recipe) {
        this(EntryIngredients.ofIngredients(recipe.getIngredients()),
                Collections.singletonList(EntryIngredients.of(recipe.getResultItem())));
        this.RECIPE = recipe;
    }

    public SeedProcessorDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    public IReprocessorRecipe getRecipe() {
        return this.RECIPE;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return MAREIPlugin.REPROCESSOR_ID;
    }
}
