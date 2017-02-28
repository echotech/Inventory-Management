package wgu.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import wgu.model.Outsourced;
import wgu.model.Part;

/**
 * Created by jreis on 2/28/2017.
 */
public class ModifyPartController {

    @FXML
    private Label iDLabel;
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
        iDLabel.setText(Integer.toString(part.getPartID()));
        nameLabel.setText(part.getName());
        invLabel.setText(Integer.toString(part.getInstock()));
        priceLabel.setText(Double.toString(part.getPrice()));
        minLabel.setText(Integer.toString(part.getMin()));
        maxLabel.setText(Integer.toString(part.getMax()));
        companyLabel.setText((Outsourced)part.getCompanyName());
    }



}
