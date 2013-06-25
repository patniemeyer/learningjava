import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    public String name;
    public Address address;
    public int age;

    public static void main( String[] args ) throws JAXBException
    {
        Person person = new Person();
        person.name="Pat Niemeyer";
        person.address = new Address();
		person.address.city = "St. Louis";
        person.address.street = "Java St.";
        person.address.number = 1234;
        person.address.zip = 54321;
        person.age = 42;

        TestJAXBMarshall.marshall( person );
    }
}
