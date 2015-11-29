package com.payee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.payee.domain.BankAccount;
import com.payee.domain.User;
import com.payee.utility.DBUtility;

public class BankAccountService {
	
	private Connection connection;

	public BankAccountService() {
		connection = DBUtility.getConnection();
	}

	public BankAccount addBankAccount(BankAccount bankAccount) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into bankAccount(country,bankName,accountNumber,bankCode,userId) values (?,?,?,?,? )");

			// Parameters start with 1
			//preparedStatement.setInt(1, user.getUserid());
			int i=0;
			preparedStatement.setString(++i, bankAccount.getCountryName());
			preparedStatement.setString(++i, bankAccount.getBankName());			
			preparedStatement.setString(++i, bankAccount.getAccountNumber());
			preparedStatement.setString(++i, bankAccount.getBankCode());
			//preparedStatement.setString(++i, bankAccount.getAccountName());
			preparedStatement.setString(++i, bankAccount.getUserId());
			preparedStatement.executeUpdate();
			bankAccount.setValid(true);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankAccount;
	}
	
	public BankAccount getBankAccountById(String userId) {
		BankAccount bankAccount = new BankAccount();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from bankAccount where userId = ?");
			preparedStatement.setString(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				//user.setUserid(rs.getInt("userid"));
				bankAccount.setCountryName(rs.getString("country"));
				bankAccount.setBankName(rs.getString("bankName"));
				bankAccount.setAccountNumber(rs.getString("accountNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankAccount;
	}



}
