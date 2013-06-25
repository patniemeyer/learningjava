
interface Foo {
	public static int FOO = 1;
}

public class M< T extends Foo >
{
	public void main( String [] args )
	{
		int i = T.FOO;
	}

}
