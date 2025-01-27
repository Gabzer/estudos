# Spring-Boot

Spring Boot est un framework que facilita a criacao de projetos Java baseados no Spring.

Sem configuracoes - JUSTE RUN: so iniciar o projeto e ja roda-lo.


## SpringInitializr

www.start.spring.io - para criar rapidamente um projeto


## Compreendendo um projeto SpringBoot

pom.xml - arquivo usado pelo Maven para instalar as dependencias.

.mvn - pasta onde ficam as config do Maven.

resources - pasta onde colocamos arqs de config, templates (pasta com o mesmo nome) e arq estaticos (pasta static) (CSS/HMTL/JS/SQL).

---application.properties - arq onde temos configuracoes especificas da apli Spring.

src/main/java/{app_dominio}/{nome_app}Application.java - classe principal/de entrada da app, ela vai inicializar toda a app.

o SpringBoot utilisa muito das anotacoes (nome em cima da classe que comeca com @) para fazer configuracoes das nossas classes (Design Patterns).

classe do tipo Controller: recebe as requisicoes http (arqs colocados normalmente em src/main/java/{app_dominio}/controller).

Api STATEFULL -> o estado do cliente é mantido no servidor.

Api STATELESS -> a cada requisicao eu recebo todas as informacoes que eu preciso para fazer aquela funcionalidade que o cliente estah pedindo.


## Anotacoes

@SpringBootApplication - define a porta de entrada da app (resumo de @Configuration, @EnableAutoConfiguration e @ComponentScan)

@RestController - controller do tipo Rest (stateless) (resume @Controller e @ResponseBody).

@RequestMapping() - tal controller escuta a todas as requisicoes que chegam no end-point definido entre parenteses ("/hello-world").

@GetMapping - tal metodo escuta as requisicoes GET. Podemos ajuntar mais path, soh colocar parenteses ("/get").


## O que e Bean no SpringBoot ?
## O que e Spring ?

25:35