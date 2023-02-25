package domaine;

import java.util.Objects;

public class Result implements Comparable<Result>{
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

    public String getCommune() {
        return commune;
    }

    public int getNbElecteurs() {
        return nbElecteurs;
    }

    public int getNbOui() {
        return nbOui;
    }

    public int getNbNon() {
        return nbNon;
    }

    public int getNbBlanc() {
        return nbBlanc;
    }

    public int calculateParticipationRate(){
        return 100 * (this.getNbOui() + this.getNbNon() + this.getNbBlanc()) / this.getNbElecteurs();
    }

    @Override
    public int compareTo(Result o) {
        return this.getCommune().compareToIgnoreCase(o.getCommune());
    }

    @Override
    public String toString() {
        return commune + " (" + nbElecteurs + " électeurs, participation: " + this.calculateParticipationRate() + "%) : " + nbOui + " oui, " + nbNon + " non";
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