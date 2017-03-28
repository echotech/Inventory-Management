package wgu.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by jreis on 2/9/2017.
 */
public class InHouse extends Part {


    private IntegerProperty machineID;

    public void setMachineID(int machineID) {
        this.machineID.set(machineID);
    }

    public int getMachineID() {
        return machineID.get();
    }

    public IntegerProperty machineIDProperty() {
        return machineID;
    }


    public InHouse(String name, double partPrice, int partInstock) {
        super(name, partPrice, partInstock);
        this.machineID = new SimpleIntegerProperty(1);

    }
}
