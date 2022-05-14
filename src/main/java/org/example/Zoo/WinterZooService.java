package org.example.Zoo;

import lombok.extern.slf4j.Slf4j;
import org.example.ZooStarter.ZooProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile(ProfileConstants.WINTER)
@Slf4j
public class WinterZooService implements ZooService {

    @Autowired
    private ZooProperties zooProperties;

    @Autowired
    private AnimalRepo animalRepo;

    @Override
    public void refresh() {
        List<Animal> all = animalRepo.findAll();
        all.forEach(animal -> {
            animal.setSleeping(zooProperties.getAnimals().getAsleepInWinter().contains(animal.getType().name()));
            animalRepo.save(animal);
        });
    }
}
