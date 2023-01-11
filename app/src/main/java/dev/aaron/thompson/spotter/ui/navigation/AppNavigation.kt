package dev.aaron.thompson.spotter.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.aaron.thompson.spotter.data.model.lifts
import dev.aaron.thompson.spotter.ui.screens.recentLifts.RecentLiftsScreen

/**
 * @param startDestination default screen visible when user opens app.
 * @param routes gives access to all destination routes in [AppDestinations] object.
 *
 * This is an entry point triggered once activity starts.
 */
@Composable
fun AppNavigation(
    startDestination: String = AppDestinations.RECENT_LIFTS_ROUTE,
    routes: AppDestinations = AppDestinations
) {
    // Create a NavHostController to handle navigation.
    val navController = rememberNavController()
    val actions = remember(navController) {
        Actions(navController, routes)
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(
            AppDestinations.RECENT_LIFTS_ROUTE
        ) {
//            val viewModel = hiltViewModel<HomeViewModel>()
            val groupedLifts = lifts.groupBy { it.movementName[0] }
            RecentLiftsScreen(groupedLifts = groupedLifts)
        }

//        composable(
//            AppDestinations.SEARCH_RECENT_LIFTS_ROUTE
//        ) {
////            val viewModel = hiltViewModel<SearchViewModel>()
//            SearchScreen(
//                selectedActor = actions.selectedActor,
//                navigateUp = actions.navigateUp,
//                viewModel = viewModel
//            )
//        }

//        composable(
//            route = "${AppDestinations.ACTOR_DETAIL_ROUTE}/{${routes.ACTOR_DETAIL_ID_KEY}}",
//            arguments = listOf(
//                navArgument(routes.ACTOR_DETAIL_ID_KEY) { type = NavType.IntType }
//            )
//        ) {
//            val viewModel = hiltViewModel<ActorDetailsViewModel>()
//            ActorDetailsScreen(
//                selectedMovie = actions.selectedMovie,
//                navigateUp = actions.navigateUp,
//                viewModel = viewModel
//            )
//        }
//
//        composable(
//            route = "${AppDestinations.MOVIE_DETAILS_ROUTE}/{${routes.MOVIE_DETAILS_ID_KEY}}",
//            arguments = listOf(
//                navArgument(routes.MOVIE_DETAILS_ID_KEY) { type = NavType.IntType }
//            )
//        ) {
//            val viewModel = hiltViewModel<MovieDetailViewModel>()
//            MovieDetailScreen(
//                navigateUp = actions.navigateUp,
//                viewModel = viewModel,
//                selectedMovie = actions.selectedMovie
//            )
//        }
    }
}