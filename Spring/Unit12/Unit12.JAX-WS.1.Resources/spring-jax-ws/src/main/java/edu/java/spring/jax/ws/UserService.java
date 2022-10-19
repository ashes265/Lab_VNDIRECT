package edu.java.spring.jax.ws;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@Component("userService")
public class UserService {
    @WebMethod(operationName = "say")
    public String sayHello(String name){
        return "Hello to String 'name' ==> "+name;
    }
}
