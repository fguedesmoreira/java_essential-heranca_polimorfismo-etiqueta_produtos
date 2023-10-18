package entities;

public class ImportedProduct extends Product {

	private Double customsFee;

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	@Override
	public String priceTag() {
		return this.getName() + " $ "
				+ String.format("%.2f", this.TotalPrice()) + " (Customs fee: $ " + this.getCustomsFee() + ")";
	}

	public Double TotalPrice() {
		return this.getPrice() + this.getCustomsFee();
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

}