package online_toeic_test_springboot.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private Integer id;
    private String email;
    private String name;
    private Integer role;
    private String password;
    private String confirmPassword;
}
