package com.yang.bean;

/**
 * @ProjectName: com.yang.bean
 * @author: ZhangBiBo
 * @description: 测试动态sql的JavaBean
 * @data: 2021/12/25
 */
public class Account {
    private Integer id;
    private String username;
    private String money;

    public Account() {
    }

    public Account(Integer id, String username, String money) {
        this.id = id;
        this.username = username;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
