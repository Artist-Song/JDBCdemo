package edu.tju.employees.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.tju.employees.db.DBConnection;

public class DepartmentsDAO {
	/**
	 * 查询:返回全部部门
	 * @param emp
	 * @throws SQLException 
	 */
	public List<Departments> findAll() throws SQLException{		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List<Departments> list = new ArrayList<Departments>(); 

		conn = DBConnection.getConnection();
		stat = conn.createStatement();
		rs = stat.executeQuery("select * from departments");
		while (rs.next()) {
			String no = rs.getString("dept_no");
			String name = rs.getString("dept_name");
			Departments d = new Departments();
			list.add(d);
			d.setDeptName(name);
			d.setDeptNo(no);
//			System.out.println(no+":"+name);
		}

		// TOD
		return list	;
	}
	
	/**
	 * 增加
	 * @param dept
	 * @throws SQLException 
	 */
	public void insert(Departments dept) throws SQLException {
		
		String deptNo = dept.getDeptNo();
		String deptName = dept.getDeptName();
		assert deptNo != null;
		assert deptName != null;
		
		Connection conn = null;
		Statement stat = null;

		conn = DBConnection.getConnection();
		stat = conn.createStatement();
		String sql="insert into departments(dept_no,dept_name) values ('"+deptNo+"','"+deptName+"');";
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		// TODO
	}
	
	/**
	 * 删除
	 * @param dept
	 * @throws SQLException 
	 */
	public void delete(Departments dept) throws SQLException {
		
		String deptNo = dept.getDeptNo();
		assert deptNo != null;
		
		Connection conn = null;
		Statement stat = null;
		System.out.println(deptNo);
		conn = DBConnection.getConnection();
		stat = conn.createStatement();
		String sql="delete from departments  where dept_no= '"+deptNo+"';"; 
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		
		// TODO
	}
	
	/**
	 * 修改
	 * @param dept
	 * @throws SQLException 
	 */
	public void update(Departments dept) throws SQLException {
		
		String deptNo = dept.getDeptNo();
		String deptName = dept.getDeptName();
		assert deptNo != null;
		assert deptName != null;
		
		Connection conn = null;
		Statement stat = null;
		

		conn = DBConnection.getConnection();
		stat = conn.createStatement();
		String sql = "update departments set dept_name = '"+deptName+"' where dept_no = '"+deptNo+"';";
		stat.execute(sql);		
		stat.close();
		conn.close();

		// TODO
	}
	
	/**
	 * 查询:查找指定编号的员工（根据主键查找）
	 * @param emp
	 * @throws SQLException 
	 */
	public Departments query(String deptNo) throws SQLException {
		
		assert deptNo != null;
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		Departments dept = new Departments(); 
		
		conn = DBConnection.getConnection();
		stat = conn.createStatement();
		rs = stat.executeQuery("select emp_no from dept_emp where  dept_emp.dept_no = '"+deptNo+"';");
		while (rs.next()) {
			String no = rs.getString("emp_no");
			
			
			
				System.out.println(no);
		}

		
		
		
		// TODO
		

		return dept;
	}
}
