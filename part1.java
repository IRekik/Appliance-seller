// -----------------------------------------------------
// Assignment 1
// Part I
// Written by: Ismael Rekik (40132567)
// -----------------------------------------------------

/** Name : Ismael Rekik, ID : 40132567
COMP249
Assignment # 1
Due Date : January 31, 2020
/*

/**
 * The class Appliance allows to create appliance objects with a default constructor, a parametrized constructor and a copy constructor.
 * Contains 4 private attributes, String type, String brand, long serialNumber and double price
 * Contains 4 accessor methods , one for each attribute, and 3 mutator methods, one for each attribute except for the serialNumber
 * @author i_rekik
 * @version Part 1
 * Contains a toString() method that returns the values of all the attributes of a specific object
 * Contains a findNumberOfCreatedAppliances() that returns the number of appliance objects created
 */ 
class Appliance {
	private String type;
	private String brand;
	private long serialNumber;
	private double price;
	static private int numberOfCreatedAppliances;
	/**
	 * Default contructor
	 */
	public Appliance () {
		type="";
		brand="";
		price=0;
		serialNumber=0;
		numberOfCreatedAppliances++;
	}
	/**
	 * Constructor that takes four parameters: type, brand, serialNumber and price
	 * @param type Takes the passed value and stores it in type
	 * @param brand Takes the passed value and stores it in brand
	 * @param serialNumber Takes the passed value and stores it in serialNumber
	 * @param price Takes the passed value and stores it in price
	 */
	public Appliance(String type,String brand,long serialNumber, double price) {
		this.type=type;
		this.brand=brand;
		this.serialNumber=serialNumber;
		this.price=price;
		numberOfCreatedAppliances++;
	}
	/**
	 * 
	 * @param appliance takes all the values from an entered object and assign them to the values of another object
	 */
	public Appliance(Appliance appliance) {
		this.type=appliance.type;
		this.brand=appliance.brand;
		this.serialNumber=appliance.serialNumber;
		this.price=appliance.price;
	}
	/**
	 * @param type Sets the value of type
	 */
	public void setType(String type) {
		this.type=type;
	}
	/**
	 * 
	 * @param brand Sets the value of brand
	 */
	public void setBrand(String brand) {
		this.brand=brand;
	}
	/**
	 * 
	 * @param price Sets the value of price
	 */
	public void setPrice(double price) {
		this.price=price;
	}
	/**
	 * 
	 * @return the value of type
	 */
	public String getType() {
		return type;
	}
	/**
	 * 
	 * @return the value of brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * 
	 * @return the value of serialNumber
	 */
	public long getSerialNumber() {
		return serialNumber;
	}
	/**
	 * 
	 * @return the value of price
	 */
	public double getPrice () {
		return price;
	}
	/**
	 * toString() method that returns a string with the an object's attributes
	 */
	public String toString() {
		return ("Type : "+type+", brand : "+brand+", serial number : "+ serialNumber+ ", price : "+price+".");
	}
	/**
	 * findNumberOfCreatedAppliances() method that keeps track of the number of appliance objects created
	 */
	public int findNumberOfCreatedAppliances() {
		return numberOfCreatedAppliances;
	}
}
/**
 * End of the class Appliance
 */
