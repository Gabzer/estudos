# Spring-Boot

Spring Boot est un framework que facilita a criacao de projetos Java baseados no Spring.

Sem configuracoes - JUSTE RUN: so iniciar o projeto e ja roda-lo.


## Spring Initializr

start.spring.io - para criar rapidamente um projeto

Sabendo que mesmo com Maven ou Gradle nohs encontramos com problemas de compatibilidade de versoes, o Spring Initializr eh uma ferramenta que nos ajuda a criar um projeto Spring Boot com as dependencias certas.

Esse site cria a estrutura dos packages e tbm o pom.xml/build.gradle.


## Compreendendo um projeto SpringBoot

pom.xml - arquivo usado pelo Maven para instalar as dependencias.

.mvn - pasta onde ficam as config do Maven.

resources - pasta onde colocamos arqs de config, templates (pasta com o mesmo nome) e arq estaticos (pasta static) (CSS/HMTL/JS/SQL).

---application.properties - arq onde temos configuracoes especificas da apli Spring.

src/main/java/{app_dominio}/{nome_app}Application.java - classe principal/de entrada da app, ela vai inicializar toda a app.

o SpringBoot utilisa muito das anotacoes (nome em cima da classe que comeca com @) para fazer configuracoes das nossas classes (Design Patterns).

Api STATEFULL -> o estado do cliente é mantido no servidor.

Api STATELESS -> a cada requisicao eu recebo todas as informacoes que eu preciso para fazer aquela funcionalidade que o cliente estah pedindo.

criando uma instancia: pode ser pelo construtor mas o SpringBoot recomenda usar o @Autowired (injecao de dependencia).

```java
@Autowired
private HelloWorldService helloWorldService;
```

Classe de tipo Controller: recebe as requisicoes http (arqs colocados normalmente em src/main/java/{app_dominio}/controller).

Classe de tipo Service: onde colocamos a logica de negocio da app.

Classe de tipo Configuration: definem Beans e instancias de classe no contexto da app. O Spring pode entao injetar classes de bibliotecas externas a ele.
Deve-se utilizar o @Bean sobre o metodo para indicar ao Spring que ele deve gerencia-lo como um Bean.


## Anotacoes

@SpringBootApplication - define a porta de entrada da app (resumo de @Configuration, @EnableAutoConfiguration e @ComponentScan)

@Profile() - define o perfil de configuracao da app. Tem que ser posta embaixo da anotacao @SpringBootApplication. Pode ser usada para definir o perfil de configuracao da app (dev, prod, test - entre parenteses na anotacao).

@RestController - controller do tipo Rest (stateless) (resume @Controller e @ResponseBody).

@RequestMapping() - tal controller escuta a todas as requisicoes que chegam no end-point definido entre parenteses ("/hello-world").

@GetMapping - tal metodo escuta as requisicoes GET. Podemos ajuntar mais path, soh colocar parenteses ("/get").

@PostMapping() - tal metodo escuta as requisicoes POST.

@PathVariable("") - pega uma info que vem na URL.

@RequestParam() - 
```java
@PostMapping("/{id}")
public String helloWorldPost(@PathVariable String id, @RequestParam(value = "filter", defaultValue = "nenhum") String filter, @RequestBody User body) {
    return "Hello World " + filter + " " + id;
}
```

@RequestBody - indica que o parametro do metodo eh o corpo(body de um Post) da requisicao.

@Service - classe de tipo Service.

@Autowired - injecao de dependencia (criacao de uma instancia).

@Bean - define um Bean (instancia de uma classe) no contexto da app.


## Lombok Anotations

@Getter - cria os metodos get.

@Setter - cria os metodos set.

@AllArgsContructor - cria um construtor com todos os parametros.


## Configuracoes

No application.properties:

config da port:

```
server.port=8080
```

config do BD:

```
spring.datasource.url=jdbc:mysql://localhost:3306/first_spring_app
spring.datasource.username=root
spring.datasource.password=root
```

usando variaveis de ambiente (os : entre a var_ambiente e o valor padrao):

```
spring.datasource.url=${DB_HOST:jdbc:mysql://localhost:3306/first_spring_app}
```

perfil de configuracao:

```
spring.profiles.active=${ACTIVE_PROFILE:dev}
```

eh possivel criar um arquivo application-dev.properties e colocar as configuracoes especificas para o perfil dev.


## O que eh Bean no SpringBoot ?
## O que eh Spring ?


# Criacao de microservices Spring Boot

https://github.com/Gabzer/creating-spring-boot-microservices-3839084

Core Spring Framework - open-source que providencia a injecao de dependencias do Spring Beans, o que ocorre pelo contexto do app. Esse contexto segue o modelo do conceito de inversao do controle (inversion-of-control design pattern).

O que eh a injecao de dependencias (ou DI) ? Ela separa a utilisacao de objetos da dependencia. A criacao de dependencias eh gerenciada fora da classe, o que a faz mais flexivel, mais sustetavel e mais facil de TU.

Inversion-of-Control Framework (IOC) - mantem o ciclo de vida de um objeto e necessita uma injecao de dependencias. A classe abandona o controle, de onde a inversao do controle para o framework.

Spring Application Context (Spring Container) - eh o framework IOC do Spring

Spring Bean - eh um objeto Java gerenciado pelo Spring Container. O Scope default = singleton (mas existem outros: prototype, request, session, etc).

Como config nossa DI ? Coloca-las diretamente no code Java = Anotations.

Spring Modules: spring.io/projects - Spring Framework, Spring Boot, Spring Data, Spring MVC, Spring Cloud e etc.

@Repository - que fica sobre uma classe - faz um Autowired de uma classe nas outras que dependem dela (normalmente elas estao anotadas com @Service)

## Web Application for Relational DB

- Required dependencies:
    1. Spring Web, wich includes Tomcat and Spring MVC;
    2. Rest Repositories to expose Spring Data repositories over REST;
    3. Java Persistence API;
    4. Lombok: generates getter/setter/logger bytecode;
    5. H2 in-memory database driver.

Por ter na classe principal o metodo main, nohs temos o controle sobre tudo. E o servidor de aplicacao estara dentro de nossa aplicacao.

Actuator denpendency - para monitorar a app (bilan de santé).

Jakarta Persistence Layer (Java Persistence API) - para mapear os objetos relacionais.

Spring Data JPA