package students;

import java.util.Objects;

public class Human {

	private String name;
	private String lastName;
	public Gender gender;

	public Human(String name, String lastName, Gender gender) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", lastName=" + lastName + ", gender=" + gender + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gender, lastName, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		return gender == other.gender && Objects.equals(lastName, other.lastName) && Objects.equals(name, other.name);
	}
}
