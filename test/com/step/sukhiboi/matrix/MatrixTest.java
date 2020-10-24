package com.step.sukhiboi.matrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class MatrixTest {
  private Matrix matrix1;
  private Matrix matrix2;

  @Before
  public void initializeTestFields() {
    matrix1 = Matrix.createMatrix(2, 2, new int[][] { { 1, 1 }, { 1, 1 } });
    matrix2 = Matrix.createMatrix(2, 2, new int[][] { { 2, 2 }, { 2, 2 } });
  }

  //toString

  @Test
  public void shouldReturnStringRepresentationOfMatrix() {
    assertEquals(matrix1.toString(), "\nSize: 2 Rows, 2 Columns\n1 1 \n1 1 \n");
  }

  //equals

  @Test
  public void shouldReturnTrueIfSameMatrixCompared() {
    assertEquals(matrix1, matrix1);
  }

  @Test
  public void shouldReturnFalseIfDifferentObjectCompared() {
    assertFalse(matrix1.equals(new Object()));
  }

  @Test
  public void shouldReturnFalseIfDifferentSizedMatrixCompared() {
    int[][] values1 = { { 1 }, { 1 } };
    matrix1 = Matrix.createMatrix(2, 1, values1);

    int[][] values2 = { { 2, 2 }, { 2, 2 }, { 2, 2 } };
    matrix2 = Matrix.createMatrix(3, 2, values2);

    assertFalse(matrix1.equals(matrix2));
  }

  @Test
  public void shouldReturnFalseIfDifferentMatrixCompared() {
    assertFalse(matrix1.equals(matrix2));
  }

  @Test
  public void shouldReturnFalseIfNullCompared() {
    assertFalse(matrix1.equals(null));
  }

  //add

  @Test
  public void shouldAddTwoMatrixes() {
    int[][] expectedValues = { { 3, 3 }, { 3, 3 } };
    Matrix expected = Matrix.createMatrix(2, 2, expectedValues);

    assertEquals(matrix1.add(matrix2), expected);
  }

  @Test
  public void shouldReturnNullIfDifferentSizeMatrixesAdded() {
    int[][] values1 = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
    matrix1 = Matrix.createMatrix(3, 2, values1);

    assertEquals(matrix1.add(matrix2), null);
  }

  //subtract

  @Test
  public void shouldSubtractTwoMatrixes() {
    int[][] expectedValues = { { -1, -1 }, { -1, -1 } };
    Matrix expected = Matrix.createMatrix(2, 2, expectedValues);

    assertEquals(matrix1.subtract(matrix2), expected);
  }

  @Test
  public void shouldReturnNullIfDifferentSizeMatrixesSubtracted() {
    int[][] values1 = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
    Matrix matrix1 = Matrix.createMatrix(3, 2, values1);

    assertEquals(matrix1.subtract(matrix2), null);
  }

  // multiply

  @Test
  public void shouldMultiplyTwoMatrixes() {
    int[][] expectedValues = { { 4, 4 }, { 4, 4 } };
    Matrix expected = Matrix.createMatrix(2, 2, expectedValues);

    assertEquals(matrix1.multiply(matrix2), expected);
  }

  @Test
  public void shouldMultiplyTwoMatrixesOfDifferentSizes() {
    int[][] values1 = { { 10, 10 }, { 10, 10 }, { 10, 10 } };
    matrix1 = Matrix.createMatrix(3, 2, values1);

    int[][] values2 = { { 2, 2, 2 }, { 2, 2, 2 } };
    matrix2 = Matrix.createMatrix(2, 3, values2);

    int[][] expectedValues = { { 40, 40, 40 }, { 40, 40, 40 }, { 40, 40, 40 } };
    Matrix expected = Matrix.createMatrix(3, 3, expectedValues);

    assertEquals(matrix1.multiply(matrix2), expected);
  }

  @Test
  public void shouldReturnNullIfMatrixesWithDifferentRowAndColumnSizeMultiplied() {
    int[][] values1 = { { 10, 10, 10 }, { 10, 10, 10 } };
    Matrix matrix1 = Matrix.createMatrix(2, 3, values1);

    assertEquals(matrix1.multiply(matrix2), null);
  }

  //determinant

  @Test
  public void shouldReturnDeterminantOfMatrix() {
    assertEquals(matrix1.determinant(), 0);
  }

  @Test
  public void shouldReturnDeterminantOfA3By3Matrix() {
    int[][] values1 = { { 1, 2, 1 }, { 1, 3, 4 }, { 1, 5, 3 } };
    Matrix matrix1 = Matrix.createMatrix(3, 3, values1);

    assertEquals(matrix1.determinant(), -7);
  }

  @Test
  public void shouldReturnZeroIfANonSquareMatrixGiven() {
    int[][] values1 = { { 1, 2, 1 }, { 1, 3, 4 } };
    Matrix matrix1 = Matrix.createMatrix(2, 3, values1);

    assertEquals(matrix1.determinant(), 0);
  }
}
