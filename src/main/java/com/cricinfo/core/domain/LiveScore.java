package com.cricinfo.core.domain;

import com.cricinfo.core.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ToString
public class LiveScore extends BaseEntity {

    private String title;
    private String link;
    private String description;
    private String guid;
}