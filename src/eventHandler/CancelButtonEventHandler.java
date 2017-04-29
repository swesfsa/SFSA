package eventHandler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by 1030129 on 29.04.17.
 */
public class CancelButtonEventHandler implements EventHandler<ActionEvent> {

    /**
     * @author 1030129
     * @param event
     */
    @Override
    public void handle(ActionEvent event) {
        System.out.println("cancelButton pressed");
    }
}
