package com.step.sukhiboi.matrix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        assertEquals("Matrix{rows=2, columns=2, values=\n1 1 \n1 1 \n}",matrix1.toString());
    }

    //equals

    @Test
    public void shouldReturnTrueIfSameMatrixCompared() {
        assertEquals(matrix1, matrix1);
    }

    @Test
    public void shouldReturnFalseIfDifferentObjectCompared() {
        assertNotEquals(matrix1, new Object());
    }

    @Test
    public void shouldReturnFalseIfDifferentSizedMatrixCompared() {
        int[][] values1 = { { 1 }, { 1 } };
        matrix1 = Matrix.createMatrix(2, 1, values1);

        int[][] values2 = { { 2, 2 }, { 2, 2 }, { 2, 2 } };
        matrix2 = Matrix.createMatrix(3, 2, values2);

        assertNotEquals(matrix1, matrix2);
    }

    @Test
    public void shouldReturnFalseIfDifferentMatrixCompared() {
        assertNotEquals(matrix1, matrix2);
    }

    @Test
    public void shouldReturnFalseIfNullCompared() {
        assertNotEquals(null, matrix1);
    }

    //add

    @Test
    public void shouldAddTwoMatrices() {
        int[][] expectedValues = { { 3, 3 }, { 3, 3 } };
        Matrix expected = Matrix.createMatrix(2, 2, expectedValues);

        assertEquals(matrix1.add(matrix2), expected);
    }

    @Test
    public void shouldReturnNullIfDifferentSizeMatricesAdded() {
        int[][] values1 = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
        matrix1 = Matrix.createMatrix(3, 2, values1);

        if (matrix1 != null) {
            assertNull(matrix1.add(matrix2));
        }
    }

    //subtract

    @Test
    public void shouldSubtractTwoMatrices() {
        int[][] expectedValues = { { -1, -1 }, { -1, -1 } };
        Matrix expected = Matrix.createMatrix(2, 2, expectedValues);

        assertEquals(matrix1.subtract(matrix2), expected);
    }

    @Test
    public void shouldReturnNullIfDifferentSizeMatricesSubtracted() {
        int[][] values1 = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
        Matrix matrix1 = Matrix.createMatrix(3, 2, values1);

        if (matrix1 != null) {
            assertNull(matrix1.subtract(matrix2));
        }
    }

    // multiply

    @Test
    public void shouldMultiplyTwoMatrices() {
        int[][] expectedValues = { { 4, 4 }, { 4, 4 } };
        Matrix expected = Matrix.createMatrix(2, 2, expectedValues);

        assertEquals(expected, matrix1.multiply(matrix2));
    }

    @Test
    public void shouldMultiplyTwoMatricesOfDifferentSizes() {
        int[][] values1 = { { 10, 10 }, { 10, 10 }, { 10, 10 } };
        matrix1 = Matrix.createMatrix(3, 2, values1);

        int[][] values2 = { { 2, 2, 2 }, { 2, 2, 2 } };
        matrix2 = Matrix.createMatrix(2, 3, values2);

        int[][] expectedValues = { { 40, 40, 40 }, { 40, 40, 40 }, { 40, 40, 40 } };
        Matrix expected = Matrix.createMatrix(3, 3, expectedValues);

        assertEquals(matrix1.multiply(matrix2), expected);
    }

    @Test
    public void shouldReturnNullIfMatricesWithDifferentRowAndColumnSizeMultiplied() {
        int[][] values1 = { { 10, 10, 10 }, { 10, 10, 10 } };
        Matrix matrix1 = Matrix.createMatrix(2, 3, values1);

        if (matrix1 != null) {
            assertNull(matrix1.multiply(matrix2));
        }
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

        if (matrix1 != null) {
            assertEquals(matrix1.determinant(), -7);
        }
    }

    @Test
    public void shouldReturnZeroIfANonSquareMatrixGiven() {
        int[][] values1 = { { 1, 2, 1 }, { 1, 3, 4 } };
        Matrix matrix1 = Matrix.createMatrix(2, 3, values1);

        if (matrix1 != null) {
            assertEquals(matrix1.determinant(), 0);
        }
    }
}
