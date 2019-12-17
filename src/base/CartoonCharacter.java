package base;
public class CartoonCharacter implements Comparable<CartoonCharacter> {

    private String surname;
    private String firstname;

    public CartoonCharacter(String f, String s) {
        firstname = f;
        surname = s;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setFirstname(String name) {
        firstname = name;
    }

    public void setSurname(String name) {
        surname = name;
    }

    public String toString() {
        return surname + ", " + firstname;
    }


    public int compareTo(CartoonCharacter other) {
        if (surname.equals(other.surname)) {
            return firstname.compareTo(other.firstname);
        }
        return surname.compareTo(other.surname);
    }

}