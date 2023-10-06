package com.example.demo.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TagRecus implements Serializable {
	
	@Id
	private String tag;
	private int ordre;
	private String valeur;
	
	
	
	
	
	public TagRecus() {
		super();
	}



	public TagRecus(String tag, int ordre, String valeur) {
		super();
		this.tag = tag;
		this.ordre = ordre;
		this.valeur = valeur;
	}



	public String getTag() {
		return tag;
	}



	public void setTag(String tag) {
		this.tag = tag;
	}



	public int getOrdre() {
		return ordre;
	}



	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}



	public String getValeur() {
		return valeur;
	}



	public void setValeur(String valeur) {
		this.valeur = valeur;
	}



	@Override
	public String toString() {
		return "TagRecus [tag=" + tag + ", ordre=" + ordre + ", valeur=" + valeur + "]";
	}
	
	
	
	
	
	
}
