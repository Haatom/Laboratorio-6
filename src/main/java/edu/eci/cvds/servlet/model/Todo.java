package edu.eci.cvds.servlet.model;
/**
* @authors David Perez Nicolas Camacho
*/
public class Todo{
	
	public int userId;
	public int id;
	public String title;
	public boolean completed;
	
	public Todo(){ }
	
	public int getId(){
		return id;
	}
	public void setId(int num){
		id = num;
	}
	public int getUserId(){
		return userId;
	}
	public void setUserId(int num){
		userId = num;
	}
	
	public String getTitle(){
		return title;
	}
	public void setTitle(String stri){
		title = stri;
	}
	
	public boolean getCompleted(){
		return completed;
	}
	public void  setCompleted(boolean a){
		completed = a;
	}
        
}