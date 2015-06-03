package hello.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * An Order
 * @author ifaturoti_adeyemi
 *
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private	long id;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<OrderProduct> orderProduct;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address shippingInfo;
	
	private Date orderDate;
	
	@OneToOne
	private Customer customer;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Billing billing;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Comment comment;
	
	private BigDecimal total;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<OrderProduct> getOrderProduct() {
		return orderProduct;
	}
	public void setOrderProduct(List<OrderProduct> orderProduct) {
		this.orderProduct = orderProduct;
	}
	public Address getShippingInfo() {
		return shippingInfo;
	}
	public void setShippingInfo(Address shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
