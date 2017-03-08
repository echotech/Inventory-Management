package wgu.model;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.beans.property.*;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jreis on 2/9/2017.
 */
public abstract class Part{

    private static AtomicInteger next_id = new AtomicInteger(0);
    private SimpleStringProperty partName;
    private SimpleDoubleProperty partPrice;
    private SimpleIntegerProperty partInstock;
    private SimpleIntegerProperty partMin;
    private SimpleIntegerProperty partMax;
    private SimpleIntegerProperty partID;

    //Setters and Getters
    public void setName(String name){this.partName.set(name);}
    public String getName(){return partName.get();}
    public SimpleStringProperty partNameProperty(){return partName;}

    public void setPrice(Double price){this.partPrice.set(price);}
    public Double getPrice(){return partPrice.get();}
    public SimpleDoubleProperty partPriceProperty(){return partPrice;}

    public void setInstock(int amt){this.partInstock.set(amt);}
    public int getInstock(){return partInstock.get();}
    public SimpleIntegerProperty partInStockProperty(){return partInstock;}

    public void setMin(int min){this.partMin.set(min);}
    public int getMin(){return partMin.get();}
    public SimpleIntegerProperty partMinProperty(){return partMin;}

    public void setMax(int max){this.partMax.set(max);}
    public int getMax(){return partMax.get();}
    public SimpleIntegerProperty partMaxProperty(){return partMax;}

    public void setPartID(int id){this.partID.set(next_id.incrementAndGet());  }
    public int getPartID(){return partID.get();}
    public SimpleIntegerProperty partIDProperty(){return partID;}

    //Constructors
    public Part(){}
    public Part(SimpleIntegerProperty ID, SimpleStringProperty name, SimpleDoubleProperty partPrice, SimpleIntegerProperty partInstock, SimpleIntegerProperty partMin, SimpleIntegerProperty partMax){
        this.partID=ID;
        this.partName=name;
        this.partPrice=partPrice;
        this.partInstock=partInstock;
        this.partMin=partMin;
        this.partMax=partMax;
    }


}





