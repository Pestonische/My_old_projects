package model.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Doctor.class)
public class Doctor_ {

	public static volatile SingularAttribute<Doctor, Integer> id;
    public static volatile SingularAttribute<Doctor, String> fio;
    public static volatile ListAttribute<Doctor, Record> record;
	
}
