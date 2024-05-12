package top.newhand.shopcommon.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author hexg8236
 * @className User
 * @Since 2024/5/12 19:38
 * @description 用户实体类
 **/
@Entity(name = "shop_user")
@Data
public class User {
    // 主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 手机号
    private String telephone;
}
