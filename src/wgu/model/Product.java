package wgu.model;

import javafx.beans.property.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import wgu.MainApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import static java.lang.System.out;

/**
 * Created by jreis on 2/2/2017.
 */

public class Product{
    /** Auto-generated ID variable
     *
     */
    private static AtomicInteger next_id = new AtomicInteger(0);  // <-- static, class-wide counter
    private ArrayList<Part> parts;
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty instock;
    private IntegerProperty min;
    private IntegerProperty max;
    private IntegerProperty productID;

    /** Add part to parts arraylist
     *
     * @param var
     */

    public void addPart(Part var){
        parts.add(var);
        }


    /** Remove part by ID
     *
     * @param id
     * @return boolean
     */
    public boolean removePart(int id){
       return parts.removeIf(part -> part.getPartID()==id);
    }

   public void updatePart(int id) throws Exception {

       for(Part part : parts){
           if (part.getPartID()==(id)){
              return;            }
           else {
              throw new Exception("Part not found.");
           }
       }

   }

   public Part lookupPart(int id) throws Exception {

       for (Part part : parts) {
           if (part.getPartID()==(id)) {
               return part;}
           else {
               throw new Exception("Part not found.");
           }
       }
       return null;

   }

    public void setInstock(int amt){this.instock.set(amt);}

    public int getInstock(){return instock.get();}

    public SimpleIntegerProperty inStockProperty(){return instock;}

    public void setMin(int min){this.min.set(min);}

    public int getMin(){return min.get();}

    public SimpleIntegerProperty minProperty(){return min;}

    public void setMax(int max){this.max.set(max);}

    public int getMax(){return max.get();}

    public SimpleIntegerProperty maxProperty(){return max;}

    public void setProductID(int id){this.productID.set(next_id.incrementAndGet());  }

    public int getProductID(){return productID.get();}

    public SimpleIntegerProperty productIDProperty(){return productID;}


}
