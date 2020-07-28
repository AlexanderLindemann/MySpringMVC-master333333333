package ru.alexander.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexander.springmvc.model.Role;
import ru.alexander.springmvc.model.User;
import ru.alexander.springmvc.service.UserService;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public String userController(Model model) {
        List<User> list = userService.listUsers();
        model.addAttribute("list", list);
        return "first/users";
    }

    @GetMapping("/addUser")
    public String getAllUsers(Model model) {
        model.addAttribute("newUser", new User());
        List<User> list = userService.listUsers();
        model.addAttribute("users", list);
        return "first/addPerson";
    }

    @PostMapping("/addUser")
    public String savePerson(Model model, User user) {
        String name = user.getName();
        String password = user.getPassword();
        Set<Role> setRole = new HashSet<>();
        Role role = new Role(1l,"ROLE_USER");
        setRole.add(role);

        User newUser = new User(name, password, Collections.singleton(role));
        userService.add(newUser);
        return "redirect:/admin/users";

    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "first/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.update(user);
//        serviceInterface.add(user);
        return "redirect:/admin/users";
    }
}

