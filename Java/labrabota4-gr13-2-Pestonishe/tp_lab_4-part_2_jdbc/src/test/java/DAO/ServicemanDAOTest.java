package DAO;

import DataSets.ServicemanData;
import JDBC.DBService;
import junit.framework.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ServicemanDAOTest extends TestCase {


    @Test
    public void testSave() throws Exception {
        ServicemanData expected = new ServicemanData(1,"Petrov", "Petrov",
                99999, 1);
        DBService dbService = new DBService();
        dbService.dropTable();
        dbService.createTable();
        dbService.saveUser(expected);
        ArrayList<ServicemanData> result = dbService.getUsers();
        Assert.assertEquals(result.get(0).getId(), expected.getId());
    }
    @Test
    public void testUpdate() throws Exception {
        ServicemanData expected = new ServicemanData(1,"Petrov", "Petrov",
                99999, 1);
        DBService dbService = new DBService();
        dbService.dropTable();
        dbService.createTable();
        dbService.saveUser(expected);
        String[] str = new String[]{"Petrov", "Petrov",
                "99009", "2"};
        dbService.updateUser(expected, str);
        ArrayList<ServicemanData> result = dbService.getUsers();
        Assert.assertEquals(result.get(0).getSalary(), Integer.parseInt(str[2]));
    }

    @Test
    public void testGetID() throws Exception {
        ServicemanData expected = new ServicemanData(1,"Petrov", "Petrov",
                99999, 1);
        DBService dbService = new DBService();
        dbService.dropTable();
        dbService.createTable();
        dbService.saveUser(expected);
        ServicemanData result = dbService.getUser(expected.getId());
        Assert.assertEquals(result.getId(), expected.getId());
    }
}