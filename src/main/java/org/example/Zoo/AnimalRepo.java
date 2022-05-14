package org.example.Zoo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnimalRepo extends MongoRepository<Animal, String> {

    List<Animal> findAllByIsSleeping(boolean isSleeping);

    Boolean deleteAnimalById(String id);

}
