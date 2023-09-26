package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // TODO: Get average grade for all students in your team.
        String[] teamMembers = this.gradeDB.getMyTeam().getMembers();
        int sum = 0, count = 0;
        for (String member : teamMembers) {
            Grade grade = this.gradeDB.getGrade(member, course);
            sum += grade.getGrade();
            count++;
        }

        return count == 0 ? 0 : (float) sum / count;
    }
}
