package org.example.enumrestrequesttest.valid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

public class EnumArrayValidator implements ConstraintValidator<NonNullEnumArray, Object[]> {

    private final Set<String> acceptedValues = new HashSet<>();

    @Override
    public void initialize(NonNullEnumArray constraintAnnotation) {
        Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClass();
        Enum<?>[] enumConstants = enumClass.getEnumConstants();
        for (Enum<?> enumConstant : enumConstants) {
            acceptedValues.add(enumConstant.name());
        }
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        for (Object enumValue : value) {
            if (enumValue == null)
                return false;
            if (!acceptedValues.contains(enumValue.toString())) {
                return false;
            }
        }
        return true;
    }
}
