package domain;
import java.util.List;


public class User {
	private String name;
	private Integer age;
	private List<User> friends;
	private Long id;
	public User () {
		
	}
	
	public User(Long id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public List<User> getFriends() {
		return friends;
	}
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
