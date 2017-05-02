package view;

import javafx.stage.Stage;
/**
 * @author 9459758
 */
public abstract class ViewTemplate {

    protected String stageTitle;

    protected ViewTemplate(String stageTitle) {
        this.stageTitle = stageTitle;
    }

    abstract public void show(Stage stage);
}
