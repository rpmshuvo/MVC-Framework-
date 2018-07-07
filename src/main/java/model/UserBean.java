 package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import framework.iModel;
import hibernate.Userinfo;
/**
 * This {@link Class} is a Bean which is use as a Model .It implement the {@link iModel} interface.
 * @author rpm shuvo
 *
 */
@Entity(name = "user")
@Table(name = "user")
 public class UserBean  implements iModel
 {
 	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	@Column(name="id")
	private int id; 
 	@Column(name="username")
	private String username ;
 	@Column(name="password")
    private String password ;
 	@Column(name="firstname")
	private String firstname ;
 	@Column(name="lastname")
	private String lastname ;
 	
 	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
/**
 * constructor of {@link UserBean}
 */
	public UserBean(){}
/**
 * This method	get data from {@link org.hibernate.dialect.Database}
 */
	public ArrayList<?> getData() {
		return Userinfo.getUser();
	}
 	
 	
 }