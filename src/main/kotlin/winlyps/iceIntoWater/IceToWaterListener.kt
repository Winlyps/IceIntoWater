package winlyps.iceIntoWater

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin

class IceToWaterListener(private val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        // Check if the player right-clicked on a block
        if (event.action == Action.RIGHT_CLICK_BLOCK) {
            val clickedBlock = event.clickedBlock
            // Check if the clicked block is any type of ice
            if (clickedBlock?.type in listOf(Material.ICE, Material.PACKED_ICE, Material.BLUE_ICE)) {
                // Replace the ice block with water
                if (clickedBlock != null) {
                    clickedBlock.type = Material.WATER
                }
            }
        }
    }
}