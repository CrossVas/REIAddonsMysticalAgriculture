package dev.crossvas.mods.maxrei.displays;

import com.blakebr0.mysticalagriculture.compat.jei.CruxRecipe;
import dev.crossvas.mods.maxrei.MAREIPlugin;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;

import java.util.Collections;
import java.util.List;

public class CruxDisplay extends BasicDisplay {

    private CruxRecipe RECIPE;

    public CruxDisplay(CruxRecipe recipe) {
        this(EntryIngredients.ofIngredients(recipe.getIngredients()),
                Collections.singletonList(EntryIngredients.of(recipe.essence)));
        this.RECIPE = recipe;
    }

    public CruxDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    public CruxRecipe getRecipe() {
        return this.RECIPE;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return MAREIPlugin.CRUX_ID;
    }
}
