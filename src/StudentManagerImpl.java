import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManagerImpl implements StudentManager {
    private GenericList<Student> studentList = new GenericList<>();

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void removeStudent(int id) throws StudentNotFoundException {
        Student student = findStudent(id);
        studentList.remove(student);
    }

    @Override
    public Student findStudent(int id) throws StudentNotFoundException {
        return studentList.getAll().stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList.getAll();
    }

    public List<Student> getStudentsAbove21() {
        return studentList.getAll().stream()
                .filter(student -> student.getAge() > 21)
                .collect(Collectors.toList());
    }

    public List<Student> getSortedStudentsByName() {
        return studentList.getAll().stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }
}
