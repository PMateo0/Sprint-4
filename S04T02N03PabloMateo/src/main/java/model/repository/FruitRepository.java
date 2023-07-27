package model.repository;

import model.domain.Fruit;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitRepository extends MongoRepository <Fruit, ObjectId> {
}
