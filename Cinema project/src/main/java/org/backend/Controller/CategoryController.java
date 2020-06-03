package org.backend.Controller;

import org.backend.Repository.CategoryRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    final CategoryRepository categoryRepository;
    public CategoryController(CategoryRepository categoryRepository) { this.categoryRepository = categoryRepository; }

    /*@GetMapping("/Categories")
    public List<Category> Categories(){
        return categoryRepository.findAll();
    }
    @GetMapping("/Category/{id}")
    public Category Category(@PathVariable Long id){
        return categoryRepository.findById(id).get();
    }
    @DeleteMapping("/Category/{id}")
    public void Delete(@PathVariable Long id){
        categoryRepository.deleteById(id);
    }
    @PostMapping("/Category")
    public Category Add(@RequestBody Category category){
        return categoryRepository.save(category);
    }
    @PutMapping("/Category/{id}")
    public Category Update(@RequestBody Category category, @PathVariable Long id){
        category.setId(id);
        return categoryRepository.save(category);
    }*/
}
