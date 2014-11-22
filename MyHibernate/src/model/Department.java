package model;
// default package
// Generated Nov 20, 2014 1:09:15 AM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Department generated by hbm2java
 */
@Entity
@Table(name = "department", catalog = "hibernate")
public class Department implements java.io.Serializable {

	private Integer departmentId;
	private SystemUser systemUserByCreatedBy;
	private SystemUser systemUserByLastUpdatedBy;
	private String departmentName;
	private String departmentCode;
	private Date creationTimestamp;
	private Date lastUpdatedTimestamp;
	private Set<Classes> classeses = new HashSet<Classes>(0);
	private Set<Employee> employees = new HashSet<Employee>(0);

	public Department() {
	}

	public Department(SystemUser systemUserByCreatedBy,
			SystemUser systemUserByLastUpdatedBy, String departmentName,
			String departmentCode) {
		this.systemUserByCreatedBy = systemUserByCreatedBy;
		this.systemUserByLastUpdatedBy = systemUserByLastUpdatedBy;
		this.departmentName = departmentName;
		this.departmentCode = departmentCode;
	}

	public Department(SystemUser systemUserByCreatedBy,
			SystemUser systemUserByLastUpdatedBy, String departmentName,
			String departmentCode, Date creationTimestamp,
			Date lastUpdatedTimestamp, Set<Classes> classeses,
			Set<Employee> employees) {
		this.systemUserByCreatedBy = systemUserByCreatedBy;
		this.systemUserByLastUpdatedBy = systemUserByLastUpdatedBy;
		this.departmentName = departmentName;
		this.departmentCode = departmentCode;
		this.creationTimestamp = creationTimestamp;
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
		this.classeses = classeses;
		this.employees = employees;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "department_id", unique = true, nullable = false)
	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	public SystemUser getSystemUserByCreatedBy() {
		return this.systemUserByCreatedBy;
	}

	public void setSystemUserByCreatedBy(SystemUser systemUserByCreatedBy) {
		this.systemUserByCreatedBy = systemUserByCreatedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "last_updated_by", nullable = false)
	public SystemUser getSystemUserByLastUpdatedBy() {
		return this.systemUserByLastUpdatedBy;
	}

	public void setSystemUserByLastUpdatedBy(
			SystemUser systemUserByLastUpdatedBy) {
		this.systemUserByLastUpdatedBy = systemUserByLastUpdatedBy;
	}

	@Column(name = "department_name", nullable = false, length = 100)
	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Column(name = "department_code", nullable = false, length = 5)
	public String getDepartmentCode() {
		return this.departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_timestamp", length = 19)
	public Date getCreationTimestamp() {
		return this.creationTimestamp;
	}

	public void setCreationTimestamp(Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated_timestamp", length = 19)
	public Date getLastUpdatedTimestamp() {
		return this.lastUpdatedTimestamp;
	}

	public void setLastUpdatedTimestamp(Date lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Classes> getClasseses() {
		return this.classeses;
	}

	public void setClasseses(Set<Classes> classeses) {
		this.classeses = classeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
