package com.github.eniqen.algo.leetcode.tree.dfs.booking;

import java.util.*;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class BookingTopKClosestHotels {
	public static void main(String[] args) {
		int[][] map = new int[][] {
				{0, 0,   0,  0, 0, 0,   0,   0, 0, 0},
				{0, 150, 1,  0, 0, 0,   0,   1, 1, 0},
				{0,   0, 1,  0, 0, 0,   0,  90, 1, 0},
				{0,   0, 1,  1, 1, 1,   1, 330, 1, 0},
				{0,   0, 1,  0, 0, 0,   1,   1, 1, 0},
				{1,   1, 1,  0, 0, 0,   0,   0, 0, 0},
				{0,   1, 1,  1, 1, 1,   1,   0, 0, 0},
				{0,   1, 1, 70, 1, 0, 120,   0, 0, 0},
				{0,  50, 1,  0, 0, 0,   0,   0, 0, 0},
				{0,  20, 1,  0, 0, 0,   0,   0, 0, 0}
		};

		int[] start = new int[] {4, 2};
		int k = 2;
		int[] price_range = new int[] {20, 80};
		List<Point> result = BookingTopKClosestHotels.getClosestPropertiesWithinBudget(map, start, k, price_range);

		System.out.println("\n RESULT \n");
		result.forEach(p -> System.out.println("X = " + p.x + " - Y " + p.y));
	}
	private static final int EMPTY = 0;
	private static final int ROAD = 1;

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Point)) return false;
			Point point = (Point) o;
			if (x != point.x) return false;
			return y == point.y;
		}

		@Override
		public int hashCode() {
			int result = x;
			result = 31 * result + y;
			return result;
		}
	}

	public static class HotelInfo {
		final Point coordinates;
		final int price;
		final int steps;

		public HotelInfo(int x, int y, int price, int steps) {
			this.coordinates = new Point(x, y);
			this.price = price;
			this.steps = steps;
		}
	}
	/*
	 * Complete the 'getClosestPropertiesWithinBudget' function below.
	 *
	 * The function is expected to return a 2D_INTEGER_ARRAY.
	 */

	private static List<Point> getClosestPropertiesWithinBudget(int[][] map, int[] start_point, int k, int[] price_range) {
		final Queue<HotelInfo> topK = new PriorityQueue<>((a, b) -> Integer.compare(b.steps, a.steps));
		Map<Point, HotelInfo> hotelById = new HashMap<>();
		getNextPoint(map, start_point[0] , start_point[1], 0, hotelById, price_range);

		for(HotelInfo h: hotelById.values()) {
			topK.offer(h);
			while(!topK.isEmpty() && topK.size() > k) topK.poll();
		}

		List<Point> result = new ArrayList<>();
		while(!topK.isEmpty()) result.add( topK.poll().coordinates);
		return result;
	}

	private static void getNextPoint(int [][] map,
									 int x,
									 int y,
									 int steps,
									 Map<BookingTopKClosestHotels.Point,
											 BookingTopKClosestHotels.HotelInfo> hotels,
									 int [] price_range
	) {
		if(x >= map.length || y >= map[0].length || x < 0 || y < 0 || map[x][y] == EMPTY) return;
		int price = map[x][y];
		if(price > ROAD &&  price >= price_range[0] && price <= price_range[1]) {
			HotelInfo h = new BookingTopKClosestHotels.HotelInfo(x, y, price, steps);
			if(!hotels.containsKey(h.coordinates)) {
				hotels.put(h.coordinates, h);
			} else {
				HotelInfo prev = hotels.get(h.coordinates);
				hotels.put(h.coordinates, prev.steps < h.steps ? prev : h);
			}
			return;
		}

		int[][] copyMap = Arrays.stream(map)
				.map(int[]::clone)
				.toArray(int[][]::new);

		copyMap[x][y] = 0;

		getNextPoint(copyMap, x, y + 1, steps + 1, hotels, price_range);
		getNextPoint(copyMap, x, y - 1, steps + 1, hotels, price_range);
		getNextPoint(copyMap, x + 1, y, steps + 1, hotels, price_range);
		getNextPoint(copyMap, x - 1, y, steps + 1, hotels, price_range);
	}
}
