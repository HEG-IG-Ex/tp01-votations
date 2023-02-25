package domaine;

import java.util.Comparator;

public class ParticipationRateComparator implements Comparator<Result> {

    @Override
    public int compare(Result r1, Result r2) {
        return Integer.compare(r2.calculateParticipationRate(), r1.calculateParticipationRate());
    }
}
