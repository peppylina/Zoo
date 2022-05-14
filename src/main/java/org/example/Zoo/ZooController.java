package org.example.Zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ZooController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private ZooService zooService;

    @GetMapping("/all")
    public ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> allAnimals = animalService.getAllAnimals();
        return ResponseEntity.ok(allAnimals);
    }

    @PostMapping("/animal")
    public ResponseEntity<Animal> addNewAnimal(@RequestBody Animal animal) {
        Animal newAnimal = animalService.addNewAnimal(animal);
        return ResponseEntity.ok(newAnimal);
    }

    @DeleteMapping("/animal/{id}")
    public ResponseEntity<Boolean> deleteAnimal(@PathVariable String id) {
        Boolean deleted = animalService.deleteAnimalById(id);
        return ResponseEntity.ok(deleted);
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refreshInfo() {
        zooService.refresh();
        return ResponseEntity.ok().build();
    }

}
