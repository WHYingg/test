package First;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DriverDemo {
	public static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/why?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
	//MySQL���ݿ�������û���
	public static final String DBUSER="root";
	//���ݿ���������
	public static final String DBPASS="root";
	public static void main(String args[]) {
		Connection conn=null;
		Statement stmt=null;
		try {
			Class.forName(DBDRIVER);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
			stmt=conn.createStatement();
			stmt.executeUpdate("CREATE TABLE MyTable(id  VARCHAR(30),name  VARCHAR(20),sex  VARCHAR(2),age  INTEGER,position  VARCHAR(20),salary  INTEGER,party  VARCHAR(20))");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
