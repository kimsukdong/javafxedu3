package phone;

import java.sql.Blob;

public class Products {
	private int id;
	private String description;
	private String price;
	private String status;
	private String category;
	private Blob image;
	public Products(int id, String description, String price, String status, String category, Blob image) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.status = status;
		this.category = category;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	
	
}
