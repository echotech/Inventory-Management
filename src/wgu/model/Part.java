package wgu.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jreis on 2/9/2017.
 */
public abstract class Part {

    private static AtomicInteger nextId = new AtomicInteger(0);
    private SimpleStringProperty partName;
    private SimpleDoubleProperty partPrice;
    private SimpleIntegerProperty partInstock;
    private SimpleIntegerProperty partMin;
    private SimpleIntegerProperty partMax;
    private SimpleIntegerProperty partID;

    //Setters and Getters
    public void setPartName(String name) {
        this.partName.set(name);
    }

    public String getPartName() {
        return partName.get();
    }

    public SimpleStringProperty partNameProperty() {
        return partName;
    }

    public void setPartPrice(Double price) {
        this.partPrice.set(price);
    }

    public Double getPartPrice() {
        return partPrice.get();
    }

    public SimpleDoubleProperty partPriceProperty() {
        return partPrice;
    }

    public void setPartInstock(int amt) {
        this.partInstock.set(amt);
    }

    public int getPartInstock() {
        return partInstock.get();
    }

    public SimpleIntegerProperty partInStockProperty() {
        return partInstock;
    }

    public void setPartMin(int min) {
        this.partMin.set(min);
    }

    public int getPartMin() {
        return partMin.get();
    }

    public SimpleIntegerProperty partMinProperty() {
        return partMin;
    }

    public void setPartMax(int max) {
        this.partMax.set(max);
    }

    public int getPartMax() {
        return partMax.get();
    }

    public SimpleIntegerProperty partMaxProperty() {
        return partMax;
    }

    public void setPartID(int id) {
        this.partID.set(id);
    }

    public int getPartID() {
        return partID.get();
    }

    public SimpleIntegerProperty partIDProperty() {
        return partID;
    }

    //Constructors


    public Part(String name, double partPrice, int partInstock) {
        this.partID = new SimpleIntegerProperty(nextId.incrementAndGet());
        this.partName = new SimpleStringProperty(name);
        this.partPrice = new SimpleDoubleProperty(partPrice);
        this.partInstock = new SimpleIntegerProperty(partInstock);
        this.partMin = new SimpleIntegerProperty(0);
        this.partMax = new SimpleIntegerProperty(0);
    }


}





