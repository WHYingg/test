package First;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdditinData {
	public static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/why?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
	//MySQL���ݿ�������û���
	public static final String DBUSER="root";
	//���ݿ���������
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
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1000','��һ','Ů','40','��','4000','��')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1001','����','��','19','��','2999','��')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1002','����','Ů','33','��','5100','��')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1003','����','��','55','��','3900','��')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1004','����','Ů','42','��','3123','��')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1005','����','��','32','��','3560','��')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1006','����','��','69','��','6100','��')");
			stmt.executeUpdate("INSERT INTO MyTable VALUES('1007','����','Ů','49','��','5200','��')");

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
