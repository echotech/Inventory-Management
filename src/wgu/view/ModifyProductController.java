package wgu.view;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import wgu.MainApp;
import wgu.model.Part;
import wgu.model.Product;

/**
 * Created by admin on 3/28/2017.
 */

public class ModifyProductController {
    private Product product;
    private Stage dialogStage;
    private boolean saveClicked = false;

    @FXML
    private TextField idText;
    @FXML
    private TextField nameText;
    @FXML
    private TextField invText;
    @FXML
    private TextField priceText;
    @FXML
    private TextField minText;
    @FXML
    private TextField maxText;
    @FXML
    private TextField searchPartText;
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

    public void initialize() {
        // Initialize the part table with the 4 columns.
        partIdColumn.setCellValueFactory(
                cellData -> cellData.getValue().partIDProperty().asObject());
        partNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().partNameProperty());
        partInvColumn.setCellValueFactory(
                cellData -> cellData.getValue().partInStockProperty().asObject());
        partPriceColumn.setCellValueFactory(
                cellData -> cellData.getValue().partPriceProperty().asObject());
    }


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        partTable.setItems(mainApp.getPartData());

        //Search for parts by name or ID.
        FilteredList<Part> filteredPart = new FilteredList<>(mainApp.getPartData(), p -> true);


        searchPartText.textProperty().addListener((observable, oldValue, newValue)->{
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
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setProduct(Product prod) {
        // Fill the labels with info from the part object.
        this.product = prod;
        idText.setText(Integer.toString(prod.getProductID()));
        nameText.setText(prod.getProductName());
        invText.setText(Integer.toString(prod.getProductInstock()));
        priceText.setText(Double.toString(prod.getProductPrice()));
        minText.setText(Integer.toString(prod.getProductMin()));
        maxText.setText(Integer.toString(prod.getProductMax()));
    }

    public boolean isSaveClicked() {
        return saveClicked;
    }

    @FXML
    private void handleNewSave() {
        if (isInputValid()) {
            try {
                Integer prodInstock = Integer.parseInt(invText.getText());
                String prodName = nameText.getText();
                Double prodPrice = Double.parseDouble(priceText.getText());
                Integer prodMin = Integer.parseInt(minText.getText());
                Integer prodMax = Integer.parseInt(maxText.getText());

                Product prod = new Product(prodName, prodPrice, prodInstock);
                prod.setProductPrice(prodPrice);
                prod.setProductInstock(prodInstock);
                prod.setProductMin(prodMin);
                prod.setProductMax(prodMax);

                mainApp.addProdData(prod);
                saveClicked = true;
                dialogStage.close();

            } catch (NumberFormatException nfe) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("Please correct invalid fields");
                alert.setContentText("Ensure all fields have accurate data");

                alert.showAndWait();
            }
        }
    }

    @FXML
    private void handleModSave() {
        if (isInputValid()) {
            try {
                Integer prodInstock = Integer.parseInt(invText.getText());
                String prodName = nameText.getText();
                Double prodPrice = Double.parseDouble(priceText.getText());
                Integer prodMin = Integer.parseInt(minText.getText());
                Integer prodMax = Integer.parseInt(maxText.getText());

                product.setProductName(prodName);
                product.setProductPrice(prodPrice);
                product.setProductInstock(prodInstock);
                product.setProductMin(prodMin);
                product.setProductMax(prodMax);

                saveClicked = true;
                dialogStage.close();

            } catch (NumberFormatException nfe) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("Please correct invalid fields");
                alert.setContentText("Ensure all fields have accurate data");

                alert.showAndWait();
            }
        }
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameText.getText() == null || nameText.getText().length() == 0) {
            errorMessage += "No valid product name!\n";
        }
        if (invText.getText() == null || invText.getText().length() == 0) {
            errorMessage += "No valid inventory amount!\n";
        }
        if (minText.getText() == null || minText.getText().length() == 0) {
            errorMessage += "No valid min!\n";
        }

        if (maxText.getText() == null || maxText.getText().length() == 0) {
            errorMessage += "No valid max!\n";
        }

        if (priceText.getText() == null || priceText.getText().length() == 0) {
            errorMessage += "No valid price!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }


        @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
