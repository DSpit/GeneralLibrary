package com.dspit.toolkits.matricies;

import com.dspit.toolkits.matricies.exceptions.UndefinedException;

public interface Matrix {
	
	public boolean isConsistent();
	
	public boolean hasUniqueSolution();
	
	/**
	 * Method which returns the number of columns in the row, or
	 * the matrix's row length.
	 * 
	 * @return The number of columns in this matrix.
	 */
	public int getNumberOfCols();
	
	/**
	 * Method which returns the number of rows, or the matrix's
	 * column length.
	 * 
	 * @return The number of rows in this matrix.
	 */
	public int getNumberOfRows();
	
	/**
	 * Method which returns the value stored at the entry given.
	 * If the desired indices are out of bounds, then this method
	 * throws an {@link IndexOutOfBoundsException}.
	 * 
	 * @param rowIndex The index of the row of the desired entry.
	 * @param colIndex The index of the column of the desired entry.
	 * 
	 * @return The entry located at the given entries.
	 * 
	 */
	public double getValueAt(int rowIndex, int colIndex) 
										throws IndexOutOfBoundsException;
	
	public void setValueAt(int rowIndex, int colIndex)
										throws IndexOutOfBoundsException;
	
	
	public void multiplyByConstant(int rowIndex, double contant)
										throws IndexOutOfBoundsException;
	
	public void switchRows(int rowIndex, int swapIndex)
										throws IndexOutOfBoundsException;
	
	public void addRowToAnother(int rowIndex, int addIndex, double constant)
										throws IndexOutOfBoundsException;
	
	/**
	 * Method which generates a new matrix which is transpose (flipped) 
	 * to the to this current matrix
	 */
	public Matrix transpose();
	
	public Matrix adjoint();
	
	/**
	 * Method which first determines if the matrix multiplication of 
	 * this matrix and the given matrix (in that order) is defined and then 
	 * if it is, perform a matrix multiplication.
	 * 
	 * <br><br>This method should act as such:
	 * <br> A = this matrix
	 * <br> M = the given matrix parameter.
	 * <br> {@link #add(Matrix)} = A X M
	 * <br><br><b>NOTE:</b> A X M != M X A
	 * 
	 * 
	 * @param m The matrix to multiply this one by.
	 * 
	 * @return The result of the matrix multiplication or <b>null</b> if the 
	 * 				matrix multiplication is undefined.
	 */
	public Matrix multiply(Matrix m) throws UndefinedException;
	
	/**
	 * Method which first determines if the matrix addition of this matrix 
	 * and the given matrix can be performed, and if it is, the perform it.
	 * 
	 * @param m The matrix to add to the this one.
	 * 
	 * @return The result of the matrix addition or <b>null</b> if the 
	 * 				matrix addition is undefined.
	 */
	public Matrix add(Matrix m) throws UndefinedException;
}
