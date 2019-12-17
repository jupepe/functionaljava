package j9_10;

import java.io.IOException;

public interface DataSourceReader {

    void generateReport(String source);
    

    private String readFromDatabase(String source) {

        String data = "Reading some data from the " + source;
        return getDataAsFormatted(data);

    }

    private String readFromFile(String source) {

        String data = "Reading some data from the " + source;        
        return getDataAsFormatted(data);

    }

    private String readFromXmlFile(String source) {

        String data = "<data>Reading some data from the XML File data source <source>"
                + source + "</source></data>";
        return getDataAsFormatted(data);

    }

    private String readFromNetwork(String source) {

        String data = "Reading some data from the Internet data source ";

        return getDataAsFormatted(data);

    }

    private String getDataAsFormatted(String data) {

        String header = "**Header**\n";
        String footer = "\n**Footer**\n";
        return header + data + footer;

    }

    default String getData(String dataSource) throws Exception {

        String data = null;

        switch (dataSource) {
        case "Database":
            data = readFromDatabase(dataSource);
            break;
        case "File":
            data = readFromFile(dataSource);
            break;
        case "XmlFile":
            data = readFromXmlFile(dataSource);
            break;
        case "Network":
            data = readFromNetwork(dataSource);
            break;
        default:
            throw new IOException("No correct datasource: " + dataSource);
        }
        return data;
    }

}