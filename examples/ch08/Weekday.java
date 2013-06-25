
public enum Weekday {

    Sunday(8), Monday(0), Tuesday(1), Wednesday(2), Thursday(4), 
      Friday(6), Saturday(10) { };

	enum Sub { A, B }
	
    int fun;

    Weekday( int fun ) { this.fun = fun; }

    public int getFun() { return fun; }

}

