package nl.gamereview;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import nl.gamereview.web.AppController;
import nl.gamereview.web.GameController;
import nl.gamereview.web.GameRestController;

@SpringBootTest
class GamereviewApplicationTests {

	@Autowired
	private AppController appController;
	@Autowired
	private GameController gameController;
	@Autowired
	private GameRestController gameRestController;

	@Test
	public void contextLoads() throws Exception{
		assertThat(appController).isNotNull();
		assertThat(gameController).isNotNull();
		assertThat(gameRestController).isNotNull();
	}

}
