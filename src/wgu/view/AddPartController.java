package wgu.view;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import wgu.model.*;
import wgu.MainApp;


/**
 * Dialog to edit details of a person.
 *
 * @author Jed Reisner
 */
public class AddPartController {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField invField;
    @FXML
    private TextField costField;
    @FXML
    private TextField minField;
    @FXML
    private TextField maxField;
    @FXML
    private TextField companyField;
    @FXML
    private TextField machineIDField;


    private Stage dialogStage;
    private Outsourced out;
    private InHouse in;
    public RadioButton prodType;

    private MainApp mainApp;


    public AddPartController(){
    }
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }



    /**
     * Sets the part to be edited in the dialog.
     *
     * @param out
     */
    public void setOutsourced(Outsourced out) {
        this.out = out;

        idField.setText(Integer.toString(out.getPartID()));
        nameField.setText(out.getPartName());
        invField.setText(Integer.toString(out.getPartInstock()));
        costField.setText(Double.toString(out.getPartPrice()));
        minField.setText(Integer.toString(out.getPartMin()));
        maxField.setText(Integer.toString(out.getPartMax()));
        companyField.setText(out.getCompanyName());
           }

    public void setInHouse(InHouse in) {
        this.in = in;

        idField.setText(Integer.toString(in.getPartID()));
        nameField.setText(out.getPartName());
        invField.setText(Integer.toString(out.getPartInstock()));
        costField.setText(Double.toString(out.getPartPrice()));
        minField.setText(Integer.toString(out.getPartMin()));
        maxField.setText(Integer.toString(out.getPartMax()));
        machineIDField.setText(Integer.toString(in.getMachineID()));

    }



    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "Please input valid name!\n";
        }
        if (invField.getText() == null || invField.getText().length() == 0) {
            errorMessage += "Please enter inventory!\n";
        }
        if (costField.getText() == null || costField.getText().length() == 0) {
            errorMessage += "Missing cost!\n";
        }

        if (minField.getText() == null || minField.getText().length() == 0) {
            errorMessage += "Need to set min!\n";
        }

        if (maxField.getText() == null || maxField.getText().length() == 0) {
            errorMessage += "Need to set max!\n";
        }

        if (companyField.getText() == null || companyField.getText().length() == 0) {
            errorMessage += "No valid company!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}