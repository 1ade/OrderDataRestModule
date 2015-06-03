package hello.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A Customer
 * @author ifaturoti_adeyemi
 *
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
public class Customer {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private	long id;
	String firstName;
	String lastName;
	String mail;
	String title;
	@OneToMany
	List<Address> deliveryAddresses;
	@OneToMany
	List<Billing> billingInfos;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Address> getDeliveryAddresses() {
		return deliveryAddresses;
	}
	public void setDeliveryAddresses(List<Address> deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}
	public List<Billing> getBillingInfos() {
		return billingInfos;
	}
	public void setBillingInfos(List<Billing> billingInfos) {
		this.billingInfos = billingInfos;
	}		
}
