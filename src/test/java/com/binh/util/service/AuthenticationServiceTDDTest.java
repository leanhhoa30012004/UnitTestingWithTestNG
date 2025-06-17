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
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private AuthenticationService authService;
//
//    @BeforeMethod
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testLoginSuccess() {
//        when(userRepository.findByUsername("admin"))
//                .thenReturn(new User("admin", "admin123"));
//
//        boolean result = authService.login("admin", "admin123");
//        Assert.assertTrue(result);
//    }
//
//    @Test
//    public void testLoginWrongPassword() {
//        when(userRepository.findByUsername("admin"))
//                .thenReturn(new User("admin", "admin123"));
//
//        boolean result = authService.login("admin", "wrongpass");
//        Assert.assertFalse(result);
//    }
//
//    @Test
//    public void testLoginUserNotFound() {
//        when(userRepository.findByUsername("ghost")).thenReturn(null);
//
//        boolean result = authService.login("ghost", "whatever");
//        Assert.assertFalse(result);
//    }

    private UserRepository userRepository;
    private AuthenticationService authService;

    @BeforeMethod
    public void setUp() {
        userRepository = mock(UserRepository.class);
        authService = new AuthenticationService(userRepository);
    }

    @Test
    public void testLoginSuccess() {
        when(userRepository.findByUsername("admin"))
                .thenReturn(new User("admin", "1234"));

        boolean result = authService.login("admin", "1234");
        assertTrue(result);
    }

    @Test
    public void testLoginWrongPassword() {
        when(userRepository.findByUsername("admin"))
                .thenReturn(new User("admin", "1234"));

        boolean result = authService.login("admin", "wrongpass");
        assertFalse(result);
    }

    @Test
    public void testLoginUserNotFound() {
        when(userRepository.findByUsername("notfound"))
                .thenReturn(null);

        boolean result = authService.login("notfound", "1234");
        assertFalse(result);
    }

}