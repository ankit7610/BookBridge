
package com.plcoding.bookpedia.book.presentation.book_list

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.plcoding.bookpedia.book.domain.Book
import org.junit.Rule
import org.junit.Test

class BookListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun initialState_shouldDisplaySearchAndFavoritesTabs() {
        composeTestRule.setContent {
            BookListScreen(state = BookListState(), onAction = {})
        }

        composeTestRule.onNodeWithText("Search Results").assertIsDisplayed()
        composeTestRule.onNodeWithText("Favorites").assertIsDisplayed()
    }

    @Test
    fun search_shouldDisplaySearchResults() {
        val books = listOf(
            Book(
                id = "1",
                title = "The Lord of the Rings",
                authors = listOf("J.R.R. Tolkien"),
                imageUrl = "",
                description = "",
                numPages = 1000,
                averageRating = 5.0,
                languages = listOf("English")
            )
        )

        composeTestRule.setContent {
            BookListScreen(state = BookListState(searchResults = books), onAction = {})
        }

        composeTestRule.onNodeWithText("The Lord of the Rings").assertIsDisplayed()
    }

    @Test
    fun favoritesTab_shouldBeEmptyInitially() {
        composeTestRule.setContent {
            BookListScreen(state = BookListState(), onAction = {})
        }

        composeTestRule.onNodeWithText("Favorites").performClick()
        composeTestRule.onNodeWithText("You haven't added any books to your favorites yet.").assertIsDisplayed()
    }

    @Test
    fun searchAndNavigate_shouldNavigateToDetailScreen() {
        val books = listOf(
            Book(
                id = "1",
                title = "The Lord of the Rings",
                authors = listOf("J.R.R. Tolkien"),
                imageUrl = "",
                description = "",
                numPages = 1000,
                averageRating = 5.0,
                languages = listOf("English")
            )
        )

        var navigated = false
        composeTestRule.setContent {
            BookListScreen(
                state = BookListState(searchResults = books),
                onAction = {
                    if (it is BookListAction.OnBookClick) {
                        navigated = true
                    }
                }
            )
        }

        composeTestRule.onNodeWithText("The Lord of the Rings").performClick()
        assert(navigated)
    }
}
