package com.payee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.payee.domain.BankAccount;
import com.payee.domain.Transaction;
import com.payee.domain.User;
import com.payee.utility.DBUtility;

public class TransactionService {
	

	
	private Connection connection;

	public TransactionService() {
		connection = DBUtility.getConnection();
	}

	public void addTransaction(Transaction transaction) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into transaction(sender,receiver,transactionDate,status,amount) values (?,?,?,?,? )");

			// Parameters start with 1
			//preparedStatement.setInt(1, user.getUserid());
			int i=0;
			preparedStatement.setString(++i, transaction.getSender());
			preparedStatement.setString(++i, transaction.getReceiver());			
			preparedStatement.setString(++i, transaction.getTransactionDate());
			preparedStatement.setBoolean(++i, true);
			preparedStatement.setString(++i, transaction.getAmount());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Transaction getTransactionById(String senderId) {
		Transaction transaction = new Transaction();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from transaction where sender = ? ");
			preparedStatement.setString(1, senderId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				transaction.setTransactionId((rs.getInt("transactionId")));
				transaction.setReceiver(rs.getString("receiver"));
				transaction.setStatus((rs.getBoolean("status")));
				transaction.setAmount((rs.getString("amount")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transaction;
	}
	
	public List<Transaction> getAllTransactions(String senderId) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from transaction where sender = ? limit 10");
			preparedStatement.setString(1, senderId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Transaction transaction = new Transaction();
				//user.setUserid(rs.getInt("userid"));
				transaction.setTransactionId((rs.getInt("transactionId")));
				transaction.setSender((rs.getString("sender")));
				transaction.setReceiver(rs.getString("receiver"));
				transaction.setStatus((rs.getBoolean("status")));
				transaction.setAmount((rs.getString("amount")));
				transactions.add(transaction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return transactions;
	}
	
}
