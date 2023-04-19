package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBManager;

public class RegisterUserLogic {
	public void execute(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("insert into user (name, password, accountNumber) values (?, ?, ?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getAccountNumber());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
