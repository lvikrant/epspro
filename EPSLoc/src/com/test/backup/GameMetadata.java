package com.test.backup;

import java.util.HashMap;
import java.util.Map;

import com.test.utils.EventValue;

public class GameMetadata {

	
	MetadataValue mValue;
	int pid;
	
	Map<Integer,MetadataValue> map = new HashMap<Integer,MetadataValue>();

	public MetadataValue getmValue() {
		return mValue;
	}

	public void setmValue(MetadataValue mValue) {
		this.mValue = mValue;
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

	public GameMetadata(MetadataValue mValue, int pid,
			Map<Integer, MetadataValue> map) {
		super();
		this.mValue = mValue;
		this.pid = pid;
		this.map = map;
	}	
}