package dev.crossvas.mods.maxrei.displays;

import com.blakebr0.mysticalagriculture.api.crafting.IInfusionRecipe;
import dev.crossvas.mods.maxrei.MAREIPlugin;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;

import java.util.Collections;
import java.util.List;

public class InfusionDisplay extends BasicDisplay {

    private IInfusionRecipe RECIPE;

    public InfusionDisplay(IInfusionRecipe recipe) {
        this(EntryIngredients.ofIngredients(recipe.getIngredients()),
                Collections.singletonList(EntryIngredients.of(recipe.getResultItem())));
        this.RECIPE = recipe;
    }

    public InfusionDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    public IInfusionRecipe getRecipe() {
        return this.RECIPE;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return MAREIPlugin.INFUSION_ID;
    }
}
