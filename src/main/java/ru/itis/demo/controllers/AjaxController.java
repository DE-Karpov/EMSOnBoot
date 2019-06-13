package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.demo.forms.ProductForm;
import ru.itis.demo.models.Product;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepository;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.ProductService;

import java.util.Optional;

@RestController
public class AjaxController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/products/addProduct")
    public ResponseEntity<Object> addProduct(Authentication authentication, ProductForm form) {
        if (authentication != null && form.getAction().equals("buy")) {
            Optional<Product> product = productService.getProduct(form.getId());
            UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
            User user = details.getUser();
            Product returnedProduct = Product.builder()
                    .name(productService.getProduct(form.getId()).get().getName())
                    .build();
           // product.ifPresent(value -> user.getCart().add(value));
            if(product.isPresent()){
                user.getCart().add(product.get());
                usersRepository.save(user);
                user.getCart().remove(product.get());
            }
            return ResponseEntity.ok(returnedProduct);
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping("/products/list")
    public ResponseEntity<Object> showProducts(Authentication authentication){
        if (authentication != null){
            UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
            User user = details.getUser();
            return ResponseEntity.ok(usersRepository.findByLogin(user.getLogin()).get().getCart().getProducts());
        }
        return ResponseEntity.ok(null);
    }
}
