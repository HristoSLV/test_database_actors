package actor_demo.test_db.actor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ActorDBTest {
    @Autowired
    private ActorRepository actorRepository;


    @Test
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        ActorEntity actorEntity = actorRepository
                .save(new ActorEntity("testActor", 28));
        ActorEntity foundEntity = actorRepository.findById(actorEntity.getId()).orElse(null);

        assertNotNull(foundEntity);
        assertEquals(actorEntity.getName(), foundEntity.getName());
    }

    @Test
    public void testHowManyRows(){
        List<ActorEntity> actorEntityList = actorRepository.findAll();
        assertEquals(7, actorEntityList.size());
    }
}
