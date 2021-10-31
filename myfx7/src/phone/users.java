package phone;

public class users {
	int seatno, price,id;
	String name, date;
	public users(int id, String name,int seatno, int price, String date) {
		super();
		this.seatno = seatno;
		this.price = price;
		this.name = name;
		this.date = date;
		this.id = id;
	}
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	public int getPrice() {
		return price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
			
}
