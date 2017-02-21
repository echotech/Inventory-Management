package wgu.model;

import javafx.beans.property.StringProperty;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jreis on 2/9/2017.
 */
public class Outsourced extends Part{

    private StringProperty companyName;
    private StringProperty companyPhone;

    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }

    public String getCompanyName() {
        return companyName.get();
    }

    public StringProperty nameProperty(){return companyName;}

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone.set(companyPhone);
    }

    public String getCompanyPhone() {
        return companyPhone.get();
    }

    public StringProperty phoneProperty(){return companyPhone;}


    }


