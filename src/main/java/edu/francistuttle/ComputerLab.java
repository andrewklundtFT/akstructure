package edu.francistuttle;

import java.util.ArrayList;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ComputerLab 
{
    public static void main( String[] args ) throws Exception 
    {
        ComputerLab a = new ComputerLab();
        a.parse("C:/Users/ak1036178/Desktop/Hitgub/akparsing/src/main/java/edu/francistuttle/lab.xml");
        printComputerList(a.lab);
    }

    private ArrayList<Computer> lab;

    public  ArrayList<Computer> parse (String fileNameWithPath) throws ParserConfigurationException, SAXException, IOException  {
        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
    
        //Build Document
        Document doc = builder.parse(new File(fileNameWithPath));
        
        lab = createComputerList(doc);
        return lab;
    }

    public static ArrayList<Computer> createComputerList(Document doc) {
        ArrayList<Computer> computerList = new ArrayList<Computer>();
        NodeList computerNodeList = doc.getElementsByTagName("computer");
        for (int i = 0; i < computerNodeList.getLength(); i++) {
            Element computer = (Element) computerNodeList.item(i);
            String computerId = computer.getAttribute("id");
            String computerManufacturer = computer.getElementsByTagName("manufacturer").item(0).getTextContent();
            String computerProcessor = computer.getElementsByTagName("processor").item(0).getTextContent();
            computerList.add(new Computer(computerId, computerManufacturer, computerProcessor, createMonitorList(computer)));
        }
        return computerList;
    }

    public static ArrayList<Monitor> createMonitorList(Element computer) {
        ArrayList<Monitor> monitorList = new ArrayList<Monitor>();
        NodeList monitorNodeList = computer.getElementsByTagName("monitor");
        for (int i = 0; i < monitorNodeList.getLength(); i++) {
            Element monitor = (Element) monitorNodeList.item(i);
            String monitorId = monitor.getAttribute("id");
            String monitorManufacturer = monitor.getElementsByTagName("manufacturer").item(0).getTextContent();
            String monitorResolution = monitor.getElementsByTagName("resolution").item(0).getTextContent();
            monitorList.add(new Monitor(monitorId, monitorManufacturer, monitorResolution));
        }
        return monitorList;
    }

    public static void printComputerList(ArrayList<Computer> computerList) {
        for (Computer computer : computerList) {
            System.out.println("computer id: " + computer.id);
            System.out.println("\tcomputer processor: " + computer.processor);
        }
    } 
}
