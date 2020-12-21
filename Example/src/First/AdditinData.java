package First;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdditinData {
	public static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/why?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
	//MySQL数据库的连接用户名
	public static final String DBUSER="root";
	//数据库连接密码
	public static final String DBPASS="root";
	public static final void main(String []args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rt=null;
		try {
			Class.forName(DBDRIVER);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
			stmt=conn.createStatement();
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1000','王一','女','40','高','4000','否')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1001','王二','男','19','中','2999','否')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1002','王三','女','33','高','5100','是')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1003','王四','男','55','低','3900','否')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1004','王五','女','42','中','3123','否')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1005','王六','男','32','中','3560','否')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1006','王七','男','69','高','6100','是')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1007','王九','女','49','高','5200','是')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1008','王十','男','59','高','5300','是')");

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
