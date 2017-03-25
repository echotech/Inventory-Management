package wgu.view;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import wgu.MainApp;
import wgu.model.InHouse;
import wgu.model.Part;
import wgu.model.Product;

import java.io.IOException;



/**
 * Created by jreis on 2/27/2017.
 */
public class InventoryManagement {



    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, Integer> productIdColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Integer> productInvColumn;
    @FXML
    private TableColumn<Product, Double> productPriceColumn;

    @FXML
    private TableView<Part> partTable;
    @FXML
    private TableColumn<Part, Integer> partIdColumn;
    @FXML
    private TableColumn<Part, String> partNameColumn;
    @FXML
    private TableColumn<Part, Integer> partInvColumn;
    @FXML
    private TableColumn<Part, Double> partPriceColumn;
    @FXML
    Button exitBtn;
    @FXML
    Button modPartBtn;
    @FXML
    Button addPartBtn;
    @FXML
    Button delPartBtn;
    @FXML
    Button searchPartBtn;
    @FXML
    Button modProdBtn;
    @FXML
    Button addProdBtn;
    @FXML
    Button delProdBtn;
    @FXML
    Button searchProdBtn;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public void InventoryOverviewController() {
    }



    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */

    @FXML
    private void initialize() {
        // Initialize the part table with the 4 columns.
        partIdColumn.setCellValueFactory(
                cellData -> cellData.getValue().partIDProperty().asObject());
        partNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().partNameProperty());
        partInvColumn.setCellValueFactory(
                cellData -> cellData.getValue().partInStockProperty().asObject());
        partPriceColumn.setCellValueFactory(
                cellData -> cellData.getValue().partPriceProperty().asObject());

        //Initialize the product table with the 4 columns.
        productIdColumn.setCellValueFactory(
                cellData -> cellData.getValue().productIDProperty().asObject());
        productNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().productNameProperty());
        productInvColumn.setCellValueFactory(
                cellData -> cellData.getValue().productInstockProperty().asObject());
        productPriceColumn.setCellValueFactory(
                cellData -> cellData.getValue().productPriceProperty().asObject());

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        partTable.setItems(mainApp.getPartData());
        productTable.setItems(mainApp.getProductData());


    }

    /** Modify Part Button
     *
     * @param part
     */
    @FXML
    private void handleModifyPart() {
        Part selectedPart = partTable.getSelectionModel().getSelectedItem();
        if (selectedPart != null) {
            boolean saveClicked = mainApp.showModifyPartDialog(selectedPart);
            if (saveClicked){
                //TODO figure out what to put here.
                partTable.getColumns().get(0).setVisible(false);
                partTable.getColumns().get(0).setVisible(true);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Part Selected");
            alert.setContentText("Please select a part in the table.");

            alert.showAndWait();
        }
    }

    /**
     * Called when user clicks new button
     */
    @FXML
    public void handleAddPart(){
//TODO Fix this to actually work.
        boolean saveClicked = mainApp.showModifyPartDialog();
        if (saveClicked){
            mainApp.getPartData();
        }

    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeletePart() {
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
    private void handleDeleteProduct() {
        int selectedIndex = productTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            productTable.getItems().remove(selectedIndex);
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
        mainApp.primaryStage.close();}


    //TODO Implement add product
    /*
    @FXML
    public void handleAddProduct(Product add){
       Product tempProduct = new Product();
       boolean saveClicked = mainApp.showModifyProductDialogue(tempProduct);
       if (saveClicked){
           mainApp.getProductData().add(tempProduct);
       }

    }
    */

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
}
