package online_toeic_test_springboot.controller;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.HttpMethod;
import online_toeic_test_springboot.domain.model.User;
import online_toeic_test_springboot.service.UserService;
import online_toeic_test_springboot.validation.RequestBodyValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    @Autowired
    private final UserService userService;

    private final RequestBodyValidation requestBodyValidation;

    @GetMapping("/examinees")
    public ResponseEntity<List<User>> getExaminees() {
        return ResponseEntity.ok().body(userService.getAllExaminees());
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUsersById(@PathVariable Integer userId) {
        return ResponseEntity.ok().body(userService.getUserById(userId));
    }

    @PostMapping("/admin-login")
    public ResponseEntity<User> adminLogin(@RequestBody User user) {
        requestBodyValidation.validateToLogin(user);
        return ResponseEntity.ok().body(userService.adminLogin(user));
    }

    @PostMapping("/examinee-login")
    public ResponseEntity<User> examineeLogin(@RequestBody User user) {
        requestBodyValidation.validateToLogin(user);
        return ResponseEntity.ok().body(userService.examineeLogin(user));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) throws URISyntaxException {
        requestBodyValidation.validateUser(user, HttpMethod.POST);
        userService.register(user);
        return ResponseEntity.created(new URI("/api/register")).body(user);
    }

    @PutMapping("/edit-profile/{userId}")
    public ResponseEntity<User> editProfile(@PathVariable Integer userId, @RequestBody User user) {
        user.setId(userId);
        requestBodyValidation.validateUser(user, HttpMethod.PUT);
        userService.updateUser(user);
        return ResponseEntity.ok().body(user);
    }
}
