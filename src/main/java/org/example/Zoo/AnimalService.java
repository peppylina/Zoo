package org.example.Zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalService {

    @Autowired
    private AnimalRepo animalRepo;

    public List<Animal> getAllAnimals() {
        return animalRepo.findAll();
    }

    public Animal addNewAnimal(Animal animal) {
        return animalRepo.save(animal);
    }

    public Boolean deleteAnimalById(String id) {
        return animalRepo.deleteAnimalById(id);
    }
}
