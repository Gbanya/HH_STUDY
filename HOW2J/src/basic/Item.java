package basic;

public class Item {
	
	String name;
	int price;

	public void buy(){
		System.out.println("����");
	}

	public String toString(){
		return name + price;
	}

	/*public void finalize(){
		System.out.println("��ǰ�������ڱ����գ�");
	}*/

	public boolean equals(Object o){
		if( o instanceof Item){
			Item h = (Item) o;
			return h.price == this.price;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item bottle = new Item();
		bottle.name = "Ѫƿ";
		bottle.price = 50;
		
		Item shoe = new Item();
		shoe.name = "��Ь";
		shoe.price = 350;
		
		Item sword = new Item();
		sword.name = "����";
		sword.price = 350;

		System.out.println(sword.toString());
		System.out.println("--------");
		System.out.println(sword);

		System.out.println(shoe.equals(sword));
	}




}
