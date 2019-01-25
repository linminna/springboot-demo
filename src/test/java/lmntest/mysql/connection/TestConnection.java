package lmntest.mysql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.util.StringUtils;

public class TestConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://180.76.135.202:3306/lmn?serverTimezone=UTC", "root", "java");
		
		/*String sql = "insert into t_activity_user (user_id,act_id,friend_help_count,last_help_friends) values(?,?,?,?)"; // 生成一条sql语句
        // 创建一个Statment对象
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setInt(2, 2);
		ps.setInt(3, 3);
		ps.setString(4, "@🐲较瘦");
		ps.executeUpdate();*/
		
		Statement statment = conn.createStatement();
		ResultSet resultSet = statment.executeQuery("select * from t_activity_user");

		while (resultSet.next()) {
			Object o1 = resultSet.getString("id");
			Object o2 = resultSet.getString("last_help_friends");
			if(StringUtils.isEmpty(o1) || StringUtils.isEmpty(o2)){
				continue;
			}
			System.out.println(o1.toString() + "---" + o2.toString());
		}
		conn.close();
	}

}
