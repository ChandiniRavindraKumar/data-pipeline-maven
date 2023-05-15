package team.project.datapipeline.postgres.service;

import team.project.datapipeline.postgres.model.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    List<Actor> findAll();

    Actor create(Actor actor);
    Optional<Actor> find(Integer actorId);

    Actor update(Actor actor) throws Exception;




}
