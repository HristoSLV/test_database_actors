package actor_demo.test_db.actor;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "actors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private int age;

    public ActorEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
