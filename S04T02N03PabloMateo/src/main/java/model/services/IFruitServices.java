package model.services;

import model.domain.Fruit;
import org.bson.types.ObjectId;

import java.util.*;

public interface IFruitServices {
    Fruit createFruit (Fruit fruit);
    Fruit updateFruit (ObjectId id, Fruit fruit);
    Fruit deleteFruit (ObjectId id);
    Optional<Fruit> getFruit (ObjectId id);
    List<Fruit> getAllFruits ();

}