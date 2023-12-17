package dev.crossvas.mods.maxrei.categories;

import com.blakebr0.mysticalagriculture.init.ModBlocks;
import dev.crossvas.mods.maxrei.MAREIPlugin;
import dev.crossvas.mods.maxrei.displays.InfusionDisplay;
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

public class InfusionCategory implements DisplayCategory<InfusionDisplay> {

    public static final InfusionCategory INSTANCE = new InfusionCategory();

    @Override
    public CategoryIdentifier<? extends InfusionDisplay> getCategoryIdentifier() {
        return MAREIPlugin.INFUSION_ID;
    }

    @Override
    public Component getTitle() {
        return ModBlocks.INFUSION_ALTAR.get().getName();
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.INFUSION_ALTAR.get());
    }

    @Override
    public List<Widget> setupDisplay(InfusionDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ObjectArrayList<>();
        MAREIPlugin.createRecipeBase(widgets, bounds);
        int offset = 5;
        int x = bounds.getMinX();
        int y = bounds.getMinY();
        widgets.add(Widgets.createArrow(new Point(x + 92, y + 37)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 33 + offset, y + 33 + offset), EntryIngredients.ofIngredient(display.getRecipe().getIngredients().get(0)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 7 + offset, y + 7 + offset), EntryIngredients.ofIngredient(display.getRecipe().getIngredients().get(1)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 33 + offset, y + 1 + offset), EntryIngredients.ofIngredient(display.getRecipe().getIngredients().get(2)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 59 + offset, y + 7 + offset), EntryIngredients.ofIngredient(display.getRecipe().getIngredients().get(3)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 65 + offset, y + 33 + offset), EntryIngredients.ofIngredient(display.getRecipe().getIngredients().get(4)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 59 + offset, y + 59 + offset), EntryIngredients.ofIngredient(display.getRecipe().getIngredients().get(5)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 33 + offset, y + 64 + offset), EntryIngredients.ofIngredient(display.getRecipe().getIngredients().get(6)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 7 + offset, y + 59 + offset), EntryIngredients.ofIngredient(display.getRecipe().getIngredients().get(7)));
        MAREIPlugin.addInputSlot(widgets, new Point(x + 1 + offset, y + 33 + offset), EntryIngredients.ofIngredient(display.getRecipe().getIngredients().get(8)));
        MAREIPlugin.addLargeOutputSlot(widgets, new Point(x + 123 + offset, y + 33 + offset), EntryIngredients.of(display.getRecipe().getResultItem()));
        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 18 * 5 + 1;
    }

    @Override
    public int getDisplayWidth(InfusionDisplay display) {
        return 154;
    }
}
