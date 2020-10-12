package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Cart;
import vn.codegym.model.FlowerProducts;
import vn.codegym.service.ProductService;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("cart")
public class CartController {
    @Autowired
    ProductService productService;

    @GetMapping
    public String getCartPage(HttpSession session){
        Map<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        return "cart/list";
    }

    @PostMapping("add")
    public String getCartPage(@RequestParam("id") long productId, HttpSession session) {
        Map<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        FlowerProducts product = productService.findById(productId);
        if (product != null) {
            if (cartItems.containsKey(productId)) {
                Cart item = cartItems.get(productId);
                item.setProduct(product);
                item.setQuantity(item.getQuantity() + 1);
                cartItems.put(productId, item);
            } else {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(productId, item);
            }
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        return "cart/list";
    }

    public double totalPrice(Map<Long, Cart> cartItems) {
        long count = 0;
        for (Map.Entry<Long, Cart> list : cartItems.entrySet()) {
            count += list.getValue().getProduct().getPrice() * (100-list.getValue().getProduct().getDiscount())
                    /100 * list.getValue().getQuantity();
        }
        return count;
    }

    @GetMapping(value = "remove/{id}")
    public String viewRemove(ModelMap modelMap, HttpSession session, @PathVariable("id") long productId) {
        Map<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        if (cartItems.containsKey(productId)) {
            cartItems.remove(productId);
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        return "cart/list";
    }

    @GetMapping("update/{id}")
    public ModelAndView updateCart(@PathVariable("id") long id, Cart editItem, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("redirect:/cart");
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if(cartItems == null) {
            cartItems = new HashMap<>();
        }
        FlowerProducts product = productService.findById(id);
        if(cartItems.containsKey(id)){
            Cart item = cartItems.get(id);
            item.setProduct(product);
            item.setQuantity(editItem.getQuantity());
            cartItems.put(id, item);
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotalAmount", totalPrice(cartItems));
        session.setAttribute("myCartNumber", cartItems.size());

        return modelAndView;

    }

}
