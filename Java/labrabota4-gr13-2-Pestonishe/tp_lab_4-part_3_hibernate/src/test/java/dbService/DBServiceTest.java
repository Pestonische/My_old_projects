package dbService;

import dbService.dataSets.ServicemanDataSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DBServiceTest {

    @Test
    void testGetServicemanByNameReturnsCorrectValue() throws DBException {
        String name = "Vasechka";

        DBService dbService = new DBService("update");
        ServicemanDataSet serviceman = new ServicemanDataSet(name, "big boss", 100, 1);
        dbService.addServiceman(serviceman.getFirstName());

        ServicemanDataSet answer = dbService.getServicemanByName(name);
        Assertions.assertEquals(answer.getFirstName(), serviceman.getFirstName());
        dbService.close();
    }

    @Test
    void testAddServicemanReturnsCorrectValue() throws DBException {
        String name = "Vasyok";
        long id = 1;

        DBService dbService = new DBService("create");
        ServicemanDataSet serviceman = new ServicemanDataSet(id, name, "big boss", 100, 1);
        dbService.addServiceman(serviceman.getFirstName());

        ServicemanDataSet answer = dbService.getServiceman(id);
        Assertions.assertEquals(answer.getId(), serviceman.getId());
        dbService.close();
    }

    @Test
    void testAddServicemanWithFewParameters() throws DBException {
        String name = "Vasyok";
        long id = 1;

        DBService dbService = new DBService("create");
        ServicemanDataSet serviceman = new ServicemanDataSet(id, name, "big boss", 100, 1);
        dbService.addServiceman(id, serviceman.getFirstName(), serviceman.getPosition(), serviceman.getSalary(),
                serviceman.getDepartmentId());

        ServicemanDataSet answer = dbService.getServiceman(id);
        Assertions.assertEquals(answer.getId(), serviceman.getId());
        dbService.close();
    }
}