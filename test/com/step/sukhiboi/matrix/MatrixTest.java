package com.step.sukhiboi.matrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void shouldReturnTrueIfSameMatrixCompared() {
    int[][] values1 = { { 1, 1 }, { 1, 1 } };
    Matrix matrix1 = Matrix.createMatrix(2, 2, values1);

    String desc = "should return true if same matrix is compared with itself";
    assertTrue(desc, matrix1.equals(matrix1));
  }

  @Test
  public void shouldReturnFalseIfDifferentObjectCompared() {
    int[][] values1 = { { 1, 1 }, { 1, 1 } };
    Matrix matrix1 = Matrix.createMatrix(2, 2, values1);

    String desc = "should return false if any other type of object is compared";
    assertFalse(desc, matrix1.equals(new Object()));
  }

  @Test
  public void shouldReturnFalseIfDifferentSizedMatrixCompared() {
    int[][] values1 = { { 1 }, { 1 } };
    Matrix matrix1 = Matrix.createMatrix(2, 1, values1);

    int[][] values2 = { { 2, 2 }, { 2, 2 }, { 2, 2 } };
    Matrix matrix2 = Matrix.createMatrix(3, 2, values2);

    String desc = "should return false if 2 different sized matrix compared";
    assertFalse(desc, matrix1.equals(matrix2));
  }

  @Test
  public void shouldReturnFalseIfNullCompared() {
    int[][] values1 = { { 1, 1 }, { 1, 1 } };
    Matrix matrix1 = Matrix.createMatrix(2, 2, values1);

    String desc = "should return false if null is compared";
    assertFalse(desc, matrix1.equals(null));
  }

  @Test
  public void shouldAddTwoMatrixes() {
    int[][] values1 = { { 1, 1 }, { 1, 1 } };
    Matrix matrix1 = Matrix.createMatrix(2, 2, values1);

    int[][] values2 = { { 2, 2 }, { 2, 2 } };
    Matrix matrix2 = Matrix.createMatrix(2, 2, values2);

    int[][] expectedValues = { { 3, 3 }, { 3, 3 } };
    Matrix expected = Matrix.createMatrix(2, 2, expectedValues);

    String desc = "should add two same size matrixes";
    assertTrue(desc, matrix1.add(matrix2).equals(expected));
  }

  @Test
  public void shouldReturnNullIfDifferentSizeMatrixesAdded() {
    int[][] values1 = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
    Matrix matrix1 = Matrix.createMatrix(3, 2, values1);

    int[][] values2 = { { 2, 2 }, { 2, 2 } };
    Matrix matrix2 = Matrix.createMatrix(2, 2, values2);

    String desc = "should return null if 2 different sized matrix added";
    assertNull(desc, matrix1.add(matrix2));
  }

  @Test
  public void shouldSubtractTwoMatrixes() {
    int[][] values1 = { { 10, 10 }, { 10, 10 } };
    Matrix matrix1 = Matrix.createMatrix(2, 2, values1);

    int[][] values2 = { { 2, 2 }, { 2, 2 } };
    Matrix matrix2 = Matrix.createMatrix(2, 2, values2);

    int[][] expectedValues = { { 8, 8 }, { 8, 8 } };
    Matrix expected = Matrix.createMatrix(2, 2, expectedValues);

    String desc = "should subtract two same size matrixes";
    assertTrue(desc, matrix1.subtract(matrix2).equals(expected));
  }

  @Test
  public void shouldReturnNullIfDifferentSizeMatrixesSubtracted() {
    int[][] values1 = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
    Matrix matrix1 = Matrix.createMatrix(3, 2, values1);

    int[][] values2 = { { 2, 2 }, { 2, 2 } };
    Matrix matrix2 = Matrix.createMatrix(2, 2, values2);

    String desc = "should return null if 2 different sized matrix subtracted";
    assertNull(desc, matrix1.subtract(matrix2));
  }

  @Test
  public void shouldMultiplyTwoMatrixes() {
    int[][] values1 = { { 10, 10 }, { 10, 10 } };
    Matrix matrix1 = Matrix.createMatrix(2, 2, values1);

    int[][] values2 = { { 2, 2 }, { 2, 2 } };
    Matrix matrix2 = Matrix.createMatrix(2, 2, values2);

    int[][] expectedValues = { { 40, 40 }, { 40, 40 } };
    Matrix expected = Matrix.createMatrix(2, 2, expectedValues);

    String desc = "should multiply same sized matrix";
    assertTrue(desc, matrix1.multiply(matrix2).equals(expected));
  }

  @Test
  public void shouldMultiplyTwoMatrixesOfDifferentSizes() {
    int[][] values1 = { { 10, 10 }, { 10, 10 }, { 10, 10 } };
    Matrix matrix1 = Matrix.createMatrix(3, 2, values1);

    int[][] values2 = { { 2, 2, 2 }, { 2, 2, 2 } };
    Matrix matrix2 = Matrix.createMatrix(2, 3, values2);

    int[][] expectedValues = { { 40, 40, 40 }, { 40, 40, 40 }, { 40, 40, 40 } };
    Matrix expected = Matrix.createMatrix(3, 3, expectedValues);

    String desc =
      "should multiply 2 matrix where the rows count of one matrix is equal to column count of the other";
    assertTrue(desc, matrix1.multiply(matrix2).equals(expected));
  }

  @Test
  public void shouldReturnNullIfMatrixesWithDifferentRowAndColumnSizeMultiplied() {
    int[][] values1 = { { 10, 10 }, { 10, 10 }, { 10, 10 } };
    Matrix matrix1 = Matrix.createMatrix(3, 2, values1);

    int[][] values2 = { { 2, 2 } };
    Matrix matrix2 = Matrix.createMatrix(1, 2, values2);

    String desc =
      "should return null if the row count and column count are not same";
    assertNull(desc, matrix1.multiply(matrix2));
  }

  @Test
  public void shouldReturnDeterminantOfMatrix() {
    int[][] values1 = { { 10, 2 }, { 12, 10 } };
    Matrix matrix1 = Matrix.createMatrix(2, 2, values1);

    String desc = "should return determinant of 2x2 matrix";
    assertEquals(desc, matrix1.determinant(), 76);
  }

  @Test
  public void shouldReturnDeterminantOfA3By3Matrix() {
    int[][] values1 = { { 1, 2, 1 }, { 1, 3, 4 }, { 1, 5, 3 } };
    Matrix matrix1 = Matrix.createMatrix(3, 3, values1);

    String desc = "should return determinant of 3x3 matrix";
    assertEquals(matrix1.determinant(), -7);
  }

  @Test
  public void shouldReturnZeroIfANonSquareMatrixGiven() {
    int[][] values1 = { { 1, 2, 1 }, { 1, 3, 4 } };
    Matrix matrix1 = Matrix.createMatrix(2, 3, values1);

    String desc = "should return 0 if given matrix is not a square matrix";
    assertEquals(matrix1.determinant(), 0);
  }
}
