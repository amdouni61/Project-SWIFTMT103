package com.example.demo.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Detail implements Serializable {

	@Id
	private String id;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<TagRecus> tagRecus;
	
	
	
	
	
	
	public Detail(String id, List<TagRecus> tagRecus) {
		super();
		this.id = id;
		this.tagRecus = tagRecus;
	}




	public Detail() {
		super();
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public List<TagRecus> getTagRecus() {
		return tagRecus;
	}




	public void setTagRecus(List<TagRecus> tagRecus) {
		this.tagRecus = tagRecus;
	}




	@Override
	public String toString() {
		return "Detail [id=" + id + ", tagRecus=" + tagRecus + "]";
	}

	
	
	

	
	
}
