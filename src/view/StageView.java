package view;

import javafx.stage.Stage;

/**
 * Created by tmonn on 29.06.2017.
 */
public abstract class StageView extends ViewTemplate implements IStageView {

    String stageTitle;
    StageView(String stageTitle) {
        this.stageTitle = stageTitle;
    }

    abstract public void show(Stage stage);

}
