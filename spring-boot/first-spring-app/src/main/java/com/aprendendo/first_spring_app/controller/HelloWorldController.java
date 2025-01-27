package com.aprendendo.first_spring_app.controller;

import com.aprendendo.first_spring_app.domain.User;
import com.aprendendo.first_spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// STATEFULL -> o estado do cliente é mantido no servidor
// STATELESS -> a cada requisicao eu recebo todas as informacoes que eu preciso para fazer aquela funcionalidade que o cliente estah pedindo

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    // Opcao 2 : fazer a injecao da dependencia com @Autowired
    @Autowired
    private HelloWorldService helloWorldService;

    // lib externa, configurada no arquivo HelloConfiguration.java
    // @Autowired
    // private SDKAWS sdkAws;

    // Opcao 1 : fazer esse constructor
    // o Spring fez a injecao da dependencia HelloWorldService
    /*public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }*/

    // si @GetMapping("/get") -> GET /hello-world/get
    // GET /hello-world
    @GetMapping
    public String helloWorld() {
        return helloWorldService.getHelloMessage("Gabriel");
    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable String id, @RequestParam(value = "filter", defaultValue = "nenhum") String filter, @RequestBody User body) {
        return "Hello World " + filter + " " + id;
    }
}
