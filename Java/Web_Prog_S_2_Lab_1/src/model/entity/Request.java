package model.entity;

public class Request {

	/**
     * id of request
     */
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
     * tenant id
     */
    private int tenant_id;
    /**
     * time
     */
    private int time;
    /**
     * constructor to create request
     * @param id id of request
     * @param type of tenant
     * @param overdue of tenant
     * @param tenant_id of tenant
     */
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
    	return tenant_id;
    }
    
    public void setPatientId(int patient_id) {
    	this.tenant_id = patient_id;
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
                id, type, numberWorkers, tenant_id, time, complete, overdue);
    }
}
