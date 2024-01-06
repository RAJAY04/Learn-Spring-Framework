package com.Ajay.LearnSpringFramework.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name,int age,Address address){}
record Address(String firstLine,String city){}

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name(){
        return "Ajay";
    }

    @Bean
    public int age(){
        return 19;
    }

    @Bean
    public Person person(){
        return new Person("Ravi",20,new Address("kuntalpady","karkala"));
    }

    @Bean
    public Person person2MethodCall(){
        return new Person(name(),age(),address());
    }

    @Bean
    @Primary
    public Person person3Parameter(String name,int age,Address customAddress2){
        return new Person(name,age,customAddress2);
    }

    @Bean
    public Person person4Qualifier(String name,int age,    @Qualifier("person3Qualifier")
    Address address){
        return new Person(name,age,address);
    }

    //below even though the method name is address the beanname is customAddress
    @Bean(name = "customAddress")
    @Primary
    public Address address(){
        return new Address("kuntalpady","karkala");
    }

    @Bean(name = "customAddress2")
    @Qualifier("person3Qualifier")
    public Address address1(){
        return new Address("Bedrangadi","Borkatte");
    }



}
