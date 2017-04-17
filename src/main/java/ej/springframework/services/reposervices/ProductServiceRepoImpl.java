package ej.springframework.services.reposervices;

import ej.springframework.commands.ProductForm;
import ej.springframework.converters.ProductFormToProduct;
import ej.springframework.converters.ProductToProductForm;
import ej.springframework.domain.Product;
import ej.springframework.repositories.ProductRepository;
import ej.springframework.services.ProductService;
import ej.springframework.services.SendTextMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eunsoojung on 9/26/16.
 * Refactring for S17_L92
 */
@Service
@Profile("springdatajpa")
public class ProductServiceRepoImpl implements ProductService {

    private ProductRepository productRepository;
    // Add for S17_L92.4.1
    private ProductToProductForm productToProductForm;
    private ProductFormToProduct productFormToProduct;
    // S17_L92.4.3
    private SendTextMessageService sendTextMessageService;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Add for S17_L92.4.2
    @Autowired
    public void setProductToProductForm(ProductToProductForm productToProductForm) {
        this.productToProductForm = productToProductForm;
    }

    @Autowired
    public void setProductFormToProduct(ProductFormToProduct productFormToProduct) {
        this.productFormToProduct = productFormToProduct;
    }

    // S17_L92.4.4
    @Autowired
    public void setSendTextMessageService(SendTextMessageService sendTextMessageService) {
        this.sendTextMessageService = sendTextMessageService;
    }

    @Override
    public List<?> listAll() {
        // S17_L92.4.5
        sendTextMessageService.sendTextMessage("Listing Products");

        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product getById(Integer id) {
        // S17_L92.4.5
        sendTextMessageService.sendTextMessage("Requested Product ID: " + id);
        return productRepository.findOne(id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        return productRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }

    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm) {
        return saveOrUpdate(productFormToProduct.convert(productForm));
    }
}
