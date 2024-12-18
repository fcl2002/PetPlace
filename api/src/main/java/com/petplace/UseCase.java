package com.petplace;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Service
@Validated

public @interface UseCase { 
}