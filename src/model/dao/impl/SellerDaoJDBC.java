package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {

		this.conn = conn;

	}

	@Override
	public void insert(Seller obj) {

	}

	@Override
	public void update(Seller obj) {

	}

	@Override
	public void deleteById(Integer id) {

	}

	@Override
	public Seller findById(Integer id) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT seller.*, department.Name as DepName " + "" + "FROM seller "
					+ "INNER JOIN department on (department.Id = seller.Id ) " + "WHERE seller.Id = ?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			
			if (rs.next()) {
				
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("DepName"));
				
			    Seller obj = new Seller();
			    obj.setId(rs.getInt("Id"));
			    obj.setName(rs.getString("Name"));
			    obj.setEmail(rs.getString("Email"));
			    obj.setBaseSalary(rs.getDouble("BaseSalary"));
			    obj.setBirthDate(rs.getDate("BirthDate"));
			    obj.setDepartment(dep);
			    return obj;
				
				
			}else {
				
				return null;
			}
			

		}
		catch (SQLException e) {
			
			 throw new DbException(e.getMessage());
			 
		}
		finally {
			
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
			
		}

		
	}

	@Override
	public List<Seller> findAll() {

		return null;
	}

}