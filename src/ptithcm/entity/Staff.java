package ptithcm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Staffs")
public class Staff {
	@Id
	@Column(name="ID")
	private String ID;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Gender")
	private int gender;
	
	@Column(name="Birthday")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date birthday;
	
	@Column(name="Photo")
	private String photo;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Salary")
	private float salary;
	
	@Column(name="Notes")
	private String notes;
	
	@ManyToOne
	@JoinColumn(name="DepartID")
	private Depart depart;

	public Staff()
	{
		super();
	}
	
	public Staff(String iD, String name, int gender, Date birthday, String photo, String email, float salary,
			String notes, Depart depart) {
		super();
		ID = iD;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.photo = photo;
		this.email = email;
		this.salary = salary;
		this.notes = notes;
		this.depart = depart;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	
}
