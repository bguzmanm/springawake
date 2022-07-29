package cl.awakelab.m1spring.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "film_actor")
public class FilmActor {

    @EmbeddedId
    private FilmActorPK id;
    private LocalDate lastUpdate;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    private FilmEntity filmEntity;
    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id", insertable = false, updatable = false)
    private ActorEntity actorEntity;
}
