package joienl.winterishere.item;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "WeakerAccess"})
public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<>();

    public static Item BLIZZARD_ROD; //369
    public static Item BLIZZARD_POWDER; //377
    public static Item ICE_CREAM; //378
    public static Item ICE_CHARGE; //385
    public static Item FROSTED_NETHERBRICK; //405

    static {
        BLIZZARD_ROD = new ModItemBase("blizzard_rod");
        BLIZZARD_POWDER = new ModItemBase("blizzard_powder");
        ICE_CREAM = new ModItemBase("ice_cream");
        ICE_CHARGE = new ModItemBase("ice_charge");
        FROSTED_NETHERBRICK = new ModItemBase("frosted_netherbrick");
    }
}