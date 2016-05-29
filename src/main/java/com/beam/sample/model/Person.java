package com.beam.sample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by x0r on 14/05/16.
 */
@Accessors(chain = true)
@Document(collection = "Person")
@TypeAlias("doktor")
public class Person extends BaseModel {

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private Address address;


}
