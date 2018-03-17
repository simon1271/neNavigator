package com.huawei.rtn.testtool.web;

import com.huawei.rtn.testtool.domain.User;
import com.huawei.rtn.testtool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        List<User> users = userService.findAll();
        model.put("users", users);
        return "home";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String submit(User user) {
        userService.save(user);
        return "redirect:/";
    }
}
