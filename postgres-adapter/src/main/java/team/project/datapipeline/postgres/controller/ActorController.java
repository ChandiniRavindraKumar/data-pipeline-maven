package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.Actor;
import team.project.datapipeline.postgres.model.FilmActor;
import team.project.datapipeline.postgres.service.ActorService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actors")
public class ActorController {
    @Autowired
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;

    }

    @QueryMapping
    public Actor actorById(@Argument Integer id) {
        Optional<Actor> actorOpt = actorService.find(id);
        return actorOpt.get();
    }

    @QueryMapping
    public List<Actor> findActors() {
        List<Actor> actors = actorService.findAll();
        return actors;
    }



    @GetMapping
    public List<Actor> List() {
        return actorService.findAll();
    }

    @GetMapping("/{actorId}")
    public ResponseEntity<Actor> get(@PathVariable("actorId") Integer actorId) {
        return actorService.find(actorId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Actor> create(@RequestBody Actor actor,
                                       UriComponentsBuilder uriBuilder) {
        Actor created = actorService.create(actor);
        URI newActorUri = uriBuilder.path("/actors/{actorId}").build(created.getActorId());
        return ResponseEntity.created(newActorUri).body(created);

    }

    @PutMapping
    public ResponseEntity<Actor> update(@RequestBody Actor actor,
                                        UriComponentsBuilder uriBuilder) throws Exception {
        Actor created = actorService.update(actor);
        URI newActorUri = uriBuilder.path("/actors/{actorId}").build(created.getActorId());
        return ResponseEntity.created(newActorUri).body(created);

    }

}
