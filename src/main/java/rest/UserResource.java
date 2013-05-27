package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import domain.User;

import repository.UserRepository;



public class UserResource extends HttpServlet {
	static UserRepository repository = new UserRepository();  
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {		
		JSONArray json_array = new JSONArray();
		for (User user : repository.list()) {
			json_array.add(user);
		}
		
		response.setContentType("application/json");
		response.getOutputStream().print(json_array.toString());
		response.getOutputStream().close();
	}

	protected void doPut(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String jsonUser = br.readLine();
		if (!jsonUser.isEmpty()) {
			JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(jsonUser);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setRootClass( User.class );
			User user = (User) JSONSerializer.toJava(jsonObject, jsonConfig);
			repository.add(user);
		}
		//Only for debug :)
		//response.getOutputStream().print(jsonUser);
		//response.getOutputStream().close();
	}

}
