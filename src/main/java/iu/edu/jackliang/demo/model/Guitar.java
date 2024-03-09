package iu.edu.jackliang.demo.model;

import iu.edu.jackliang.demo.enums.Builder;
import iu.edu.jackliang.demo.enums.Type;
import iu.edu.jackliang.demo.enums.Wood;

public class Guitar {
    private String serialNumber;
    private Double price;
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood topWood;

    public Guitar(String sn, Double price, Builder b, String m, Type t, Wood bW, Wood tW){
        this.serialNumber = sn;
        this.price = price;
        this.builder = b;
        this.model = m;
        this.type = t;
        this.backWood = bW;
        this.topWood = tW;
    }

    public String getSerialNumber(){
        return this.serialNumber;
    }
    public double price(){
        return this.price;
    }
    public void setPrice(Double np){
        this.price = np;
    }
    public Builder getBuilder(){
        return this.builder;
    }
    public String getModel(){
        return this.model;
    }
    public Type getType(){
        return this.type;
    }
    public Wood getBackWood(){
        return this.backWood;
    }
    public Wood getTopWood(){
        return this.topWood;
    }


}
