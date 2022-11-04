package students;

public class Main {

	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//		Random rannum = new Random();

		Student student1 = new Student("Алексей", "Дмитров", Gender.Male, 563, "Основная");
		Student student2 = new Student("Степан", "Баранов", Gender.Male, 623, "Основная");
		Student student3 = new Student("Олег", "Волынов", Gender.Male, 924, "Основная");
		Student student4 = new Student("Борис", "Пугачев", Gender.Male, 427, "Основная");
		Student student5 = new Student("Богдан", "Митрофанов", Gender.Male, 746, "Основная");
		Student student6 = new Student("Андрей", "Антонов", Gender.Male, 315, "Основная");
		Student student7 = new Student("Марина", "Леонова", Gender.Female, 258, "Основная");
		Student student8 = new Student("Анастасия", "Сорокина", Gender.Female, 916, "Основная");
		Student student9 = new Student("Зоя", "Гришина", Gender.Female, 257, "Основная");

//		Student student15 = new Student("Тамара", "Орлова", Gender.Female, 10, "Дополнительная");
		Student student11 = new Student("Юрий", "Гришин", Gender.Male, 11, "Основная");

		Student student20 = new Student("Марина", "Леонова", Gender.Female, 258, "Основная");

		Group group1 = new Group("Основная");

		try {
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student4);
			group1.addStudent(student5);
			group1.addStudent(student6);
			group1.addStudent(student7);
			group1.addStudent(student8);
			group1.addStudent(student9);

//			group2.addStudent(student15);
//			group1.addStudent(student11);

		} catch (GroupOverflowException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}

		System.out.println("+---+---+---+---+---+---+---+");
		System.out.println();

		try {
			System.out.println(group1.searchStudentByLastName("Леонова"));
			System.out.println(group1.searchStudentByLastName(student11.getLastName())); // Не существует
			System.out.println();

		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("+---+---+---+---+---+---+---+");
		System.out.println();

		group1.removeStudentById(746);
		group1.removeStudentById(491); // Не существует

		// (ВНИЗУ) sortStudentsByLastName, создание студента

//		System.out.println();
//		System.out.println("Создание нового студента:");
//		System.out.println();
//		Student student10 = new CreateStudent().newStudent();
//		CreateStudent.addStudentToGroup(student10, group1);

//		System.out.println();
//		System.out.println("Информация о созданном студенте:");
//		System.out.println();
//		System.out.println(student10);

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
//
//		// Поиск файла в рабочем каталоге
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
//		// Вычитка и возврат группы из файла
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
//		// Вычитка и возврат другой группы из файла
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
			group1.addStudent(student20);
		} catch (GroupOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		group1.checkStudentsSimilarity();
//		System.out.println(group1.checkStudentsSimilarity());
		System.out.println();

		System.out.println("+---+---+---+---+---+---+---+");
	}
}
