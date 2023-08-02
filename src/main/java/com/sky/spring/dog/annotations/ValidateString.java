//package com.sky.spring.dog.annotations;
//
//import com.sky.spring.dog.validators.StringValidator;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//import java.lang.annotation.*;
//@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE })
//@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = StringValidator.class)
//@Documented
//
//public @interface ValidateString {
//
//    String message() default "{colour.invalid}";
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default { };
//}
