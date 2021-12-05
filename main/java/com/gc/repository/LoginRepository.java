package com.gc.repository;

public interface LoginRepository {
    int login(String username, String password, Integer authority);


}
