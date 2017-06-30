package misc;

import model.Model;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by tmonn on 27.06.2017.
 */
public class XML {

    public static void xmlExport(Model model, File file) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Model.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal( model, file );  // XML root is instance of Model
    }

    public static Model xmlImport(File file) throws JAXBException, SAXException {
        JAXBContext jc = JAXBContext.newInstance(Model.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (Model) unmarshaller.unmarshal(file);
    }
}
