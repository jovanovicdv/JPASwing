package domain;

public enum Title {
	PROFESSOR("Professor"),
	ASSISTENT_PROFESSOR("Assistent_Professor"),
	TEACHING_ASSISTENT("Teaching_Professor");
	
	String title;

	
	
	private Title(String title) {
		this.title = title;
	}



	public String getTitle() {
		return title;
	}

}
