package cz.vostinak.nba.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import cz.vostinak.presentation.screens.list.PlayersListScreen
import cz.vostinak.presentation.screens.player.PlayerDetailScreen
import cz.vostinak.presentation.screens.team.TeamDetailScreen

/**
 * Main navigation.
 */
@Composable
fun MainNavHost() {
    val navigationState = rememberNavigationState(
        startRoute = Screens.PlayersList,
        topLevelRoutes = setOf(Screens.PlayersList)
    )
    val navigator = remember { Navigator(navigationState) }

    val entryProvider = entryProvider<NavKey> {
        entry<Screens.PlayersList> {
            PlayersListScreen(
                onPlayerDetailClick = { playerId ->
                    navigator.navigate(Screens.PlayerDetail(playerId))
                }
            )
        }
        entry<Screens.PlayerDetail> { key ->
            PlayerDetailScreen(
                playerId = key.playerId,
                onBack = {
                    navigator.goBack()
                },
                onTeamClick = { teamId ->
                    navigator.navigate(Screens.TeamsDetail(teamId))
                }
            )
        }
        entry<Screens.TeamsDetail> { key ->
            TeamDetailScreen(
                teamId = key.teamId,
                onBack = {
                    navigator.goBack()
                }
            )
        }
    }

    NavDisplay(
        entries = navigationState.toEntries(entryProvider),
        onBack = { navigator.goBack() }
    )
}