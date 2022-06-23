package org.example.Zoo.service;

import org.example.Zoo.model.Animal;
import org.example.Zoo.repo.AnimalRepo;
import org.example.Zoo.service.ZooService;
import org.example.Zoo.utils.ProfileConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile(ProfileConstants.SUMMER)
public class SummerZooService implements ZooService {

    @Autowired
    private AnimalRepo animalRepo;

    @Override
    public void refresh() {
        List<Animal> all = animalRepo.findAll();
        all.forEach(animal -> {
            animal.setSleeping(false);
            animalRepo.save(animal);
        });
    }

}
