package wgu.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jreis on 2/2/2017.
 */

public class Product {
    /**
     * Auto-generated ID variable
     */
    private static AtomicInteger nextId = new AtomicInteger(0);  // <-- static, class-wide counter
    private ArrayList<Part> parts;
    private SimpleStringProperty productName;
    private SimpleDoubleProperty productPrice;
    private SimpleIntegerProperty productInstock;
    private SimpleIntegerProperty productMin;
    private SimpleIntegerProperty productMax;
    private SimpleIntegerProperty productID;

    //Constructor
    public Product(String name, double productPrice, int productInstock) {
        this.productID = new SimpleIntegerProperty(nextId.incrementAndGet());
        this.productName = new SimpleStringProperty(name);
        this.productPrice = new SimpleDoubleProperty(productPrice);
        this.productInstock = new SimpleIntegerProperty(productInstock);
        this.productMin = new SimpleIntegerProperty(0);
        this.productMax = new SimpleIntegerProperty(0);
    }

    //Setters and Getters
    public void setProductName(String name) {
        this.productName.set(name);
    }

    public String getProductName() {
        return productName.get();
    }

    public SimpleStringProperty productNameProperty() {
        return productName;
    }

    public void setProductPrice(Double price) {
        this.productPrice.set(price);
    }

    public Double getProductPrice() {
        return productPrice.get();
    }

    public SimpleDoubleProperty productPriceProperty() {
        return productPrice;
    }

    public void setProductInstock(int amt) {
        this.productInstock.set(amt);
    }

    public int getProductInstock() {
        return productInstock.get();
    }

    public SimpleIntegerProperty productInstockProperty() {
        return productInstock;
    }

    public void setProductMin(int min) {
        this.productMin.set(min);
    }

    public int getProductMin() {
        return productMin.get();
    }

    public SimpleIntegerProperty productMinProperty() {
        return productMin;
    }

    public void setProductMax(int max) {
        this.productMax.set(max);
    }

    public int getProductMax() {
        return productMax.get();
    }

    public SimpleIntegerProperty productMaxProperty() {
        return productMax;
    }

    public void setProductID(int id) {
        this.productID.set(id);
    }

    public int getProductID() {
        return productID.get();
    }

    public SimpleIntegerProperty productIDProperty() {
        return productID;
    }


    /**
     * Add part to parts arraylist
     *
     * @param var
     */

    public void addPart(Part var) {
        parts.add(var);
    }


    /**
     * Remove part by ID
     *
     * @param id
     * @return boolean
     */
    public boolean removePart(int id) {
        return parts.removeIf(part -> part.getPartID() == id);
    }

    public void updatePart(int id) throws Exception {

        for (Part part : parts) {
            if (part.getPartID() == (id)) {
                return;
            } else {
                throw new Exception("Part not found.");
            }
        }

    }

    public Part lookupPart(int id) throws Exception {

        for (Part part : parts) {
            if (part.getPartID() == (id)) {
                return part;
            } else {
                throw new Exception("Part not found.");
            }
        }
        return null;

    }


}
