import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBExperiments
{
	public static void main( String [] args ) throws JAXBException
    {
		Inventory inventory = new Inventory();

		Animal animal = new Gorilla();
        animal.animalClass= Animal.AnimalClass.mammal;
		animal.name = "Song Fang";
		animal.species = "Giant Panda";
		animal.habitat = "China";
		animal.food = "Bamboo";
		animal.temperament = "Friendly";
		animal.weight = 45.0;
        FoodRecipe recipe = new FoodRecipe();
        recipe.name = "Gorilla Chow";
        recipe.ingredient.add( "leaves" );
        recipe.ingredient.add( "insects" );
        recipe.ingredient.add( "fruit" );
        animal.foodRecipe = recipe;

		inventory.animal.add( animal );

        JAXBContext context = JAXBContext.newInstance( Inventory.class );
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(inventory, System.out);
	}

}
