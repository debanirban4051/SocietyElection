package com.cg.login.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Voters")
@GenericGenerator(name = "voter_sequence",strategy = "increment")
public class Voter {

	@Id
	@Column(name = "voter_id")
	@GeneratedValue(generator = "voter_sequence", strategy = GenerationType.IDENTITY)
	private long voterId;

	@Column(name = "voter_name")
	private String voterName;

	@Column(name = "voter_contact")
	private String voterContact;

	@Column(name = "voter_age")
	private int voterAge;

	@Column(name = "voter_flat_number")
	private int voterFlatNumber;

	@Column(name = "voter_password")
	private String voterPassword;

	public Voter() {
	}

	public Voter(long voterId, String voterName, String voterContact, int voterAge, int voterFlatNumber,
			String voterPassword) {
		this.voterId = voterId;
		this.voterName = voterName;
		this.voterContact = voterContact;
		this.voterAge = voterAge;
		this.voterFlatNumber = voterFlatNumber;
		this.voterPassword = voterPassword;
	}

	public long getVoterId() {
		return voterId;
	}

	public void setVoterId(long voterId) {
		this.voterId = voterId;
	}

	public String getVoterName() {
		return voterName;
	}

	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	public String getVoterContact() {
		return voterContact;
	}

	public void setVoterContact(String voterContact) {
		this.voterContact = voterContact;
	}

	public int getVoterAge() {
		return voterAge;
	}

	public void setVoterAge(int voterAge) {
		this.voterAge = voterAge;
	}

	public int getVoterFlatNumber() {
		return voterFlatNumber;
	}

	public void setVoterFlatNumber(int voterFlatNumber) {
		this.voterFlatNumber = voterFlatNumber;
	}

	public String getVoterPassword() {
		return voterPassword;
	}

	public void setVoterPassword(String voterPassword) {
		this.voterPassword = voterPassword;
	}

	@Override
	public String toString() {
		return "Voter [voterId=" + voterId + ", voterName=" + voterName + ", voterContact=" + voterContact
				+ ", voterAge=" + voterAge + ", voterFlatNumber=" + voterFlatNumber + ", voterPassword=" + voterPassword
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + voterAge;
		result = prime * result + ((voterContact == null) ? 0 : voterContact.hashCode());
		result = prime * result + voterFlatNumber;
		result = prime * result + (int) (voterId ^ (voterId >>> 32));
		result = prime * result + ((voterName == null) ? 0 : voterName.hashCode());
		result = prime * result + ((voterPassword == null) ? 0 : voterPassword.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voter other = (Voter) obj;
		if (voterAge != other.voterAge)
			return false;
		if (voterContact == null) {
			if (other.voterContact != null)
				return false;
		} else if (!voterContact.equals(other.voterContact))
			return false;
		if (voterFlatNumber != other.voterFlatNumber)
			return false;
		if (voterId != other.voterId)
			return false;
		if (voterName == null) {
			if (other.voterName != null)
				return false;
		} else if (!voterName.equals(other.voterName))
			return false;
		if (voterPassword == null) {
			if (other.voterPassword != null)
				return false;
		} else if (!voterPassword.equals(other.voterPassword))
			return false;
		return true;
	}

}
