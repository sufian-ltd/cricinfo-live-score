package com.cricinfo.core.domain;

import com.cricinfo.core.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class User extends BaseEntity {

    private String username;

    @JsonIgnore
    private String password;

}