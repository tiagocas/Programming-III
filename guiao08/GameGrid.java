package guiao08;

public class GameGrid {
	private int[][] grid;
	private int width;
	private int height;
	private int counter;
	
	
	public GameGrid(int height, int width) {
		this.height = height;
		this.width = width;
		this.grid = new int[height][width];
		refresh();
	}
	
	public boolean checkIfLastPlayerWon() {
		return checkHorizontally() || checkVertically() || checkDiagonally();
	}
	
	public boolean checkIfEnded() {
		return checkIfLastPlayerWon() || (counter >= width*height);
	}
	
	public boolean checkDiagonally() {
		return grid[1][1] != 0 && ((grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) || (grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2])) ;
	}
	
	public boolean checkVertically() {
		for(int i=0;i<this.width;i++) {
			if(this.grid[0][i] == this.grid[1][i] && this.grid[1][i] == this.grid[2][i]) {
				if(this.grid[0][i] != 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkHorizontally() {
		for(int i=0;i<this.height;i++) {
			if(this.grid[i][0] == this.grid[i][1] && this.grid[i][1] == this.grid[i][2]) {
				if(this.grid[i][0] != 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void mark(int height, int width, int value) {
		this.grid[height-1][width-1] = value;
		this.counter++;
		//show();
	}
	
	public void refresh() {
		for(int i=0;i<this.height;i++) {
			for(int j=0;j<this.width;j++) {
				this.grid[i][j] = 0;
			}
		}
		this.counter = 0;
	}
	
	public void show() {
		String resp = "";
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				resp += grid[i][j] + "  ";
			}
			resp += "\n";
		}
		System.out.println(resp);
	}
	
}
