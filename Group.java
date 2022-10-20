package students;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Group {

	private String groupName;
	private Student[] students;

	public Group(String groupName) {
		super();
		students = new Student[10];
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudents() {
		return students;
	}

	// Метод добавления студента в группу. В случае добавления 11 студента должно
	// быть возбужденно пользовательское исключение
	public void addStudent(Student student) throws GroupOverflowException {

		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
//				System.out.println(student.gender.getFilePermissions() + student.getName() + " " + student.getLastName()
//						+ " добавлен в группу " + student.getGroupName() + "!");
				return;
			}
		}

		throw new GroupOverflowException(student.gender.getFilePermissions() + student.getName() + " "
				+ student.getLastName() + " не добавлен,\nгруппа " + student.getGroupName() + " переполнена :(");
	}

	// Метод поиска студента в группе. Если студент не найден должно быть
	// возбужденно пользовательское исключение
	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {

		for (int j = 0; j < students.length; j++) {
			if (students[j] != null) {
				if (students[j].getLastName() == lastName) {
					return students[j];
				}
			}
		}
		throw new StudentNotFoundException("Студент не найден,\nили он ещё не добавлен в группу :(");
	}

	// Метод удаления студента по номеру зачетки, вернуть true если такой студент
	// был и он был удален и false в противном случае
	public boolean removeStudentByID(int id) {

		for (int k = 0; k < students.length; k++) {
			if (students[k] != null) {
				if (students[k].getId() == id) {
					students[k] = null;
					System.out.println("Студент по номеру зачетки " + id + " удалён!");
					return true;
				}
			}
		}
		System.out.println("Студент по номеру зачетки " + id + " не найден :(");
		return false;
	}

	// Метод сортировки массива студентов по фамилии
	public void sortStudentsByLastName() {
		Arrays.sort(students, Comparator.nullsFirst(new StudentsLastNameComparator()));
	}

////	(ПОД ВОПРОСОМ) - СПРОСИТЬ У ЧЕЛА
//	
//	public void generateStudentID(int studentID) {
//		Random rannum = new Random();
//		for (int i = 0; i < students.length; i++) {
//			if (students[i] != null) {
//				studentID = (rannum.nextInt(200, 500));
//				if (students[i].getId() == studentID) {
//					studentID = (rannum.nextInt(200, 500));
//					students[i].setId(studentID);
//				}
//			}
//			System.out.println("");
//			System.out.println("Номер зачётки студента " + students[i].getId() + " сгенерирован!");
//		}
//	}

	@Override
	// Метод вывода группы студентов
	public String toString() {
		String listOfStudents = "";
		String[] arrayOfStudents = new String[10];

		for (int i = 0; i < arrayOfStudents.length; i++) {
			if (students[i] != null)
				arrayOfStudents[i] = students[i].getLastName() + " " + students[i].getName();
			else
				arrayOfStudents[i] = "";
		}

		Arrays.sort(arrayOfStudents);
		for (int i = 0; i < arrayOfStudents.length; i++) {
			if (arrayOfStudents[i] != "") {
				listOfStudents += arrayOfStudents[i] + "\n";
			}
		}

		return listOfStudents;
	}
}
