package uz.maniac4j.gluonfirst.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;

public class PrimaryView {

    public View getView() {
        try {
            return FXMLLoader.load(Objects.requireNonNull(PrimaryView.class.getResource("primary.fxml")));
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
