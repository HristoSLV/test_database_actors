package actor_demo.test_db.actor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles({"testsql"})
@Testcontainers
public class ActorDBTest {
    @Autowired
    private ActorRepository actorRepository;

    @Container
    //@ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.1.0").withDatabaseName("db_test_testcontainer");

    @DynamicPropertySource
    static void dynamicConfiguration(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
    }

    @Test
    public void givenGenericEntityRepository_whenSaveAndRetrieveEntity_thenOK() {
        ActorEntity actorEntity = actorRepository
                .save(new ActorEntity("testActor", 28));
        ActorEntity foundEntity = actorRepository.findById(actorEntity.getId()).orElse(null);

        assertNotNull(foundEntity);
        assertEquals(actorEntity.getName(), foundEntity.getName());
    }

    @Test
    public void CheckDatabaseSize(){
        List<ActorEntity> actorEntityList = actorRepository.findAll();
        assertEquals(7, actorEntityList.size());
    }
}
