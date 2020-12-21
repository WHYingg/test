package First;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowData {
	public static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/why?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
	public static final String DBUSER="root";
	public static final String DBPASS="root";
	public static final void main(String []args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		try {
			Class.forName(DBDRIVER);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
			stmt=conn.createStatement();
			String query1="SELECT * FROM MyTable";
			rs1=stmt.executeQuery(query1);
			System.out.println("编号"+"\t姓名"+"\t性别"+"\t年龄"+"\t职称"+"\t工资"+"\t是否党员");
			while(rs1.next()) {
				String id=rs1.getString("id").trim();
				String name=rs1.getString("name").trim();
				String sex=rs1.getString("sex").trim();
				int age=rs1.getInt("age");
				String position=rs1.getString("position").trim();
				int salary=rs1.getInt("salary");
				String party=rs1.getString("party").trim();
				System.out.println(id+"\t"+name+"\t"+sex+"\t"+age+"\t"+position+"\t"+salary+"\t"+party);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			rs1.close();
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

