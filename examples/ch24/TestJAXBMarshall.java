import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.Arrays;

public class TestJAXBMarshall
{
	public static void main( String [] args ) throws JAXBException
    {
		Inventory inventory = new Inventory();
        Animal animal = new Animal( Animal.AnimalClass.mammal,
            "Song Fang", "Giant Panda", "China", "Friendly", 45.0, "Bamboo" );
        inventory.animal.add( animal );
        FoodRecipe recipe = new FoodRecipe();
        recipe.name = "Gorilla Chow";
        recipe.ingredient.addAll( Arrays.asList( "fruit", "shoots", "leaves" ) );
		animal = new Animal( Animal.AnimalClass.mammal,
            "Cocoa", "Gorilla", "Ceneral Africa", "Know-it-all", 45.0, recipe );
		inventory.animal.add( animal );

        marshall( inventory );
	}

    public static void marshall( Object jaxbObject ) throws JAXBException
    {
        JAXBContext context = JAXBContext.newInstance( jaxbObject.getClass() );
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(jaxbObject, System.out);
    }
}
