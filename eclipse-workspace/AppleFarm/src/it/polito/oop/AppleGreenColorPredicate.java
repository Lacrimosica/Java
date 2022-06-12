package it.polito.oop;

public class AppleGreenColorPredicate implements ApplePredicate{
	public boolean test(Apple apple) {
		return Color.GREEN.equals(apple.getColor());
	}
}
