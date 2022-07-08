import javax.xml.transform.Result;
import java.sql.*;
import java.util.List;

public class EmployeeDAOImplementation implements EmployeeDAO{
    @Override
    public Employee get(int id) throws SQLException {
        Connection con = Database.getConnection();
        Employee employee = null;

        String sql = "SELECT id, employee_id, first_name, last_name, dept_id FROM employees Where id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            int oid = rs.getInt("id");
            int employeeId = rs.getInt("employeeId");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int deptId = rs.getInt("dept_id");

            employee = new Employee(id, employeeId, firstName, lastName, deptId);
        }

        return employee;
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Employee employee) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Employee employee) throws SQLException {
        Connection con = Database.getConnection();

        String sql = "INSERT INTO employees (employee_id, first_name, last_name, deptId) Values (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, employee.getEmployeeId());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getLastName());
        ps.setInt(4, employee.getDepId());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(con);

        return result;
    }

    @Override
    public int update(Employee employee) throws SQLException {
       Connection con = Database.getConnection();

       String sql = ("UPDATE employees set employee_id = ?, first_name = ?, last_name = ?, dept_id = ?, where id = ?");

       PreparedStatement ps = con.prepareStatement(sql);

       ps.setInt(1, employee.getEmployeeId());
       ps.setString(2, employee.getFirstName());
       ps.setString(3, employee.getLastName());
       ps.setInt(4, employee.getDepId());
       ps.setInt(5, employee.getId());

       int result = ps.executeUpdate();

       Database.closePreparedStatement(ps);
       Database.closeConnection(con);

       return result;
    }

    @Override
    public int delete(Employee employee) throws SQLException {
        Connection con = Database.getConnection();

        String sql = "DELETE FROM employees WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, employee.getEmployeeId());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getLastName());
        ps.setInt(4, employee.getDepId());
        ps.setInt(5, employee.getId());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(con);

        return result;


    }
}
