package importPacked;

import packA.classExample; // import from another package


public class impPack {
	
	
	public static void main(String[] args) {
		
		
		classExample.myMethod(); // import method
		
		classExample.myParaMethod("4");
		
		int y = classExample.myReturnMethod(6);
		System.out.println(y);
		
		
		
	}

}
