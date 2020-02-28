package org.manager.Controller;

import org.manager.Model.Product;
import org.manager.Repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class ProductController {

    final ProductRepository products;

    public ProductController(ProductRepository products) {
        this.products = products;
    }

    @GetMapping("/Products")
    public List<Product> index(){
        return products.findAll();
    }

    @GetMapping("/Products/{id}")
    public List<Product> index(@PathVariable String id){
        return products.findAllById(Collections.singleton(Long.parseLong(id)));
    }

    @GetMapping("/Products/delete/{id}")
    public void delete(@PathVariable String id){
        products.deleteById(Long.parseLong(id));
    }

    @PostMapping("/Products/save")
    public Product create(@RequestBody Product prod){
        return products.save(prod);
    }

}
