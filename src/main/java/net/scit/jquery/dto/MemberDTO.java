package net.scit.jquery.dto;

public class MemberDTO {
	private String userid;
	private String userpwd;
	private int age;
	private String location;
	
  	public MemberDTO() {
	}

	public String getUserid() {
		return userid;
	}

	public String getUserpwd() {
		return userpwd;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getLocation() {
		return location;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", userpwd=" + userpwd + ", age=" + age + ", location=" + location + "]";
	}
}
