import hydraulic.*;



public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HSystemExt s = new HSystemExt();
		
		Source src = new Source("Src");
		s.addElement(src);
		Tap r = new Tap("R");
		s.addElement(r);
		Multisplit t = new Multisplit("MS",3);
		s.addElement(t);
		Sink sink1 = new Sink("sink A");
		s.addElement(sink1);
		Sink sink2 = new Sink("sink B");
		s.addElement(sink2);
		Sink sink3 = new Sink("sink C");
		s.addElement(sink3);
		
		t.setProportions(0, 0.35 , 1 , 0.35 , 2, 0.3);
		
	}

}
