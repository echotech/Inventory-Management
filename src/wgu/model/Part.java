package wgu.model;

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
    public void setInstock(int amt){this.instock.set(amt);}

    public int getInstock(){return instock.get();}

    public SimpleIntegerProperty inStockProperty(){return instock;}

    public void setMin(int min){this.min.set(min);}

    public int getMin(){return min.get();}

    public SimpleIntegerProperty minProperty(){return min;}

    public void setMax(int max){this.max.set(max);}

    public int getMax(){return max.get();}

    public SimpleIntegerProperty maxProperty(){return max;}

    public void setPartID(int id){this.partID.set(next_id.incrementAndGet());  }

    public int getPartID(){return partID.get();}

    public SimpleIntegerProperty partIDProperty(){return partID;}


}





