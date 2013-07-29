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
	
	public GamePath findWinner(Integer champion){
		states.add(this);
		return findWinner(new GamePath(), champion);
	}
	
	private ArrayList<GameTree> states = new ArrayList<GameTree>();
	
	public GamePath findWinner(GamePath path, Integer champion){
		while(!states.isEmpty()){
			GameTree gt = states.get(states.size() - 1);
			
			if(gt.node.isThereAWinner(champion)){
				path.add(gt);
				return path;
			}
			
			if(gt.childs.size() == 0){
				if(path.path.contains(gt))
					path.path.remove(gt);
				states.remove(gt);
			}
			else{
				path.add(gt);
				for (GameTree gameTree : gt.childs) {
					states.add(gameTree);
				}
				gt.childs = new ArrayList<GameTree>();
			}
		}
		
		return null;
	}
}
