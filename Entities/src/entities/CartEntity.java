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
@Table(name = "cart")
public class CartEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Boolean enCours;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VehiculesEntity> vehicules;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserEntity user;
    
    
    public CartEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getEnCours() {
        return this.enCours;
    }

    public void setEnCours(Boolean enCours) {
        this.enCours = enCours;
    }
    
    public List<VehiculesEntity> getVehicules() {
        return this.vehicules;
    }

    public void setVehicules(List<VehiculesEntity> vehicules) {
        this.vehicules = vehicules;
    }
    
    public UserEntity getUser() {
        return this.user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}