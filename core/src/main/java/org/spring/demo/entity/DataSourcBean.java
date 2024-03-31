package org.spring.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 模拟数据库
 */
@Data
@AllArgsConstructor
public class DataSourcBean {
    private String username;
    private String password;
    private String port;
}
