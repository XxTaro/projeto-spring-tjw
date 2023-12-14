package br.gustavo.lopes.MySpringApp.controller;

import br.gustavo.lopes.MySpringApp.model.User;
import br.gustavo.lopes.MySpringApp.service.impl.StockServiceImpl;
import br.gustavo.lopes.MySpringApp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    StockServiceImpl stockService;

    @GetMapping("/create")
    public String createHome() {
        return "user/create";
    }

    @GetMapping("/list")
    public String listHome(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.findAll());
        return "user/list";
    }

    @PostMapping("/create")
    public String create(User user) {
        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        stockService.findAllByUserId(id).forEach(stock -> stockService.delete(stock.getId()));
        userService.delete(id);
        return "redirect:/user/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.findById(id));
        return "user/edit";
    }

    @PostMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/user/list";
    }

}
