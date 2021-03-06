package joienl.winterishere;

import joienl.winterishere.proxy.CommonProxy;
import joienl.winterishere.util.handlers.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@SuppressWarnings("ALL")
@Mod(modid = WinterIsHere.MODID, name = WinterIsHere.NAME, version = WinterIsHere.VERSION)
public class WinterIsHere {

    public static final String MODID = "wih";
    public static final String NAME = "Winter Is Here";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(MODID)
    public static WinterIsHere instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) { RegistryHandler.preInitRegistries(); }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) { RegistryHandler.initRegistries(); }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) { RegistryHandler.postInitRegistries(); }

    @Mod.EventHandler
    public void serverInit(FMLServerStartingEvent e) { RegistryHandler.serverRegistries(e); }

    @SidedProxy(clientSide = "joienl.winterishere.proxy.ClientProxy", serverSide = "joienl.winterishere.proxy.CommonProxy")
    public static CommonProxy proxy;
}