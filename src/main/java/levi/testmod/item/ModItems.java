package levi.testmod.item;

import levi.testmod.TestMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item JONAH = registerItem("jonah",
            new Item(new FabricItemSettings()));
    public static final Item LEVI = registerItem("levi",
            new Item(new FabricItemSettings()));
    public static final Item ELMO = registerItem("elmo",
            new Item(new FabricItemSettings()));
    public static final Item TITUS = registerItem("titus",
            new Item(new FabricItemSettings()));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {

        addItemsToItemGroup(ItemGroups.INGREDIENTS, JONAH);
        addItemsToItemGroup(ItemGroups.INGREDIENTS, LEVI);
        addItemsToItemGroup(ItemGroups.INGREDIENTS, ELMO);
        addItemsToItemGroup(ItemGroups.INGREDIENTS, TITUS);
    }
    public static  void addItemsToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }


    public  static  void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);
        addItemsToItemGroup();
    }
}
