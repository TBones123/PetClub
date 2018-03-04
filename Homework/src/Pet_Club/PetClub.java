package Pet_Club;

public class PetClub {
    private String namePet;

    public PetClub(String namePet) {
        this.namePet = namePet;
        }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    @Override
    public String toString() {
        return "namePet='" + namePet;
    }
}
