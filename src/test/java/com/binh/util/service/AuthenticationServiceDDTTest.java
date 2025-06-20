package com.binh.util.service;

import com.binh.util.entity.User;
import com.binh.util.repository.UserRepository;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class AuthenticationServiceDDTTest {

    private UserRepository userRepository;
    private AuthenticationService authService;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        userRepository = mock(UserRepository.class);
        authService = new AuthenticationService(userRepository);
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"admin", "1234", true},
                {"admin", "wrong", false},
                {"guest", "1234", false}
        };
    }

    @Test(dataProvider = "loginData", groups = {"login"})
    public void testLoginDDT(String username, String password, boolean expected) {
        when(userRepository.findByUsername("admin"))
                .thenReturn(new User("admin", "1234"));
        when(userRepository.findByUsername("guest"))
                .thenReturn(null);

        boolean result = authService.login(username, password);
        assertEquals(result, expected, "Failed on: " + username + "/" + password);
    }
}
