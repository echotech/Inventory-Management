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
    public void setPartName(String name){this.partName.set(name);}
    public String getPartName(){return partName.get();}
    public SimpleStringProperty partNameProperty(){return partName;}

    public void setPartPrice(Double price){this.partPrice.set(price);}
    public Double getPartPrice(){return partPrice.get();}
    public SimpleDoubleProperty partPriceProperty(){return partPrice;}

    public void setPartInstock(int amt){this.partInstock.set(amt);}
    public int getPartInstock(){return partInstock.get();}
    public SimpleIntegerProperty partInStockProperty(){return partInstock;}

    public void setPartMin(int min){this.partMin.set(min);}
    public int getPartMin(){return partMin.get();}
    public SimpleIntegerProperty partMinProperty(){return partMin;}

    public void setPartMax(int max){this.partMax.set(max);}
    public int getPartMax(){return partMax.get();}
    public SimpleIntegerProperty partMaxProperty(){return partMax;}

    public void setPartID(int id){this.partID.set(next_id.incrementAndGet());  }
    public int getPartID(){return partID.get();}
    public SimpleIntegerProperty partIDProperty(){return partID;}

    //Constructors
    public Part(){}
    public Part(SimpleIntegerProperty ID, SimpleStringProperty name, SimpleDoubleProperty partPrice, SimpleIntegerProperty partInstock){
        this.partID=ID;
        this.partName=name;
        this.partPrice=partPrice;
        this.partInstock=partInstock;

    }


}





