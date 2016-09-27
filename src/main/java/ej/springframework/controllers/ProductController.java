package ej.springframework.controllers;

import ej.springframework.commands.ProductForm;
import ej.springframework.converters.ProductToProductForm;
import ej.springframework.domain.Product;
import ej.springframework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by eunsoojung on 8/31/16.
 */
@Controller
public class ProductController {

    private ProductService productService;
    private ProductToProductForm productToProductForm;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setProductToProductForm(ProductToProductForm productToProductForm) {
        this.productToProductForm = productToProductForm;
    }

    @RequestMapping("/product/list")
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }

    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "product/show";
    }

//    @RequestMapping("product/edit/{id}")
//    public String edit(@PathVariable Integer id, Model model){
//        model.addAttribute("product", productService.getById(id));
//        return "product/productform";
//    }
//
//    @RequestMapping("/product/new")
//    public String newProduct(Model model){
//        model.addAttribute("product", new Product());
//        return "product/productform";
//    }

//    @RequestMapping(value = "/product", method = RequestMethod.POST)
//    public String saveOrUpdateProduct(Product product){
//        Product savedProduct = productService.saveOrUpdate(product);
//        return "redirect:/product/show/" + savedProduct.getId();
//    }
    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Product product = productService.getById(id);
        ProductForm productForm = productToProductForm.convert(product);

        model.addAttribute("productForm", productForm);
        return "product/productform";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("productForm", new ProductForm());
        return "product/productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid ProductForm productForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product/productform";
        }

        Product savedProduct = productService.saveOrUpdateProductForm(productForm);

        return "redirect:/product/show/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/product/list";
    }
}