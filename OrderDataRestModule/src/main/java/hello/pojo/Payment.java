package hello.pojo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A Payment
 * @author ifaturoti_adeyemi
 *
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private	long id;
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	
}
