package org.bank.Controller;

import org.bank.Model.Category;
import org.bank.Repositories.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class CategoryController {
    final CategoryRepository categories;

    public CategoryController(CategoryRepository categories) {
        this.categories = categories;
    }

    @GetMapping("/Categories")
    public List<Category> index(){
        return categories.findAll();
    }

    @GetMapping("/Categories/{id}")
    public List<Category> index(@PathVariable String id){
        return categories.findAllById(Collections.singleton(Long.parseLong(id)));
    }

    @GetMapping("/Categories/delete/{id}")
    public void delete(@PathVariable String id){
        categories.deleteById(Long.parseLong(id));
    }

    @PostMapping("/Categories/save")
    public Category create(@RequestBody Category cat){
        return categories.save(cat);
    }


}
