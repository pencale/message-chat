package ru.chat.chatdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.chat.chatdemo.model.User;
import ru.chat.chatdemo.service.UserMapperServiceImpl;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by alexpench on 16.02.17.
 */
@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UserMapperServiceImpl userMapperService;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping(path = "chat", method = RequestMethod.POST)
    public String login(@RequestParam(value = "name", required = true) String name,
                        @RequestParam(value = "email", required = true) String email,
                        @RequestParam(value = "avatar", required = true) String avatar,
                        Model model) {
        User chatOwner = userMapperService.add(new User(name,email,avatar));
        model.addAttribute("chatOwner", chatOwner);
        return "chat";
    }
}
