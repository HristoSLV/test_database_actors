package actor_demo.test_db.actor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<ActorEntity, Long> {
}
