package com.notifier.json;

import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONObject;

import com.notifier.banOBJ.Ban;
import com.notifier.kickOBJ.Kick;

public class Json {
	public static String banToJSON(Ban ban) throws IOException {
		JSONObject obj = new JSONObject();
		
		obj.put("sender", ban.getSender());
		obj.put("target", ban.getTarget());
		obj.put("season", "ban");

	    StringWriter out = new StringWriter();
	    obj.writeJSONString(out);
	      
	    String jsonText = out.toString();
	    
	    return jsonText;
	}
	
	public static String kickToJSON(Kick kick) throws IOException {
		JSONObject obj = new JSONObject();
		
		obj.put("sender", kick.getSender());
		obj.put("target", kick.getTarget());
		obj.put("season", "kick");

	    StringWriter out = new StringWriter();
	    obj.writeJSONString(out);
	      
	    String jsonText = out.toString();
	    
	    return jsonText;
	}
}
