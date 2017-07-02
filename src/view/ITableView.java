package view;

import javafx.scene.control.TableView;

/**
 * Created by tmonn on 01.07.2017.
 */
public interface ITableView extends ITabView {
    TableView getTableView();
    void clearDetailView();
}
