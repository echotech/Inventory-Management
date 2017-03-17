package wgu.model;

import java.util.ArrayList;

/**
 * Created by jreis on 2/17/2017.
 */
public class Inventory {

    private ArrayList<Product> allProducts;
    private ArrayList<Part> allParts;

    public void addProduct(Product p){ allProducts.add(p);}

    public boolean removeProduct(int rem){
        return allProducts.removeIf(part -> part.getProductID()==rem);
    }

    public Product lookupProduct(int id) throws Exception{
        for (Product prod : allProducts) {
            if (prod.getProductID()==(id)) {
                return prod;
            }
            else{
                throw new Exception("Product not found.");
            }
        }
        return null;
    }

    public void updateProduct(int up){

    }
}
