package io.github.joke.demo.immutablesjackson.controller;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.immutables.value.Value;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.RetentionPolicy.CLASS;
import static org.immutables.value.Value.Style.ValidationMethod.VALIDATION_API;

@Target(PACKAGE)
@Retention(CLASS)
@Value.Style(
        deepImmutablesDetection = true,
        defaultAsDefault = true,
        jdkOnly = true,
        overshadowImplementation = true,
        typeImmutable = "*Immutable",
        validationMethod = VALIDATION_API
)
@JsonPOJOBuilder(withPrefix = "")
@interface ImmutableStyle {

}

