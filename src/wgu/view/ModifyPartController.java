package wgu.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import wgu.model.InHouse;
import wgu.model.Outsourced;
import wgu.model.Part;

/**
 * Created by jreis on 2/28/2017.
 */
public class ModifyPartController {

    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label invLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label minLabel;
    @FXML
    private Label maxLabel;
    @FXML
    private Label companyLabel;
    @FXML
    private Label companyNameLabel;
    @FXML
    private Label machineIdLabel;
    @FXML
    private TextField companyNameText;
    @FXML
    private TextField machineIdText;

    private Stage dialogStage;
    private Part part;
    private boolean saveClicked= false;

    @FXML
    protected void onInhouseRadioButtonSelected() {
        companyNameLabel.setVisible(false);
        companyNameText.setVisible(false);
        machineIdLabel.setVisible(true);
        machineIdText.setVisible(true);
    }

    /**
     * Hides MachineID and shows CompanyName.
     */
    @FXML
    protected void onOutsourcedRadioButtonSelected() {
        companyNameLabel.setVisible(true);
        companyNameText.setVisible(true);
        machineIdLabel.setVisible(false);
        machineIdText.setVisible(false);
    }


    /** Modify Part Button
     *
     * @param part
     */
    private void modifyPart(Part part) {
        // Fill the labels with info from the part object.
        idLabel.setText(Integer.toString(part.getPartID()));
        nameLabel.setText(part.getName());
        invLabel.setText(Integer.toString(part.getInstock()));
        priceLabel.setText(Double.toString(part.getPrice()));
        minLabel.setText(Integer.toString(part.getMin()));
        maxLabel.setText(Integer.toString(part.getMax()));
        companyNameLabel.setText(Integer.toString((Outsourced)part.getCompanyName()));
        machineIdLabel.setText(Integer.toString(InHouse.getMachineID()));
    }

    public boolean saveClicked(){return saveClicked;}

    private void handleSave(){
        if (inHouseSelected){
            part.setPartID(Integer.parseInt(idLabel.getText()));
            part.setName(nameLabel.getText());
            part.setInstock(Integer.parseInt(invLabel.getText());
            part.setPrice(Double.parseDouble(priceLabel.getText()));
            part.setMin(Integer.parseInt(minLabel.getText()));
            part.setMax(Integer.parseInt(maxLabel.getText()));
            (InHouse)part.setMachineID(Integer.parseInt(machineIdLabel.getText()));
        } else if (outSourcedSelected){
            part.setPartID(Integer.parseInt(idLabel.getText()));
            part.setName(nameLabel.getText());
            part.setInstock(Integer.parseInt(invLabel.getText());
            part.setPrice(Double.parseDouble(priceLabel.getText()));
            part.setMin(Integer.parseInt(minLabel.getText()));
            part.setMax(Integer.parseInt(maxLabel.getText()));
            (Outsourced)part.setCompanyName(companyNameLabel.getText());

        } else {
            return;
        }
    }



}
