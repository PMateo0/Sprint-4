package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.domain.Fruit;

import java.util.*;

public interface IFruitServices {
    Fruit createFruit (Fruit fruit);
    Fruit updateFruit (int id, Fruit fruit);
    Fruit deleteFruit (int id);
    Optional<Fruit> getFruit (int id);
    List<Fruit> getAllFruits ();

}