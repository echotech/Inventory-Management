package wgu.model;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.beans.property.*;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jreis on 2/9/2017.
 */
public abstract class Part{

    private static AtomicInteger next_id = new AtomicInteger(0);
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty instock;
    private SimpleIntegerProperty min;
    private SimpleIntegerProperty max;
    private SimpleIntegerProperty partID;

    //Setters and Getters
    public void setName(String name){this.name.set(name);}
    public String getName(){return name.get();}
    public SimpleStringProperty partNameProperty(){return name;}

    public void setPrice(Double price){this.price.set(price);}
    public Double getPrice(){return price.get();}
    public SimpleDoubleProperty partPriceProperty(){return price;}

    public void setInstock(int amt){this.instock.set(amt);}
    public int getInstock(){return instock.get();}
    public SimpleIntegerProperty partInStockProperty(){return instock;}

    public void setMin(int min){this.min.set(min);}
    public int getMin(){return min.get();}
    public SimpleIntegerProperty partMinProperty(){return min;}

    public void setMax(int max){this.max.set(max);}
    public int getMax(){return max.get();}
    public SimpleIntegerProperty partMaxProperty(){return max;}

    public void setPartID(int id){this.partID.set(next_id.incrementAndGet());  }
    public int getPartID(){return partID.get();}
    public SimpleIntegerProperty partIDProperty(){return partID;}

    //Constructors
    public Part(){}
    public Part(SimpleIntegerProperty ID, SimpleStringProperty name, SimpleDoubleProperty partPrice, SimpleIntegerProperty partInstock, SimpleIntegerProperty partMin, SimpleIntegerProperty partMax){
        this.partID=ID;
        this.name=name;
        this.price=partPrice;
        this.instock=partInstock;
        this.min=partMin;
        this.max=partMax;
    }


}





