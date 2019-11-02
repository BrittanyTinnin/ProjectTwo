package com.revature.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="photos")
public class Photo {

	@Id
	@Column(name = "photo_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "date")
	private Timestamp date;
	
	@Column(name = "url")
	private String url;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User puser;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="post_id")
	private Post post;

	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Photo(int id, Timestamp date, String url, User user) {
		super();
		this.id = id;
		this.date = date;
		this.url = url;
		this.puser = user;
	}

	public Photo(Timestamp date, String url, User user) {
		super();
		this.date = date;
		this.url = url;
		this.puser = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public User getUser() {
		return puser;
	}

	public void setUser(User user) {
		this.puser = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((puser == null) ? 0 : puser.hashCode());
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
		Photo other = (Photo) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (puser == null) {
			if (other.puser != null)
				return false;
		} else if (!puser.equals(other.puser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", date=" + date + ", url=" + url + ", user=" + puser + "]";
	}

}
