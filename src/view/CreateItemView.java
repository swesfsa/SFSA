package view;

import javafx.stage.Stage;

/**
 * Created by tmonn on 29.06.2017.
 */
public abstract class CreateItemView extends ViewTemplate {
    protected String stageTitle;
    protected CreateItemView(String stageTitle) {
        this.stageTitle = stageTitle;
    }

    abstract public void show(Stage stage);

}
