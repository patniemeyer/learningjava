
class Mouse { }

class Bear { }

class Trap< T > {
    T trapped;

    public void snare( T trapped ) {
        this.trapped = trapped; 
    }

    public T release() {
        return trapped;
    }
}

class TrapMain {

	static <T> Trap<T> create() {
		return new Trap<T>();
	}

    public static void main( String [] ar ) {
        Trap<Mouse> mouseTrap = new Trap<Mouse>();
        mouseTrap.snare( new Mouse() );
        Mouse mouse = mouseTrap.release();

		// Type inference of factory method
		Trap<Mouse> mouseTrap2 = create();
		Trap<Bear> bearTrap = create();
    }
}
