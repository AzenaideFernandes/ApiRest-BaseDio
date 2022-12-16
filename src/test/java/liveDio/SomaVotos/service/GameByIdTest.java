package liveDio.SomaVotos.service;

import liveDio.SomaVotos.domain.model.Game;
import liveDio.SomaVotos.domain.model.GameRepository;
import liveDio.SomaVotos.service.impl.GameServiceImpl;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Optional;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class GameByIdTest {

    @Autowired
    private GameServiceImpl serviceImpl;

    @Autowired
    private GameRepository repository;

    public GameByIdTest() {

    }

    @Test
    public void findByIdTest() {

        Game game = serviceImpl.findById(1L);

        assertEquals("Meujogo", game.getName());
        assertEquals(" bom jogo", game.getDescription());
        assertEquals("mmm", game.getCover());
        assertEquals("0",String.valueOf(game.getVotes()));
    }

    @Test
    public void deleteByIdTest() {
        serviceImpl.delete(121L);
        //Optional<Game> optionalGame = GameRepository.findById(1L);
    }

}