package model.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Record.class)
public class Record_ {

	public static volatile SingularAttribute<Record, Integer> id;
    public static volatile SingularAttribute<Record, String> diagnosis;
    public static volatile SingularAttribute<Record, Boolean> discharged;
    public static volatile SingularAttribute<Record, Patient> patient;
    public static volatile SingularAttribute<Record, Doctor> doctor;
    
}