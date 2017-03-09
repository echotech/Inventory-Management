package wgu.view;

import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public InventoryOverviewController() {
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
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */

    @FXML
    private void initialize() {

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
    private void handleModifyPart(Part part) {
        Part selectedPart = partTable.getSelectionModel().getSelectedItem();
        if (selectedPart != null) {
            boolean saveClicked = mainApp.showModifyPartDialog(selectedPart);
            

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
        primaryStage.close();}


    public void addPart(Part add){
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AddPart.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Part");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AddPartController controller = loader.getController();
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
