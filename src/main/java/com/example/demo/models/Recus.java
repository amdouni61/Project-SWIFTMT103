package com.example.demo.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class Recus implements Serializable {

	@Id
	private String id;
	private int type;
	private String sens;
	private String rec;
	private String eme;
	private Date dateRec;
	private String timeRec;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Detail detail;

	public Recus() {
		super();
	}



	public Recus(String id, int type, String sens, String rec, String eme, Date dateRec, String timeRec,
			Detail detail) {
		super();
		this.id = id;
		this.type = type;
		this.sens = sens;
		this.rec = rec;
		this.eme = eme;
		this.dateRec = dateRec;
		this.timeRec = timeRec;
		this.detail = detail;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSens() {
		return sens;
	}

	public void setSens(String sens) {
		this.sens = sens;
	}

	public String getRec() {
		return rec;
	}

	public void setRec(String rec) {
		this.rec = rec;
	}

	public String getEme() {
		return eme;
	}

	public void setEme(String eme) {
		this.eme = eme;
	}

	public Date getDateRec() {
		return dateRec;
	}

	public void setDateRec(Date dateRec) {
		this.dateRec = dateRec;
	}

	public String getTimeRec() {
		return timeRec;
	}

	public void setTimeRec(String timeRec) {
		this.timeRec = timeRec;
	}
	
	

	



	public Detail getDetail() {
		return detail;
	}



	public void setDetail(Detail detail) {
		this.detail = detail;
	}



	@Override
	public String toString() {
		return "Recus [id=" + id + ", type=" + type + ", sens=" + sens + ", rec=" + rec + ", eme=" + eme + ", dateRec="
				+ dateRec + ", timeRec=" + timeRec + ", detail=" + detail + "]";
	}



	
	
	



	
	
	
	
	



}
