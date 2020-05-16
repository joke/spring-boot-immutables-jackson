package de.xckk.demo.immutablesmongo.repository.model;

import org.immutables.annotate.InjectAnnotation;
import org.immutables.value.Value;
import org.springframework.data.annotation.PersistenceConstructor;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.RetentionPolicy.CLASS;
import static org.immutables.annotate.InjectAnnotation.Where.CONSTRUCTOR;

@Target(PACKAGE)
@Retention(CLASS)
@Value.Style(
        allParameters = true,
        deepImmutablesDetection = true,
        defaultAsDefault = true,
        jacksonIntegration = false,
        jdkOnly = true,
        of = "new",
        optionalAcceptNullable = true,
        overshadowImplementation = true,
        typeImmutable = "*Immutable"
)
@InjectAnnotation(type = PersistenceConstructor.class, target = CONSTRUCTOR)
@interface ImmutableStyle {

}

