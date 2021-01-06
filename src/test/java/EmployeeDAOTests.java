import com.ex.project_1.dao.EmployeeDAO;
import com.ex.project_1.dao.EmployeeDAOImpl;
import com.ex.project_1.model.Employee;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for EmployeeDAO methods.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDAOTests {
    EmployeeDAO eDAO = new EmployeeDAOImpl();

    @Test
    public void aaastart() {
        eDAO.deleteEmployee("jdoe");
        eDAO.deleteEmployee("hfields");
    }

    @Test
    public void aaddEmployeeTest() {
        Employee e1 = new Employee("mladair", "brighid", "mladair@morardain.com",
                "Morag", "Ladair", "Hardhaigh Palace",
                "Alba Cavanich", 12345, 1234567890);
        Assert.assertTrue(eDAO.addEmployee(e1));

        Employee e2 = new Employee("zvongenbu", "pandoria", "zvongenbu@tantal.com",
                "Zeke", "Von Genbu", "Theoscaldia Palace",
                "Theosoir", 12345, 1234567890);
        Assert.assertTrue(eDAO.addEmployee(e2));
    }

    @Test
    public void getEmployeesTest() {
        List<Employee> e = new ArrayList<Employee>();

        Employee e1 = new Employee("mladair", "brighid", "mladair@morardain.com",
                "Morag", "Ladair", "Hardhaigh Palace",
                "Alba Cavanich", 12345, 1234567890);
        e.add(e1);

        Employee e2 = new Employee("zvongenbu", "pandoria", "zvongenbu@tantal.com",
                "Zeke", "Von Genbu", "Theoscaldia Palace",
                "Theosoir", 12345, 1234567890);
        e.add(e2);

        String expected = e.toString();

        List<Employee> a = eDAO.getEmployees();
        String actual = a.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEmployeeByUsernameTest() {
        Employee e = new Employee("mladair", "brighid", "mladair@morardain.com",
                "Morag", "Ladair", "Hardhaigh Palace",
                "Alba Cavanich", 12345, 1234567890);
        String expected = e.toString();

        Employee a = eDAO.getEmployeeByUsername("mladair");
        String actual = a.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateEmployeeTest() {
        Employee addam = new Employee("aorigo", "mythra", "aorigor@torna.com",
                "Addam", "Origo", "Aureus Palace",
                "Auresco", 12345, 1234567890);
        eDAO.addEmployee(addam);
        addam.setPassword("pyra");
        eDAO.updateEmployee(addam);

        Employee e = new Employee("aorigo", "pyra", "aorigor@torna.com",
                "Addam", "Origo", "Aureus Palace",
                "Auresco", 12345, 1234567890);
        String expected = e.toString();

        Employee a = eDAO.getEmployeeByUsername("aorigo");
        String actual = a.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void zdeleteEmployeeTest() {
        Assert.assertTrue(eDAO.deleteEmployee("mladair"));
        Assert.assertTrue(eDAO.deleteEmployee("zvongenbu"));
        Assert.assertTrue(eDAO.deleteEmployee("aorigo"));
    }

}
