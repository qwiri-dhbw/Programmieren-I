package io.d2a.dhbw.eeee.annotations;

import java.lang.annotation.Annotation;

public interface AnnotationProvider {

    <A extends Annotation> A get(final Class<A> clazz);

}
