package liuhuan.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import liuhuan.data.SpittleRepository;
import liuhuan.data.imp.SpittleRepositoryImp;
import liuhuan.model.Spittle;
import liuhuan.web.SpittleController;

public class SpittleControllerTest {
	@Test
	public void shouldShowRecentSpittles() throws Exception{
		List<Spittle> spittles = createSpittleList(20);
		SpittleRepository repository = Mockito.mock(SpittleRepository.class);
		SpittleController controller = new SpittleController(repository);
		Mockito.when(repository.findSpittles(Integer.MAX_VALUE, 20)).thenReturn(spittles);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
		       .andExpect(MockMvcResultMatchers.view().name("spittles"))
		       .andExpect(MockMvcResultMatchers.model().attributeExists("spiltleList"));
		       //.andExpect(MockMvcResultMatchers.model().attribute("spiltleList",spittles));
	}
	
	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for(int i = 0; i < count; i++){
			spittles.add(new Spittle("Spittle" + i, new Date()));
		}
		return spittles;
	}
}
