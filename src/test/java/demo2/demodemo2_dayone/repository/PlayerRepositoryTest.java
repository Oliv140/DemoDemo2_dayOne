package demo2.demodemo2_dayone.repository;

import demo2.demodemo2_dayone.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;
    boolean isInitiated = false;

    //Før hver eneste test køres denne kode
    @BeforeEach
    void setUp() {
        if(!isInitiated){
            playerRepository.deleteAll();
            playerRepository.save(new Player("Lionel Messi","C1","P1"));
            playerRepository.save(new Player("P2","C2","P2"));
            isInitiated=true;
        }
    }

    @Test
    public void deleteAll(){
        playerRepository.deleteAll();
        assertEquals(0, playerRepository.count());
    }

    @Test
    public void testAll(){
        Long count = playerRepository.count();
        assertEquals(2,count);
    }

    @Test
    void findByName() {
       Player p1 = playerRepository.findByName("P2");
       assertEquals("P2",p1.getName());
    }


    @Test
    void findByNameLike() {
        Player p = playerRepository.findByNameLike("%Messi%");
        assertEquals("Lionel Messi", p.getName());
    }

}