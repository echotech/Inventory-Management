package wgu;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import wgu.model.InHouse;
import wgu.model.Part;
import wgu.model.Product;
import wgu.view.InventoryManagement;
import wgu.view.ModifyPartController;

import java.io.IOException;


public class MainApp extends Application {

    public Stage primaryStage;
    private BorderPane rootLayout;

    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, String> productStringTableColumn;

    /**
     * The data as an observable list of Parts and Products.
     */
    private ObservableList<Part> partData = FXCollections.observableArrayList();
    private ObservableList<Product> productData = FXCollections.observableArrayList();

    public MainApp() {

        partData.add(new InHouse("Stupid Part", 1, 1));
        productData.add(new Product(1, "Prod1", 2, 3.50));
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Inventory Management");

        initRootLayout();
        showInventoryManagement();


    }


    /**
     * Return data in partTable as observable list
     */
    public ObservableList<Part> getPartData() {
        return partData;
    }

    public void addPartData(Part part){partData.add(part);}

    /**
     * Return data in partTable as observable list
     */
    public ObservableList<Product> getProductData() {
        return productData;
    }


    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Root.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the overview inside the root layout.
     */
    public void showInventoryManagement() {
        try {
            // Load inventory view.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/InventoryManagement.fxml"));
            AnchorPane inventoryOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(inventoryOverview);

            // Give the controller access to the main app.
            InventoryManagement controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showModifyPartDialog() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ModifyPart.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Modify Part");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the part into the controller.
            //Part tempPart = new InHouse();
            ModifyPartController controller = loader.getController();
            controller.setMainApp(this);
            controller.setDialogStage(dialogStage);

            //controller.setPart(tempPart);


            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isSaveClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showModifyPartDialog(Part part) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ModifyPart.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Modify Part");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the part into the controller.
            ModifyPartController controller = loader.getController();
            controller.setMainApp(this);
            controller.setDialogStage(dialogStage);
            controller.setPart(part);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isSaveClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    //TODO Implement ModifyProductController
    /*
    public boolean showModifyProductDialog(Product prod){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ModifyProduct.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Modify Product");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the product into the controller.
            ModifyProductController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setProduct(prod);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isSaveClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    */


    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
