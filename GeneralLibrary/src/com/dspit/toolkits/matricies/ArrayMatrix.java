package com.dspit.data;

public class ArrayMatrix implements Matrix{
	
	private double[][] mMatrix;
	
	public ArrayMatrix(double[][] m){
		mMatrix = m;
	}
	
	public ArrayMatrix(Matrix m){
		mMatrix = new double[m.getNumberOfRows()][m.getNumberOfCols()];
		for(int i = 0; i < m.getNumberOfRows(); ++i){
			for(int j = 0; j < m.getNumberOfCols(); ++j){
				mMatrix[i][j] = m.getValueAt(i, j);
			}
		}
	}
	
	@Override
	public int getNumberOfRows(){
		return mMatrix.length;
	}
	
	@Override
	public int getNumberOfCols(){
		if(this.getNumberOfCols() == 0){
			return 0;
		}
		
		return mMatrix[0].length;
	}
	
	@Override
	public double getValueAt(int rowIndex, int colIndex) throws IndexOutOfBoundsException{
		try{
			return mMatrix[rowIndex][colIndex];
		}catch(IndexOutOfBoundsException e){
			throw new IndexOutOfBoundsException(String.format("The index at ( %d, %d ) is out of bounds", rowIndex, colIndex));
		}
	}
	
	@Override
	public void addRow(double[] row){
		//TODO
	}
	
	@Override
	public void addRow(double[] row, int rowIndex){
		//TODO
	}
	
	@Override
	public boolean removeRow(double[] row){
		return false;//TODO
	}
	
	@Override
	public boolean removeRow(int rowIndex){
		return false;//TODO
	}

	@Override
	public boolean removeLastRow() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSquare() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void toTranspose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Matrix transpose() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix multiply(Matrix m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix add(Matrix m) {
		// TODO Auto-generated method stub
		return null;
	}
}
