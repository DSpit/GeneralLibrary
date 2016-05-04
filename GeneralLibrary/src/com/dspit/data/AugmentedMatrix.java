package com.dspit.data;

public class AugmentedMatrix {
	
	private double[][] mMatrix;
	
	public AugmentedMatrix(double[][] m){
		mMatrix = m;
	}
	
	public AugmentedMatrix(AugmentedMatrix m){
		mMatrix = new double[m.getRowLength()][m.getColLength()];
		for(int i = 0; i < m.getRowLength(); ++i){
			for(int j = 0; j < m.getColLength(); ++j){
				mMatrix[i][j] = m.getValueAt(i, j);
			}
		}
	}
	
	
	public int getRowLength(){
		return mMatrix.length;
	}
	
	public int getColLength(){
		if(this.getRowLength() == 0){
			return 0;
		}
		
		return mMatrix[0].length;
	}
	
	public double getValueAt(int rowIndex, int colIndex) throws IndexOutOfBoundsException{
		try{
			return mMatrix[rowIndex][colIndex];
		}catch(IndexOutOfBoundsException e){
			throw new IndexOutOfBoundsException(String.format("The index at ( %d, %d ) is out of bounds", rowIndex, colIndex));
		}
	}
	
	public void addRow(double[] row){
		//TODO
	}
	
	public void addRow(double[] row, int rowIndex){
		//TODO
	}
	
	public boolean removeRow(double[] row){
		return false;//TODO
	}
	
	public boolean removeRow(int rowIndex){
		return false;//TODO
	}
}
