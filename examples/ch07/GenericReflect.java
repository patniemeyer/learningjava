import java.util.*;
import java.lang.reflect.*;

public class GenericReflect
{

	public static void main( String	[] args	)
	{
		// public interface List<E> extends Collection<E> { }

		TypeVariable []	tv = List.class.getTypeParameters();
		System.out.println( tv[0].getName() ); // E

		class StringList extends ArrayList<String> { }

		Type type = StringList.class.getGenericSuperclass();
		System.out.println( type );  //java.util.ArrayList<java.lang.String>
		ParameterizedType pt = (ParameterizedType)type;
		System.out.println( pt.getActualTypeArguments()[0] );
			//class	java.lang.String
	}

}
