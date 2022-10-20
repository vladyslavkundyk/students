package students;

public class CSVStringConverter implements StringConvertor {

	@Override
	public String toStringRepresentation(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student fromStringRepresentation(String str) {

		String[] arrStudent = str.split(";");
		Student student = new Student(arrStudent[0], arrStudent[1], setStudentGender(arrStudent[2]),
				Integer.parseInt(arrStudent[3]), arrStudent[4]);

		return student;
	}

	private Gender setStudentGender(String gender) {

		for (int i = 0; i < Gender.values().length; i++) {
			if (Gender.values()[i].toString().equals(gender))
				return Gender.values()[i];
		}
		return null;
	}
}
