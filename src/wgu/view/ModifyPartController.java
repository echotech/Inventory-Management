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
    private TextField companyNameText;
    @FXML
    private TextField machineIdText;
    @FXML
    private Label machineIdLabel;
    @FXML
    private Label companyNameLabel;
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
        tbInhouse.setSelected(true);

        partType.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                if (partType.getSelectedToggle().equals(tbInhouse)) {
                    companyNameText.setVisible(false);
                    companyNameLabel.setVisible(false);
                    machineIdText.setVisible(true);
                    machineIdLabel.setVisible(true);
                } else if (partType.getSelectedToggle().equals(tbOutsourced)) {
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
            Part part = new InHouse();
            part.setPartID(Integer.parseInt(idLabel.getText()));
            part.setPartName(nameLabel.getText());
            part.setPartInstock(Integer.parseInt(invLabel.getText()));
            part.setPartPrice(Double.parseDouble(priceLabel.getText()));
            part.setPartMin(Integer.parseInt(minLabel.getText()));
            part.setPartMax(Integer.parseInt(maxLabel.getText()));
            ((InHouse) part).setMachineID(Integer.parseInt(machineIdText.getText()));

            saveClicked = true;
            dialogStage.close();

        } else if (partType.getSelectedToggle().equals(tbOutsourced)) {
            Part part = new Outsourced();
            part.setPartID(Integer.parseInt(idLabel.getText()));
            part.setPartName(nameLabel.getText());
            part.setPartInstock(Integer.parseInt(invLabel.getText()));
            part.setPartPrice(Double.parseDouble(priceLabel.getText()));
            part.setPartMin(Integer.parseInt(minLabel.getText()));
            part.setPartMax(Integer.parseInt(maxLabel.getText()));
            ((Outsourced) part).setCompanyName(companyNameText.getText());

            saveClicked = true;
            dialogStage.close();
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
