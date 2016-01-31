package com.ashindigo.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a mod for Auto-Json creation
 * @author Ash Indigo
 */
// TODO Might want to add some data
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UtilsJson {

}
