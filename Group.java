package students;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Group {

	private String groupName;
//	private Student[] students;
	private List<Student> students = new ArrayList<>(10);

	public Group() {
	}

	public Group(String groupName) {
		super();
//		students = new Student[10];
		this.groupName = groupName;
	}

	public Group(String groupName, List<Student> students) {
		this.groupName = groupName;
		this.students = students;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	// OLD Метод добавления студента в группу. В случае добавления 11 студента
	// должно быть возбужденно пользовательское исключение:

//	public void addStudent(Student student) throws GroupOverflowException {
//
//		for (int i = 0; i < students.length; i++) {
//			if (students[i] == null) {
//				students[i] = student;
////				System.out.println(student.gender.getFilePermissions() + student.getName() + " " + student.getLastName()
////						+ " добавлен в группу " + student.getGroupName() + "!");
//				return;
//			}
//		}

	// NEW Метод добавления студента в группу. В случае добавления 11 студента
	// должно быть возбужденно пользовательское исключение:

	public void addStudent(Student student) throws GroupOverflowException {

		if (students.size() < 10) {
			students.add(student);
			student.setGroupName(this.groupName);
			student.setId(students.size());
			return;
		}
		throw new GroupOverflowException("Студент " + student.getLastName() + " не добавлен,\nгруппа переполнена!");
	}

	// OLD Метод поиска студента в группе. Если студент не найден должно быть
	// возбужденно пользовательское исключение:

//	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
//
//		for (int j = 0; j < students.length; j++) {
//			if (students[j] != null) {
//				if (students[j].getLastName() == lastName) {
//					return students[j];
//				}
//			}
//		}
//		throw new StudentNotFoundException("Студент не найден,\nили он ещё не добавлен в группу :(");
//	}

	// NEW Метод поиска студента в группе. Если студент не найден должно быть
	// возбужденно пользовательское исключение:

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		Student tempStudent = null;

		for (Student student : students) {
			if (student.getLastName().equals(lastName)) {
				tempStudent = student;
			}
		}
		if (tempStudent == null) {
			throw new StudentNotFoundException(
					"Студент по фамилии " + lastName + " не найден,\nили он ещё не добавлен в группу :(\n");
		}
		System.out.println("Студент по фамилии найден! Это:");
		return tempStudent;
	}

	// OLD Метод удаления студента по номеру зачетки, вернуть true если такой
	// студент был и он был удален и false в противном случае:

//	public boolean removeStudentById(int id) {
//
//		for (int k = 0; k < students.length; k++) {
//			if (students[k] != null) {
//				if (students[k].getId() == id) {
//					students[k] = null;
//					System.out.println("Студент по номеру зачетки " + id + " удалён!");
//					return true;
//				}
//			}
//		}
//		System.out.println("Студент по номеру зачетки " + id + " не найден :(");
//		return false;
//	}

	// NEW Метод удаления студента по номеру зачетки, вернуть true если такой
	// студент был и он был удален и false в противном случае:

	public boolean removeStudentById(int id) {

		for (Student student : students) {
			if (student.getId() == id) {
				System.out.println("Студент по номеру зачетки " + id + " удалён!");
				students.remove(student);
				return true;
			}
		}
		System.out.println("Студент по номеру зачетки " + id + " не найден :(\n");
		return false;
	}

	// OLD Метод сортировки массива студентов по фамилии:

//	public void sortStudentsByLastName() {
//		Arrays.sort(students, Comparator.nullsFirst(new StudentsLastNameComparator()));
//	}

	// NEW Метод сортировки массива студентов по фамилии:

	public void sortStudentsByLastName() {
		Collections.sort(students, Comparator.comparing(Human::getLastName));
	}

	// OLD Метод вывода группы студентов:

//	@Override	
//	public String toString() {
//		String listOfStudents = "";
//		String[] arrayOfStudents = new String[10];
//
//		for (int i = 0; i < arrayOfStudents.length; i++) {
//			if (students[i] != null)
//				arrayOfStudents[i] = students[i].getLastName() + " " + students[i].getName();
//			else
//				arrayOfStudents[i] = "";
//		}
//
//		Arrays.sort(arrayOfStudents);
//		for (int i = 0; i < arrayOfStudents.length; i++) {
//			if (arrayOfStudents[i] != "") {
//				listOfStudents += arrayOfStudents[i] + "\n";
//			}
//		}
//
//		return listOfStudents;
//	}

	// OLD Метод для проверки факта отсутствия эквивалентных студентов в группе:

//	public boolean checkStudentsSimilarity() {
//		for (int i = 0; i < students.length; i++) {
//			for (int j = i + 1; j < students.length; j++) {
//				if (students[i] != null && students[j] != null) {
//					if (students[i].equals(students[j])) {
//						System.out.println("Похожий студент найден - " + students[i].getName() + " "
//								+ students[i].getLastName() + " 🤔");
//						return true;
//
//					}
//				}
//			}
//		}
//		System.out.println("Похожий студент не найден 👍");
//		return false;
//	}

	// NEW Метод для проверки факта отсутствия эквивалентных студентов в группе:

//	public boolean checkStudentsSimilarity() {
//		for (int i = 0; i < students.size() - 1; i++) {
//			for (int j = i + 1; j < students.size(); j++) {
//				if (students.get(i).getLastName() != null
//						&& students.get(i).getLastName().equals(students.get(j).getLastName())) {
//
//					System.out.println("Похожий студент найден - " + students.get(i).getName() + " "
//							+ students.get(i).getLastName() + " 🤔");
//					return true;
//				}
//			}
//		}
//		System.out.println("Похожих студентов не найдено 👍");
//		return false;
//	}

	public boolean checkStudentsSimilarity() {
		for (int i = 0; i < students.size() - 1; i++) {
			for (int j = i + 1; j < students.size(); j++) {
				if (students.get(i).getLastName() != null && students.get(i).getName() != null
						&& students.get(i).getLastName().equals(students.get(j).getLastName())
						&& students.get(i).getName().equals(students.get(j).getName())) {

					System.out.println("Похожий студент найден - " + students.get(i).getName() + " "
							+ students.get(i).getLastName() + " 🤔");
					return true;
				}
			}
		}
		System.out.println("Похожих студентов не найдено 👍");
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupName, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Objects.equals(students, other.students);
	}

	// NEW Метод вывода группы студентов:

	@Override
	public String toString() {
		sortStudentsByLastName();
		StringBuilder studentsList = new StringBuilder("Информация о группе: " + groupName + '\n');

		for (Student student : students) {
			studentsList.append(student.toString());
		}
		return studentsList.toString();
	}
}
