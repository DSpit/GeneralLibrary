package com.dspit.data;

public interface Matrix {
	
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
	
	/**
	 * Method which adds the given row to end of the matrix. The given
	 * row must have the same number of columns as the matrix that it 
	 * is being added to. This method should be a direct implementation of 
	 * {@link #addRow(double[], int)}.
	 * 
	 * @param row The row to be added to the matrix.
	 * 
	 * @return <b>true</b> if the row is the same size as the matrix 
	 * 				and has successfully been added and <b>false</b> if 
	 * 				the given row cannot be added to the matrix.
	 */
	public boolean addRow(double[] row);
	
	/**
	 * Method which adds the given row at the index given. The row
	 * must have the same number of columns as the matrix that it 
	 * is being added to.
	 * 
	 * @param row The row to be added.
	 * @param rowIndex The index to add the row at.
	 * 
	 * @return <b>true</b> if the row is the same size as the matrix and 
	 * 				was successfully added at the right index and <b>false</b> if 
	 * 				the given row cannot be added to the matrix.
	 */
	public boolean addRow(double[] row, int rowIndex);
	
	/**
	 * Method which removes the given row from the matrix. This method must
	 * search and identify which row corresponds to the given row and remove 
	 * it from the matrix, or return false if it could not match the row.
	 * 
	 * @param row Row to match and remove in the matrix
	 * 
	 * @return <b>true</b> if the row has been successfully matched and removed and 
	 * 			<b>false</b> if the row could not be matched or could not be removed.
	 */
	public boolean removeRow(double[] row);
	
	/**
	 * Method which removes a row at a given index. 
	 * 
	 * @param rowIndex The index of the row to be removed from the matrix.
	 * 
	 * @return <b>true</b> if the row has been successfully removed and 
	 * <b>false</b> false otherwise.
	 */
	public boolean removeRow(int rowIndex);
	
	/**
	 * Method which removes the last row of the matrix. This method should be
	 * a direct implementation of {@link #removeRow(int)}.
	 * 
	 * @return <b>true</b> if the row has been successfully removed and
	 * 				<b>false</b> otherwise.
	 */
	public boolean removeLastRow();
	
	/**
	 * Method which determines if the matrix can be considered a square matrix, that is
	 * it has the same number of columns as it does rows.
	 * 
	 * @return <b>true</b> if the matrix is a square matrix and <b>false</b> otherwise.
	 */
	public boolean isSquare();
	
	/**
	 * Method which transposes the matrix. 
	 * <br><br><b>This method alters the current object</b>
	 * 
	 * @see #transpose()
	 */
	public void toTranspose();
	
	/**
	 * Method which creates a new {@link Matrix} implementing object
	 * which is the transpose of this current object.
	 * <br><br><b>This method DOES NOT alter the current object</b>
	 *
	 * @return A new matrix which is exactly the transpose of the current object.
	 * 
	 * @see #toTranspose()
	 */
	public Matrix transpose();
	
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
	public Matrix multiply(Matrix m);
	
	/**
	 * Method which first determines if the matrix addition of this matrix 
	 * and the given matrix can be performed, and if it is, the perform it.
	 * 
	 * @param m The matrix to add to the this one.
	 * 
	 * @return The result of the matrix addition or <b>null</b> if the 
	 * 				matrix addition is undefined.
	 */
	public Matrix add(Matrix m);
}
