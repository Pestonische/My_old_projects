package view;


import controller.HouseController;
import model.dao.RequestDAO;
import model.dao.WorkerDAO;
import model.entity.Request;
import model.exception.DAOException;
import model.exception.HouseControllerException;

import java.util.logging.Logger;

public class Main {

	private static Logger logger = Logger.getLogger(String.valueOf(Main.class));
	
	public static void main(String[] args) {
		HouseController controller = new HouseController();
        try {
            controller.readRequest();
            RequestDAO requestDAO = new RequestDAO();
            Request request = requestDAO.selectRequestById(1);
            Request request2 = requestDAO.selectRequestById(2);
            WorkerDAO workerDAO = new WorkerDAO();
            controller.assigningWorker(request);
            controller.assigningWorker(request2);
            controller.readWorkersByIdTask(request);
            controller.completeWork(workerDAO.readWorkerById(request.getId()).get(0), 2);
            controller.readRequestByOverdue();


        } catch (HouseControllerException | DAOException e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }

	}

}
