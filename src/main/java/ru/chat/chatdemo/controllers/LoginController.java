package ru.chat.chatdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.chat.chatdemo.model.User;
import ru.chat.chatdemo.service.UserMapperServiceImpl;

import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(path = "chat", method = RequestMethod.GET)
    public String login(@RequestParam(value = "name", required = true) String name, Model model) {
        User chatOwner = userMapperService.add(name);
        model.addAttribute("chatOwner", chatOwner);
        return "chat";
    }
}
