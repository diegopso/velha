////////////////////////////////////////////////////////////////////////////////
////////////DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.////////////
////////////////////////////////////////////////////////////////////////////////
package velha;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Diego Oliveira <diegopso2@gmail.com>
 */
public class GamePath {

	public ArrayList<GameTree> path;

	public GamePath() {
		path = new ArrayList<GameTree>();
	}
	
	public void add(GameTree gt){
		path.add(gt);
	}

	@Override
	public String toString() {
		String str = "";

		for (GameTree gt : path) {
			for (int i = 0; i < Game.dimension; i++) {
				for (int j = 0; j < Game.dimension; j++) {
					str += gt.node.state[i][j].toString() + "|";
				}
				str += "\n";
			}
			str += "\n";
		}

		return str;
	}
}
