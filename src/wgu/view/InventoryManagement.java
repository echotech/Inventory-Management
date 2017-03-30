package wgu.view;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import wgu.MainApp;
import wgu.model.InHouse;
import wgu.model.Part;
import wgu.model.Product;


/**
 * Created by jreis on 2/27/2017.
 */
public class InventoryManagement {

    @FXML
    private TextField searchPartTextField;
    @FXML
    private TextField searchProductTextField;
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

        //Search for parts by name or ID.
        FilteredList<Part> filteredPart = new FilteredList<>(mainApp.getPartData(), p -> true);

        searchPartTextField.textProperty().addListener((observable, oldValue, newValue)->{
            filteredPart.setPredicate(part ->{
                if (newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(Integer.toString(part.getPartID()).equals(newValue)){
                    return true;
                }
                else if(part.getPartName().equals(lowerCaseFilter)){
                    return true;
                }
                return false;
            });
        });

        SortedList<Part> sortedParts = new SortedList<>(filteredPart);
        sortedParts.comparatorProperty().bind(partTable.comparatorProperty());
        partTable.setItems(sortedParts);

        //Search for products by name or ID.
        FilteredList<Product> filteredProduct = new FilteredList<>(mainApp.getProductData(), p -> true);
        searchProductTextField.textProperty().addListener((observable, oldValue, newValue)->{
            filteredProduct.setPredicate(prod ->{
                if (newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(Integer.toString(prod.getProductID()).equals(newValue)){
                    return true;
                }
                else if(prod.getProductName().equals(lowerCaseFilter)){
                    return true;
                }
                return false;
            });
        });

        SortedList<Product> sortedProducts = new SortedList<>(filteredProduct);
        sortedProducts.comparatorProperty().bind(productTable.comparatorProperty());
        productTable.setItems(sortedProducts);
    }

    /**
     * Modify Part Button
     * edit details of existing part.
     */
    @FXML
    private void handleModifyPart() {
        Part selectedPart = partTable.getSelectionModel().getSelectedItem();
        if (selectedPart != null) {
            boolean saveClicked = mainApp.showModifyPartDialog(selectedPart);
            if (saveClicked) {

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
    public void handleAddPart() {

        boolean saveClicked = mainApp.showNewPartDialog();
        if (saveClicked) {
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
            alert.setHeaderText("No Part Selected");
            alert.setContentText("Please select a part in the table.");

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
            alert.setHeaderText("No Product Selected");
            alert.setContentText("Please select a product in the table.");

            alert.showAndWait();
        }
    }

    /**
     * Launches add new product window.
     */
    @FXML
    public void handleAddProduct(){
       Product tempProduct = new Product("Temp",1,1);
       boolean saveClicked = mainApp.showModifyProductDialog(tempProduct);
       if (saveClicked){
           mainApp.getProductData().add(tempProduct);
       }

    }

    /**
     * Modify Product Button
     * edit details of existing part.
     */
    @FXML
    private void handleModifyProduct() {
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            boolean saveClicked = mainApp.showModifyProductDialog(selectedProduct);
            if (saveClicked) {

                productTable.getColumns().get(0).setVisible(false);
                productTable.getColumns().get(0).setVisible(true);
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

    @FXML
    private void handleExit() {
        mainApp.primaryStage.close();
    }

}
