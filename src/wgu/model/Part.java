package wgu.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jreis on 2/9/2017.
 */
public abstract class Part{

    private static AtomicInteger next_id = new AtomicInteger(0);
    private StringProperty name;
    private DoubleProperty price;
    private IntegerProperty instock;
    private IntegerProperty min;
    private IntegerProperty max;
    private IntegerProperty partID;

    //Setters and Getters
    public void setInstock(int amt){this.instock.set(amt);}

    public int getInstock(){return instock.get();}

    public IntegerProperty inStockProperty(){return instock;}

    public void setMin(int min){this.min.set(min);}

    public int getMin(){return min.get();}

    public IntegerProperty minProperty(){return min;}

    public void setMax(int max){this.max.set(max);}

    public int getMax(){return max.get();}

    public IntegerProperty maxProperty(){return max;}

    public void setProductID(int id){this.partID.set(next_id.incrementAndGet());  }

    public int getProductID(){return partID.get();}

    public IntegerProperty productIDProperty(){return partID;}


}





