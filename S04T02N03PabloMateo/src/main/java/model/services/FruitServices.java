package model.services;

import model.domain.Fruit;
import model.repository.FruitRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FruitServices implements IFruitServices {
    @Autowired
    private FruitRepository fruitRepository;
    @Override
    public Fruit createFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }
    @Override
    public Optional <Fruit> getFruit(ObjectId id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);

        return fruitOptional;
    }
    @Override
    public List<Fruit> getAllFruits() {

        return fruitRepository.findAll();
    }
    @Override
    public Fruit updateFruit (ObjectId id, Fruit fruit) {
        Optional<Fruit> fruitData = fruitRepository.findById(id);
        Fruit myFruit = null;

        if (fruitData.isPresent()) {
            myFruit = fruitData.get();
            myFruit.setName(fruit.getName());
            myFruit.setQuantityKilo(fruit.getQuantityKilo());
        }
        return myFruit;
    }
    @Override
    public Fruit deleteFruit(ObjectId id) {
        Fruit deletedFruit =  fruitRepository.findById(id).get();
        fruitRepository.deleteById(id);
        return deletedFruit;
    }
}
