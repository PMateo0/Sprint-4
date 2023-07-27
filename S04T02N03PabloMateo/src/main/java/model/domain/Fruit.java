package model.domain;

import jakarta.persistence.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Entity
@NamedQueries({
        @NamedQuery(name = "Fruit.updateBy", query = "update Fruit f set ")
})
@Document(collection = "Fruit")
public class Fruit {
    @Id
    private ObjectId id;

   @Field(name ="name ")
    private String name;
    @Field(name="quantity")
    private int quantityKilo;

    public Fruit ( ObjectId id, String name, int quantityKilo){
        this.id = id;
        this.name = name;
        this.quantityKilo = quantityKilo;
    }

    public Fruit(){}

    public ObjectId getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityKilo() {
        return quantityKilo;
    }

    public void setQuantityKilo(int quantityKilo) {
        this.quantityKilo = quantityKilo;
    }
}


