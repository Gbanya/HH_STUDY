public final class ExceHand{
	public static void main(String[] argc) {
		/*
		 int a[] = new int[2];
		try {
			System.out.println("Acess element three :"+ a[3]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception thrown :"+ e);
		}
	    finally{
	        a[0] = 6;
	        System.out.println("First element value: " +a[0]);
	        System.out.println("The finally statement is executed");
	     }
	     */
		CheckingAccount c = new CheckingAccount(101);
	      System.out.println("Depositing $500...");
	      c.deposit(500.00);
	      try{
	         System.out.println("\nWithdrawing $100...");
	         c.withdraw(100.00);
	         System.out.println("\nWithdrawing $600...");
	         c.withdraw(600.00);
	      }catch(InsufficientFundsException e){
	         System.out.println("Sorry, but you are short $" + e.getAmount());
	         e.printStackTrace();
	      }
	}
}

//�Զ����쳣�࣬�̳�Exception��
private class InsufficientFundsException extends Exception{
	private double amount;
	public InsufficientFundsException(double amount){
	  this.amount = amount;
	} 
	public double getAmount(){
	  return amount;
	}
}
//����ģ�������˻�
private class CheckingAccount
{
	//balanceΪ��numberΪ����
	 private double balance;
	 private int number;
	 public CheckingAccount(int number){
	    this.number = number;
	 }
	//��������Ǯ
	 public void deposit(double amount){
	    balance += amount;
	 }
	//������ȡǮ
	 public void withdraw(double amount) throws
	                            InsufficientFundsException {
	    if(amount <= balance){
	       balance -= amount;
	    }
	    else{
	       double needs = amount - balance;
	       throw new InsufficientFundsException(needs);
	    }
	 }
	//�������������
	 public double getBalance(){
	    return balance;
	 }
	//���������ؿ���
	 public int getNumber(){
	    return number;
	 }
}