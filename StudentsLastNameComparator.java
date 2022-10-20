package students;

import java.util.Comparator;

public class StudentsLastNameComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {

		Student studentFirst = (Student) o1;
		Student studentSecond = (Student) o2;

		String nameFirst = studentFirst.getName();
		String nameSecond = studentSecond.getName();

		if (nameFirst.compareTo(nameSecond) > 0) {
			return 1;
		}
		if (nameFirst.compareTo(nameSecond) < 0) {
			return -1;
		}
		return 0;
	}
}
