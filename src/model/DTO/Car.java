package model.DTO;

import java.io.Serializable;
import javax.persistence.*;
import org.codehaus.jackson.map.annotate.JsonRootName;

import com.google.gson.annotations.Expose;



/**
 * The persistent class for the car database table.
 * 
 */
@Entity
@NamedQuery(name="Car.findAll", query="SELECT c FROM Car c")
@JsonRootName("response")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Expose
	private String eancode;
	@Expose
	private Integer amount;
	@Expose
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