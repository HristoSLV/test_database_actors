package actor_demo.test_db.actor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public ActorEntity saveActor(ActorEntity actorEntity) {
        return actorRepository.save(actorEntity);
    }

    public List<ActorEntity> getAllActors() {
        return actorRepository.findAll();
    }

    public Optional<ActorEntity> getActorById(Long id) {
        return actorRepository.findById(id);
    }

    public ActorEntity updateActor(Long id, ActorEntity updatedActor) {
        Optional<ActorEntity> existingActor = actorRepository.findById(id);
        if (existingActor.isPresent()) {
            ActorEntity actor = existingActor.get();
            actor.setName(updatedActor.getName());
            actor.setAge(updatedActor.getAge());
            return actorRepository.save(actor);
        } else {
            throw new RuntimeException("Actor not found");
        }
    }

    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}
