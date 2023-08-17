package model.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Patient.class)
public class Patient_ {

	public static volatile SingularAttribute<Patient, Integer> id;
    public static volatile SingularAttribute<Patient, String> fio;
    public static volatile ListAttribute<Patient, Prescription> prescriptions;
    public static volatile ListAttribute<Patient, Record> records;
	
}