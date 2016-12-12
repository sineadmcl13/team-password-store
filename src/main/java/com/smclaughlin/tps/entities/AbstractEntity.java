package com.smclaughlin.tps.entities;

import com.smclaughlin.tps.utils.UUIDGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by sineadmclaughlin on 12/12/2016.
 */
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected String uuid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public AbstractEntity() {
        this.id = null;
        this.uuid = UUIDGenerator.randomUUID().toString();
    }

}
