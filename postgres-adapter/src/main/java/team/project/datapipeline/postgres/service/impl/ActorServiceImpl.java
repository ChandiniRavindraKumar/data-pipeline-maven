package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.Actor;
import team.project.datapipeline.postgres.repository.ActorRepository;
import team.project.datapipeline.postgres.service.ActorService;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> findAll() {
        return (List<Actor>) actorRepository.findAll();
    }
    @Override
    public Actor create(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Optional<Actor> find(Integer actorId) {
        return actorRepository.findById(actorId);
    }

    @Override
    public Actor update(Actor actor) throws Exception {

        if (Objects.isNull(actor.getActorId())) {
            throw new Exception("Actor id is mandatory for the update operation");
        }

        Actor updatedActor = null;

        Optional<Actor> existingActorOpt = actorRepository.findById(actor.getActorId());

        if (existingActorOpt.isPresent()) {
            Actor existingActor = existingActorOpt.get();

            if (!actor.getFirstName().equals(existingActor.getFirstName())) {
                existingActor.setFirstName(actor.getFirstName());
            }

            if (!actor.getLastName().equals(existingActor.getLastName())) {
                existingActor.setLastName(actor.getLastName());
            }

            updatedActor = actorRepository.save(existingActor);
        } else {
            throw new Exception("Actor is not found in the database");
        }

        return updatedActor;
    }
}
