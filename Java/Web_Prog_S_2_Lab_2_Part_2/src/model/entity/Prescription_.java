package model.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Prescription.class)
public class Prescription_ {

	public static volatile SingularAttribute<Prescription, Integer> id;
    public static volatile SingularAttribute<Prescription, String> name;
    public static volatile SingularAttribute<Prescription, Patient> patient;
	
}