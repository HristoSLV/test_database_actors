package actor_demo.test_db.actor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actor")
public class ActorController {
    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/find-all")
    public List<ActorEntity> getAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ActorEntity> getActorById(@PathVariable Long id) {
        Optional<ActorEntity> actorEntity = actorService.getActorById(id);
        return actorEntity.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<ActorEntity> newActor(@RequestBody ActorEntity actorEntity) {
        ActorEntity actor = actorService.saveActor(actorEntity);
        return ResponseEntity.ok(actor);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ActorEntity> updateActor(@PathVariable Long id, @RequestBody ActorEntity actorEntity){
        ActorEntity actor = actorService.updateActor(id, actorEntity);
        return ResponseEntity.ok(actor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        actorService.deleteActor(id);
        return ResponseEntity.ok("Actor deleted successfully!");
    }
}
