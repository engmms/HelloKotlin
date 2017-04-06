package es.voghdev.hellokotlin

import android.content.Context
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class SomeDetailPresenterTest {
    @Mock
    lateinit var mockUserRepository: UserRepository

    @Mock
    lateinit var mockContext: Context

    @Mock
    lateinit var mockView: SomeDetailPresenter.MVPView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `should request a List of users on start`() = runBlocking<Unit> {
        val presenter = SomeDetailPresenter(mockContext, mockUserRepository)

        assertNotNull(presenter)

        presenter.view = mockView
        presenter.initialize().join()

        verify(mockUserRepository, times(1))?.getUsers()
    }

    @Test
    fun `should show user list if request has results`() = runBlocking<Unit> {
        val presenter = SomeDetailPresenter(mockContext, mockUserRepository)
        `when`(mockUserRepository.getUsers()).thenReturn(listOf(User(name = "John")))
        assertNotNull(presenter)

        presenter.view = mockView
        presenter.initialize().join()

        verify(mockView, times(1))?.showUsers(anyList())
    }

    @Test
    fun `should show empty case if request has no results`() = runBlocking<Unit> {
        val presenter = SomeDetailPresenter(mockContext, mockUserRepository)

        assertNotNull(presenter)

        presenter.view = mockView
        presenter.initialize().join()

        verify(mockView, times(1))?.showEmptyCase()
    }
}
