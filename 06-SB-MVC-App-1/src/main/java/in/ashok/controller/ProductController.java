package in.ashok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ashok.Repo.ProductRepo;
import in.ashok.entity.Product;
import jakarta.annotation.PostConstruct;

@Controller
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        try {
            List<Product> products = productRepo.findAll();
            model.addAttribute("products", products);
            return "Product";
        } catch (Exception e) {
            model.addAttribute("error", "Unable to fetch products.");
            return "error";
        }
    }

    @PostConstruct
    public void saveSampleProduct() {
        Product p = new Product();
        p.setPid(2);
        p.setPname("Poco");
        p.setPrice(25000.0);
        productRepo.save(p);
    }
}
 