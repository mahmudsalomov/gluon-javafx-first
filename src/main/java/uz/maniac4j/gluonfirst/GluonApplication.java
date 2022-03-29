package uz.maniac4j.gluonfirst;

import uz.maniac4j.gluonfirst.views.PrimaryView;
import uz.maniac4j.gluonfirst.views.SecondaryView;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

import static com.gluonhq.charm.glisten.application.AppManager.HOME_VIEW;

public class GluonApplication extends Application {

    public static final String PRIMARY_VIEW = HOME_VIEW;
    public static final String SECONDARY_VIEW = "Secondary View";

    private final AppManager appManager = AppManager.initialize(this::postInit);

    @Override
    public void init() {
        appManager.addViewFactory(PRIMARY_VIEW, () -> new PrimaryView().getView());
        appManager.addViewFactory(SECONDARY_VIEW, () -> new SecondaryView().getView());

        DrawerManager.buildDrawer(appManager);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        appManager.start(primaryStage);
    }

    private void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

        scene.getStylesheets().add(Objects.requireNonNull(GluonApplication.class.getResource("style.css")).toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(Objects.requireNonNull(GluonApplication.class.getResourceAsStream("/icon.png"))));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
