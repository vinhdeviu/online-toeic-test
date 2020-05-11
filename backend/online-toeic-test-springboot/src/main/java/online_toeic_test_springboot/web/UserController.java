//package online_toeic_test_springboot.web;
//
//import lombok.RequiredArgsConstructor;
//import online_toeic_test_springboot.domain.TestInfor;
//import online_toeic_test_springboot.domain.User;
//import online_toeic_test_springboot.service.PartOutput;
//import online_toeic_test_springboot.service.ToeicTestService;
//import online_toeic_test_springboot.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Validated
//@RestController
//@RequestMapping("/api")
//@RequiredArgsConstructor
//@CrossOrigin
//public class UserController {
//
//  @Autowired
//  private final UserService userService;
//
//  @RequestMapping(value = "/user", method = RequestMethod.GET)
//  public List<User> listUser() {
//    return userService.findAll();
//  }
//
//  @RequestMapping(value = "/user", method = RequestMethod.POST)
//  public User create(@RequestBody User user) {
//    return userService.save(user);
//  }
//
//  @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//  public String delete(@PathVariable(value = "id") int id) {
//    userService.delete(id);
//    return "success";
//  }
//}
