import java.util.Objects;

public class Result {
    private String commune;
    private int nbElecteurs;
    private int nbOui;
    private int nbNon;
    private int nbBlanc;

    public Result(String commune, int nbElecteurs, int nbOui, int nbNon, int nbBlanc) {
        this.commune = commune;
        this.nbElecteurs = nbElecteurs;
        this.nbOui = nbOui;
        this.nbNon = nbNon;
        this.nbBlanc = nbBlanc;
    }

    @Override
    public String toString() {
        return commune + " (" + nbElecteurs + " électeurs, participation: ?????%) : " + nbOui + " oui, " + nbNon + " non";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return commune.equals(result.commune);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commune);
    }
}