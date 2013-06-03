/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package velha;

/**
 *
 * @author Diego Oliveira <diegopso2@gmail.com>
 */
public class Velha {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Game g = new Game(new Integer[][]{
			{1,1,0},
			{-1,-1,0},
			{1,1,-1}
		}, -1);
		
		g.play(null);
		
		GameTree gt = GameTree.getInstane();
		
		System.out.println("done!");
	}
}
