package refactoring.catalog.others.refactoringgolf.store.after;

public class BikesDiscount implements CategoryDiscount{

	public float calculateDiscount(OrderItem orderItem) {
		return orderItem.unitPricePerQuantity() * 20 / 100;
	}

}
