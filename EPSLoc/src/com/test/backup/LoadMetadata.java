/*package com.test.backup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;


public class LoadMetadata {
	static String key;
    static String[] fields;
    static GameMetadata gm;
	
    public LoadMetadata()
	{
		 String key = "id";
	     String[] fields = "id,pid,type".split(",");
	     gm = new GameMetadata();
	}
	public static void main(String[] args)
	{
		JsonReader jsonReader;
		
		try {

			JSONParser p = new JSONParser();
			BufferedReader reader = new BufferedReader(new FileReader("./src/com/test/resources/metadata.json"));
			for(String line = reader.readLine(); line != null; line = reader.readLine())
			{

				JSONObject obj = (JSONObject)p.parse(line);
				Iterator i$ = obj.keySet().iterator();
				do
				{
					if(!i$.hasNext())
						break;
					String key = (String)i$.next();
					if(!"id".equals(key) && !contains(key))
						System.out.println("Skipping meta-data field '{}'"+ key);
					else
						if(key.equals("type"))
						{
							if(obj.get(key).toString().equals("left leg"))
							{
								meta.put(key, EventType.LeftLeg);
								meta.put("leg", Integer.valueOf(0));
							} else
								if(obj.get(key).toString().equals("right leg"))
								{
									meta.put(key, EventType.RightLeg);
									meta.put("leg", Integer.valueOf(1));
								} else
									if(obj.get(key).toString().indexOf("all") >= 0)
										meta.put(key, EventType.Ball);
						} else
						{
							try
							{
								meta.put(key, new Integer((new StringBuilder()).append(obj.get(key)).append("").toString()));
							}
							catch(Exception e)
							{
								meta.put(key, (Serializable)obj.get(key));
							}
						}
				} while(true);
				System.out.println("Adding {}"+ meta);
				Integer k = new Integer(((Serializable)meta.get(this.key)).toString());
				if(k != null)
				{
					System.out.println("Adding meta-data for key '{}'"+k);
					metaData.put(k, meta);
				}
			}

			reader.close();


		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}




	protected static boolean contains(String f)
	{
		if(fields == null)
			return true;
		String arr$[] = fields;
		int len$ = arr$.length;
		for(int i$ = 0; i$ < len$; i$++)
		{
			String field = arr$[i$];
			if(field.equals(f))
				return true;
		}

		return false;
	}
}

public void init()
	{
	try {

		BufferedReader br = new BufferedReader(new FileReader("c:\\file.json"));
		GameMetadata metadata = gson.fromJson(br, GameMetadata.class);
		System.out.println(""+metadata);

	} catch (IOException e) {
		e.printStackTrace();
	}
	}
*/