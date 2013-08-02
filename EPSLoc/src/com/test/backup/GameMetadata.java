package com.test.backup;

import java.util.HashMap;
import java.util.Map;

import com.test.utils.EventValue;

public class GameMetadata {

	int pid;
	int id;
	int player_id;
	String team;
	String name;
	String type;
	Map<Integer,MetadataValue> map;

	public GameMetadata() {
		map = new HashMap<Integer,MetadataValue>();
	}	

	public void addEntry(int pid,int id,int player_id,String team,String name,String type)
	{
		map.put(pid, new MetadataValue(id, player_id, team, name, type));
	}


	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Map<Integer, MetadataValue> getMap() {
		return map;
	}

	public void setMap(Map<Integer, MetadataValue> map) {
		this.map = map;
	}
	public int getId(int pid) {
		if(map.containsKey(pid))
		{
		return map.get(pid).getId();
		}
		return -1;
	}

	public void setId(int pid,int id) {
		if(map.containsKey(pid))
		{
		map.get(pid).setId(id);
		}		
	}

	public int getPlayer_id(int pid) {
		if(map.containsKey(pid))
		{
		return map.get(pid).getPlayer_id();
		}
		return -1;
	}

	public void setPlayer_id(int pid,int player_id) {
		if(map.containsKey(pid))
		{
		map.get(pid).setPlayer_id(player_id);
		}		
	}

	public String getTeam(int pid) {
		if(map.containsKey(pid))
		{
		return map.get(pid).getTeam();
		}
		return null;
	}

	public void setTeam(int pid,String team) {
		if(map.containsKey(pid))
		{
		map.get(pid).setTeam(team);
		}		
	}

	public String getName(int pid) {
		if(map.containsKey(pid))
		{
		return map.get(pid).getName();
		}
		return null;
	}

	public void setName(int pid,String name) {
		if(map.containsKey(pid))
		{
		map.get(pid).setType(name);
		}		
	}

	public String getType(int pid) {
		if(map.containsKey(pid))
		{
		return map.get(pid).getType();
		}
		return null;		
	}

	public void setType(int pid,String type) {
		if(map.containsKey(pid))
		{
		map.get(pid).setType(type);
		}		
	}


	@Override
	public String toString() {
		
		return "Process_Id: " + String.valueOf(pid) +
				"ID: " + String.valueOf(map.get(pid).getId())+
				"Player_ID: " + String.valueOf(map.get(pid).getPlayer_id())+
				"Team_name: " + map.get(pid).getTeam()+
				"Name: " + map.get(pid).getName()+
				"Type: " + map.get(pid).getType();			
	}
}