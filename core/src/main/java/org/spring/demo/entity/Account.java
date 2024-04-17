package org.spring.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * 用户实体
 *
 * @author bigbangz.github.io
 * @date 2024/4/3 15:48
 */
@Data
@AllArgsConstructor
public class Account extends BaseEntity {

    @NotEmpty(message = "用户不允许为空")
    private String username;

    // 密码字段不参与序列化（但反序列化是参与的）、不参与更新（但插入是参与的）
    // 这意味着密码字段不会在获取对象（很多操作都会关联用户对象）的时候泄漏出去；
    // 也意味着此时“修改密码”一类的功能无法以用户对象资源的接口来处理（因为更新对象时密码不会被更新），需要单独提供接口去完成
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @Column(updatable = false)
    private String password;

    @NotEmpty(message = "用户姓名不允许为空")
    private String name;

    private String avatar;

    @Pattern(regexp = "1\\d{10}", message = "手机号格式不正确")
    private String telephone;

    @Email(message = "邮箱格式不正确")
    private String email;

    private String location;

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(username, account.username) && Objects.equals(telephone, account.telephone) && Objects.equals(email, account.email);
    }

}
