package backup;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "system_user")
public class SystemUser {

    @Id @GeneratedValue
    @Column(name = "system_user_id")
    private int systemUserId;
    
    @Column(name = "system_user_name")
    private String systemUserName;
    
    @Column(name = "system_user_group_id")
    private int systemUserGroupId;
    
    @Column(name = "system_user_type")
    private int systemUserType;
    
    @Column(name = "creation_timestamp")
	private Timestamp creationTimestamp;
    
	@Column(name = "last_updated_timestamp")
	private Timestamp lastUpdatedTimestamp;
	
	@ManyToOne 	@JoinColumn(name = "created_by")
	private SystemUser createdBy;
	
	@ManyToOne	@JoinColumn(name = "last_updated_by")
	private SystemUser lastUpdatedBy;
    
	public SystemUser() {
		// TODO Auto-generated constructor stub
	}
	
	public int getSystemUserId() {
		return systemUserId;
	}

	public void setSystemUserId(int systemUserId) {
		this.systemUserId = systemUserId;
	}

	public String getSystemUserName() {
		return systemUserName;
	}

	public void setSystemUserName(String systemUserName) {
		this.systemUserName = systemUserName;
	}

	public int getSystemUserGroupId() {
		return systemUserGroupId;
	}

	public void setSystemUserGroupId(int systemUserGroupId) {
		this.systemUserGroupId = systemUserGroupId;
	}

	public int getSystemUserType() {
		return systemUserType;
	}

	public void setSystemUserType(int systemUserType) {
		this.systemUserType = systemUserType;
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


	
}
