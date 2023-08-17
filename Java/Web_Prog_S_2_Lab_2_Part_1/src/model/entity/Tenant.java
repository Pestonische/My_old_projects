package model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * class that represent Tenant entity
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */
@Entity(name = "Tenant")
@Table(name = Tenant.tableName)
@NamedQueries({
    @NamedQuery(
            name = "readTenants",
            query = "select * from tenant"),
    @NamedQuery(
            name = "readTenant",
            query = "select p from tenant p where p.id = :id")
})
public class Tenant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String tableName = "Tenants";
	
	/**
     * id of Tenant
     */
	@Id
    @GeneratedValue
    private int id;

    /**
     * FIO of Tenant
     */
    private String fio;

    
    @OneToMany(cascade=CascadeType.MERGE, mappedBy = "Tenant")
    private List<Worker> records = new ArrayList<Worker>();
    
    
    /**
     * Default constructor to create Tenant
     */
    public Tenant() {
        setId(0);
        setFio("");
    }
    
    /**
     * constructor to create Tenant
     * @param id id of Tenant
     * @param FIO FIO of Tenant
     */
    public Tenant(int id, String fio) {
        setId(id);
        setFio(fio);
    }
	

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return String.format("Tenant:\n\tid - %d\n\tfio - %s", id, fio);
    }
    
}
