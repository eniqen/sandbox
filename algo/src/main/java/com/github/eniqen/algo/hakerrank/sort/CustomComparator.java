package com.github.eniqen.algo.hakerrank.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mikhail Nemenko {@literal <m.nemenko@elama.ru>}
 */
public class CustomComparator {
	public static void main(String[] args) {
		final Player smith = Player.of("Smith", 20);
		final Player jones1 = Player.of("Jones", 15);
		final Player jones2 = Player.of("Jones", 20);

		final Player[] list = new Player[] {smith, jones1, jones2};
		Arrays.sort(list, new Checker());

		System.out.println(Arrays.toString(list));
	}
}

class Player {
	final int score;
	final String name;

	public Player(String name, int score) {
		this.score = score;
		this.name = name;
	}

	public static Player of(String name, int score) {
		return new Player(name, score);
	}

	@Override
	public String toString() {
		return "[" + name + "," + score + "]";
	}
}

class Checker implements Comparator<Player> {
	public int compare(Player p1, Player p2) {
		if(p1.score == p2.score) {
			return p1.name.compareTo(p2.name);
		} else {
			return (p1.score - p2.score) * -1;
		}
	}
}
