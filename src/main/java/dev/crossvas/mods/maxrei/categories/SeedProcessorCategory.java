package dev.crossvas.mods.maxrei.categories;

import com.blakebr0.mysticalagriculture.init.ModBlocks;
import dev.crossvas.mods.maxrei.MAREIPlugin;
import dev.crossvas.mods.maxrei.displays.SeedProcessorDisplay;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.network.chat.Component;

import java.util.List;

public class SeedProcessorCategory implements DisplayCategory<SeedProcessorDisplay> {

    public static final SeedProcessorCategory INSTANCE = new SeedProcessorCategory();

    @Override
    public CategoryIdentifier<? extends SeedProcessorDisplay> getCategoryIdentifier() {
        return MAREIPlugin.REPROCESSOR_ID;
    }

    @Override
    public Component getTitle() {
        return ModBlocks.BASIC_REPROCESSOR.get().getName();
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.BASIC_REPROCESSOR.get());
    }

    @Override
    public List<Widget> setupDisplay(SeedProcessorDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ObjectArrayList<>();
        int offset = 5;
        Point inputPoint = new Point(bounds.getMinX() + offset + 8, bounds.getCenterY() - 18 / 2 + 1);
        Point progressPoint = new Point(bounds.getCenterX() - 18 / 2 - offset, bounds.getCenterY() - 18 / 2 + 1);
        Point outputPoint = new Point(bounds.getMaxX() - 3 - 18 - 8, bounds.getCenterY() - 18 / 2 + 1);
        MAREIPlugin.createRecipeBase(widgets, bounds);
        MAREIPlugin.addLargeOutputSlot(widgets, outputPoint, EntryIngredients.of(display.getRecipe().getResultItem()));
        widgets.add(Widgets.createArrow(progressPoint).animationDurationTicks(100));
        MAREIPlugin.addInputSlot(widgets, inputPoint, EntryIngredients.ofIngredient(display.getRecipe().getIngredients().get(0)));
        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 48;
    }

    @Override
    public int getDisplayWidth(SeedProcessorDisplay display) {
        return 96;
    }
}
