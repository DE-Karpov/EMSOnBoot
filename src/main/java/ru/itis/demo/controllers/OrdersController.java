package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.demo.models.Order;
import ru.itis.demo.models.Product;
import ru.itis.demo.models.Role;
import ru.itis.demo.models.User;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.OrderService;
import ru.itis.demo.services.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrdersController {

    private final OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String getOrdersPage(Authentication authentication, ModelMap modelMap) {
        if (authentication == null) {
            return "redirect:/login";
        } else {
            if(authentication.getAuthorities().contains(new SimpleGrantedAuthority(Role.ADMIN.name()))) {
                modelMap.addAttribute("admin", true);
            }
            UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
            User user = details.getUser();
            List<Product> orders = orderService.findOrders(user.getId());
            Map<String,Long> order = new HashMap<>();
            String name;
            for(Product product : orders){
                name = product.getName();
                order.put(name,orderService.getAmount(user.getId(),product.getId()));
            }
            modelMap.addAttribute("ordersFromServer", order);
            return "orders";
        }
    }
}
