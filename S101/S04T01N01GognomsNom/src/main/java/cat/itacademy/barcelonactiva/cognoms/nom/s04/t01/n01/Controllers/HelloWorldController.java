package cat.itacademy.barcelonactiva.cognoms.nom.s04.t01.n01.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping({"/HelloWorld" ,  "/HelloWorld/{name}"})
    public String getSaluda( @RequestParam(defaultValue = "UNKNOWN") String name){ return "Hello, " + name + " You are executing a Maven project.";    }
    @GetMapping(value = {"/HelloWorld2" , "/HelloWorld2/{name}"})
    public String saluda2(@PathVariable (required = false) String name){ return "Hello, " + name + " You are executing a Maven project.";  }
}
