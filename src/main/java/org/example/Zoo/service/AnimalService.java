package org.example.Zoo.service;

import org.example.Zoo.model.Animal;
import org.example.Zoo.repo.AnimalRepo;
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
