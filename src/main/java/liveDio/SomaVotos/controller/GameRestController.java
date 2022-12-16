package liveDio.SomaVotos.controller;

import liveDio.SomaVotos.controller.games.BaseRestControler;
import liveDio.SomaVotos.domain.model.Game;
import liveDio.SomaVotos.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class GameRestController extends BaseRestControler {

    @Autowired
    private GameService businessLayer;

    @GetMapping("games")
    public ResponseEntity<List<Game>> findAll(){
        List<Game> games = businessLayer.findAll();
        return ResponseEntity.ok(games);
    }

    @GetMapping("games/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id){
        Game games = businessLayer.findById(id);
        return ResponseEntity.ok(games);
    }

    @PostMapping("games")
    public ResponseEntity<Game> insert(@RequestBody Game game){
        businessLayer.insert(game);
        return ResponseEntity.ok(game);
    }

    @PutMapping("games/{id}")
    public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game game){
        businessLayer.update(id, game);
        return ResponseEntity.ok(game);
    }

    @DeleteMapping("games/{id}")
    public ResponseEntity<Game> delete(@PathVariable Long id){
        businessLayer.delete(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("games/{id}/vote")
    public ResponseEntity<Game> update(@PathVariable Long id){
        businessLayer.vote(id);
        return ResponseEntity.ok().build();
    }


}
