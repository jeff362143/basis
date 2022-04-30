注解是放在java类、方法、字段、参数之前的一种特殊注释。
注解定义后也是一种 class ，所有的注解都继承自 java.lang.annotation.Annotation，因此，读取注解，需要使用反射API。
注释会被编译器忽略，但注解可以被编译器打包进class文件，它是起标识作用的元数据。

java注解分三类：(注解起到的就是标记作用?方法被标记后就需要特殊处理)
第一类是由编译器使用的注解，例如:
@Override :让编译器检查该方法是否正确地实现了覆写; @SuppressWarnings :告诉编译器忽略此处代码产生的警告。
第二类一般是用于底层库处理的。
第三类是在程序运行期能够读取的注解，它们在加载后一直存在于JVM中，这也是最常用的注解。
例如，一个配置了 @PostConstruct 的方法会在调用构造方法后自动被调用(这是Java代码读取该注解识别的功能，不会被jvm识别)


定义Annotation的步骤
1、用@interface定义注解
2、添加参数、默认值
把最常用的参数定义为 value() ，推荐所有参数都尽量设置默认值。
public @interface Report{
    int type() default 0;
    String value() default "";
}
3、用元注解配置注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {
    int type() default 0;
    String level() default "info";
    String value() default "";
}
其中，必须设置 @Target 和 @Retention ，
@target指定注解的可应用范围；@Retention 一般设置为 RUNTIME ，因为我们自 定义的注解通常要求在运行期读取

