package com.test.utils;

public class GameSettingMetadataValue {

	/**
	 * @param args
	 */
	int id;	
	String team;
	String playerId;
	String playerName;
	String sensorType;
	
	public GameSettingMetadataValue(int id, String team, String playerId,
			String playerName, String sensorType) {
		super();
		this.id = id;
		this.team = team;
		this.playerId = playerId;
		this.playerName = playerName;
		this.sensorType = sensorType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	

}