package wgu.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by jreis on 2/9/2017.
 */
public class Outsourced extends Part {

    private StringProperty companyName;
    private StringProperty companyPhone;


    public Outsourced(String name, double partPrice, int partInstock) {
        super(name, partPrice, partInstock);
        this.companyName=new SimpleStringProperty("Change me!");
    }

    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }

    public String getCompanyName() {
        return companyName.get();
    }

    public StringProperty companyNameProperty() {
        return companyName;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone.set(companyPhone);
    }

    public String getCompanyPhone() {
        return companyPhone.get();
    }

    public StringProperty phoneProperty() {
        return companyPhone;
    }


}


