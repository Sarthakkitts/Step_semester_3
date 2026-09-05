public class ApplicantCounter {
    public static void main(String[] args) {
        new Applicant();
        new Applicant();
        new Applicant();
        System.out.println("Total applicants: " + Applicant.totalApplicants);
    }

    static class Applicant {
        static int totalApplicants;

        Applicant() {
            totalApplicants++;
        }
    }
}
