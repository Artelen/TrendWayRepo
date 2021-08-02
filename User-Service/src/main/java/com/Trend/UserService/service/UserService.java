package com.Trend.UserService.service;

import com.Trend.UserService.entity.User;
import com.Trend.UserService.reporsitory.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final KafkaProducerService kafkaService;

    public UserService(UserRepository userRepository, KafkaProducerService kafkaService) {
        this.userRepository = userRepository;
        this.kafkaService = kafkaService;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Entity with id: %s does not exists.", id)
        ));
    }

    public User findByEmail(String email)
    {
        return this.userRepository.findByEmail(email);
    }

    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail()))
            throw new RuntimeException("Email has already taken.");
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
        kafkaService.sendMessage(id.toString(),"deleteUser");
    }

    public User updateUser(User user) {
        Long userId = user.getId();
        this.findById(userId);
        return userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
