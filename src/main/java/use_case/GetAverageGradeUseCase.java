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
        Team myTeam = gradeDB.getMyTeam();
        int totalGrade = 0;
        int count = 0;
        for(String member: myTeam.getMembers()){
            System.out.println(String.format("%d member: %s", count, member));
            totalGrade += gradeDB.getGrade(member, course).getGrade();
            count += 1;
        }
        return (float) totalGrade / count;
    }
}
