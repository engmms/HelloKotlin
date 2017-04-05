package es.voghdev.hellokotlin

import android.content.Context
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class UserDetailPresenterTest {
    @Mock
    lateinit var mockUserRepository: UserRepository

    @Mock
    lateinit var mockContext: Context

    @Mock
    lateinit var mockView: UserDetailPresenter.MVPView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `should request a List of users on start`() = runBlocking<Unit> {
        val presenter = UserDetailPresenter(mockContext, mockUserRepository)

        presenter.view = mockView
        presenter.initialize()

        waitForAsyncBlocksToFinish()

        verify(mockUserRepository, times(1))?.getUsers()
    }

    private fun waitForAsyncBlocksToFinish() {
        Thread.sleep(30)
    }
}
