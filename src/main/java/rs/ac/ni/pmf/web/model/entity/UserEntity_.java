package rs.ac.ni.pmf.web.model.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import rs.ac.ni.pmf.web.model.entity.UserEnums.UserType;

@StaticMetamodel(UserEntity.class)
public class UserEntity_ {
	public static volatile SingularAttribute<UserEntity, Integer> id;
	public static volatile SingularAttribute<UserEntity, String> username;
	public static volatile SingularAttribute<UserEntity, UserType> userType;
	public static volatile SingularAttribute<UserEntity, VehicleEntity> vehicle;
}