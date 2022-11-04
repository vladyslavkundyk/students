package students;

import java.util.Scanner;
import java.util.Random;

public class CreateStudent {

	Scanner sc = new Scanner(System.in);
	Random rannum = new Random();

	public Student newStudent() {

		Student student = new Student(null, null, null, 0, null);

		System.out.println("Введите имя студента (String) >");
		student.setName(sc.nextLine());

		System.out.println("Введите фамилию студента (String) >");
		student.setLastName(sc.nextLine());

		System.out.println("Введите пол студента (male/female) >");
		String studentGender = sc.nextLine();

		if (studentGender.equals("male")) {
			student.setGender(Gender.Male);
		} else if (studentGender.equals("female")) {
			student.setGender(Gender.Female);
		} else {
			System.out.println("");
			System.out.println("Неправильный ввод!");
			System.out.println("");
		}

		student.setId(rannum.nextInt(200, 500));
		System.out.println("Номер зачётки студента " + student.getId() + " сгенерирован!");
		System.out.println("");

		System.out.println("Введите название группы студента (String) >");
		student.setGroupName(sc.nextLine());

		return student;
	}

	public static void addStudentToGroup(Student student, Group group) {

		try {
			group.addStudent(student);
		} catch (GroupOverflowException e) {
			System.out.println(student.gender.getFilePermissions() + student.getName() + " " + student.getLastName()
					+ " не добавлен,\nгруппа " + student.getGroupName() + " переполнена :(");
		}
	}
}
