package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of products: ");
		int numberOfProducts = sc.nextInt();

		List<Product> productsList = new ArrayList<>();

		for (int i = 1; i <= numberOfProducts; i++) {
			System.out.printf("Product #%d data:%n", i);

			System.out.print("Common, used or imported (c/u/i)? ");
			char productType = sc.next().charAt(0);

			while (Character.toUpperCase(productType) != 'C' && Character.toUpperCase(productType) != 'U'
					&& Character.toUpperCase(productType) != 'I') {
				System.out.print("Allowed values (c/u/i): ");
				productType = sc.next().charAt(0);
			}

			sc.nextLine();

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (Character.toUpperCase(productType) == 'C') {
				productsList.add(new Product(name, price));
			} else if (Character.toUpperCase(productType) == 'I') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();

				productsList.add(new ImportedProduct(name, price, customsFee));
			} else {
				sc.nextLine();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String manufactureDate = sc.nextLine();

				productsList.add(new UsedProduct(name, price, sdf.parse(manufactureDate)));
			}

		}

		sc.close();

		System.out.println();
		System.out.println("PRICE TAGS:");

		for (Product product : productsList) {
			System.out.println(product.priceTag());
		}

	}

}