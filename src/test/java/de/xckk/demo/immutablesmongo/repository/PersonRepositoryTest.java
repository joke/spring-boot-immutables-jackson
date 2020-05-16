package de.xckk.demo.immutablesmongo.repository;

import de.xckk.demo.immutablesmongo.repository.model.PersonImmutable;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@TestMethodOrder(OrderAnnotation.class)
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    @Order(1)
    void savePerson() {
        final var person = PersonImmutable.builder()
                .firstName("John")
                .lastName("Doe")
                .phone("+49...")
                .build();
        personRepository.save(person);
    }

    @Test
    @Order(2)
    void findPerson() {
        final var person = personRepository.findAll().get(0);
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals("+49...", person.getPhone().orElseThrow());
    }

}