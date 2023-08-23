package demo2.demodemo2_dayone.api;

import demo2.demodemo2_dayone.entity.Player;
import demo2.demodemo2_dayone.repository.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping
    List<Player> getPlayers() {
        return  playerRepository.findAll();
    }
}

