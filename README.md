### Develop
- [Git](http://git-scm.com/downloads)
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Spring Boot Reference Guide](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Test](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html)

### Running the Examples

To follow the simple Spring Boot example (project name:test-demo):

- in a new file called `HelloController.java`:

```
@RestController
public class HelloController {
    @RequestMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
```
- in another new file called `Application.java`:
```
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
```
- from the terminal in the project directory ,you can execute `mvn package`
- you'll be given a `test-demo.jar` that you can execute: `java -jar test-demo.jar`
- you can test the `api /index` in the browser

### Pushing to Cloud Foundry

- `cf login` to ensure that you've authenticated against your Pivotal Web Services account. My session looked like this, yours will feature your own Cloud Foundry credentials.
```
> cf login

API endpoint> api.run.test.io

Email> MY_EMAIL@HOST.com

Password>
Authenticating...
OK

Select an org (or press enter to skip):
1. org-xxx-test
2. org-xxx

Org> 1
Targeted org org-xxx-test

Targeted space space-devtest1


API endpoint:   https://api.run.test.io
User:           MY_EMAIL@HOST.com
Org:            org-xxx-test
Space:          space-devtest1

```
- create a new file named `manifest.yml` in the project directory
```
---
applications:
- name: test-demo
  memory: 2048m
  instances: 1
  disk_quota: 2048m
  host: test-demo
  domain: xxx.cn
  path: ./target/test-demo-0.1.0.jar
  stack: cflinuxfs2
  buildpack: java_buildpack_new
``` 
- `cf push -f manifest.yml`
-  the `SOME_NAME_YOU_MAKEUP_HERE` is arbitrary; it'll inform the URL that's used to mount the application and as such it shares a shared global (DNS) namespace

### Coverage Report
- Execute `mvn cobertura:cobertura -Dcobertura.report.format=html` at console.
- See the detailed coverage report in the folder of each sub project. The path of the report folder is  `subproject:target/site/`

### Swagger UI
- Reference: [Integrating Swagger into a Spring Boot RESTful Webservice with Springfox](http://www.hascode.com/2015/07/integrating-swagger-into-a-spring-boot-restful-webservice-with-springfox/)
- Access Swagger UI at: http://localhost:8080/swagger-ui.html
- Use @ApiIgnore and @ApiInclude to control what apis are included or ignored. It provides fine grained control over whats included or excluded. It works on a method level.By default everything is marked as included unless it is excluded. 

### Code Style
- Eclipse -> Preferences -> Java -> Code Style -> Formatter -> Import  microservice/eclipse-java-style.xml
- In Eclipse, in the Package Explorer, right-click on the top-level package of the project. Choose Source > Organize Imports, and you're done, for all the files in your project.

### TestNG
- Go to Eclipse -> Help -> Eclipse Marketplace.
- Find "TestNG", and install.