package controller;

import model.domain.Fruit;
import model.services.FruitServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruita")
public class FruitController {
    @Autowired
    FruitServices fruitServices;

    @PostMapping("/add")
    public ResponseEntity<Fruit> add(@RequestBody Fruit fruit) {
        try {
            return new ResponseEntity<>(fruitServices.createFruit(fruit), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAll() {
        try {
            List<Fruit> fruits = fruitServices.getAllFruits();

            if (fruits.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(fruits, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit>getOne(@PathVariable("id") ObjectId id){
        Optional<Fruit> optionalFruit = fruitServices.getFruit(id);

        if(optionalFruit.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(optionalFruit.get(),HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Fruit> delete(@PathVariable("id") ObjectId id) {
        try {
            Fruit removedFruit = fruitServices.deleteFruit(id);
            return new ResponseEntity<>(removedFruit,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Fruit>delete(@PathVariable("id")ObjectId id, @RequestBody Fruit fruit){
        Fruit newfruit = fruitServices.updateFruit(id,fruit);
        if(newfruit != null){
            fruitServices.deleteFruit(id);
            return new ResponseEntity<>(newfruit,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}