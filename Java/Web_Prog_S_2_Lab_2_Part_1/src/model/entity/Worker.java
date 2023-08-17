package model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * class that represent Worker entity
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */

@Entity(name = "Worker")
@Table(name = Worker.tableName)
@NamedQueries({

    @NamedQuery(
            name = "readWorkers",
            query = "select * from worker"
    ),
    @NamedQuery(
            name = "readWorkersById",
            query = "select * from Worker r where r.id = :id"
    ),
    @NamedQuery(
            name = "updateWorkersTaskId",
            query = "update Worker r set r.task_id = :task_id where r.id = :id"
    ),

})
public class Worker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String tableName = "Workers";
	
	/**
     * id of Worker
     */
    @Id
    @GeneratedValue
    private int id;
    /**
     * profile of worker
     */
    private String profile;
    
    /**
     * doctor_id of Worker
     */
    @ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
    private Request task;
    

    
    /**
     * Default constructor to create Worker
     */
    public Worker() {
        setId(0);
        setProfile("");
        setTaskId(0);
    }
    

    public Worker(int id, String profile, Request task) {
        setId(id);
        setProfile(profile);
        setTaskId(task.getId());
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getTaskId() {
    	return task.getId();
    }

    public void setTaskId(int task_id) {
    	this.task.setId(task_id);
    }
    @Override
    public String toString() {
        return String.format("Worker:\n\tid - %d\n\tprofile - %s task - %d", id, profile, task);
    }
    
}
