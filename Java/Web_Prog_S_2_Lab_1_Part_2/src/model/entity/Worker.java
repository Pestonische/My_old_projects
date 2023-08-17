package model.entity;

public class Worker {

	/**
     * id of worker
     */
    private int id;

    /**
     * profile of worker
     */
    private String profile;
    /**
     * task id of worker
     */
    private int taskId;
    
    /**
     * constructor to create worker
     * @param id id of worker
     * @param profile of worker
     */
    public Worker(int id, String profile, int taskId) {
        setId(id);
        setProfile(profile);
        setTaskId(taskId);
    }
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return String.format("Worker:\n\tid - %d\n\tprofile - %s task - %d", id, profile, taskId);
    }
	
}
