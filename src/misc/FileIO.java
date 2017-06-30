package misc;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.IModel;
import model.Model;

import javax.xml.bind.JAXBException;
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

    public static File openFileChooser(FileExtension fileExtension) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("SFSA-Datei öffnen");
        if(fileExtension == FileExtension.XML)
            fileChooser.getExtensionFilters().add(xmlExtensionFilter);
        else if(fileExtension == FileExtension.SFSA)
            fileChooser.getExtensionFilters().add(sfsaExtensionFilter);
        return fileChooser.showOpenDialog(new Stage());
    }

    public static File saveAsFileChooser(FileExtension fileExtension) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("SFSA-Datei speichern");
        if(fileExtension == FileExtension.XML)
            fileChooser.getExtensionFilters().add(xmlExtensionFilter);
        else if(fileExtension == FileExtension.SFSA)
            fileChooser.getExtensionFilters().add(sfsaExtensionFilter);
        return fileChooser.showSaveDialog(new Stage());
    }
}
