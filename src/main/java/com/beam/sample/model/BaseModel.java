package com.beam.sample.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.domain.Persistable;

import java.util.Date;

/**
 * Created by x0r on 14/05/16.
 */
public class BaseModel implements Persistable<String> {

    @Id
    @Getter
    @Setter
    private String id;

    @CreatedDate
    @Getter
    @Setter
    private Date created;

    @LastModifiedDate
    @Getter
    @Setter
    private Date lastModified;

    @Version
    @Getter
    @Setter
    private Long version;

    @Transient
    @Setter
    private boolean isNew = false;


    public boolean isNew() {
        return isNew;
    }

    @Override
    public boolean equals(Object obj) {
        BaseModel bm = (BaseModel) obj;

        return getId().equals(bm.getId());
    }
}
