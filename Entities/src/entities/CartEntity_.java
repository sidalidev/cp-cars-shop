package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-12-21T13:44:59.623+0100")
@StaticMetamodel(CartEntity.class)
public class CartEntity_ {
	public static volatile SingularAttribute<CartEntity, Integer> id;
	public static volatile SingularAttribute<CartEntity, Boolean> enCours;
	public static volatile ListAttribute<CartEntity, VehiculesEntity> vehicules;
	public static volatile SingularAttribute<CartEntity, UserEntity> user;
}
