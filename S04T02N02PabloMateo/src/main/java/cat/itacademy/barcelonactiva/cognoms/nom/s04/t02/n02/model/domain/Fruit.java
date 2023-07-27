package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.domain;

import jakarta.persistence.*;
    @Entity
    @Table(name="fruits")
    public class Fruit {
        @Id
        @GeneratedValue
        private int id;

        @Column(name = "name")
        private String name;
        @Column(name="quantity")
        private int quantityKilo;

        public Fruit ( int id, String name, int quantityKilo){
            this.id = id;
            this.name = name;
            this.quantityKilo = quantityKilo;
        }

        public Fruit(){}

        public int getId() {
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


