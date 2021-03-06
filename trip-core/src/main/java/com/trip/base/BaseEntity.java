package com.trip.base;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 基础信息
 */
public class BaseEntity implements Serializable {

    /*@Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}