package j9_10;

class DataSourceReaderImpl implements DataSourceReader {

    @Override
    public void generateReport(String source) {
        try {
            System.out.println(getData(source));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

public class DataSourceReaderTest {
    public static void main(String args[]) throws Exception {
        DataSourceReaderImpl reader = new DataSourceReaderImpl();
        System.out.println(reader.getData("Database"));
        System.out.println(reader.getData("File"));
        System.out.println(reader.getData("XmlFile"));
        System.out.println(reader.getData("Network"));
        reader.generateReport("XmlFile");
        reader.generateReport("WorkWork");
    }

}
