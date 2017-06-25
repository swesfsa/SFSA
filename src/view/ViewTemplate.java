package view;

import javafx.stage.Stage;
/**
 * @author 9459758
 */
public abstract class ViewTemplate {

    protected String _stageTitle;

    protected ViewTemplate(String stageTitle) {
        _stageTitle = stageTitle;
    }

    abstract public void show(Stage stage);
}
