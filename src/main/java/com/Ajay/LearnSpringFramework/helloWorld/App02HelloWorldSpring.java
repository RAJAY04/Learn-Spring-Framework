package com.Ajay.LearnSpringFramework.helloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        //1.launch a spring context
        try(        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        ) {
            //2.configure things that we want spring framework to manage- @configuration class
            //helloWorldConfiguration class we created for the above purpose
            //name - @Bean

            //3.retrieving beans managed by spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameter"));
            System.out.println(context.getBean(Person.class));
            System.out.println(context.getBean("customAddress"));
            //we can also use class as alternative to name
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean("person4Qualifier"));

            //for the above line to work we need to have at least one primary bean

            //sout all the bean names
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
