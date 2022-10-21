package students;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.Arrays;
//import java.util.Objects;
//import java.util.Scanner;

public class GroupFileStorage {

	public void saveGroupToCSV(Group group) {

		String sepSymbol = ";";

		File fileGroupName = new File("D:\\Группы студентов\\" + group.getGroupName() + ".csv");

		try (PrintWriter pw = new PrintWriter(fileGroupName)) {
			for (int i = 0; i < group.getStudents().length; i++) {
				Student student = group.getStudents()[i];
				if (student != null) {
					pw.println(student.getName() + sepSymbol + student.getLastName() + sepSymbol + student.getGender()
							+ sepSymbol + student.getId() + sepSymbol + student.getGroupName());
				}
			}
			System.out.println("Группа сохранена в файл: " + group.getGroupName() + ".csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Group loadGroupFromCSV(File file) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String tempString = "";
			Group result = new Group(file.getName());
			CSVStringConverter convert = new CSVStringConverter();
			for (;;) {
				tempString = br.readLine();
				if (tempString == null) {
					break;
				}
				try {
					result.addStudent(convert.fromStringRepresentation(tempString));
				} catch (GroupOverflowException e) {
					e.printStackTrace();
				}
			}
			return result;
		}
	}

	public File findFileByGroupName(String groupName, File workFolder) {

		File[] tempFiles = workFolder.listFiles();
		if (tempFiles != null) {
			for (int i = 0; i < tempFiles.length; i++) {
				if (tempFiles[i].isFile() && tempFiles[i].getName().equals(groupName + ".csv")) {
					return tempFiles[i];
				}
			}
		}
		return null;
	}

//	public static Student studentFromString(String text) {
//
//		String[] arr = text.split(";");
//		Student student = new Student(arr[0], arr[1], Gender.valueOf(arr[2]), Integer.valueOf(arr[3]), arr[4]);
//
//		return student;
//
//	}

}
