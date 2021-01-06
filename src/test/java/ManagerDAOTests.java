import com.ex.project_1.dao.ManagerDAO;
import com.ex.project_1.dao.ManagerDAOImpl;
import com.ex.project_1.model.Manager;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Tests for ManagerDAO methods.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManagerDAOTests {
    ManagerDAO mDAO = new ManagerDAOImpl();

    @Test
    public void aaastart() {
        mDAO.deleteManager("ghan");
        mDAO.deleteManager("aduet");
    }

    @Test
    public void aaddManagerTest() {
        Manager m1 = new Manager("ghan", "pword", "Gina", "Han");
        Manager m2 = new Manager("hfields", "pword", "Hayden", "Fields");

        Assert.assertTrue(mDAO.addManager(m1));
        Assert.assertTrue(mDAO.addManager(m2));
    }

    @Test
    public void getManagerByUsernameTest() {
        Manager e = new Manager("hfields", "pword", "Hayden", "Fields");
        String expected = e.toString();

        Manager a = mDAO.getManagerByUsername("hfields");
        String actual = a.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void zdeleteManagerTest() {
        Assert.assertTrue(mDAO.deleteManager("ghan"));
        Assert.assertTrue(mDAO.deleteManager("hfields"));
    }
}
