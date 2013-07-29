package com.test.backup;

public class MetadataValue {

	/**
	 * @param args
	 */
	int id;
	int player_id;
	String team;
	String name;
	String type;
	
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
	public MetadataValue(int id, int player_id, String team, String name,
			String type) {
		super();
		this.id = id;
		this.player_id = player_id;
		this.team = team;
		this.name = name;
		this.type = type;
	}
}