package org.spring.demo.entity;

import java.io.Serializable;

/**
 * JavaBean领域对象的共同基类，定义了ID属性和其访问字段
 *
 * @author bigbangz.github.io
 * @date 2024/4/16 15:47
 **/
public class BaseEntity implements Serializable {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
