package dev.crossvas.mods.maxrei;

import com.blakebr0.mysticalagriculture.client.screen.ReprocessorScreen;
import com.blakebr0.mysticalagriculture.client.screen.SoulExtractorScreen;
import com.blakebr0.mysticalagriculture.compat.jei.CruxRecipe;
import com.blakebr0.mysticalagriculture.init.ModBlocks;
import com.blakebr0.mysticalagriculture.init.ModItems;
import com.blakebr0.mysticalagriculture.init.ModRecipeTypes;
import dev.crossvas.mods.maxrei.categories.*;
import dev.crossvas.mods.maxrei.displays.*;
import dev.crossvas.mods.maxrei.recipes.AwakeningRecipe;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import me.shedaniel.rei.plugin.common.displays.DefaultInformationDisplay;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Block;

import java.util.Arrays;
import java.util.List;

@REIPluginClient
public class MAREIPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        addCat(registry, AWAKENING_ID, AwakeningCategory.INSTANCE,
                ModBlocks.AWAKENING_ALTAR.get(),
                ModBlocks.AWAKENING_PEDESTAL.get(),
                ModBlocks.ESSENCE_VESSEL.get()
        );

        addCat(registry, INFUSION_ID, InfusionCategory.INSTANCE,
                ModBlocks.INFUSION_ALTAR.get(),
                ModBlocks.INFUSION_PEDESTAL.get()
        );
        addCat(registry, REPROCESSOR_ID, SeedProcessorCategory.INSTANCE,
                ModBlocks.BASIC_REPROCESSOR.get(),
                ModBlocks.INFERIUM_REPROCESSOR.get(),
                ModBlocks.PRUDENTIUM_REPROCESSOR.get(),
                ModBlocks.TERTIUM_REPROCESSOR.get(),
                ModBlocks.IMPERIUM_REPROCESSOR.get(),
                ModBlocks.SUPREMIUM_REPROCESSOR.get()
        );

        addCat(registry, SOUL_EXTRACTOR_ID, SoulExtractorCategory.INSTANCE, ModBlocks.SOUL_EXTRACTOR.get());
        registry.add(CruxCategory.INSTANCE);
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        RecipeManager RECIPES = Minecraft.getInstance().level.getRecipeManager();
        RECIPES.getAllRecipesFor(ModRecipeTypes.AWAKENING.get()).forEach(recipe -> registry.add(new AwakeningDisplay(new AwakeningRecipe(recipe))));
        RECIPES.getAllRecipesFor(ModRecipeTypes.INFUSION.get()).forEach(recipe -> registry.add(new InfusionDisplay(recipe)));
        RECIPES.getAllRecipesFor(ModRecipeTypes.REPROCESSOR.get()).forEach(recipe -> registry.add(new SeedProcessorDisplay(recipe)));
        RECIPES.getAllRecipesFor(ModRecipeTypes.SOUL_EXTRACTION.get()).forEach(recipe -> registry.add(new SoulExtractorDisplay(recipe)));
        CruxRecipe.getGeneratedRecipes().forEach(recipe -> registry.add(new CruxDisplay(recipe)));

        DefaultInformationDisplay informationDisplay = DefaultInformationDisplay.createFromEntries(EntryIngredients.of(ModItems.COGNIZANT_DUST.get()), ModItems.COGNIZANT_DUST.get().getDescription());
        informationDisplay.line(Component.translatable("jei.desc.mysticalagriculture.cognizant_dust"));
        registry.add(informationDisplay);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerContainerClickArea(new Rectangle(99, 52, 22, 15), ReprocessorScreen.class, REPROCESSOR_ID);
        registry.registerContainerClickArea(new Rectangle(99, 52, 22, 15), SoulExtractorScreen.class, SOUL_EXTRACTOR_ID);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void addCat(CategoryRegistry r, CategoryIdentifier id, DisplayCategory displayCat, Block... stations) {
        r.add(displayCat);
        Arrays.stream(stations).forEach(station -> r.addWorkstations(id, EntryStacks.of(station)));
    }

    public static final CategoryIdentifier<AwakeningDisplay> AWAKENING_ID = CategoryIdentifier.of(new ResourceLocation("mysticalagriculture", "awakening"));
    public static final CategoryIdentifier<InfusionDisplay> INFUSION_ID = CategoryIdentifier.of(new ResourceLocation("mysticalagriculture", "infusion"));
    public static final CategoryIdentifier<SeedProcessorDisplay> REPROCESSOR_ID = CategoryIdentifier.of(new ResourceLocation("mysticalagriculture", "reprocessor"));
    public static final CategoryIdentifier<SoulExtractorDisplay> SOUL_EXTRACTOR_ID = CategoryIdentifier.of(new ResourceLocation("mysticalagriculture", "extractor"));
    public static final CategoryIdentifier<CruxDisplay> CRUX_ID = CategoryIdentifier.of(new ResourceLocation("mysticalagriculture", "crux"));

    public static void createRecipeBase(List<Widget> list, Rectangle bounds) {
        list.add(Widgets.createRecipeBase(bounds));
    }

    public static void addInputSlot(List<Widget> list, Point point, EntryIngredient entry) {
        list.add(Widgets.createSlot(point).entries(entry).markInput());
    }

    public static void addLargeOutputSlot(List<Widget> list, Point point, EntryIngredient entry) {
        list.add(Widgets.createResultSlotBackground(point));
        list.add(Widgets.createSlot(point).entries(entry).markOutput().disableBackground());
    }
}
