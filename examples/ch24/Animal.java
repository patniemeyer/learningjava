
import javax.xml.bind.annotation.XmlAttribute;

//@XmlRootElement
//@XmlRootElement(name = "myanimal")
//@XmlType(propOrder = {"species", "name"}) // if used must specify all
public class Animal
{
    public static enum AnimalClass { mammal, reptile, bird, fish, amphibian, invertebrate }

    @XmlAttribute
    //@XmlAttribute(name = "class")
    public AnimalClass animalClass;

	public String name, species, habitat, food, temperament;
    public Double weight;
	public FoodRecipe foodRecipe;

    public Animal() { }

    public Animal(
        AnimalClass animalClass, String name, String species, String habitat,
        String temperament, Double weight, String food )
    {
        this.animalClass = animalClass;
        this.name = name;
        this.species = species;
        this.habitat = habitat;
        this.food = food;
        this.temperament = temperament;
        this.weight = weight;
    }

    public Animal(
        AnimalClass animalClass, String name, String species, String habitat,
        String temperament, Double weight, FoodRecipe foodRecipe )
    {
        this.animalClass = animalClass;
        this.name = name;
        this.species = species;
        this.habitat = habitat;
        this.temperament = temperament;
        this.weight = weight;
        this.foodRecipe = foodRecipe;
    }

    public String toString() { return name +"("+animalClass+", "+species+")"; }

}

