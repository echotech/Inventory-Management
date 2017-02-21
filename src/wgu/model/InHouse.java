package wgu.model;

import javafx.beans.property.IntegerProperty;

/**
 * Created by jreis on 2/9/2017.
 */
public class InHouse extends Part{
    private IntegerProperty machineID;

    public void setMachineID(int machineID) {
        this.machineID.set(machineID);
    }

    public int getMachineID() {
        return machineID.get();
    }

    public IntegerProperty machineIDProperty(){return machineID;}
}
