package com.sitiaisyah.idn.uasandroid_java.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttendanceItem {

	@SerializedName("date")
	@Expose
	private String date;

	@SerializedName("kelas")
	@Expose
	private String kelas;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("id")
	@Expose
	private int id;

	@SerializedName("description")
	@Expose
	private String description;

	@SerializedName("lesson")
	@Expose
	private String lesson;

	public AttendanceItem(){

	}

	public AttendanceItem(int id, String date, String name, String kelas, String lesson, String description){
		this.id = id;
		this.date = date;
		this.name = name;
		this.kelas = kelas;
		this.lesson = lesson;
		this.description = description;

	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setKelas(String kelas){
		this.kelas = kelas;
	}

	public String getKelas(){
		return kelas;
	}

	public void setLesson(String lesson){
		this.lesson = lesson;
	}

	public String getLesson(){
		return lesson;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}
}