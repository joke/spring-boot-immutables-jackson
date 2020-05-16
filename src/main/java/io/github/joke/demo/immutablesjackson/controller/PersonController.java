package io.github.joke.demo.immutablesjackson.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class PersonController {

    @GetMapping("/person")
    ResponseEntity<Person> getPerson() {
        return ok(PersonImmutable.builder()
                .firstName("John")
                .lastName("Doe")
                .phones(List.of("+49..."))
                .address(AddressImmutable.builder()
                        .street("Street 1")
                        .country("Germany")
                        .build())
                .build());
    }

    @PostMapping("/person")
    ResponseEntity<Person> postPerson(@RequestBody final Person person) {
        return created(URI.create("/person")).body(person);
    }
}
