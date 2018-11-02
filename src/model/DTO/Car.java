package model.DTO;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * The persistent class for the car database table.
 * 
 */
@Entity
@NamedQuery(name="Car.findAll", query="SELECT c FROM Car c")
@XmlRootElement(name = "response")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String eancode;

	private Integer amount;

	private String description;

	public Car() {
	}

	public String getEancode() {
		return this.eancode;
	}

	public void setEancode(String eancode) {
		this.eancode = eancode;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}