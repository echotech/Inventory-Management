package wgu.model;

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
    private String name;
    private double price;
    private int instock;
    private int min;
    private int max;
    private int productID;

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
           Scene scene = new Scene(rootLayout);
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

    public void setInstock(int amt){this.instock=amt;}

    public int getInstock(){return this.instock;}

    public void setMin(int min){this.min=min;}

    public int getMin(){return this.min;}

    public void setMax(int max){this.max=max;}

    public int getMax(){return this.max;}

    public void setPartID(int id){this.productID = next_id.incrementAndGet();  }

    public int getProductID(){return this.productID;}
}
