package cz.vostinak.nba.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

/**
 * Screens.
 */
@Serializable
sealed interface Screens: NavKey {

    /**
     * Players list.
     */
    @Serializable
    data object PlayersList: Screens

    /**
     * PlayerItemState detail.
     */
    @Serializable
    data class PlayerDetail(val playerId: Long): Screens

    /**
     * Teams detail.
     */
    @Serializable
    data class TeamsDetail(val teamId: Long): Screens
}