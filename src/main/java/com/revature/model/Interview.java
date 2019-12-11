package com.revature.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * An object representation of our Interview model.
 * 
 * @author Davin Merry
 * @author John Thaddeus Kelly
 */
@Entity
@Table(name = "interviews")
public class Interview {
	@Id
	@Column(name = "interview_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "interview_profile")
	// @JsonIgnore
	private Profile profile;

	@Column(name = "interview_date")
	private Timestamp date;

	@Column(name = "interview_is_complete")
	private boolean isComplete;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "interview_job")
	private Job job;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "interviewer_users", joinColumns = { @JoinColumn(name = "interview_id") }, inverseJoinColumns = {
			@JoinColumn(name = "users_id") })
	// @LazyCollection(LazyCollectionOption.FALSE)
	// @JsonIgnore
	private Set<User> users = new HashSet<>();

	public Interview() {
	}

	public Interview(int id, Profile profile, Timestamp date, boolean isComplete, Job job, Set<User> users) {
		this.id = id;
		this.profile = profile;
		this.date = date;
		this.isComplete = isComplete;
		this.job = job;
		this.users = users;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public boolean isIsComplete() {
		return this.isComplete;
	}

	public boolean getIsComplete() {
		return this.isComplete;
	}

	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

// 	@Override
// 	public boolean equals(Object o) {
// 		if (o == this)
// 			return true;
// 		if (!(o instanceof Interview)) {
// 			return false;
// 		}
// 		Interview interview = (Interview) o;
// 		return id == interview.id && Objects.equals(profile, interview.profile) && Objects.equals(date, interview.date) && isComplete == interview.isComplete && Objects.equals(job, interview.job) && Objects.equals(users, interview.users);
// 	}

// 	@Override
// 	public int hashCode() {
// 		return Objects.hash(id, profile, date, isComplete, job, users);
// 	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", profile='" + getProfile() + "'" +
			", date='" + getDate() + "'" +
			", isComplete='" + isIsComplete() + "'" +
			", job='" + getJob() + "'" +
			", users='" + getUsers() + "'" +
			"}";
	}

}
