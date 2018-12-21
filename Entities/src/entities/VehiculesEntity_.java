package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-12-21T12:37:33.944+0100")
@StaticMetamodel(VehiculesEntity.class)
public class VehiculesEntity_ {
	public static volatile SingularAttribute<VehiculesEntity, Integer> id;
	public static volatile SingularAttribute<VehiculesEntity, String> name;
	public static volatile SingularAttribute<VehiculesEntity, Float> price;
	public static volatile SingularAttribute<VehiculesEntity, Integer> quantity;
	public static volatile ListAttribute<VehiculesEntity, OptionsEntity> options;
	public static volatile SingularAttribute<VehiculesEntity, TypeEntity> type;
}
