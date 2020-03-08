package domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Subject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private int espb;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			   name="subject_studyprogram",
			   joinColumns=@JoinColumn(name="id_subject", referencedColumnName="id"),
			   inverseJoinColumns=@JoinColumn(name="id_studyprogram", referencedColumnName="id"))
	private Set<StudyProgram> studyPrograms;
	
	private int semester;

	public Subject() {
		super();
		this.studyPrograms = new HashSet<StudyProgram>();
	}

	public Subject(String name, int espb, int semester) {
		super();
		this.name = name;
		this.espb = espb;
		this.semester = semester;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public Set<StudyProgram> getStudyPrograms() {
		return studyPrograms;
	}

	public void setStudyPrograms(Set<StudyProgram> studyPrograms) {
		this.studyPrograms = studyPrograms;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", espb=" + espb + ", studyPrograms=" + studyPrograms
				+ ", semester=" + semester + "]";
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Subject))
			return false;
		Subject other = (Subject) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	

}
