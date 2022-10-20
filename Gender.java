package students;

public enum Gender {

	Male("Студент "), Female("Студентка ");

	private String getFilePermissions = "";

	private Gender(String getFilePermissions) {
		this.getFilePermissions = getFilePermissions;
	}

	public String getFilePermissions() {
		return getFilePermissions;
	}

	public void setFilePermissions(String getFilePermissions) {
		this.getFilePermissions = getFilePermissions;
	}
}
