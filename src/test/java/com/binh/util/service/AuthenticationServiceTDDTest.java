package com.binh.util.service;

import com.binh.util.entity.User;
import com.binh.util.repository.UserRepository;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class AuthenticationServiceTDDTest {

    private UserRepository userRepository;
    private AuthenticationService authService;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        userRepository = mock(UserRepository.class);
        authService = new AuthenticationService(userRepository);
    }

    @Test(groups = {"login"})
//    @Test
    public void testLoginSuccess() {
        when(userRepository.findByUsername("admin"))
                .thenReturn(new User("admin", "1234"));

        boolean result = authService.login("admin", "1234");
        assertTrue(result);
    }

//    @Test
//    @Test(dependsOnMethods = {"testLoginSuccess"}, groups = {"login"})
    @Test(groups ={"login"} )
    public void testLoginWrongPassword() {
        when(userRepository.findByUsername("admin"))
                .thenReturn(new User("admin", "1234"));

        boolean result = authService.login("admin", "wrongpass");
        assertFalse(result);
    }

//    @Test(dependsOnMethods = {"testLoginWrongPassword"}, groups = {"login"})
    @Test(groups ={"login"} )
//    @Test
    public void testLoginUserNotFound() {
        when(userRepository.findByUsername("notfound"))
                .thenReturn(null);

        boolean result = authService.login("notfound", "1234");
        assertFalse(result);
    }

}