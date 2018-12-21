package entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "vehicules")
public class VehiculesEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Float price;
    private Integer quantity;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OptionsEntity> options;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private TypeEntity type;
    
   
    public VehiculesEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public TypeEntity getType() {
        return type;
    }

    public void setType(TypeEntity type) {
        this.type = type;
    }

    public List<OptionsEntity> getOption() {
         return this.options;
    }

    public void setOption(List<OptionsEntity> option) {
        this.options = option;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}