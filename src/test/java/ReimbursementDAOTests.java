import com.ex.project_1.dao.ReimbursementDAO;
import com.ex.project_1.dao.ReimbursementDAOImpl;
import com.ex.project_1.model.Reimbursement;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for ReimbursementDAO methods.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReimbursementDAOTests {
    ReimbursementDAO rDAO = new ReimbursementDAOImpl();

    @Test
    public void aaastart() {
        rDAO.deleteRequest(79);
        rDAO.deleteRequest(77);
        rDAO.deleteRequest(80);
        rDAO.deleteRequest(81);
        rDAO.deleteRequest(78);
    }

    @Test
    public void aaddRequestTest() {
        Reimbursement r1 = new Reimbursement("mladair", 500.00,
                "Made a trip to Gormott",
                "Pending", "Pending");
        Assert.assertTrue(rDAO.addRequest(r1));

        Reimbursement r2 = new Reimbursement("mladair", 20.00,
                "Bought some accessories",
                "Approved", "hfields");
        Assert.assertTrue(rDAO.addRequest(r2));

        Reimbursement r3 = new Reimbursement("zvongenbu", 300.00,
                "Made a trip to Argentum",
                "Pending", "Pending");
        Assert.assertTrue(rDAO.addRequest(r3));

        Reimbursement r4 = new Reimbursement("zvongenbu", 300.00,
                "Found something shiny in Mor Ardain",
                "Denied", "hfields");
        Assert.assertTrue(rDAO.addRequest(r4));
    }

    @Test
    public void getPendingRequestsTest() {
        List<Reimbursement> e = new ArrayList<>();

        Reimbursement r1 = new Reimbursement("mladair", 500.00,
                "Made a trip to Gormott",
                "Pending", "Pending");
        int r1ID = rDAO.getReimbursement("Made a trip to Gormott").getReimbursementID();
        r1.setReimbursementID(r1ID);
        e.add(r1);

        Reimbursement r2 = new Reimbursement("zvongenbu", 300.00,
                "Made a trip to Argentum",
                "Pending", "Pending");
        int r2ID = rDAO.getReimbursement("Made a trip to Argentum").getReimbursementID();
        r2.setReimbursementID(r2ID);
        e.add(r2);

        String expected = e.toString();

        List<Reimbursement> a = rDAO.getPendingRequests();
        String actual = a.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getResolvedRequestsTest() {
        List<Reimbursement> e = new ArrayList<>();

        Reimbursement r1 = new Reimbursement("mladair", 20.00,
                "Bought some accessories",
                "Approved", "hfields");
        int r1ID = rDAO.getReimbursement("Bought some accessories").getReimbursementID();
        r1.setReimbursementID(r1ID);
        e.add(r1);

        Reimbursement r2 = new Reimbursement("zvongenbu", 300.00,
                "Found something shiny in Mor Ardain",
                "Denied", "hfields");
        int r2ID = rDAO.getReimbursement("Found something shiny in Mor Ardain").getReimbursementID();
        r2.setReimbursementID(r2ID);
        e.add(r2);

        String expected = e.toString();

        List<Reimbursement> a = rDAO.getResolvedRequests();
        String actual = a.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRequestsForEmployeeTest() {
        List<Reimbursement> e = new ArrayList<>();

        Reimbursement r1 = new Reimbursement("mladair", 500.00,
                "Made a trip to Gormott",
                "Pending", "Pending");
        int r1ID = rDAO.getReimbursement("Made a trip to Gormott").getReimbursementID();
        r1.setReimbursementID(r1ID);
        e.add(r1);

        Reimbursement r2 = new Reimbursement("mladair", 20.00,
                "Bought some accessories",
                "Approved", "hfields");
        int r2ID = rDAO.getReimbursement("Bought some accessories").getReimbursementID();
        r2.setReimbursementID(r2ID);
        e.add(r2);

        String expected = e.toString();

        List<Reimbursement> a = rDAO.getRequestsForEmployee("mladair");
        String actual = a.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPendingRequestsForEmployeeTest() {
        List<Reimbursement> e = new ArrayList<>();

        Reimbursement r1 = new Reimbursement("mladair", 500.00,
                "Made a trip to Gormott",
                "Pending", "Pending");
        int r1ID = rDAO.getReimbursement("Made a trip to Gormott").getReimbursementID();
        r1.setReimbursementID(r1ID);
        e.add(r1);

        String expected = e.toString();

        List<Reimbursement> a = rDAO.getPendingRequestsForEmployee("mladair");
        String actual = a.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getResolvedRequestsForEmployeeTest() {
        List<Reimbursement> e = new ArrayList<>();

        Reimbursement r1 = new Reimbursement("mladair", 20.00,
                "Bought some accessories",
                "Approved", "hfields");
        int r1ID = rDAO.getReimbursement("Bought some accessories").getReimbursementID();
        r1.setReimbursementID(r1ID);
        e.add(r1);

        String expected = e.toString();

        List<Reimbursement> a = rDAO.getResolvedRequestsForEmployee("mladair");
        String actual = a.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void zupdatePendingRequestStatusTest() {
        int iD = rDAO.getReimbursement("Made a trip to Gormott").getReimbursementID();
        rDAO.updatePendingRequestStatus(iD, "Approved", "hfields");

        List<Reimbursement> e = new ArrayList<>();

        Reimbursement r1 = new Reimbursement("mladair", 20.00,
                "Bought some accessories",
                "Approved", "hfields");
        int r1ID = rDAO.getReimbursement("Bought some accessories").getReimbursementID();
        r1.setReimbursementID(r1ID);
        e.add(r1);

        Reimbursement r2 = new Reimbursement("mladair", 500.00,
                "Made a trip to Gormott",
                "Approved", "hfields");
        int r2ID = rDAO.getReimbursement("Made a trip to Gormott").getReimbursementID();
        r2.setReimbursementID(r2ID);
        e.add(r2);

        String expected = e.toString();

        List<Reimbursement> a = rDAO.getResolvedRequestsForEmployee("mladair");
        String actual = a.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void zzdeleteRequestsTest() {
        int r1ID = rDAO.getReimbursement("Made a trip to Gormott").getReimbursementID();
        int r2ID = rDAO.getReimbursement("Bought some accessories").getReimbursementID();
        int r3ID = rDAO.getReimbursement("Made a trip to Argentum").getReimbursementID();
        int r4ID = rDAO.getReimbursement("Found something shiny in Mor Ardain").getReimbursementID();

        Assert.assertTrue(rDAO.deleteRequest(r1ID));
        Assert.assertTrue(rDAO.deleteRequest(r2ID));
        Assert.assertTrue(rDAO.deleteRequest(r3ID));
        Assert.assertTrue(rDAO.deleteRequest(r4ID));
    }

}
