package DBConnection;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private final StringProperty Email = new SimpleStringProperty(this, "Email");
    public StringProperty EmailProperty() {
        return Email ;
    }
    public final String getEmail() {
        return EmailProperty().get();
    }
    public final void setEmail (String Email) {
        EmailProperty().set(Email);
    }
    private final StringProperty Motdepasse = new SimpleStringProperty(this, "Motdepasse");
    public StringProperty MotdepasseProperty() {
        return Motdepasse ;
    }
    public final String getLastName() {
        return MotdepasseProperty().get();
    }
    public final void setLastName(String Motdepasse) {
    	MotdepasseProperty().set(Motdepasse);
    }

    public Person() {}

    public Person(String Email, String Motdepasse) {
        setEmail(Email);
        setLastName(Motdepasse);
    }



}
