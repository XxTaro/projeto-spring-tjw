package br.gustavo.lopes.MySpringApp.controller;

import br.gustavo.lopes.MySpringApp.model.Stock;
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
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockServiceImpl stockService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/add/{id}")
    public String createHome(@PathVariable("id") long id, ModelMap modelMap) {
        modelMap.addAttribute("cur_user", userService.findById(id));
        modelMap.addAttribute("stock", new Stock());
        return "stock/create";
    }

    @GetMapping("/list")
    public String listHome(ModelMap modelMap) {
        modelMap.addAttribute("stocks", stockService.findAll());
        return "stock/list";
    }

    @PostMapping("/add/{id}")
    public String create(@PathVariable("id") long id, Stock stock) {
        stock.setUser(userService.findById(id));
        stock.setId(null);
        stockService.save(stock);
        return "redirect:/stock/list/"+stock.getUser().getId();
    }

    @GetMapping("/list/{id}")
    public String listByUserId(@PathVariable("id") long id, ModelMap modelMap) {
        modelMap.addAttribute("stocks", stockService.findAllByUserId(id));
        return "stock/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        Stock stockDb = stockService.findById(id);
        stockService.delete(id);
        return "redirect:/stock/list/"+stockDb.getUser().getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, ModelMap modelMap) {
        Stock stock = stockService.findById(id);
        modelMap.addAttribute("stock", stock);
        modelMap.addAttribute("cur_user", stock.getUser());
        return "stock/edit";
    }

    @PostMapping("/edit")
    public String edit(Stock stock) {
        Stock stockDb = stockService.findById(stock.getId());
        stock.setUser(stockDb.getUser());
        stockService.edit(stock);
        return "redirect:/stock/list/"+stock.getUser().getId();
    }

}
