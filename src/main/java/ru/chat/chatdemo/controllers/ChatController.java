package ru.chat.chatdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.chat.chatdemo.model.Chat;
import ru.chat.chatdemo.model.Message;
import ru.chat.chatdemo.model.User;
import ru.chat.chatdemo.service.ChatServiceImpl;
import ru.chat.chatdemo.service.MessageServiceImpl;
import ru.chat.chatdemo.service.UserMapperServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by alexpench on 18.02.17.
 */
@Controller
@RequestMapping
public class ChatController {
    @Autowired
    private ChatServiceImpl ChatService;

    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private UserMapperServiceImpl userMapperService;

    @RequestMapping(value = "messages", method = RequestMethod.POST)
    public String load(@RequestParam(value = "ownerId", required = true) Long ownerId,
                       @RequestParam(value = "userId", required = true) Long userId,
                       Model model) {
        Long[] users = {ownerId, userId};
        Chat chat = ChatService.addChat(users);
        List<Message> messages = messageService.getMessagesForChat(chat);
        model.addAttribute("chatId", chat.getId());
        model.addAttribute("messages", messages);
        return "messages :: messagesList";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void save(@RequestBody Message message, HttpServletResponse response){
        messageService.save(message);
        response.setStatus(200);
    }

    @RequestMapping(value = "activeusers", method = RequestMethod.POST)
    @ResponseBody
    public List<User> getActiveUsers(@RequestBody User user, HttpServletResponse response){
        List<User> users = userMapperService.getAllActiveUsers();
        users.remove(userMapperService.findOne(user.getId()));
        return users;
    }

    @RequestMapping(value = "setnotactive", method = RequestMethod.POST)
    public void updateStatus(@RequestBody User user, HttpServletResponse response){
        userMapperService.updateStatus(user);
        response.setStatus(200);
    }
}
