package de.xckk.demo.immutablesmongo.repository.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value.Immutable;

import java.util.Optional;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Immutable
public interface Person {

    default UUID getId() {
        return randomUUID();
    }

    String getFirstName();
    String getLastName();
    Optional<String> getPhone();

}

