package winlyps.iceIntoWater

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.plugin.java.JavaPlugin

class IceToWaterListener(private val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        // Check if the player right-clicked on a block with the main hand
        if (event.action == Action.RIGHT_CLICK_BLOCK && event.hand == EquipmentSlot.HAND) {
            val clickedBlock = event.clickedBlock
            val itemInHand = event.item

            // Check if the clicked block is any type of ice
            if (clickedBlock?.type in listOf(Material.ICE, Material.PACKED_ICE, Material.BLUE_ICE)) {
                // Check if the player is holding a block in their hand
                if (itemInHand != null && itemInHand.type.isBlock) {
                    // Allow the player to place the block without converting the ice to water
                    return
                }

                // Replace the ice block with water
                if (clickedBlock != null) {
                    clickedBlock.type = Material.WATER
                }
            }
        }
    }
}