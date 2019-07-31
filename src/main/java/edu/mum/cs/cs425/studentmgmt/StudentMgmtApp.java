package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.ClassRoomRepository;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.repository.TranscriptRepository;

@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner {

	@Autowired
	StudentRepository studentrepository;
	@Autowired
	TranscriptRepository transcriptrepository;
	@Autowired
	ClassRoomRepository classroomrepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Student s = new Student("000-61-0001","Anna","Lynn","Smith",3.45f,LocalDate.of(2019, 5, 24));
		Transcript t = new Transcript(s,"BS Computer Science");
		Classroom c = new Classroom(s,"McLaughlin building","M105");
		Student savedStudent = saveStudent(s);
		Transcript savedTranscript = saveTranscript(t);
		Classroom savedClassroom = saveClassroom(c);
		System.out.printf("Student %s saved Successfully", s.getFirstName());
	}
	
	Student saveStudent(Student s) {
		return studentrepository.save(s);
	}
	
	Transcript saveTranscript(Transcript t) {
		return transcriptrepository.save(t);
	}
	
	Classroom saveClassroom(Classroom c) {
		return classroomrepository.save(c);
	}
	

}
