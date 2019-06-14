package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.demo.forms.ProductForm;
import ru.itis.demo.models.Order;
import ru.itis.demo.models.Product;
import ru.itis.demo.models.User;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.OrderService;
import ru.itis.demo.services.ProductService;

@Controller
public class ProductsController {

    private final OrderService orderService;

    private final ProductService productService;

    @Autowired
    public ProductsController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProductsPage(Authentication authentication, ModelMap model) {
        if (authentication != null) {
            model.addAttribute("header", true);
        }
        return "products";
    }

//    @PostMapping(value = "products", params = "redirect")
//    public String addOrder(Authentication authentication) {
//        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
//        User user = details.getUser();
//        for (Product product : user.getCart().getProducts()) {
//            Order order = Order.builder()
//                    .user(user)
//                    .productId(product.getId())
//                    .status("Delievering")
//                    .build();
//            orderService.addOrder(order);
//        }
//        return "orders";
//    }
}
