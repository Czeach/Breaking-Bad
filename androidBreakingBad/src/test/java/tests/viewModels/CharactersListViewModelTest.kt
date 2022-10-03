package tests.viewModels

import com.czech.breakingbad.android.ui.characters.CharactersListViewModel
import com.czech.breakingbad.datasource.network.models.Characters
import com.czech.breakingbad.interactors.characters.GetCharactersList
import com.czech.breakingbad.interactors.characters.SearchCharacter
import com.czech.breakingbad.util.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@OptIn(ExperimentalCoroutinesApi::class)
class CharactersListViewModelTest {

    @Mock
    private lateinit var charListRepository: GetCharactersList

    @Mock
    private lateinit var searchCharRepository: SearchCharacter

    @Mock
    private lateinit var charListViewModel: CharactersListViewModel

    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    @Before
    fun initMocks(){
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testCoroutineDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    private val response = Characters(
        charId = 1,
        name = "",
        birthday = "",
        occupation = listOf("", "", ""),
        img = "",
        status = "",
        nickname = "",
        appearance = listOf(1, 4, 2),
        portrayed = "",
        category = "",
        betterCallSaulAppearance = listOf(6, 9)
    )

    @Test
    fun searchChar() = testCoroutineDispatcher.runBlockingTest {

        charListViewModel = CharactersListViewModel(charListRepository,searchCharRepository)

        val responseToData = DataState.data(data = listOf(response))

        val channel = Channel<DataState<List<Characters>>>()

        val flow = channel.consumeAsFlow()

        val query = ""

        Mockito.`when`(searchCharRepository.execute(query)).thenReturn(flow)

        val job = launch {
            channel.send(responseToData)
        }

        charListViewModel.searchCharacter()

        Assert.assertEquals(true, charListViewModel.state.value.characters.firstOrNull()?.charId == 1)
        Assert.assertEquals(true, !charListViewModel.state.value.isLoading)
        job.cancel()
    }

    @Test
    fun getCharListTest() = testCoroutineDispatcher.runBlockingTest {

        charListViewModel = CharactersListViewModel(charListRepository,searchCharRepository)

        val responseToData = DataState.data(data = listOf(response))

        val channel = Channel<DataState<List<Characters>>>()

        val flow = channel.consumeAsFlow()

        Mockito.`when`(charListRepository.execute()).thenReturn(flow)

        val job = launch {
            channel.send(responseToData)
        }

        charListViewModel.loadCharacters()

        Assert.assertEquals(true, charListViewModel.state.value.characters == listOf(response))
        Assert.assertEquals(true, !charListViewModel.state.value.isLoading)
        job.cancel()
    }

}