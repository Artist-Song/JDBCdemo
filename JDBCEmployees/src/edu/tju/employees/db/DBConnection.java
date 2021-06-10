package edu.tju.employees.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库访问类
 * @author Xin Wang
 *
 */
public class DBConnection {

	// 驱动程序类
	public final static String DB_DRIVER_CLASS =
		"org.postgresql.Driver";
	// 连接字符串URL
	public final static String DB_URL =
        "jdbc:postgresql://localhost:5432/postgres";
	// 登录用户名
    public final static String USERNAME = "postgres";
    // 登录口令
    public final static String PASSWORD = "13110009101SJ";
    
    // 静态块
	static {
		// 加载驱动程序
		try {
			Class.forName(DB_DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
	}
	
	// 获得JDBC连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					DB_URL, USERNAME, PASSWORD);
			
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return conn;
	}
}
