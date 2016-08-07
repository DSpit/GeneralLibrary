package com.dspit.toolkits.matricies;

import com.dspit.toolkits.matricies.exceptions.UndefinedException;

public class ArrayMatrix implements Matrix{

	@Override
	public boolean isConsistent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasUniqueSolution() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumberOfCols() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getValueAt(int rowIndex, int colIndex) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setValueAt(int rowIndex, int colIndex) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void multiplyByConstant(int rowIndex, double contant) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void switchRows(int rowIndex, int swapIndex) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRowToAnother(int rowIndex, int addIndex, double constant) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Matrix transpose() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix adjoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix multiply(Matrix m) throws UndefinedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix add(Matrix m) throws UndefinedException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
