package hector.tang.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * create table user (
 * id int(11) not null auto_increment,
 * username varchar(32) not null comment '用户名称',
 * birthday datetime default null comment '生日',
 * sex char(1) default null comment '性别',
 * address varchar(256) default null comment '地址',
 * primary key (id)
 * )engine=InnoDB default charset=utf8;
 * 当数据库定义的字段名称和pojo类的属性名称不一致时，如果要使用查询返回结果集封装到pojo对象需要使用映射的方式进行配置
 *
 * 在为进行映射时userName是可以封装进user对象中的，因为在windows下mysql对大小写不敏感，所以mysql中的username字段可以和
 * java 中的userName进行匹配
 */
public class User implements Serializable {
    private int id;

    private String username;

    private Date birthday;

    private String sex;

    private String address;

    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
