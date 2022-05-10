package jeff.demo.api;

import jeff.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserControl {

    @GetMapping("/login")
    @ResponseBody
    public User toLogin(){
        User user = new User(1, "jeff", "spl123");
        return user;
    }
}
