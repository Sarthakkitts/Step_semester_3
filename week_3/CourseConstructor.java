public class CourseConstructor {
    public static void main(String[] args) {
        Course course = new Course("21CSC201J", "Data Structures");
        System.out.println(course.code + " - " + course.title);
    }

    static class Course {
        String code;
        String title;

        Course(String code, String title) {
            this.code = code;
            this.title = title;
        }
    }
}
