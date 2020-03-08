package domain;

public enum Role {
	ADMIN("Admin"),
	PROFESSOR("Professor"),
	STUDENT("Student");
	
	private String role;

	private Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
	
	

}
