package dev.crossvas.mods.maxrei.categories;

import com.blakebr0.mysticalagriculture.init.ModBlocks;
import dev.crossvas.mods.maxrei.MAREIPlugin;
import dev.crossvas.mods.maxrei.displays.AwakeningDisplay;
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

public class AwakeningCategory implements DisplayCategory<AwakeningDisplay> {

    public static final AwakeningCategory INSTANCE = new AwakeningCategory();

    @Override
    public CategoryIdentifier<? extends AwakeningDisplay> getCategoryIdentifier() {
        return MAREIPlugin.AWAKENING_ID;
    }

    @Override
    public Component getTitle() {
        return ModBlocks.AWAKENING_ALTAR.get().getName();
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.AWAKENING_ALTAR.get());
    }

    @Override
    public List<Widget> setupDisplay(AwakeningDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ObjectArrayList<>();
        MAREIPlugin.createRecipeBase(widgets, bounds);
        int offset = 5;
        int x = bounds.getMinX();
        int y = bounds.getMinY();
        widgets.add(Widgets.createArrow(new Point(x + 92, y + 37)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 33 + offset, y + 33 + offset), EntryIngredients.ofItemStacks(display.getRecipe().getInputs().get(0)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 7 + offset, y + 7 + offset), EntryIngredients.ofItemStacks(display.getRecipe().getInputs().get(1)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 33 + offset, y + 1 + offset), EntryIngredients.ofItemStacks(display.getRecipe().getInputs().get(2)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 59 + offset, y + 7 + offset), EntryIngredients.ofItemStacks(display.getRecipe().getInputs().get(3)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 65 + offset, y + 33 + offset), EntryIngredients.ofItemStacks(display.getRecipe().getInputs().get(4)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 59 + offset, y + 59 + offset), EntryIngredients.ofItemStacks(display.getRecipe().getInputs().get(5)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 33 + offset, y + 64 + offset), EntryIngredients.ofItemStacks(display.getRecipe().getInputs().get(6)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 7 + offset, y + 59 + offset), EntryIngredients.ofItemStacks(display.getRecipe().getInputs().get(7)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 1 + offset, y + 33 + offset), EntryIngredients.ofItemStacks(display.getRecipe().getInputs().get(8)));
        MAREIPlugin.addLargeOutputSlot(widgets, new Point(x + 123 + offset, y + 33 + offset), EntryIngredients.of(display.getRecipe().getOutput()));
        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 18 * 5 + 1;
    }

    @Override
    public int getDisplayWidth(AwakeningDisplay display) {
        return 154;
    }
}
