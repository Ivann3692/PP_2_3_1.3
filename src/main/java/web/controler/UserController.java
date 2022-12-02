package web.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import web.service.UserService;

@Controller
//@RequestMapping("/")
public class UserController {

//    @Autowired
//    private UserService userService;

    @GetMapping(value = "/")
    public String showAllUsers(ModelMap model) {
//        List<User> list = userService.getUsers();
//        model.addAttribute("listUsers", list);
        return "index";
    }
}
