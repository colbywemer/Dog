/**
 * @author cgwemer - cgwemer
 * CIS175 - Spring 2022
 * Feb 3, 2022
 */
package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="items")
public class Dog {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="STORE")
	private String breed; 
	@Column(name="ITEM")
	private String name;
	@Column(name="Owner")
	private String owner;
	public Dog() {
		super();
	}
	public Dog(String breed, String name, String owner) {
		super();
		this.breed = breed;
		this.name = name;
		this.owner = owner;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String returnItemDetails() {
		return "";
	}
	
}
