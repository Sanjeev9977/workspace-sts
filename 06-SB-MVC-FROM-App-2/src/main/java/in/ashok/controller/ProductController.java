package in.ashok.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import in.ashok.Repo.ProductRepo;
import in.ashok.Repo.ProductServiceInt;
import in.ashok.entity.Product;

@Controller
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductServiceInt productService;

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/product")
    public ModelAndView load() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("productObj", new Product());
        mv.setViewName("product");
        return mv;
    }

    @PostMapping("/product")
    public String save(Product product, Model model) {
        try {
            Boolean saved = productService.saveproduct(product);
            if (saved) {
                model.addAttribute("msg", "Product saved successfully.");
            } else {
                model.addAttribute("msg", "Failed to save product.");
            }
            model.addAttribute("productObj", new Product());
            return "product"; // Return to the same view for form binding
        } catch (Exception e) {
            logger.error("Error saving product: {}", e.getMessage());
            model.addAttribute("error", "An unexpected error occurred while saving the product.");
            return "error";
        }
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        try {
            List<Product> products = productService.getproduct();
            model.addAttribute("products", products);
            return "Productview";
        } catch (Exception e) {
            logger.error("Error fetching products: {}", e.getMessage());
            model.addAttribute("error", "Unable to fetch products.");
            return "error";
        }
    }

    @GetMapping("/product/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        try {
            Product product = productService.finduseid(id);
            model.addAttribute("productObj", product);
            return "product";
        } catch (NoSuchElementException e) {
            logger.warn("Product with ID {} not found.", id);
            model.addAttribute("error", "Product with ID " + id + " not found.");
            return "error";
        }
    }

    @DeleteMapping("/product/d/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        try {
            productService.deleteProductById(id);
            logger.info("Product with ID {} deleted successfully.", id);
            return ResponseEntity.ok("Product deleted successfully.");
        } catch (NoSuchElementException e) {
            logger.warn("Failed to delete product with ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        } catch (Exception e) {
            logger.error("Error deleting product with ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }
}
