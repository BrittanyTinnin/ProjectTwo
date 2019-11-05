package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "likes")
public class Like {
	@Id
	@Column(name = "like_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User luser;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "post_id")
	private Post lpost;

	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Like(int id, User luser, Post lpost) {
		super();
		this.id = id;
		this.luser = luser;
		this.lpost = lpost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getLuser() {
		return luser;
	}

	public void setLuser(User luser) {
		this.luser = luser;
	}

	public Post getLpost() {
		return lpost;
	}

	public void setLpost(Post lpost) {
		this.lpost = lpost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((lpost == null) ? 0 : lpost.hashCode());
		result = prime * result + ((luser == null) ? 0 : luser.hashCode());
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
		Like other = (Like) obj;
		if (id != other.id)
			return false;
		if (lpost == null) {
			if (other.lpost != null)
				return false;
		} else if (!lpost.equals(other.lpost))
			return false;
		if (luser == null) {
			if (other.luser != null)
				return false;
		} else if (!luser.equals(other.luser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Like [id=" + id + ", luser=" + luser + ", lpost=" + lpost + "]";
	}

}
