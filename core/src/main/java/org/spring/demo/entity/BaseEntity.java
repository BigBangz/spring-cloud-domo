package org.spring.demo.entity;

import org.spring.demo.annotation.validation.group.AddGroup;
import org.spring.demo.annotation.validation.group.UpdateGroup;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * JavaBean领域对象的共同基类，定义了ID属性和其访问字段
 *
 * @author bigbangz.github.io
 * @date 2024/4/16 15:47
 **/
public class BaseEntity implements Serializable {

    //添加分组信息：添加的时候不能有id，修改的时候却一定要有id
    @Null(message = "id should be empty", groups = {AddGroup.class})
    @NotNull(message = "id should not be empty", groups = {UpdateGroup.class})
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
