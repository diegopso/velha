package velha;

/**
 *
 * @author Diego Oliveira <diegopso2@gmail.com>
 */
public class Game {
	public Integer[][] state;
	public Integer currentPlayer;
	public static final Integer dimension = 3;

	public Game() {
	}

	public Game(Integer[][] state, Integer currentPlayer) {
		this.state = state;
		this.currentPlayer = currentPlayer;
	}
	
	public void play(GameTree gt){
		if(gt == null){
			gt = GameTree.getInstane();
		}
		
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < 3; j++) {
				if(state[i][j] == 0){
					state[i][j] = currentPlayer;
					Integer nextPlayer = currentPlayer * -1;
					Game newState = new Game(state.clone(), nextPlayer);
					
					gt.add(this);
					GameTree ngt = gt.addChild(newState);
					
					if(!isThereAWinner()){
						newState.play(ngt);
					}
					
					state[i][j] = 0;
				}
			}
		}
	}

	private boolean isThereAWinner() {
		return Math.abs(state[0][0] + state[0][1] + state[0][2]) == 3 ||
				Math.abs(state[1][0] + state[1][1] + state[1][2]) == 3 ||
				Math.abs(state[2][0] + state[2][1] + state[2][2]) == 3 ||
				Math.abs(state[0][0] + state[1][0] + state[2][0]) == 3 ||
				Math.abs(state[0][1] + state[1][1] + state[2][1]) == 3 ||
				Math.abs(state[0][2] + state[1][2] + state[2][2]) == 3 ||
				Math.abs(state[0][0] + state[1][1] + state[2][2]) == 3 ||
				Math.abs(state[0][2] + state[1][1] + state[2][0]) == 3;
	}
	
	public String toString(){
		String str = "[ \n";
		for (Integer[] integers : state) {
			str += "[";
			for (Integer i : integers) {
				str += i + ",";
			}
			str += "] \n";
		}
		str += "]";
		return str;
	}
}
