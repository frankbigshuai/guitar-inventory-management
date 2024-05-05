package iu.edu.frank.demo.model;

import iu.edu.frank.demo.enums.Builder;
import iu.edu.frank.demo.enums.Type;
import iu.edu.frank.demo.enums.Wood;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Guitar {
    @Id
    @Column(name = "guitar_serialNumber")
    private String serialNumber;
    @Column(name = "guitar_price")
    private Double price;
    @Column(name = "guitar_builder")
    private Builder builder;
    @Column(name = "guitar_model")
    private String model;
    @Column(name = "guitar_type")
    private Type type;
    @Column(name = "guitar_backwood")
    private Wood backWood;
    @Column(name = "guitar_topwood")
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



}
