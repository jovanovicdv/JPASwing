package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Exam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_student")
	private Student student;
	
	@JoinColumn(name = "id_professor_subject", referencedColumnName = "id", table = "professor_subject")
	private long professorSubject;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfExam = new Date();
	
	
	private int grade;


	public Exam() {
		super();
	}


	public Exam(Student student, long professorSubject, Date dateOfExam, int grade) {
		super();
		this.student = student;
		this.professorSubject = professorSubject;
		this.dateOfExam = dateOfExam;
		this.grade = grade;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public long getProfessorSubject() {
		return professorSubject;
	}


	public void setProfessorSubject(long professorSubject) {
		this.professorSubject = professorSubject;
	}


	public Date getDateOfExam() {
		return dateOfExam;
	}


	public void setDateOfExam(Date dateOfExam) {
		this.dateOfExam = dateOfExam;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "Exam [id=" + id + ", student=" + student + ", professorSubject=" + professorSubject + ", dateOfExam="
				+ dateOfExam + ", grade=" + grade + "]";
	}


	@Override
	public int hashCode() {
		return 31;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Exam))
			return false;
		Exam other = (Exam) obj;
		if (id != other.id)
			return false;
		return true;
	}


	
	
	

}
