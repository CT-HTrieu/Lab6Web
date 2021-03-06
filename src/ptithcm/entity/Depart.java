package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Departs")
public class Depart {
	@Id
	@Column(name="ID")
	private String ID;
	
	@Column(name="Name")
	private String name;
	
	@OneToMany(mappedBy = "depart", fetch = FetchType.EAGER)
	private Collection<Staff> staffs;

	public Depart()
	{
		super();
	}
	
	public Depart(String iD, String name, Collection<Staff> staffs) {
		super();
		ID = iD;
		this.name = name;
		this.staffs = staffs;
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

	public Collection<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(Collection<Staff> staffs) {
		this.staffs = staffs;
	}
	
	
}
