
package com.plcoding.bookpedia.book.presentation.book_list

import app.cash.turbine.test
import com.plcoding.bookpedia.book.domain.Book
import com.plcoding.bookpedia.book.domain.BookRepository
import com.plcoding.bookpedia.book.domain.FavoriteBookRepository
import com.plcoding.bookpedia.core.domain.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class BookListViewModelTest {

    private lateinit var viewModel: BookListViewModel
    private lateinit var bookRepository: BookRepository
    private lateinit var favoriteBookRepository: FavoriteBookRepository

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        bookRepository = mock()
        favoriteBookRepository = mock()
        viewModel = BookListViewModel(bookRepository, favoriteBookRepository)
    }

    @Test
    fun `initial state is correct`() = runTest {
        val initialState = BookListState()
        assertEquals(initialState, viewModel.state.value)
    }

    @Test
    fun `search query updates state`() = runTest {
        val query = "The Lord of the Rings"
        viewModel.onAction(BookListAction.OnSearchQueryChange(query))
        assertEquals(query, viewModel.state.value.searchQuery)
    }

    @Test
    fun `search action returns success`() = runTest {
        val query = "The Lord of the Rings"
        val books = listOf(Book(
            id = "1",
            title = "The Lord of the Rings",
            authors = listOf("J.R.R. Tolkien"),
            imageUrl = "",
            description = "",
            numPages = 1000,
            averageRating = 5.0,
            languages = listOf("English")
        ))

        runBlocking {
            whenever(bookRepository.searchBooks(query)).thenReturn(Result.Success(books))
            whenever(favoriteBookRepository.getFavoriteBooks()).thenReturn(flowOf(emptyList()))

            viewModel.onAction(BookListAction.OnSearchQueryChange(query))
            viewModel.onAction(BookListAction.OnSearchClick)

            viewModel.state.test {
                val emission = awaitItem()
                assertFalse(emission.isLoading)
                assertEquals(books, emission.searchResults)
            }
        }
    }

    @Test
    fun `toggle favorite updates state`() = runTest {
        val book = Book(
            id = "1",
            title = "The Lord of the Rings",
            authors = listOf("J.R.R. Tolkien"),
            imageUrl = "",
            description = "",
            numPages = 1000,
            averageRating = 5.0,
            languages = listOf("English")
        )
        val favoriteBooksFlow = MutableStateFlow(emptyList<Book>())

        runBlocking {
            whenever(favoriteBookRepository.getFavoriteBooks()).thenReturn(favoriteBooksFlow)
            viewModel.onAction(BookListAction.OnFavoriteToggle(book))
            favoriteBooksFlow.emit(listOf(book))

            viewModel.state.test {
                val emission = awaitItem()
                assertTrue(emission.favoriteBooks.contains(book))
            }
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
