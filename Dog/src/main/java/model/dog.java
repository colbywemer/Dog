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
@Table(name="dogs")
public class dog {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="BREED")
	private String breed; 
	@Column(name="NAME")
	private String name;
	@Column(name="COLOR")
	private String color;
	public dog() {
		super();
	}
	public dog(String breed, String name, String color) {
		super();
		this.breed = breed;
		this.name = name;
		this.color = color;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String returnItemDetails() {
		return "Name: " + this.name + ", Breed: " + this.breed + ", Color: " + this.color;
	}
	
}
