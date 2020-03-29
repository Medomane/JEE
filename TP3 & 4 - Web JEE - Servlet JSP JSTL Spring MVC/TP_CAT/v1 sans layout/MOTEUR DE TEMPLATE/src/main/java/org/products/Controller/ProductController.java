package org.products.Controller;

import org.products.Model.Product;
import org.products.Repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(value="/search",method= RequestMethod.GET)
    public ModelAndView search(Model model, @RequestParam(name="mc",defaultValue="") String keyword, @RequestParam(name="page",defaultValue="0") int page){
        Page<Product> pageProducts = productRepository.search("%"+keyword+"%", PageRequest.of(page, 5));
        model.addAttribute("products", pageProducts);
        model.addAttribute("currentPage", page);
        model.addAttribute("mc",keyword);
        int[] pages=new int[pageProducts.getTotalPages()];
        for(int i=0;i<pages.length;i++) pages[i]=i;
        model.addAttribute("pages", pages);
        return new ModelAndView("products");
    }

    @RequestMapping(value="/form")
    public ModelAndView form(Model model){
        model.addAttribute("product", new Product());
        return new ModelAndView("form");
    }
    @RequestMapping(value="/save",method=RequestMethod.POST)
    public ModelAndView save(Model model, @Valid Product p, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return new ModelAndView("form");
        productRepository.save(p);
        model.addAttribute("product", p);
        return new ModelAndView("confirmation");
    }
}
