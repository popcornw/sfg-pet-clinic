 package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Description;
@Entity
@Table(name="vists")
public class Visit extends BaseEntity {
	@Column(name="date")
	private LocalDate date;
	@Column(name="description")
	private String desctiprion;
	@ManyToOne
	@JoinColumn(name="pet_id")
	private Pet pet;
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDesctiprion() {
		return desctiprion;
	}
	public void setDesctiprion(String desctiprion) {
		this.desctiprion = desctiprion;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	

}
