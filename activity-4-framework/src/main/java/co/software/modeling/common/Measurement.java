package co.software.modeling.common;

import co.software.modeling.common.Tag;

public class Measurement  {
    private int id;
    private double value;
    private String nameOfProduct;
    private Tag tag;
    private boolean takeAction;

    public Measurement(int id, double value, String nameOfProduct) {
        this.id = id;
        this.value = value;
        this.nameOfProduct = nameOfProduct;

    }

    public boolean getTakeAction() {
        return takeAction;
    }

    public void setTakeAction(boolean takeAction) {
        this.takeAction = takeAction;
    }


    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    @Override
    public String toString() {
        return "Measurement { id= "+ id + "name of product = " + nameOfProduct + ", value= " + value + ", tag = {key= " + tag.getKey() + " value= " + tag.getValue() + " take action =" + takeAction + " }}";
    }
}

