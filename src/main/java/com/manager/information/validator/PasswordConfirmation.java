package com.manager.information.validator;

import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public @interface PasswordConfirmation {
    String password();
    String confirmPassword();
    String message () default "Password must be matched!";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    @Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface List{
        PasswordConfirmation[] value();
    }
}
