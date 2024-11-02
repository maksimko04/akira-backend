package tetrada.org.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class WithoutSpaceValidator implements ConstraintValidator<WithoutSpace, String> {
    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        return str != null && !str.contains(" ");
    }
}
