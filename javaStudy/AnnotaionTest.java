import java.lang.reflect.Method;
import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    String value() default "MyAnnotation : default value";
}


class MyObject{

    @MyAnnotation
    public void testMethod1(){
        System.out.println("This is testMethod1");
    }

    @MyAnnotation(value = "My new Annotation")
    public void testMethod2(){
        System.out.println("This is testMethod2");
    }

}



class MyMain{

    public static void main(String[] args){
        Method[] methodList = MyObject.class.getMethods();

        for (Method method : methodList) {
            if(method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation=method.getDeclaredAnnotation(MyAnnotation.class);
                String value=annotation.value();
                System.out.println(method.getName() + ":" + value);
            }
        }



    }



}