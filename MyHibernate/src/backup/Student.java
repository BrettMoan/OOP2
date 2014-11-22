package backup;


import java.sql.Timestamp;




import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
    @GeneratedValue
    @Column(name = "student_id")
	private int studentId;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "age")
	private int age;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "creation_timestamp")
	private Timestamp creationTimestamp;
	@Column(name = "last_updated_timestamp")
	private Timestamp lastUpdatedTimestamp;
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	private SystemUser createdBy;
	
	@ManyToOne
	@JoinColumn(name = "last_updated_by")
	private SystemUser lastUpdatedBy;
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Timestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public Timestamp getLastUpdatedTimestamp() {
		return lastUpdatedTimestamp;
	}

	public void setLastUpdatedTimestamp(Timestamp lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}

	public SystemUser getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(SystemUser createdBy) {
		this.createdBy = createdBy;
	}

	public SystemUser getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(SystemUser lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", fullName=" + fullName
				+ ", age=" + age + ", email=" + email + ", password="
				+ password + ", creationTimestamp=" + creationTimestamp
				+ ", createdBy=" + createdBy + "]";
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

}
