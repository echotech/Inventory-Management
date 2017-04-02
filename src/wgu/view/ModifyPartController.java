package wgu.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import wgu.MainApp;
import wgu.model.InHouse;
import wgu.model.Outsourced;
import wgu.model.Part;

import java.util.Optional;

/**
 * Created by jreis on 2/28/2017.
 */
public class ModifyPartController {


    @FXML
    private TextField idLabel;
    @FXML
    private TextField nameLabel;
    @FXML
    private TextField invLabel;
    @FXML
    private TextField priceLabel;
    @FXML
    private TextField minLabel;
    @FXML
    private TextField maxLabel;
    @FXML
    private Label companyNameText;
    @FXML
    private Label machineIdText;
    @FXML
    private TextField machineIdLabel;
    @FXML
    private TextField companyNameLabel;
    @FXML
    ToggleButton tbInhouse = new ToggleButton();
    @FXML
    ToggleButton tbOutsourced = new ToggleButton();
    @FXML
    final ToggleGroup partType = new ToggleGroup();



    private Stage dialogStage;
    private Part part;
    private boolean saveClicked = false;
    // Reference to the main application.
    private MainApp mainApp;


    @FXML
    private void initialize() {
        tbInhouse.setToggleGroup(partType);
        tbOutsourced.setToggleGroup(partType);

        companyNameText.setVisible(false);
        companyNameLabel.setVisible(false);
        tbInhouse.setSelected(true);

        partType.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle oldToggle, Toggle newToggle) {

             if (newToggle.equals(tbInhouse)) {
                    companyNameText.setVisible(false);
                    companyNameLabel.setVisible(false);
                    machineIdText.setVisible(true);
                    machineIdLabel.setVisible(true);
                } else if (newToggle.equals(tbOutsourced)) {
                    companyNameText.setVisible(true);
                    companyNameLabel.setVisible(true);
                    machineIdText.setVisible(false);
                    machineIdLabel.setVisible(false);
                }
            }
        });
    }


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPart(Part part) {
        // Fill the labels with info from the part object.
        this.part = part;
        idLabel.setText(Integer.toString(part.getPartID()));
        nameLabel.setText(part.getPartName());
        invLabel.setText(Integer.toString(part.getPartInstock()));
        priceLabel.setText(Double.toString(part.getPartPrice()));
        minLabel.setText(Integer.toString(part.getPartMin()));
        maxLabel.setText(Integer.toString(part.getPartMax()));

        if (part instanceof InHouse) {
            machineIdLabel.setText(Integer.toString(((InHouse) part).getMachineID()));
            tbInhouse.setSelected(true);
            companyNameLabel.setVisible(false);
            companyNameText.setVisible(false);
        } else {
            companyNameLabel.setText(((Outsourced) part).getCompanyName());
            tbOutsourced.setSelected(true);
            machineIdLabel.setVisible(false);
            machineIdText.setVisible(false);
        }
    }

    public boolean isSaveClicked() {
        return saveClicked;
    }

    @FXML
    private void handleModifySave() {

        if (isInputValid()) {
            mainApp.getPartData().remove(part);
            if (partType.getSelectedToggle().equals(tbInhouse)) {
                try {
                    Integer partId = Integer.parseInt(idLabel.getText());
                    Integer partInstock = Integer.parseInt(invLabel.getText());
                    String partName = nameLabel.getText();
                    Double partPrice = Double.parseDouble(priceLabel.getText());
                    Integer partMin = Integer.parseInt(minLabel.getText());
                    Integer partMax = Integer.parseInt(maxLabel.getText());
                    Integer macId = Integer.parseInt(machineIdLabel.getText());


                    Part part = new InHouse(partName,partPrice,partInstock);
                    part.setPartName(partName);
                    part.setPartID(partId);
                    part.setPartPrice(partPrice);
                    part.setPartInstock(partInstock);
                    part.setPartMin(partMin);
                    part.setPartMax(partMax);
                    ((InHouse) part).setMachineID(macId);

                    mainApp.addPartData(part);
                    saveClicked = true;
                    dialogStage.close();

                } catch (NumberFormatException nfe) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.initOwner(dialogStage);
                    alert.setTitle("Invalid Fields");
                    alert.setHeaderText("Please correct invalid fields");
                    alert.setContentText("Ensure all fields have accurate data");

                    alert.showAndWait();
                }


            } else if (partType.getSelectedToggle().equals(tbOutsourced)) {
                try {
                    Integer partId = Integer.parseInt(idLabel.getText());
                    Integer partInstock = Integer.parseInt(invLabel.getText());
                    String partName = nameLabel.getText();
                    Double partPrice = Double.parseDouble(priceLabel.getText());
                    Integer partMin = Integer.parseInt(minLabel.getText());
                    Integer partMax = Integer.parseInt(maxLabel.getText());
                    String compName = companyNameLabel.getText();

                    Part part = new Outsourced(partName, partPrice, partInstock);

                    ((Outsourced) part).setCompanyName(compName);
                    part.setPartID(partId);
                    part.setPartMin(partMin);
                    part.setPartMax(partMax);
                    part.setPartName(partName);
                    part.setPartPrice(partPrice);
                    part.setPartInstock(partInstock);

                    mainApp.addPartData(part);
                    saveClicked = true;
                    dialogStage.close();

                } catch (NumberFormatException nfe) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.initOwner(dialogStage);
                    alert.setTitle("Invalid Fields");
                    alert.setHeaderText("Please correct invalid fields");
                    alert.setContentText("Ensure all fields have accurate data");

                    alert.showAndWait();
                }


            } else {
                // Show the error message.
                Alert alert = new Alert(AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("Please correct invalid fields");
                alert.setContentText("Please select In-House or Outsourced");

                alert.showAndWait();

            }

        }
    }

    @FXML
    private void handleNewSave() {
        if (isInputValid()) {
            if (partType.getSelectedToggle().equals(tbInhouse)) {
                try {
                    Integer partInstock = Integer.parseInt(invLabel.getText());
                    String partName = nameLabel.getText();
                    Double partPrice = Double.parseDouble(priceLabel.getText());
                    Integer partMin = Integer.parseInt(minLabel.getText());
                    Integer partMax = Integer.parseInt(maxLabel.getText());
                    Integer macId = Integer.parseInt(machineIdLabel.getText());

                    Part part = new InHouse(partName, partPrice, partInstock);
                    part.setPartName(partName);
                    part.setPartPrice(partPrice);
                    part.setPartInstock(partInstock);
                    part.setPartMin(partMin);
                    part.setPartMax(partMax);
                    ((InHouse) part).setMachineID(macId);

                    mainApp.addPartData(part);

                    saveClicked = true;
                    dialogStage.close();

                } catch (NumberFormatException nfe) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.initOwner(dialogStage);
                    alert.setTitle("Invalid Fields");
                    alert.setHeaderText("Please correct invalid fields");
                    alert.setContentText("Ensure all fields have accurate data");

                    alert.showAndWait();
                }
            } else if (partType.getSelectedToggle().equals(tbOutsourced)) {
                try {
                    Integer partInstock = Integer.parseInt(invLabel.getText());
                    String partName = nameLabel.getText();
                    Double partPrice = Double.parseDouble(priceLabel.getText());
                    Integer partMin = Integer.parseInt(minLabel.getText());
                    Integer partMax = Integer.parseInt(maxLabel.getText());
                    String compName = companyNameLabel.getText();

                    Part outPart = new Outsourced(partName, partPrice, partInstock);
                    outPart.setPartMin(partMin);
                    outPart.setPartMax(partMax);
                    ((Outsourced) outPart).setCompanyName(compName);

                    mainApp.addPartData(outPart);
                    saveClicked = true;
                    dialogStage.close();

                } catch (NumberFormatException nfe) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.initOwner(dialogStage);
                    alert.setTitle("Invalid Fields");
                    alert.setHeaderText("Please correct invalid fields");
                    alert.setContentText("Ensure all fields have accurate data");

                    alert.showAndWait();
                }
            } else {
                // Show the error message.
                Alert alert = new Alert(AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("Please correct invalid fields");
                alert.setContentText("Please select In-House or Outsourced");

                alert.showAndWait();

            }
        }
    }


    public boolean isDupePartId() {

        try {
            int currentId = part.getPartID();

        if (idLabel.getText() == null) {
            System.out.println("null");
            return false;
        } else {
            if (currentId == new Integer(idLabel.getText())) {
                System.out.println("Current match");

                return false;
            } else {
                for (Part p : mainApp.getPartData()) {
                    if (p.getPartID() == (new Integer(idLabel.getText()))) {
                        System.out.println("dupe");
                        return true;
                    }

                }
            }

        }
        } catch(NumberFormatException nfe){
            System.out.println("Nfe");
            return false;
        }
        catch(NullPointerException npe){
            return false;
        }
        System.out.println("nothing ventured");
        return false;
    }

    /**
     * Validates text
     *
     * @return
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameLabel.getText() == null || nameLabel.getText().length() == 0) {
            errorMessage += "No valid product name!\n";
        }
        if (invLabel.getText() == null || invLabel.getText().length() == 0) {
            errorMessage += "No valid inventory amount!\n";
        }
        if (minLabel.getText() == null || minLabel.getText().length() == 0) {
            errorMessage += "No valid min!\n";
        }

        if (isDupePartId()){
            errorMessage += "A part with that ID already exists!\n";
        }

        if (maxLabel.getText() == null || maxLabel.getText().length() == 0) {
            errorMessage += "No valid max!\n";
        }

        if (new Integer(maxLabel.getText()) < new Integer(minLabel.getText())) {
            errorMessage += "Max must be greater than min!\n";
        }

        if (new Integer(maxLabel.getText()) < new Integer(minLabel.getText())) {
            errorMessage += "Min must be less than max!\n";
        }

        if (new Integer(invLabel.getText()) < new Integer(minLabel.getText())) {
            errorMessage += "Inventory below minimum!\n";
        }

        if (new Integer(invLabel.getText())> new Integer(maxLabel.getText())) {
            errorMessage += "Inventory above maximum!\n";
        }

        if (priceLabel.getText() == null || priceLabel.getText().length() == 0) {
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

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancel?");
        alert.setHeaderText("Are you sure you want to cancel?");
        alert.setContentText("Data will not be saved.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            dialogStage.close();
        }
    }

}
