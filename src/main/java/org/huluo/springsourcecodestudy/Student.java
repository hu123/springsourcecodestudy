package org.huluo.springsourcecodestudy;

import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean {


    private String username = "zhangsna";
    private String password = "password";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Student类初始化完成咯");
    }
}
