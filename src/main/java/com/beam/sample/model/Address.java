package com.beam.sample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by x0r on 14/05/16.
 */
@Accessors(chain = true)
@Getter
@Setter
public class Address extends BaseModel {

    private String street;

    private String city;

}
