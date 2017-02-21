package wgu.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import wgu.MainApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by jreis on 2/2/2017.
 */

public class Product{
    /** Auto-generated ID variable
     *
     */
    private static AtomicInteger next_id = new AtomicInteger(0);  // <-- static, class-wide counter
    private ArrayList<Part> parts;
    private StringProperty name;
    private DoubleProperty price;
    private IntegerProperty instock;
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
     * @return
     */
    public boolean removePart(int id){
        for(Part part : parts){
            if (part.getPartID()==(id)){
                parts.remove(part);
                return true;

            }
        }

        return false;
    }

   public void updatePart(int something){
       try {
           AnchorPane modifyLayout = new AnchorPane();
           // Load root layout from fxml file.
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(MainApp.class.getResource("ModifyPart.fxml"));
           modifyLayout = (AnchorPane) loader.load();

           // Show the scene containing the root layout.
           Scene scene = new Scene(modifyLayout);
           primaryStage.setScene(scene);
           primaryStage.show();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public Part lookupPart(int id) {

       for (Part part : parts) {
           if (part.getPartID()==(id)) {
               return part;
           }
       }
       return null;
   }

    public void setInstock(int amt){this.instock.set(amt);}

    public int getInstock(){return instock.get();}

    public IntegerProperty inStockProperty(){return instock;}

    public void setMin(int min){this.min.set(min);}

    public int getMin(){return min.get();}

    public IntegerProperty minProperty(){return min;}

    public void setMax(int max){this.max.set(max);}

    public int getMax(){return max.get();}

    public IntegerProperty maxProperty(){return max;}

    public void setProductID(int id){this.productID.set(next_id.incrementAndGet());  }

    public int getProductID(){return productID.get();}

    public IntegerProperty productIDProperty(){return productID;}


}
