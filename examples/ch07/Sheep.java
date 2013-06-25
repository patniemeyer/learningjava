import java.util.HashMap; 
 
public class Sheep implements Cloneable { 
    HashMap flock = new HashMap( ); 
 
    public Sheep clone( ) { 
        try { 
            return (Sheep)super.clone( ); 
        } catch (CloneNotSupportedException e ) {  
            throw new Error("This should never happen!"); 
        } 
    } 
}

class Main {
	
	public static void main( String [] args ) 
	{
		Sheep one = new Sheep();
		Sheep two = one.clone();
	}
}

