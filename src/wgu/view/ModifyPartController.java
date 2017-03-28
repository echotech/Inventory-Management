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
    @FXML
    private Button save;
    @FXML
    private Button cancel;

    private Stage dialogStage;
    private Part part;
    private boolean saveClicked = false;
    // Reference to the main application.
    private MainApp mainApp;


    @FXML
    private void initialize() {
        tbInhouse.setToggleGroup(partType);
        tbOutsourced.setToggleGroup(partType);

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

    /**
     * Modify Part Button
     *
     * @param part
     */
    public void setPart(Part part) {
        // Fill the labels with info from the part object.
        this.part = part;
        idLabel.setText(Integer.toString(part.getPartID()));
        nameLabel.setText(part.getPartName());
        invLabel.setText(Integer.toString(part.getPartInstock()));
        priceLabel.setText(Double.toString(part.getPartPrice()));
        minLabel.setText(Integer.toString(part.getPartMin()));
        maxLabel.setText(Integer.toString(part.getPartMax()));
        companyNameText.setText(((Outsourced) part).getCompanyName());
        machineIdText.setText(Integer.toString(((InHouse) part).getMachineID()));
    }

    public boolean isSaveClicked() {
        return saveClicked;
    }

    @FXML
    private void handleSave() {
        if (partType.getSelectedToggle().equals(tbInhouse)) {
            try{
            Integer partInstock = Integer.parseInt(invLabel.getText());
            String partName = nameLabel.getText();
            Double partPrice = Double.parseDouble(priceLabel.getText());
            Integer partMin = Integer.parseInt(minLabel.getText());
            Integer partMax = Integer.parseInt(maxLabel.getText());
            Integer macId = Integer.parseInt(machineIdLabel.getText());

            Part ihPart = new InHouse(partName, partPrice, partInstock);
            ihPart.setPartMin(partMin);
            ihPart.setPartMax(partMax);
            ((InHouse) ihPart).setMachineID(macId);

            mainApp.addPartData(ihPart);
            saveClicked = true;
            dialogStage.close();

            } catch(NumberFormatException nfe){
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

            } catch(NumberFormatException nfe){
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

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
