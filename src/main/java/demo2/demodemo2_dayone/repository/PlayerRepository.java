package demo2.demodemo2_dayone.repository;

import demo2.demodemo2_dayone.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player findByName(String player);
    Player findByNameLike(String name);
}

