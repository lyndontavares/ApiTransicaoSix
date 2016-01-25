package py.com.datapar.integracao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class UtilAnnotation{
  @SuppressWarnings("unchecked")
  public static<T> T getAnnotationValue(Class<?> clazz,Class<? extends Annotation> annotationClass,String element) throws Exception {
    Annotation annotation = clazz.getAnnotation(annotationClass);
    Method method = annotationClass.getMethod(element,(Class[])null);
    if (annotation == null)
      return((T)method.getDefaultValue());
    return((T)method.invoke(annotation,(Object[])null));
  }
}
