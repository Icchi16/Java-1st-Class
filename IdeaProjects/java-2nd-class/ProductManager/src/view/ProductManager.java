package view;

import config.Config;
import controller.ProductController;
import model.Product;

import java.util.List;

public class ProductManager {
    static ProductController productController = new ProductController();

    public static void main(String[] args) {
        while (true) {
            System.out.println("------------------ Product Manager ------------------");
            System.out.println("1. Show List Products");
            System.out.println("2. Create New Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Search Product By name");
            System.out.println("6. Exit");
            System.out.println("------------------ Product Manager ------------------");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(Config.scanner().nextLine());
            switch (choice) {
                case 1:
                    showListProduct(productController.getListProducts());
                    break;
                case 2:
                    createProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    searchProductByName();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void showListProduct(List<Product> productList) {
        System.out.println("------------------- List Product --------------------");
        for (Product product : productList) {
            System.out.println("1. ProductId: " + product.getProductId());
            System.out.println("2. ProductName: " + product.getProductName());
            System.out.println("3. Quantity: " + product.getQuantity());
            System.out.println("4. Price " + product.getPrice());
            System.out.println("5. Status: " + ((product.isStatus()) ? "in stock" : "out of stock"));
            System.out.println("--------------------------------------------");
        }
        System.out.println("------------------- List Product --------------------");
    }

    public static void createProduct() {
        List<Product> productList = productController.getListProducts();
        System.out.println("Enter new products: ");
        int amount = Integer.parseInt(Config.scanner().nextLine());
        for (int i = 0; i < amount; i++) {
            System.out.println("Enter product" + (i + 1));
            int id;
            if (productList.isEmpty()) {
                id = 1;
            } else {
                id = productList.get(productList.size() - 1).getProductId() + 1;
            }
            System.out.println("Enter product name: ");
            String name = Config.scanner().nextLine();
            System.out.println("Enter product quantity: ");
            int quantity = Integer.parseInt(Config.scanner().nextLine());
            System.out.println("Enter price: ");
            float price = Float.parseFloat(Config.scanner().nextLine());
            boolean status = true;
            Product newProduct = new Product(id, name, quantity, price, status);
            productController.createProduct(newProduct);
            System.out.println("Create product success!");
        }
        System.out.println("Create " + amount + " product(s) success!");
    }

    public static void updateProduct() {
        while (true) {
            System.out.println("Enter id: ");
            int idU = Integer.parseInt(Config.scanner().nextLine());
            if (productController.findById(idU) != null) {
                System.out.println("Enter new name: ");
                String name = Config.scanner().nextLine();
                System.out.println("Enter product quantity: ");
                int quantity = Integer.parseInt(Config.scanner().nextLine());
                System.out.println("Enter price: ");
                float price = Float.parseFloat(Config.scanner().nextLine());
                boolean status = true;
                Product updateProduct = new Product(idU, name, quantity, price, status);
                productController.updateProduct(updateProduct);
                System.out.println("Update success!");
                return;
            } else System.err.println("ID not found! Try again");
        }
    }

    public static void deleteProduct() {
        while (true) {
            System.out.println("Enter id: ");
            int idR = Integer.parseInt(Config.scanner().nextLine());
            if (productController.findById(idR) != null) {
               productController.removeProduct(idR);
                System.out.println("Remove success!");
                return;
            } else System.err.println("ID not found! Try again");
        }
    }

    public static void searchProductByName() {
        System.out.println("Enter Name:");
        String searchParam = Config.scanner().nextLine();
        showListProduct(productController.searchByName(searchParam));
    }
}
