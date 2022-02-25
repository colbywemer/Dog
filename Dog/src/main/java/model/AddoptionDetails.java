package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class AddoptionDetails {
	@Id
	@GeneratedValue
	private int id;
	private String ownerName;
	private String address;
	private String phoneNumber;
	private LocalDate adoptionDate;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<dog> listOfDogs;
	public AddoptionDetails() {
		super();
	}
	public AddoptionDetails(int id, String ownerName, String address, String phoneNumber, LocalDate adoptionDate,
			List<dog> listOfDogs) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.adoptionDate = adoptionDate;
		this.listOfDogs = listOfDogs;
	}
	public AddoptionDetails(String ownerName, String address, String phoneNumber, LocalDate adoptionDate,
			List<dog> listOfDogs) {
		super();
		this.ownerName = ownerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.adoptionDate = adoptionDate;
		this.listOfDogs = listOfDogs;
	}
	public AddoptionDetails(String ownerName, String address, String phoneNumber, LocalDate adoptionDate) {
		super();
		this.ownerName = ownerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.adoptionDate = adoptionDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getAdoptionDate() {
		return adoptionDate;
	}
	public void setAdoptionDate(LocalDate adoptionDate) {
		this.adoptionDate = adoptionDate;
	}
	public List<dog> getListOfDogs() {
		return listOfDogs;
	}
	public void setListOfDogs(List<dog> listOfDogs) {
		this.listOfDogs = listOfDogs;
	}
	@Override
	public String toString() {
		return "AddoptionDetails [id=" + id + ", ownerName=" + ownerName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", adoptionDate=" + adoptionDate + ", listOfDogs=" + listOfDogs + "]";
	}
}
