
package io.davidosemwota.superheroes_list.superheroes

import io.davidosemwota.ui.base.BaseViewState

/**
 * Different states for [ListOfSuperheroesFragment].
 *
 */
sealed class ListOfSuperheroesViewState : BaseViewState {

    /**
     * Refreshing characters list.
     */
    object Refreshing : ListOfSuperheroesViewState()

    /**
     * Loaded characters list.
     */
    object Loaded : ListOfSuperheroesViewState()

    /**
     * Loading characters list.
     */
    object Loading : ListOfSuperheroesViewState()

    /**
     * Empty characters list.
     */
    object Empty : ListOfSuperheroesViewState()

    /**
     * Error on loading characters list.
     */
    object Error : ListOfSuperheroesViewState()

    // ============================================================================================
    //  Public helpers methods
    // ============================================================================================

    /**
     * Check if current view state is [Refreshing].
     *
     * @return True if is refreshing state.
     */
    fun isRefreshing() = this is Refreshing

    /**
     * Check if current view state is [Loaded].
     *
     * @return True if is loaded state, otherwise false.
     */
    fun isLoaded() = this is Loaded

    /**
     * Check if current view state is [Loading].
     *
     * @return True if is loading state, otherwise false.
     */
    fun isLoading() = this is Loading

    /**
     * Check if current view state is [Empty].
     *
     * @return True if is empty state, otherwise false.
     */
    fun isEmpty() = this is Empty

    /**
     * Check if current view state is [Error].
     *
     * @return True if is error state, otherwise false.
     */
    fun isError() = this is Error

}
