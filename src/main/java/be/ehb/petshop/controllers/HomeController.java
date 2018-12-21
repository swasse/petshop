package be.ehb.petshop.controllers;

import be.ehb.petshop.model.CartSingleton;
import be.ehb.petshop.model.TJProduct;
import be.ehb.petshop.model.TJProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private final TJProductDAO productDAO;

    @Autowired
    public HomeController(TJProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @RequestMapping(value = {"/", "/index"} , method = RequestMethod.GET)
    public String showHome(ModelMap map){
        map.addAttribute("all",productDAO.findAll());
        return "home";
    }

    @RequestMapping(value = {"/{cat}", "/index/{cat}"} , method = RequestMethod.GET)
    public String showByCategory(ModelMap map, @PathVariable(name = "cat") String cat){
        map.addAttribute("all",productDAO.findAllByCategory(cat));
        return "home";
    }

    @RequestMapping(value = {"/add/{id}", "/index/add/{id}"} , method = RequestMethod.GET)
    public String addToCart(ModelMap map, @PathVariable(name = "id") int id){
        TJProduct prod = productDAO.findById(id).get();
        CartSingleton.INSTANCE.addToCart(prod);

        return "redirect:/index";
    }

}
