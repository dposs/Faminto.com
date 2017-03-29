package com.faminto.util.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckNotWeekWinnerValidator.class)
@Documented
public @interface CheckNotWeekWinner {

    String message() default "Este Restaurante já foi o vencedor em outro dia desta semana.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
