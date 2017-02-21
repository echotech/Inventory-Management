package wgu.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jreis on 2/9/2017.
 */
public abstract class Part{

    private static AtomicInteger next_id = new AtomicInteger(0);
    private String name;
    private double price;
    private int instock;
    private int min;
    private int max;
    private int partID;



    //Setters and Getters
    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public double getPrice(){
        return this.price;
    }

    public void setInstock(int amt){
        this.instock=amt;
    }

    public int getInstock(){
        return this.instock;
    }

    public int getMin() {
        return this.min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setPartID(int id){ this.partID = next_id.incrementAndGet();}

    public int getPartID(){ return this.partID;}


}





