package com.github.eniqen.algo.hakerrank;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class JumpingOnTheCloud {
	public  static void main(String[] args) {
		final int[] clouds = new int[] {0, 0, 0, 0, 1, 0};
		final int[] c2 = new int[] {0, 0};

		int index = 0;
		int sum = 0;
        while (index++ < clouds.length - 1) {
        	if (index + 1 == clouds.length || clouds[index + 1] == 0) {
				index++;
				sum++;
			}
			else {
        		sum += clouds[index] == 0 ? 1: 0;
			}
		}

		System.out.println(sum);
	}
}
