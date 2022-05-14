package org.example.Zoo;

import org.example.ZooStarter.SeasonConfigurator;
import org.example.ZooStarter.ZooProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ZooConfiguration {

    @Autowired
    private AnimalRepo animalRepo;

    @Autowired
    private ZooProperties zooProperties;

    @Autowired
    private ApplicationContext appContext;

    @Bean
    public SeasonConfigurator seasonConfigurator() {
        return new SeasonConfigurator() {
            @Override
            public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
                List<String> activeProfiles = Arrays.stream(appContext.getEnvironment().getActiveProfiles()).collect(Collectors.toList());
                if (activeProfiles.contains(ProfileConstants.SUMMER)) {
                    List<Animal> animals = animalRepo.findAllByIsSleeping(true);
                    animals.forEach(animal -> {
                        animal.setSleeping(false);
                        animalRepo.save(animal);
                    });
                }
                else if (activeProfiles.contains(ProfileConstants.WINTER)) {
                    List<Animal> animals = animalRepo.findAll();
                    List<String> asleepInWinter = zooProperties.getAnimals().getAsleepInWinter();
                    animals.forEach(animal -> {
                        animal.setSleeping(asleepInWinter.contains(animal.getType().name()));
                        animalRepo.save(animal);
                    });
                }
            }
        };
    }

}
