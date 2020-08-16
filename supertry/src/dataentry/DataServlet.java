package dataentry;
import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
class Data {
	private String name;
	private int age;
	private String pos;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}
}
class DataDao {
	public int reg(Data data) throws ClassNotFoundException, SQLException {
		String query="insert into data_entry(name, age, position) values(?,?,?)";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mummy?useSSL=false","root","123456");
		PreparedStatement ps=conn.prepareStatement(query)){
		ps.setString(1,data.getName());
		ps.setInt(2,data.getAge());
		ps.setString(3,data.getPos());
		System.out.print(ps);
		result=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
@WebServlet("/rouge")
public class DataServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	DataDao dataDao=new DataDao();
	public DataServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		response.getWriter().append("Served at : ").append(request.getContextPath());
		RequestDispatcher dis=request.getRequestDispatcher("/WEB-INF/hello.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String name=request.getParameter("a");
		String age=request.getParameter("b");
		String pos=request.getParameter("c");
		Data data=new Data();
		int b=Integer.parseInt(age);                     //parsing from string to int
		data.setName(name);
		data.setAge(b);
		data.setPos(pos);
		try {
			dataDao.reg(data);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dis=request.getRequestDispatcher("/WEB-INF/success.jsp");
		dis.forward(request, response);
	}
}
