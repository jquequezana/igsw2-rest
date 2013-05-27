package repository;
import java.util.Collection;

import java.util.HashMap;
import java.util.Map;

import domain.User;
public class UserRepository {
	Map<Long, User> users = new HashMap<Long, User>();
	
	public void add(User person) {
		users.put(person.getId(), person);
	}
	
	public Collection<User> list() {
		return users.values();
	}
	

}
