package top.yms.server.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class HelloController {

    @GetMapping("/getuser")
    public User getUser() {
        User user = new User("yms","123456");
        return user;
    }
}