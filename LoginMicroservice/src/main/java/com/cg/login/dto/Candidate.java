package com.cg.login.dto;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="candidates")
public class Candidate {
	
	@Id
	@GeneratedValue(generator = "candidate_sequence",strategy = GenerationType.IDENTITY)
	private long candidateId;
	
	@Column(name= "candidate_name")
	private String candidateName;
	
	@Column(name = "candidate_contact")
	private String candidateContact;
	
	public Candidate(long candidateId, String candidateName, String candidateContact, Map<Voter, Long> voter) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.candidateContact = candidateContact;
		this.voter = voter;
	}
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn
	private Map<Voter,Long> voter = new HashMap<>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candidateContact == null) ? 0 : candidateContact.hashCode());
		result = prime * result + (int) (candidateId ^ (candidateId >>> 32));
		result = prime * result + ((candidateName == null) ? 0 : candidateName.hashCode());
		result = prime * result + ((voter == null) ? 0 : voter.hashCode());
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
		Candidate other = (Candidate) obj;
		if (candidateContact == null) {
			if (other.candidateContact != null)
				return false;
		} else if (!candidateContact.equals(other.candidateContact))
			return false;
		if (candidateId != other.candidateId)
			return false;
		if (candidateName == null) {
			if (other.candidateName != null)
				return false;
		} else if (!candidateName.equals(other.candidateName))
			return false;
		if (voter == null) {
			if (other.voter != null)
				return false;
		} else if (!voter.equals(other.voter))
			return false;
		return true;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateContact() {
		return candidateContact;
	}

	public void setCandidateContact(String candidateContact) {
		this.candidateContact = candidateContact;
	}



	public Candidate(long candidateId, Map<Voter, Long> voter) {
		super();
		this.candidateId = candidateId;
		this.voter = voter;
	}

	public Candidate() {
		super();
	}

	public long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}

	public Map<Voter, Long> getVoter() {
		return voter;
	}

	public void setVoter(Map<Voter, Long> voter) {
		this.voter = voter;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", candidateContact="
				+ candidateContact + ", voter=" + voter + "]";
	}
	
	

}
