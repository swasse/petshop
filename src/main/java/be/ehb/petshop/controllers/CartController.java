package be.ehb.petshop.controllers;

import be.ehb.petshop.model.CartSingleton;
import be.ehb.petshop.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CartController {

    @RequestMapping(value = "/cart" , method = RequestMethod.GET)
    public String showCart(ModelMap map){
        map.addAttribute("cart",CartSingleton.INSTANCE.getCart());
        map.addAttribute("total", CartSingleton.INSTANCE.getTotal());
        map.addAttribute("user", new User());
        return "cart";
    }

    @RequestMapping(value = "/cart" , method = RequestMethod.POST)
    public String confirmCart(ModelMap map, @Valid User user, BindingResult result){
        map.addAttribute("cart",CartSingleton.INSTANCE.getCart());
        map.addAttribute("total", CartSingleton.INSTANCE.getTotal());
        map.addAttribute("user", user);

        if(result.hasErrors()){
            return "cart";
        }

        return "confirmation";
    }
}
