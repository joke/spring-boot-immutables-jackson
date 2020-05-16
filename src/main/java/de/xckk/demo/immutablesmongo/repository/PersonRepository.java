package de.xckk.demo.immutablesmongo.repository;

import de.xckk.demo.immutablesmongo.repository.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PersonRepository extends MongoRepository<Person, UUID> {
}
