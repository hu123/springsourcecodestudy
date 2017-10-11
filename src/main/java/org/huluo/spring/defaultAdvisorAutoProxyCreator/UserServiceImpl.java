package org.huluo.spring.defaultAdvisorAutoProxyCreator;

public class UserServiceImpl implements UserService {
    public void print() {
        System.out.println(getClass() + "#print");
    }

    @Override
    public void println() {
        System.out.println(getClass() + "#println()");
    }
}