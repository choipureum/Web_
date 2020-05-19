package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Dept;

public interface DeptDao {
	
	public Dept selectOne(Connection conn, int deptno);
}
