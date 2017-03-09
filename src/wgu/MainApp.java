package wgu;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import wgu.model.InHouse;
import wgu.model.Part;
import wgu.model.Product;
import wgu.view.AddPartController;
import wgu.view.InventoryManagement;
import wgu.view.ModifyPartController;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    @FXML
    private Scene addPart, modPart, modProduct;
    @FXML
    private Button exitBtn, modPartBtn, addPartBtn, delPartBtn, searchPartBtn, modProdBtn, addProdBtn, delProdBtn, searchProdBtn;
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, String> productStringTableColumn;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Inventory Management");

        initRootLayout();


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
     * Shows the person overview inside the root layout.
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

    public void showModifyPartDialog(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ModifyPart.fxml"));
            AnchorPane modifyPartDialog = (AnchorPane) loader.load();

            rootLayout.setCenter(modifyPartDialog);

            ModifyPartController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e){
            e.printStackTrace();
        }
    }


    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
