import java.util.*;

class DateList extends ArrayList<Date> { }

class A {
	//ok public <T,S extends T> void foo( T t, S s ) { }
	//illegal forward ref public <S extends T, T> void foo( T t, S s ) { }
	//no public void foo( ? extends Date s ) { }
	//no public void foo( <? extends Date> s ) { }
	//no public void foo( <?> s ) { }


	//<T> T writeAll(Collection<T> coll, Collection<? super T> snk) { return null; }
	//<T, S extends T> S writeAll(Collection<T> coll, Collection<S> snk) { return null; }

	// generic method 
	<T> void take( T t ) { }

	void foo() {
		// for public <T,S extends T> T foo( S arg ) { return arg; }
		//ok Date date = foo( new MyDate() );
		//ok Date date = foo( new Date() );
		//no MyDate myDate = foo( new Date() );
		//ok MyDate myDate = foo( new MyDate() );

		//Set<?> s = new HashSet();
		//s.put("foo");
		//s.put(new Date());

		//Collection<?> [] ca = new Collection<?> [5];

		//List<? extends Date> list = new ArrayList<Date>(); // ok
		//new ArrayList<? extends Date>(); // error
		//List<Date>[] ldates = new List<Date>[5]; // error, array creation

		// List<?> list = new ArrayList<?>(); // err

		// can't use generic in instanceof
		// boolean b = null instanceof List<String>;
		
		//<String>take( "foo" ); // old syntax in spec doesn't work, no
		//explicit generic method types
			
		//List<Date> dl = new DateList();
		//List l = new ArrayList(); //ok
		//l.add("foo"); // warn

		//new ArrayHolder<List<Date>>();
		//ArrayHolder<?> ah = new ArrayHolder<?>();
		//ah.take( new ArrayList<?> [5] ); //err

		// List<?>[] la = new ArrayList<?>[10]; // ok
		// List<?>[] la = new ArrayList<? extends Date>[10]; // err

		//List<Object> lo = new ArrayList<Object>();
		//List<? extends Date> ld = new ArrayList<Date>();

		List l = new ArrayList();
		List<Date> ldfo = (List<Date>)l; // unchecked warning, ineffective
		Date d = ldfo.get(0); // unsafe at runtime


		//List<?> lany = new ArrayList<Date>();
		//lany.put( new Object() );
		//String s = (String)lany.get(0);

		//List<Date> ld = (List<Date>)lany; ok

		//Collection<Integer> ci = new ArrayList<Integer>();
		//List<Integer> li = new ArrayList<Integer>();
		//ci = li;
		
		//Collection<Object> co = new ArrayList<Object>();
		//Collection<Integer> ci = new ArrayList<Integer>();
		//co=(Collection<Object>)ci; //err
	}

	//void throwme() throws Exception<E> { } err

	static <T extends Comparable> T compare( T t1, T t2 ) { return null; }

	void bar() { 
		int i = compare( 1, 2 );
	}

}

	
class ArrayHolder<T> {
	T[] ta;
	void take( T [] ta ) { 
		this.ta = ta;
	}
}

/*
class B<?>//no {
	//public <T> T foo() { return null; }
}

*/
