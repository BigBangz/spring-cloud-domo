package modules.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 模拟用户类
 * @Data相当于同时使用了@ToString、@EqualsAndHashCode、@Getter、@Setter和@RequiredArgsConstrutor
 */
@Data
@AllArgsConstructor
public class User {
    private long id;
    private String email;
    private String password;
    private String name;

}
