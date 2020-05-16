package io.github.joke.demo.immutablesjackson.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value.Immutable;

import java.util.List;
import java.util.Optional;

@Immutable
@JsonSerialize(as = PersonImmutable.class)
@JsonDeserialize(builder = PersonImmutable.Builder.class)
public interface Person {

    String getFirstName();
    String getLastName();
    List<String> getPhones();
    Optional<Address> getAddress();

    @Immutable
    @JsonSerialize(as = AddressImmutable.class)
    @JsonDeserialize(builder = AddressImmutable.Builder.class)
    interface Address {
        String getStreet();
        String getCountry();
    }

}
