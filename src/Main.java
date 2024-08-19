public class Main {
    public static void main(String[] args) {
        StudentManagerImpl studentManager = new StudentManagerImpl();

        // Agregar estudiantes
        studentManager.addStudent(new Student(1, "Brayan Lem", 22));
        studentManager.addStudent(new Student(2, "Raul Morales", 20));
        studentManager.addStudent(new Student(3, "Ashli Ixbalan", 25));

        // Mostrar todos los estudiantes
        System.out.println("Todos los estudiantes:");
        studentManager.getAllStudents().forEach(System.out::println);

        // Buscar estudiante
        try {
            Student student = studentManager.findStudent(1);
            System.out.println("Estudiante encontrado: " + student);
        } catch (StudentNotFoundException e) {
            System.err.println(e.getMessage());
        }

        // Mostrar estudiantes mayores de 21 años
        System.out.println("Estudiantes mayores de 21 años:");
        studentManager.getStudentsAbove21().forEach(System.out::println);

        // Ordenar y mostrar estudiantes por nombre
        System.out.println("Estudiantes ordenados por nombre:");
        studentManager.getSortedStudentsByName().forEach(System.out::println);

        // Eliminar estudiante
        try {
            studentManager.removeStudent(2);
        } catch (StudentNotFoundException e) {
            System.err.println(e.getMessage());
        }

        // Mostrar todos los estudiantes después de eliminar
        System.out.println("Todos los estudiantes después de eliminar:");
        studentManager.getAllStudents().forEach(System.out::println);
    }
}
