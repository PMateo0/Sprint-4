package cat.itacademy.barcelonactiva.cognoms.nom.s04.t01.n02.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;
@RestController
public class HelloWorldController {

    @GetMapping({"/HelloWorld"})
    String saluda (@RequestParam(defaultValue = "UNKNOWN")String name){
        return "Hello, " + name + " You are executing a Gradle project.";
    }
    @GetMapping(value = {"/HelloWorld2" , "/HelloWorld2/{name}"})
    String saluda2(@PathVariable (required = false)String name){
        return "Hello, " + name + " You are executing a Gradle project.";
    }
}
