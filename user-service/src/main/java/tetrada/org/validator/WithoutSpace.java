package tetrada.org.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = WithoutSpaceValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WithoutSpace {
    String message() default "lastName or firstName should be without space";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
