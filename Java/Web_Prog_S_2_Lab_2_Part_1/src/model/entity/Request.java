package model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * class that represent Request entity
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */

@Entity(name = "Request")
@Table(name = Request.tableName)
@NamedQueries({
    @NamedQuery(
            name = "deleteRequest",
            query = "delete from request d where d.id = :id"),
    @NamedQuery(
            name = "readRequests",
            query = "select * from request"),
    @NamedQuery(
            name = "readRequest",
            query = "select d from request d where d.id = :id"),
    @NamedQuery(
            name = "readRequestByOverdue",
            query = "select d from request d where d.overdue = :overdue"),
    @NamedQuery(
            name = "updateRequestComplete",
            query = "update request r set r.complete = :complete where r.id = :id"),
    @NamedQuery(
            name = "readRequestOverdue",
            query = "update request r set r.overdue = :overdue where r.id = :id"),
})
public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String tableName = "Requests";
	
	/**
     * id of Request
     */
    @Id
    @GeneratedValue
    private int id;
    /**
     * type
     */
    private String type;

    /**
     * overdue or not
     */
    private boolean overdue;
    /**
     * complete or not
     */
    private boolean complete;
    /**
     * number of workers
     */
    private int numberWorkers;
    /**
     * time
     */
    private int time;
    
    @OneToMany(cascade=CascadeType.MERGE, mappedBy = "Request")
    private Tenant tenant;
    
    /**
     * Default constructor
     */
    public Request() {
        setId(0);
        setId(0);
        setType("");
        setOverdue(false);
        setNumberWorkers(0);
        setPatientId(0);
        setTime(time);
        setComplete(false);
    }
    public Request(int id, String type, int numberWorkers, int tenant_id, int time, boolean overdue, boolean complete) {
        setId(id);
        setType(type);
        setOverdue(overdue);
        setNumberWorkers(numberWorkers);
        setPatientId(tenant_id);
        setTime(time);
        setComplete(complete);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberWorkers(int numberWorkers) {
        this.numberWorkers = numberWorkers;
    }

    public int getNumberWorkers() {
        return numberWorkers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    public int getTenant_id() {
        return tenant.getId();
    }

    public void setPatientId(int patient_id) {
        this.tenant.setId(patient_id);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    @Override
    public String toString() {
        return String.format("Request:\n\tid - %d\n\ttype - %s\n\tnumberWorkers - %d\n\ttenant_id - %d\n\ttime - %d\n\tcomplete - %s\n\toverdue - %s",
                id, type, numberWorkers, tenant.getId(), time, complete, overdue);
    }
	
}
