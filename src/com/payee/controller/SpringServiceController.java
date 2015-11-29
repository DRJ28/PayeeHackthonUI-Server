package com.payee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payee.dao.BankAccountService;
import com.payee.dao.TransactionService;
import com.payee.dao.UserService;
import com.payee.domain.BankAccount;
import com.payee.domain.Transaction;
import com.payee.domain.User;


@RestController
@RequestMapping("/service/user/")
public class SpringServiceController {
	
	UserService userService=new UserService();
	BankAccountService bankAccountService=new BankAccountService();
	TransactionService transactionService=new TransactionService();
	//public User user = new User();
	     	    
	@RequestMapping(value = "/getUser", method = RequestMethod.POST,headers="Accept=application/json")
	public User getUser(@RequestBody User user) {
		
		System.out.println(user.getPassword());
		User loggedUser=userService.getUserById("0"+user.getUserId(), user.getPassword());
		//user.setFirstName("dheeraj");
		System.out.println(loggedUser.getFirstName()+ " " + loggedUser.getLastName());
		return loggedUser;
	}
	
	/*@RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
	public List<User> getAllUsers() {
		List<User> users=userService.getAllUsers();
		return users;
	}*/
	
	@RequestMapping(value = "/addBankAccount", method = RequestMethod.POST,headers="Accept=application/json")
	public BankAccount getBankAccount(@RequestBody BankAccount bankAccount) {
		
		//System.out.println(user.getPassword());
		//User user=userService.getUserById(id);
		//user.setFirstName("dheeraj");
		//System.out.println(user.getFirstName()+ " " + user.getLastName());
		//System.out.println(username);
		BankAccount addedBankAccount= bankAccountService.addBankAccount(bankAccount);
		//user.setFirstName("dheeraj");
		//System.out.println(loggedUser.getFirstName()+ " " + loggedUser.getLastName());
		return addedBankAccount;
	}
	
	@RequestMapping(value = "/getTransaction", method = RequestMethod.POST,headers="Accept=application/json")
	public List<Transaction> getTransaction(@RequestBody String senderId) {
		
		//System.out.println(user.getPassword());
		List<Transaction> transactions= transactionService.getAllTransactions(senderId);
		//user.setFirstName("dheeraj");
		//System.out.println(user.getFirstName()+ " " + user.getLastName());
		//System.out.println(username);
		return transactions;
	}
	
}