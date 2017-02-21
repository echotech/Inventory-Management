package wgu.model;

import java.util.ArrayList;

/**
 * Created by jreis on 2/17/2017.
 */
public class Inventory {

    private ArrayList<Product> products;

    public void addProduct(Product p){ products.add(p);}

    public boolean removeProduct(int rem){
        for(Product prod : products){
            if (prod.getProductID()==(rem)){
                products.remove(prod);
                return true;

            }
        }

        return false;
    }

    public Product lookupProduct(int id){
        for (Product prod : products) {
            if (prod.getProductID().equals(id)) {
                return prod;
            }
        }
        return null;
    }

    public void updateProduct(int up){

    }
}
