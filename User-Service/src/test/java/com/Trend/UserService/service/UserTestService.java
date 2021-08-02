package com.Trend.UserService.service;

import com.Trend.UserService.entity.User;
import com.Trend.UserService.reporsitory.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTestService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    void findByEmail() {
        //Given
        User user=new User("Talha Toprak", "t@t.com");

        User userToDelete= userRepository.findByEmail(user.getEmail());
        if(userToDelete!=null)
            userRepository.deleteById(userToDelete.getId());

        userRepository.save(user);

        //When
        User user1 = userRepository.findByEmail(user.getEmail());

        //Then
        assertEquals("t@t.com", user1.getEmail());
    }

    @Test
    void findById() {
        //Given
        User user=new User("Talha Toprak", "t@t.com");

        User userToDelete= userRepository.findByEmail(user.getEmail());
        if(userToDelete!=null)
            userRepository.deleteById(userToDelete.getId());
        userRepository.save(user);



        //When
        User user1 = userRepository.findById(user.getId()).orElse(null);

        //Then
        assertEquals("Talha Toprak", user1.getFullName());
    }
    @Test
    void createUser() {
        //Given
        User user = new User("Yavuz Bilgin", "y2@y.com");
        //Make sure there is no user like "user"
        User userToDelete= userRepository.findByEmail(user.getEmail());
        if(userToDelete!=null)
            userRepository.deleteById(userToDelete.getId());
        //When
        User savedUser = userService.createUser(user);
        User foundUser = userRepository.findById(savedUser.getId()).orElseThrow();

        //Then
        assertEquals(savedUser.getEmail(), foundUser.getEmail());
    }

    @Test
    void deleteById() {
        //Given
        User user = new User("Ahmet Bilgin", "a@b.com");
        User savedUser = userRepository.save(user);
        Long savedUserId = savedUser.getId();

        //When
        userService.deleteById(savedUserId);

        //Then
        Optional<User> foundUser = userRepository.findById(savedUserId);
        assertTrue(foundUser.isEmpty());
    }

    @Test
    void updateUser() {
        //Given
        User user = new User("Ayse Oz", "a@o.com");
        User savedUser = userRepository.save(user);

        //When
        String newEmail = "new@mail.com";
        savedUser.setEmail(newEmail);
        User updatedUser = userService.updateUser(savedUser);

        //Then
        assertEquals(newEmail, updatedUser.getEmail());
    }

    @Test
    void ensureUserMailUniqueness()
    {
        User user = new User("Yavuz Bilgin", "y2@y.com");
        User user2 = new User("Yavuz Bilgin2", "y2@y.com");

        User userToDelete= userRepository.findByEmail(user.getEmail());
        if(userToDelete!=null)
            userRepository.deleteById(userToDelete.getId());
        //When
        User savedUser = userService.createUser(user);
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                userService.createUser(user2) //second time
        );
        //Then
        assertEquals("Email has already taken.", exception.getMessage());

    }

}
