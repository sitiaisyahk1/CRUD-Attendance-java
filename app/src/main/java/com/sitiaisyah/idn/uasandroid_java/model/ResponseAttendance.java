package com.sitiaisyah.idn.uasandroid_java.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseAttendance{

	@SerializedName("date")
	private String date;

	@SerializedName("name")
	private String name;

	@SerializedName("lesson")
	private String lesson;

	@SerializedName("description")
	private String description;

	@SerializedName("class")
	private String jsonMemberClass;

	public void setDate(String date){
		this.date = date;
	}

	@SerializedName("person")
	private List<AttendanceItem> attendance;

	@SerializedName("error")
	private boolean error;

	@SerializedName("status")
	private int status;


	public void setAttendance(List<AttendanceItem> attendance){
		this.attendance = attendance;
	}

	public List<AttendanceItem> getPerson(){
		return attendance;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
//	public String getDate(){
//		return date;
//	}
//
//	public void setName(String name){
//		this.name = name;
//	}
//
//	public String getName(){
//		return name;
//	}
//
//	public void setLesson(String lesson){
//		this.lesson = lesson;
//	}
//
//	public String getLesson(){
//		return lesson;
//	}
//
//	public void setDescription(String description){
//		this.description = description;
//	}
//
//	public String getDescription(){
//		return description;
//	}


}