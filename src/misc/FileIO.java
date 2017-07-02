package misc;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by tmonn on 28.06.2017.
 */
public class FileIO
{
    private static FileChooser.ExtensionFilter sfsaExtensionFilter =
            new FileChooser.ExtensionFilter("SFSA", "*.sfsa");
    private static FileChooser.ExtensionFilter xmlExtensionFilter =
            new FileChooser.ExtensionFilter("XML", "*.xml");

    private FileIO() {}

    public static File openFileChooser(EFileExtension eFileExtension) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("SFSA-Datei öffnen");
        if(eFileExtension == eFileExtension.XML)
            fileChooser.getExtensionFilters().add(xmlExtensionFilter);
        else if(eFileExtension == eFileExtension.SFSA)
            fileChooser.getExtensionFilters().add(sfsaExtensionFilter);
        return fileChooser.showOpenDialog(new Stage());
    }

    public static File saveAsFileChooser(EFileExtension eFileExtension) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("SFSA-Datei speichern");
        if(eFileExtension == eFileExtension.XML)
            fileChooser.getExtensionFilters().add(xmlExtensionFilter);
        else if(eFileExtension == eFileExtension.SFSA)
            fileChooser.getExtensionFilters().add(sfsaExtensionFilter);
        return fileChooser.showSaveDialog(new Stage());
    }
}
