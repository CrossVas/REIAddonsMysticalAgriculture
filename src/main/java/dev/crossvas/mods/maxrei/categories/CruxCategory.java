package dev.crossvas.mods.maxrei.categories;

import com.blakebr0.mysticalagriculture.init.ModItems;
import dev.crossvas.mods.maxrei.MAREIPlugin;
import dev.crossvas.mods.maxrei.displays.CruxDisplay;
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

public class CruxCategory implements DisplayCategory<CruxDisplay> {

    public static final CruxCategory INSTANCE = new CruxCategory();

    @Override
    public CategoryIdentifier<? extends CruxDisplay> getCategoryIdentifier() {
        return MAREIPlugin.CRUX_ID;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.category.mysticalagriculture.crux");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModItems.PROSPERITY_SEED_BASE.get());
    }

    @Override
    public List<Widget> setupDisplay(CruxDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ObjectArrayList<>();
        MAREIPlugin.createRecipeBase(widgets, bounds);
        int offset = 5;
        int x = bounds.getMinX();
        int y = bounds.getMinY();
        Point inputPointTop = new Point(bounds.getMinX() + offset + 8, bounds.getCenterY() - 18 / 2 + 1 - 18); // top
        Point inputPointMiddle = new Point(bounds.getMinX() + offset + 8, bounds.getCenterY() - 18 / 2 + 1); // middle
        Point inputPointBottom = new Point(bounds.getMinX() + offset + 8, bounds.getCenterY() - 18 / 2 + 1 + 18); // bottom
        Point progressPoint = new Point(bounds.getCenterX() - 18 / 2 - offset, bounds.getCenterY() - 18 / 2 + 1);
        Point outputPoint = new Point(bounds.getMaxX() - 3 - 18 - 8, bounds.getCenterY() - 18 / 2 + 1);
        widgets.add(Widgets.createArrow(progressPoint));
        MAREIPlugin.addInputSlot(widgets, inputPointTop, EntryIngredients.ofIngredient(display.getRecipe().getIngredients().get(0)));
        MAREIPlugin.addInputSlot(widgets, inputPointMiddle, EntryIngredients.ofIngredient(display.getRecipe().getIngredients().get(1)));
        MAREIPlugin.addInputSlot(widgets, inputPointBottom, EntryIngredients.ofIngredient(display.getRecipe().getIngredients().get(2)));
        MAREIPlugin.addLargeOutputSlot(widgets, outputPoint, EntryIngredients.of(display.getRecipe().essence));
        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 18 * 3 + 2 * 5;
    }

    @Override
    public int getDisplayWidth(CruxDisplay display) {
        return 96;
    }
}
