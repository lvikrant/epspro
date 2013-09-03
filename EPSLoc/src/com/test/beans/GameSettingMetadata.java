package com.test.beans;

import java.util.HashMap;
import java.util.Map;
import com.test.utils.GameSettingMetadataValue;

public class GameSettingMetadata {

	int sensorId;
	int id;	
	String team;
	String playerId;
	String playerName;
	String sensorType;

	Map<Integer,GameSettingMetadataValue> map;

	public GameSettingMetadata() {
		map = new HashMap<Integer,GameSettingMetadataValue>();
	}	

	public void addEntry(int sensorId,int id,String team,String playerId,String playername,String sensorType)
	{
		map.put(sensorId, new GameSettingMetadataValue(id, team, playerId,playername, sensorType));
	}

	public int getSensorId() {
		return sensorId;
	}

	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}

	public Map<Integer, GameSettingMetadataValue> getMap() {
		return map;
	}

	public void setMap(Map<Integer, GameSettingMetadataValue> map) {
		this.map = map;
	}

	public int getId(int sensorId) {
		if(map.containsKey(sensorId))
		{
			return map.get(sensorId).getId();
		}
		return -1;
	}

	public void setId(int sensorId,int id) {
		if(map.containsKey(sensorId))
		{
			map.get(sensorId).setId(id);
		}		
	}

	public String getPlayerId(int sensorId) {
		if(map.containsKey(sensorId))
		{
			return map.get(sensorId).getPlayerId();
		}
		return null;
	}

	public void setPlayerId(int sensorId,String playerId) {
		if(map.containsKey(sensorId))
		{
			map.get(sensorId).setPlayerId(playerId);
		}		
	}

	public String getTeam(int sensorId) {
		if(map.containsKey(sensorId))
		{
			return map.get(sensorId).getTeam();
		}
		return null;
	}

	public void setTeam(int sensorId,String team) {
		if(map.containsKey(sensorId))
		{
			map.get(sensorId).setTeam(team);
		}		
	}

	public String getPlayerName(int sensorId) {
		if(map.containsKey(sensorId))
		{
			return map.get(sensorId).getPlayerName();
		}
		return null;
	}

	public void setPlayerName(int sensorId,String name) {
		if(map.containsKey(sensorId))
		{
			map.get(sensorId).setPlayerName(name);
		}		
	}

	public String getSensorType(int sensorId) {
		if(map.containsKey(sensorId))
		{
			return map.get(sensorId).getSensorType();
		}
		return null;		
	}

	public void setSensorType(int sensorId,String type) {
		if(map.containsKey(sensorId))
		{
			map.get(sensorId).setSensorType(type);
		}		
	}


	@Override
	public String toString() {

		return "SensorID: " + String.valueOf(sensorId) +
				"ID: " + String.valueOf(map.get(sensorId).getId())+					
				"Team_name: " + map.get(sensorId).getTeam()+
				"PlayerID: " + map.get(sensorId).getPlayerId()+
				"PlayerName: " + map.get(sensorId).getPlayerName()+
				"SensorType: " + map.get(sensorId).getSensorType();				

		/*"ID: " + String.valueOf(id)+
				"Player_ID: " + String.valueOf(player_id)+
				"Team_name: " + team+
				"Name: " + name+
				"Type: " + type;	*/
	}
}