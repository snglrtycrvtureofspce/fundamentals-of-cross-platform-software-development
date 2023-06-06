import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static final Scanner in = new Scanner(System.in); // scanner
    public static void main(String[] args) {
        out.println("""
                1 - Создать файл XML и соответствующую ему схему XSD.
                2 - Разбор XML-документа и инициализацию коллекции объектов с помощью DOM-парсера.
                3 - SAX-парсер для разбора XML-документа и инициализации коллекции объектов.
                4 - Проверка XML-документа с использованием XSD.
                5 - Преобразование XML в HTML.
                """);
        out.print("Введите задание: ");
        int p = in.nextInt();
        switch (p) {
            case 1 -> {
                try {
                    // Создание документа XML
                    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                    Document doc = docBuilder.newDocument();

                    // Создание корневого элемента Medicine
                    Element rootElement = doc.createElement("Medicine");
                    doc.appendChild(rootElement);

                    // Создание элементов и добавление их в корневой элемент
                    Element name = doc.createElement("Name");
                    name.appendChild(doc.createTextNode("MedicineName"));
                    rootElement.appendChild(name);

                    Element pharm = doc.createElement("Pharm");
                    pharm.appendChild(doc.createTextNode("PharmName"));
                    rootElement.appendChild(pharm);

                    Element group = doc.createElement("Group");
                    group.appendChild(doc.createTextNode("MedicineGroup"));
                    rootElement.appendChild(group);

                    Element analogs = doc.createElement("Analogs");
                    rootElement.appendChild(analogs);

                    Element analog1 = doc.createElement("Analog");
                    analog1.appendChild(doc.createTextNode("AnalogName1"));
                    analogs.appendChild(analog1);

                    Element analog2 = doc.createElement("Analog");
                    analog2.appendChild(doc.createTextNode("AnalogName2"));
                    analogs.appendChild(analog2);

                    Element versions = doc.createElement("Versions");
                    rootElement.appendChild(versions);

                    Element version1 = doc.createElement("Version");
                    version1.appendChild(doc.createTextNode("Tablets"));
                    versions.appendChild(version1);

                    Element version2 = doc.createElement("Version");
                    version2.appendChild(doc.createTextNode("Capsules"));
                    versions.appendChild(version2);

                    // Создание XSD-схемы
                    doc.getDocumentElement().normalize();
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File("medicine.xml"));
                    transformer.transform(source, result);

                    System.out.println("medicine.xml файл и схема XSD успешно созданы.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 2 -> {
                try {
                    // Загрузка XML-файла
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document document = builder.parse("medicine.xml");

                    // Получение списка элементов Medicine
                    NodeList medicineList = document.getElementsByTagName("Medicine");

                    // Инициализация коллекции объектов Medicine
                    List<Medicine> medicines = new ArrayList<>();

                    // Обход элементов Medicine
                    for (int i = 0; i < medicineList.getLength(); i++) {
                        Element medicineElement = (Element) medicineList.item(i);
                        Medicine medicine = new Medicine();

                        // Чтение данных из XML и установка соответствующих полей объекта Medicine
                        medicine.setName(getElementValue(medicineElement, "Name"));
                        medicine.setPharm(getElementValue(medicineElement, "Pharm"));
                        medicine.setGroup(getElementValue(medicineElement, "Group"));

                        // Обработка элементов Analogs
                        NodeList analogsList = medicineElement.getElementsByTagName("Analogs");
                        if (analogsList.getLength() > 0) {
                            Element analogsElement = (Element) analogsList.item(0);
                            NodeList analogList = analogsElement.getElementsByTagName("Analog");
                            for (int j = 0; j < analogList.getLength(); j++) {
                                Element analogElement = (Element) analogList.item(j);
                                medicine.addAnalog(analogElement.getTextContent());
                            }
                        }

                        // Обработка элементов Versions
                        NodeList versionsList = medicineElement.getElementsByTagName("Versions");
                        if (versionsList.getLength() > 0) {
                            Element versionsElement = (Element) versionsList.item(0);
                            NodeList versionList = versionsElement.getElementsByTagName("Version");
                            for (int j = 0; j < versionList.getLength(); j++) {
                                Element versionElement = (Element) versionList.item(j);
                                medicine.addVersion(versionElement.getTextContent());
                            }
                        }

                        // Добавление объекта Medicine в коллекцию
                        medicines.add(medicine);
                    }

                    // Вывод информации о каждом препарате
                    for (Medicine medicine : medicines) {
                        System.out.println("Name: " + medicine.getName());
                        System.out.println("Pharm: " + medicine.getPharm());
                        System.out.println("Group: " + medicine.getGroup());
                        System.out.println("Analogs: " + medicine.getAnalogs());
                        System.out.println("Versions: " + medicine.getVersions());
                        System.out.println();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 3 -> {
                try {
                    // Создание SAX-парсера
                    SAXParserFactory factory = SAXParserFactory.newInstance();
                    SAXParser parser = factory.newSAXParser();

                    // Создание обработчика SAX-событий
                    MedicineHandler handler = new MedicineHandler();

                    // Разбор XML-документа
                    parser.parse("medicine.xml", handler);

                    // Получение коллекции объектов Medicine из обработчика
                    List<Medicine> medicines = handler.getMedicines();

                    // Вывод информации о каждом препарате
                    for (Medicine medicine : medicines) {
                        System.out.println("Name: " + medicine.getName());
                        System.out.println("Pharm: " + medicine.getPharm());
                        System.out.println("Group: " + medicine.getGroup());
                        System.out.println("Analogs: " + medicine.getAnalogs());
                        System.out.println("Versions: " + medicine.getVersions());
                        System.out.println();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 4 -> {
                String xmlFilePath = "medicine.xml";
                String xsdFilePath = "medicine.xsd";

                if (validateXML(xmlFilePath, xsdFilePath)) {
                    System.out.println("XML документ valid.");
                } else {
                    System.out.println("XML документ не valid.");
                }
            }
            case 5 -> {
                try {
                    TransformerFactory tFact = TransformerFactory.newInstance();
                    Transformer transformer = tFact.newTransformer(new StreamSource("medicine.xsl"));
                    transformer.transform(new StreamSource("medicine.xml"), new
                            StreamResult("notepad.html"));
                } catch (TransformerException e) {
                    e.printStackTrace();
                }
            } default -> out.println("Exit...");
        }
    }

    // Вспомогательная функция для получения значения элемента по его тегу
    private static String getElementValue(Element parentElement, String tagName) {
        NodeList nodeList = parentElement.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            Element element = (Element) nodeList.item(0);
            return element.getTextContent();
        }
        return "";
    }

    public static boolean validateXML(String xmlFilePath, String xsdFilePath) {
        try {
            // Создание фабрики для схемы XSD
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Загрузка схемы XSD из файла
            Schema schema = schemaFactory.newSchema(new File(xsdFilePath));

            // Создание валидатора
            Validator validator = schema.newValidator();

            // Проверка XML-документа
            Source source = new StreamSource(new File(xmlFilePath));
            validator.validate(source);

            return true; // XML-документ прошел проверку

        } catch (SAXException e) {
            System.out.println("Validation error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        return false; // XML-документ не прошел проверку
    }
}
class MedicineHandler extends DefaultHandler {
    private List<Medicine> medicines;
    private Medicine currentMedicine;
    private StringBuilder data;

    public List<Medicine> getMedicines() {
        return medicines;
    }

    @Override
    public void startDocument() throws SAXException {
        medicines = new ArrayList<>();
        data = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Medicine")) {
            currentMedicine = new Medicine();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length).trim());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentMedicine != null) {
            switch (qName) {
                case "Name" -> currentMedicine.setName(data.toString());
                case "Pharm" -> currentMedicine.setPharm(data.toString());
                case "Group" -> currentMedicine.setGroup(data.toString());
                case "Analog" -> currentMedicine.addAnalog(data.toString());
                case "Version" -> currentMedicine.addVersion(data.toString());
                case "Medicine" -> {
                    medicines.add(currentMedicine);
                    currentMedicine = null;
                }
            }
        }

        data.setLength(0);
    }
}