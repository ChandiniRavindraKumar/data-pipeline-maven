package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.Actor;
import team.project.datapipeline.postgres.service.ActorService;

import java.net.URI;

@RestController
@RequestMapping("/actors")

public class ActorController {
    @Autowired
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;

    }

    @GetMapping
    public Iterable<Actor> List() {
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
