package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FruitServices implements IFruitServices {
    @Autowired
    private FruitRepository fruitRepository;

    public Fruit createFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public Optional <Fruit> getFruit(int id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);

        return fruitOptional;
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Fruit updateFruit (int id, Fruit fruit) {
        Optional<Fruit> fruitData = fruitRepository.findById(id);
        Fruit myFruit = null;

        if (fruitData.isPresent()) {
            myFruit = fruitData.get();
            myFruit.setName(fruit.getName());
            myFruit.setQuantityKilo(fruit.getQuantityKilo());
        }
        return myFruit;
    }

    public Fruit deleteFruit(int id) {
       Fruit deletedFruit =  fruitRepository.findById(id).get();
       fruitRepository.deleteById(id);
        return deletedFruit;
    }
}
