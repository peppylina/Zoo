package org.example.Zoo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Animal {

    private boolean isSleeping;

    private String name;

    @Id
    private String id;

    private AnimalType type;

}
