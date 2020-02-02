package java_ee20200201;

//處理Kai_15中運算的部分
public class Kai_16 {
	private int x,y,op;
	public Kai_16(String x, String y,String op) {
		this.x=Integer.parseInt(x);
		this.y=Integer.parseInt(y);
		this.op=Integer.parseInt(op);
	}
	 public double operation(){
		 switch(op) {
		 case 1:return x+y;
		 case 2:return x-y;
		 case 3:return x*y;
		 case 4:return x*1.0/y;
		 default:return 0;
		 }
		 
	 }
}
