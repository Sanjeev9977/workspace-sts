package in.ashok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import in.ashok.resposeBinding.Product;
import in.ashok.service.ConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConsumerController {
    
    @Autowired
    private ConsumerService service;

    @GetMapping("/")
    public String getDataForUi(@ModelAttribute("p") Product p, Model model) {
        // You can optionally pre-load some data here
        return "index";
    }
    
   

    @GetMapping("/getProduct")
    public String getProduct(@RequestParam("pid") String pid, Model model) {
        Product product = service.getProdct(pid);// Fixed method name
        service.getdata();
        model.addAttribute("p", product);
        return "index";
    }
}
 