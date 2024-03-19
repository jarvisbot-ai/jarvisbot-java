package com.jarvisbot.sdk.common.validation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@FutureRealization("This method will be implemented in the future.")
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface ValueValid {
}
