package ej.springframework.services;

import ej.springframework.commands.ProductForm;
import ej.springframework.domain.Product;

/**
 * Created by eunsoojung on 8/31/16.
 */
public interface ProductService extends CRUDService<Product> {

    Product saveOrUpdateProductForm(ProductForm productForm);
}
