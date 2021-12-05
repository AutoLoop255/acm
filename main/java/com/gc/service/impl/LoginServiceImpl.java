package com.gc.service.impl;

import com.gc.repository.LoginRepository;
import com.gc.repository.impl.LoginRepositoryImpl;
import com.gc.service.LoginService;

public class LoginServiceImpl implements LoginService {

    LoginRepository login = new LoginRepositoryImpl();
    @Override
    public int login(String username, String password, Integer authority) {
        return login.login(username, password, authority);
    }
}
