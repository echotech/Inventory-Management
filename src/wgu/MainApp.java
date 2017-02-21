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
import javafx.stage.Stage;
import wgu.model.InHouse;
import wgu.model.Part;
import wgu.model.Product;


public class MainApp extends Application {

    private Stage primaryStage;


    private AnchorPane rootLayout;
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
            loader.setLocation(MainApp.class.getResource("InventoryManagement.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = partTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            partTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }


    @FXML
    private void handleExit() {
        primaryStage.close();}


    public void addProduct(Product add){
        add = new Product();
        products.add(add);
    }

    public boolean removeProduct(int rem){
        //code to remove product

        return true;
    }

    public Part lookupProduct(int id){
        //code to look up product
        return new InHouse();
    }
    public void updateProduct(int prod){
        //code to modify product
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
