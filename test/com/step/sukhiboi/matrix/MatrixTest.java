package com.step.sukhiboi.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    private Matrix createMatrix(int rows, int columns, int[] values) {
        if (rows * columns != values.length) return null;
        int[][] matrixValues = new int[rows][columns];
        for (int i = 0, rowId = 0, colId = 0; i < values.length; i++) {
            matrixValues[rowId][colId] = values[i];
            colId++;
            if (colId == columns) {
                rowId++;
                colId = 0;
            }
        }
        return Matrix.createMatrix(rows, columns, matrixValues);
    }

    //toString

    @Test
    public void shouldReturnStringRepresentationOfMatrix() {
        Matrix matrix1 = createMatrix(2, 2, new int[]{1, 1, 1, 1});
        if (matrix1 != null) {
            assertEquals("Matrix{rows=2, columns=2, values=\n1 1 \n1 1 \n}", matrix1.toString());
        }
    }

    //equals

    @Test
    public void shouldReturnTrueIfSameMatrixCompared() {
        Matrix matrix1 = createMatrix(2, 2, new int[]{1, 1, 1, 1});
        assertEquals(matrix1, matrix1);
    }

    @Test
    public void shouldReturnFalseIfDifferentObjectCompared() {
        Matrix matrix1 = createMatrix(2, 2, new int[]{1, 1, 1, 1});
        assertNotEquals(matrix1, new Object());
    }

    @Test
    public void shouldReturnFalseIfDifferentSizedMatrixCompared() {
        Matrix matrix1 = createMatrix(2, 1, new int[]{1, 1});
        Matrix matrix2 = createMatrix(3, 2, new int[]{2, 2, 2, 2, 2, 2});

        assertNotEquals(matrix1, matrix2);
    }

    @Test
    public void shouldReturnFalseIfDifferentMatrixCompared() {
        Matrix matrix1 = createMatrix(2, 1, new int[]{1, 1});
        Matrix matrix2 = createMatrix(2, 1, new int[]{2, 2});

        assertNotEquals(matrix1, matrix2);
    }

    @Test
    public void shouldReturnFalseIfNullCompared() {
        Matrix matrix1 = createMatrix(2, 1, new int[]{1, 1});
        assertNotEquals(null, matrix1);
    }

    //add

    @Test
    public void shouldAddTwoMatrices() {
        Matrix matrix1 = createMatrix(2, 1, new int[]{1, 1});
        Matrix matrix2 = createMatrix(2, 1, new int[]{2, 2});
        Matrix expected = createMatrix(2, 1, new int[]{3, 3});

        if (matrix1 != null) {
            assertEquals(matrix1.add(matrix2), expected);
        }
    }

    @Test
    public void shouldReturnNullIfDifferentSizeMatricesAdded() {
        Matrix matrix1 = createMatrix(2, 1, new int[]{1, 1});
        Matrix matrix2 = createMatrix(3, 2, new int[]{2, 2, 2, 2, 2, 2});

        if (matrix1 != null) {
            assertNull(matrix1.add(matrix2));
        }
    }

    //subtract

    @Test
    public void shouldSubtractTwoMatrices() {
        Matrix matrix1 = createMatrix(2, 1, new int[]{1, 1});
        Matrix matrix2 = createMatrix(2, 1, new int[]{2, 2});
        Matrix expected = createMatrix(2, 1, new int[]{-1, -1});

        if (matrix1 != null) {
            assertEquals(matrix1.subtract(matrix2), expected);
        }
    }

    @Test
    public void shouldReturnNullIfDifferentSizeMatricesSubtracted() {
        Matrix matrix1 = createMatrix(2, 1, new int[]{1, 1});
        Matrix matrix2 = createMatrix(3, 1, new int[]{2, 2, 2});

        if (matrix1 != null) {
            assertNull(matrix1.subtract(matrix2));
        }
    }

    // multiply

    @Test
    public void shouldMultiplyTwoMatrices() {
        Matrix matrix1 = createMatrix(2, 2, new int[]{1, 1, 1, 1});
        Matrix matrix2 = createMatrix(2, 2, new int[]{2, 2, 2, 2});
        Matrix expected = createMatrix(2, 2, new int[]{4, 4, 4, 4});

        if (matrix1 != null) {
            assertEquals(expected, matrix1.multiply(matrix2));
        }
    }

    @Test
    public void shouldMultiplyTwoMatricesOfDifferentSizes() {
        Matrix matrix1 = createMatrix(1, 2, new int[]{10, 10});
        Matrix matrix2 = createMatrix(2, 1, new int[]{4, 4});
        Matrix expected = createMatrix(1, 1, new int[]{80});

        if (matrix1 != null) {
            assertEquals(matrix1.multiply(matrix2), expected);
        }
    }

    @Test
    public void shouldReturnNullIfMatricesWithDifferentRowAndColumnSizeMultiplied() {
        Matrix matrix1 = createMatrix(1, 2, new int[]{10, 10});
        Matrix matrix2 = createMatrix(3, 1, new int[]{4, 4, 4});

        if (matrix1 != null) {
            assertNull(matrix1.multiply(matrix2));
        }
    }

    //determinant

    @Test
    public void shouldReturnDeterminantOfMatrix() {
        Matrix matrix1 = createMatrix(2, 2, new int[]{1, 1, 1, 1});
        if (matrix1 != null) {
            assertEquals(matrix1.determinant(), 0);
        }
    }

    @Test
    public void shouldReturnDeterminantOfA3By3Matrix() {
        int[] values = {1, 2, 1, 1, 3, 4, 1, 5, 3};
        Matrix matrix1 = createMatrix(3, 3, values);

        if (matrix1 != null) {
            assertEquals(matrix1.determinant(), -7);
        }
    }

    @Test
    public void shouldReturnZeroIfANonSquareMatrixGiven() {
        Matrix matrix1 = createMatrix(1, 2, new int[]{1, 2});

        if (matrix1 != null) {
            assertEquals(matrix1.determinant(), 0);
        }
    }

    //createMatrix

    @Test
    public void shouldCreateAMatrixOfSpecifiedRowsAndColumnsWithProvidedValues() {
        Matrix matrix1 = createMatrix(1, 2, new int[]{1, 2});
        if (matrix1 != null) {
            assertEquals("Matrix{rows=1, columns=2, values=\n1 2 \n}", matrix1.toString());
        }
    }

    @Test
    public void shouldReturnNullIfRowsAndColumnCountNotMatchWithProvidedValues() {
        Matrix matrix1 = createMatrix(2, 2, new int[]{1, 2});
        assertNull(matrix1);
    }
}
