package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.demo.models.*;
import ru.itis.demo.repositories.CartsRepository;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.OrderService;
import ru.itis.demo.services.ProductService;

import java.util.List;

@Controller
public class ProductsController {

    private final OrderService orderService;
    private final ProductService productService;

    private final CartsRepository cartsRepository;

    @Autowired
    public ProductsController(OrderService orderService, CartsRepository cartsRepository, ProductService productService) {
        this.orderService = orderService;
        this.cartsRepository = cartsRepository;
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProductsPage(Authentication authentication, ModelMap modelMap) {
        if (authentication != null) {
            if(authentication.getAuthorities().contains(new SimpleGrantedAuthority(Role.ADMIN.name()))){
                modelMap.addAttribute("admin", true);
            }
            modelMap.addAttribute("header", true);
        }
        return "products";
    }

    @PostMapping("/products")
    public String addOrder(Authentication authentication) {
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        User user = details.getUser();
        Cart cart = cartsRepository.findCartById(user.getCart().getId()).get();
        List<Product> productList = cart.getProducts();
            for (Product product : productList) {
                Order order = Order.builder()
                        .user(user)
                        .amount(productService.getAmount(user.getCart().getId(),product.getName()))
                        .productId(product.getId())
                        .status("Delievering")
                        .build();
                orderService.addOrder(order);
            }
            user.getCart().getProducts().clear();
            productService.deleteProductsFromCart(user.getCart().getId());
            return "redirect:/profile";
    }
}
