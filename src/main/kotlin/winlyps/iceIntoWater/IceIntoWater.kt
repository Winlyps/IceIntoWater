package winlyps.iceIntoWater

import org.bukkit.plugin.java.JavaPlugin

class IceIntoWater : JavaPlugin() {

    override fun onEnable() {
        // Register the event listener
        server.pluginManager.registerEvents(IceToWaterListener(this), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}