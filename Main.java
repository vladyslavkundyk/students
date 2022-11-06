package students;

public class Main {

	public static void main(String[] args) {

		Student student1 = new Student("Алексей", "Дмитров", Gender.Male, 0, "");
		Student student2 = new Student("Степан", "Баранов", Gender.Male, 0, "");
		Student student3 = new Student("Олег", "Волынов", Gender.Male, 0, "");
		Student student4 = new Student("Борис", "Пугачев", Gender.Male, 0, "");
		Student student5 = new Student("Богдан", "Митрофанов", Gender.Male, 0, "");
		Student student6 = new Student("Марина", "Леонова", Gender.Female, 0, "");
		Student student7 = new Student("Андрей", "Антонов", Gender.Male, 0, "");
		
		Student student10 = new Student("Марина", "Леонова", Gender.Female, 0, "");

		Group group1 = new Group("Основная");

		try {
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student4);
//			group1.addStudent(student5);
			group1.addStudent(student6);
			group1.addStudent(student7);

		} catch (GroupOverflowException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}

		System.out.println("+---+---+---+---+---+---+---+");
		System.out.println();

		try {
			System.out.println(group1.searchStudentByLastName("Леонова"));
			System.out.println(group1.searchStudentByLastName(student5.getLastName())); // Не существует
			System.out.println();

		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("+---+---+---+---+---+---+---+");
		System.out.println();

		group1.removeStudentById(group1.getStudents().size()); // Удалить последнего студента
		group1.removeStudentById(491); // Не существует

		// SortStudentsByLastName, создание студента
//		System.out.println();
//		System.out.println("Создание нового студента:");
//		System.out.println();
//		Student student30 = new CreateStudent().newStudent();
//		CreateStudent.addStudentToGroup(student30, group1);
//
//		System.out.println();
//		System.out.println("Информация о созданном студенте:");
//		System.out.println();
//		System.out.println(student30);

		System.out.println("+---+---+---+---+---+---+---+");
		System.out.println();

		group1.sortStudentsByLastName();
		System.out.println("Группа студентов " + group1.getGroupName() + " отсортирована!");
		System.out.println();
		System.out.println(group1);

		System.out.println("+---+---+---+---+---+---+---+");
		System.out.println();

		// Запись группы в CSV файл
		GroupFileStorage gfs = new GroupFileStorage();
		gfs.saveGroupToCSV(group1);
		System.out.println();
		
		// Поиск файла в рабочем каталоге
//		File groupsFolder = new File("D:\\Группы студентов");
//		String groupToSearch = ("Основная");
//		File searchGroup = gfs.findFileByGroupName(groupToSearch, groupsFolder);
//		if (searchGroup != null) {
//			System.out.println("Найден файл группы: " + searchGroup.getName());
//			System.out.println();
//		} else {
//			System.out.println("Группы " + groupToSearch + " не существует!");
//		}
//
		// Вычитка и возврат группы из файла
//		String groupToLoad = "Основная";
//		File groupsDirectory = new File("D:\\Группы студентов\\" + groupToLoad + ".csv");
//		Group tempGroup = new Group("");
//		try {
//			tempGroup = gfs.loadGroupFromCSV(groupsDirectory);
//		} catch (FileNotFoundException e) {
//			System.out.println("Файла с группой " + groupToLoad + ".csv не существует!");
//		} catch (IOException b) {
//			b.printStackTrace();
//		}
//
		// Вычитка и возврат другой группы из файла
//		groupToLoad = "Дополнительная";
//		groupsDirectory = new File("D:\\Группы студентов\\" + groupToLoad + ".csv");
//		try {
//			tempGroup = gfs.loadGroupFromCSV(groupsDirectory);
//		} catch (FileNotFoundException e) {
//			System.out.println("Файла с группой " + groupToLoad + ".csv не существует!");
//		} catch (IOException b) {
//			b.printStackTrace();
//		}
//
//		System.out.println("Студенты из файла группы " + tempGroup.getGroupName() + ":");
//		System.out.println();
//		System.out.println(tempGroup);

		System.out.println("+---+---+---+---+---+---+---+");
		System.out.println();

		System.out.println("Студент 1 equals студент 2 = " + student2.equals(student1));
		System.out.println("Студент 2 equals студент 3 = " + student2.equals(student3));
		System.out.println("Студент 2 equals студент 2 = " + student2.equals(student2));
		System.out.println();

		System.out.println(student1.getName() + " " + student1.getLastName() + " - hashCode = " + student1.hashCode());
		System.out.println(student2.getName() + " " + student2.getLastName() + " - hashCode = " + student2.hashCode());
		System.out.println(student3.getName() + " " + student3.getLastName() + " - hashCode = " + student3.hashCode());
		System.out.println();

		System.out.println("+---+---+---+---+---+---+---+");
		System.out.println();

		group1.checkStudentsSimilarity();
//		System.out.println(group1.checkStudentsSimilarity());
		System.out.println();

		try {
			group1.addStudent(student10);
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}

		group1.checkStudentsSimilarity();
//		System.out.println(group1.checkStudentsSimilarity());
		System.out.println();

		System.out.println("+---+---+---+---+---+---+---+");
	}
}
