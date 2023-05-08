package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService{
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Quan", 100, 2000000, true));
        productList.add(new Product(2, "Ao", 100, 5000000, true));
        productList.add(new Product(3, "Tui", 100, 1500000, true));
        productList.add(new Product(4, "Ta Tua", 100, 1000, true));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        if (findById(product.getProductId()) != null) {
            // tìm thấy -> update
            productList.set(productList.indexOf(findById(product.getProductId())),product);
        } else {
            // ko tìm thấy id -> create
            productList.add(product);
        }
    }

    @Override
    public Product findById(int id) {
        for (Product product:productList) {
            if(product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        productList.remove(findById(id));
    }

    @Override
    public List<Product> searchByName(String string) {
        List<Product> listSearch = new ArrayList<>(productList);
        listSearch.removeIf(product -> !product.getProductName().trim().toLowerCase().contains(string.trim().toLowerCase()));
        return listSearch;
    }
}
