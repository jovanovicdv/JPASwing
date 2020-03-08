package domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Professor extends Person{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Enumerated(EnumType.STRING)
	private Title title;
	
	@Temporal(TemporalType.DATE)
	private Date startedToWork = new Date();
	
	@ManyToOne
	@JoinColumn(name = "id_department")
	private Department department;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			   name="professor_subject",
			   joinColumns=@JoinColumn(name="id_professor", referencedColumnName="id"),
			   inverseJoinColumns=@JoinColumn(name="id_subject", referencedColumnName="id"))
	private Set<Subject> subjects;
	
	
	
	

	public Professor() {
		super();
		this.subjects = new HashSet<Subject>();
	}

	

	



	public Professor(String firstName, String lastName, Title title, Date startedToWork,
			Department department) {
		super(firstName, lastName);
		this.title = title;
		this.startedToWork = startedToWork;
		this.department = department;
	}







	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Date getStartedToWork() {
		return startedToWork;
	}

	public void setStartedToWork(Date startedToWork) {
		this.startedToWork = startedToWork;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	

	

	@Override
	public String toString() {
		return "Professor ["+super.toString()+"title=" + title + ", startedToWork=" + startedToWork + ", department=" + department
				+ ", subjects=" + subjects + "]";
	}



	
	
	
	
	

}
