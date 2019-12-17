package functionalIface;

@FunctionalInterface
interface PrintIface {
    default void defaultPrint() {
        System.out.println("Default print");
    }

    static String tenTimes(String a) {
        return a.repeat(10);
    }

    void printIt(String str);
}

public class DefaultIfaceDemo {
    
    public static void main(String[] args) {
        PrintIface testObj = (str) -> System.out.println(str);
        System.out.println("Class: " + testObj.getClass().getName());

        testObj.defaultPrint();
        System.out.println("Static method: " + PrintIface.tenTimes("*"));
        testObj.printIt("Functional Interface called...");
        
    }

}