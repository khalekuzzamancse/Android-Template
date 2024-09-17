package feature_navigation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import common.ui.SnackBarMessage
import feature_lissuelist.issue_list.route.IssuesListRoute
import kotlinx.serialization.Serializable

@Composable
internal fun RootNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onNavigationRequest:(Route)->Unit,
    onScreenMessageUpdate:(SnackBarMessage)->Unit,
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Route.IssueList
    ) {
        composable<Route.IssueList> {
            IssuesListRoute(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),
                onDetailsRequest = { issueNum -> onNavigationRequest(Route.IssueDetails(issueNum)) },
                onUserProfileRequest = {},
                onScreenMessageUpdate = onScreenMessageUpdate
            )
        }



    }

}

interface Route {

    @Serializable
    object IssueList : Route

    @Serializable
    data class IssueDetails(val issueNumber: String) : Route

    @Serializable
    object Search : Route

}

