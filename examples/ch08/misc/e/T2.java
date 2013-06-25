class T2<K,V> { } 
class T3<K,V> extends T2<K,V> { void foo() { } }
class T4<K,V> extends T2<K,V> { void foo() { } }
class T5<K,V> extends T3<K,V> { }

class Main  {
	void foo() {
		T2<String, Number> t2 = null;
		T3 t3 = (T3<String, Number>)t2;
	}
}
