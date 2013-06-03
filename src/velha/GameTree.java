package velha;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego Oliveira <diegopso2@gmail.com>
 */
public class GameTree {
	private static GameTree instance = null;
	public List<GameTree> childs;
	public Game node;

	private GameTree() {
		childs = new ArrayList<>();
	}
	
	public static GameTree getInstane(){
		if(instance == null){
			instance = new GameTree();
		}
		return instance;
	}
	
	public void add(Game state){
		this.node = state;
	}
	
	public GameTree addChild(Game state){
		GameTree a = new GameTree();
		a.add(state);
		this.childs.add(a);
		return a;
	}
}
