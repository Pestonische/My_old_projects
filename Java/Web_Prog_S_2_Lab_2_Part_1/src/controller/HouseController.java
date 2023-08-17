package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.dao.RequestDAO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import model.dao.TenantDAO;
import model.dao.WorkerDAO;
import model.entity.Worker;
import model.entity.Tenant;
import model.entity.Request;
import model.exception.DAOException;
import model.exception.HouseControllerException;

/**
 * controller
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */
public class HouseController {

	private Logger logger = LogManager.getLogger("controller_layer");
	
	public void readRequest() throws HouseControllerException {
        ArrayList<Request> requests = new ArrayList<>();
        try {
            RequestDAO tmp = new RequestDAO();
            requests = tmp.readRequest();
            logger.info("read request");
            for(Request r: requests)
            {
                System.out.println(r);
            }
        } catch (DAOException e) {
            throw new HouseControllerException("Failed to read doctor", e);
        }
	}

    public void readWorkersByIdTask(Request request) throws HouseControllerException {
        ArrayList<Worker> workers = new ArrayList<Worker>();
        try {
            WorkerDAO tmp = new WorkerDAO();
            workers = tmp.readWorkerById(request.getId());
            logger.info("read workers");
            for(Worker w: workers)
            {
                System.out.println(w);
            }
        } catch (DAOException e) {
            throw new HouseControllerException("Failed to read workers", e);
        }
    }
    public void readRequestByOverdue() throws HouseControllerException {
        ArrayList<Request> requests = new ArrayList<>();
        try {
            RequestDAO tmp = new RequestDAO();
            requests = tmp.readRequestByOverdue();
            logger.info("read requests");
            for(Request r: requests)
            {
                System.out.println(r);
            }
        } catch (DAOException e) {
            throw new HouseControllerException("Failed to read requests", e);
        }
    }

    public void assigningWorker(Request request) throws HouseControllerException {
        try {
            WorkerDAO workerDAO = new WorkerDAO();

            ArrayList<Worker> workers = workerDAO.readWorkerById(0);
            if(request.getComplete() != true) {
                if (workers.size() > 0) {
                    for (int i = 0; i < request.getNumberWorkers(); i++) {
                        workerDAO.updateTask(workers.get(i), request.getId());
                        workers.get(i).setTaskId(request.getId());
                    }
                    logger.info("assigning worker");
                    RequestDAO requestDAO = new RequestDAO();
                    requestDAO.updateComplete(request.getId());
                    request.setComplete(true);
                } else {
                    logger.info("there aren't free masters");
                    deleteRequest(request);
                }
            }
        } catch (DAOException e) {
            throw new HouseControllerException("Failed to assigning worker", e);
        }
    }
    public void deleteRequest(Request request) throws HouseControllerException {
        try {
            RequestDAO requestDAO = new RequestDAO();
            requestDAO.deleteRequest(request);
            request.setComplete(true);
        } catch (DAOException e) {
            throw new HouseControllerException("Failed to assigning worker", e);
        }
    }
    public void completeWork(Worker worker, int time) throws HouseControllerException {
        try {
            WorkerDAO workerDAO = new WorkerDAO();
            RequestDAO requestDAO = new RequestDAO();
            if(time > requestDAO.selectRequestById(worker.getTaskId()).getTime())
            {
                requestDAO.updateOverdue(worker.getTaskId(), true);
            }
            else{
                requestDAO.updateOverdue(worker.getTaskId(), false);
            }
            workerDAO.updateTask(worker, 0);
            worker.setTaskId(0);
            logger.info("assigning worker");
        } catch (DAOException e) {
            throw new HouseControllerException("Failed to assigning worker", e);
        }
    }
}
