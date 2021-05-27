package com.cute.interview.thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子引用
 * @Author liulebin
 * @Date 2021/5/27 21:10
 */
class User {
    String userName;
    int age;

    public User() {
    }

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}

public class AtomicReferenceDemo {

    public static void main(String[] args) {

        User z3 = new User("zhangsan", 18);
        User l4 = new User("lisi", 21);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t user is " + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t user is " + atomicReference.get().toString());
    }
}
