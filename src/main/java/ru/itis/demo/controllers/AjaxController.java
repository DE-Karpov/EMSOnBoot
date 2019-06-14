package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.demo.forms.ProductForm;
import ru.itis.demo.models.Product;
import ru.itis.demo.models.User;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.ProductService;
import ru.itis.demo.services.UserService;

import java.util.Optional;

@RestController
public class AjaxController {

    private final ProductService productService;

    private final UserService userService;

    @Autowired
    public AjaxController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @PostMapping("/products/addProduct")
    public ResponseEntity<Object> addProduct(Authentication authentication, ProductForm form) {
        if (authentication != null && form.getAction().equals("buy")) {
            Optional<Product> product = productService.getProduct(form.getId());
            UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
            User user = details.getUser();
            if (product.isPresent()) {
                user.getCart().add(product.get());
                userService.saveUser(user);
                user.getCart().remove(product.get());
                return ResponseEntity.ok(product.get());
            }
        }
        return ResponseEntity.ok(null);
    }

    @PostMapping("/products/deleteProduct")
    public ResponseEntity<Object> deleteProduct(Authentication authentication, @RequestParam Long id, @RequestParam String action) {
        if (authentication != null && action.equals("delete")) {
            Optional<Product> product = productService.getProduct(id);
            UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
            User user = details.getUser();
            if (product.isPresent()) {
                user.getCart().remove(product.get());
                userService.saveUser(user);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.ok(null);
    }


    @GetMapping("/products/list")
    public ResponseEntity<Object> showProducts(Authentication authentication) {
        if (authentication != null) {
            UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
            User user = details.getUser();
            return ResponseEntity.ok(userService.findByLogin(user.getLogin()).get().getCart().getProducts());
        }
        return ResponseEntity.ok(null);
    }
}
