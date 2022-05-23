package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import model.dao.ProductDao;

import model.entities.Product;

public class ProductDaoJDBC implements ProductDao {

	private Connection conn;
	
	public ProductDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public Product findByCod(String cod) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM Product WHERE COD = ?");
			st.setString(1, cod);
			rs = st.executeQuery();
			if (rs.next()) {
				Product obj = new Product();
				obj.setCod(rs.getString("COD"));
				obj.setDescr(rs.getString("DESCR"));
				obj.setTipo(rs.getString("TIPO"));
				obj.setDescr(rs.getString("DESCEST"));
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Product> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM Product ORDER BY COD");
			rs = st.executeQuery();

			List<Product> list = new ArrayList<>();

			while (rs.next()) {
				Product obj = new Product();
				obj.setCod(rs.getString("COD"));
				obj.setDescr(rs.getString("DESCR"));
				obj.setTipo(rs.getString("TIPO"));
				obj.setDescest(rs.getString("DESCEST"));
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void insert(Product obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO Product " +
				"(COD,DESCR,TIPO,DESCEST) " +
				"VALUES " +
				"(?,?,?,?)", 
				Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getCod());
			st.setString(2, obj.getDescr());
			st.setString(3, obj.getTipo());
			st.setString(4, obj.getDescest());
			

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					String cod = rs.getString(1);
					obj.setCod(cod);
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Product obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE Product " +
				"SET DESCR = ?, " +
				"TIPO = ?," +
				"DESCEST = ? " +
				"WHERE COD = ?");

			st.setString(1, obj.getDescr());
			st.setString(2, obj.getTipo());
			st.setString(3, obj.getDescest());
			st.setString(4, obj.getCod());

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(String cod) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"DELETE FROM Product WHERE COD = ?");

			st.setString(1, cod);

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}
}
