package domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Student extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(unique = true)
	private String index;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@ManyToOne
	@JoinColumn(name = "id_studyprogram")
	private StudyProgram studyProgram;
	
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private Set<Exam> exams;
	
	

	public Student() {
		super();
		this.exams = new HashSet<Exam>();
	}

	public Student(String firstName, String lastName, String index, Date dateOfBirth, StudyProgram studyProgram) {
		super(firstName, lastName);
		this.index = index;
		this.dateOfBirth = dateOfBirth;
		this.studyProgram = studyProgram;
		this.exams = new HashSet<Exam>();
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public StudyProgram getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(StudyProgram studyProgram) {
		this.studyProgram = studyProgram;
	}

	@Override
	public String toString() {
		return "Student [index=" + index + ", dateOfBirth=" + dateOfBirth + ", studyProgram=" + studyProgram + "]";
	}
	
	
	

}
