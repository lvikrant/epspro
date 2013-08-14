package com.test.beans;

public class GameMetadata {

	int pid;
	int id;
	int player_id;
	String team;
	String name;
	String type;
	

	public GameMetadata(int pid,int id,int player_id,String team,String name,String type)
	{
		this.pid = pid;
		this.id= id;
		this.player_id = player_id;
		this.team = team;
		this.name = name;
		this.type = type;		
	}	
	

	@Override
	public String toString() {
		
		return "Process_Id: " + String.valueOf(pid) +			
		"ID: " + String.valueOf(id)+
		"Player_ID: " + String.valueOf(player_id)+
		"Team_name: " + team+
		"Name: " + name+
		"Type: " + type;	
		
				
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPlayer_id() {
		return player_id;
	}


	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
}