package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.demo.forms.ProductForm;
import ru.itis.demo.models.Cart;
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
                userService.saveUser(user, product.get());
                return ResponseEntity.ok(product.get());
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/products/deleteProduct")
    public ResponseEntity<Object> deleteProduct(Authentication authentication, @RequestParam Long id, @RequestParam String action) {
        if (authentication != null && action.equals("delete")) {
            Optional<Product> product = productService.getProduct(id);
            UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
            User user = details.getUser();
            if (product.isPresent()) {
                productService.deleteProductFromCart(user, product.get());
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }


    @GetMapping("/products/list")
    public ResponseEntity<Object> showProducts(Authentication authentication) {
        if (authentication != null) {
            UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
            User user = details.getUser();
            if (userService.findByLogin(user.getLogin()).isPresent()) {
                return ResponseEntity.ok(userService.findByLogin(user.getLogin()).get().getCart().getProducts());
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/products/getAmount")
    public ResponseEntity<Object> getAmount(Authentication authentication, @RequestParam String name) {
        if (authentication != null) {
            UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
            User user = details.getUser();
            Cart cart = user.getCart();
            Long amount = productService.getAmount(cart.getId(), name);
            return ResponseEntity.ok(amount.toString());
        }
        return ResponseEntity.badRequest().build();
    }
}
