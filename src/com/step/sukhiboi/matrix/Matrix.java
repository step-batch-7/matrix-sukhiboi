package com.step.sukhiboi.matrix;

/**
 * This class can be used to create matrix with or without values.<br>
 * It allows to perform some basic operations on matrices such as
 * addition
 * subtraction
 * multiplication
 * finding determinant
 * equating 2 matrices
 * printing matrix
 */
public class Matrix {
    private final int rows;
    private final int columns;
    private final int[][] values;

    /**
     * Creates a new null Matrix of provided rows and columns count.
     *
     * @param rows    count of rows
     * @param columns count of columns
     */
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.values = new int[rows][columns];
    }

    /**
     * Creates a new Matrix of provided rows and columns count.<br>
     * If values doesn't fit in the size of given matrix it will return null.
     *
     * @param rows    count of rows
     * @param columns count of columns
     * @param values  2d int array of values, with each sub array as a row
     * @return Matrix
     */
    public static Matrix createMatrix(int rows, int columns, int[][] values) {
        if (!isValidMatrixValues(rows, columns, values)) return null;
        Matrix newMatrix = new Matrix(rows, columns);
        for (int row = 0; row < rows; row++) {
            if (columns >= 0) System.arraycopy(values[row], 0, newMatrix.values[row], 0, columns);
        }
        return newMatrix;
    }

    /**
     * Return a new Matrix which is the sum of the current matrix and the passed matrix.<br>
     * If the passed matrix is null or is of different size then the result will be null.
     *
     * @param anotherMatrix of Matrix
     * @return Matrix
     */
    public Matrix add(Matrix anotherMatrix) {
        if (isNotMatrixInstance(anotherMatrix)) return null;
        Matrix newMatrix = new Matrix(this.rows, this.columns);
        if (this.isNotSameSize(anotherMatrix)) return null;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                newMatrix.values[i][j] = this.values[i][j] + anotherMatrix.values[i][j];
            }
        }
        return newMatrix;
    }

    /**
     * Return a new Matrix which is the difference of the current matrix and the passed matrix.<br>
     * If the passed matrix is null or is of different size then the result will be null.
     *
     * @param anotherMatrix of Matrix
     * @return Matrix
     */
    public Matrix subtract(Matrix anotherMatrix) {
        if (isNotMatrixInstance(anotherMatrix)) return null;
        Matrix newMatrix = new Matrix(this.rows, this.columns);
        if (this.isNotSameSize(anotherMatrix)) return null;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                newMatrix.values[i][j] = this.values[i][j] - anotherMatrix.values[i][j];
            }
        }
        return newMatrix;
    }

    /**
     * Return a new Matrix which is multiplication result of the current matrix and the passed matrix.<br>
     * If the passed matrix is null or the column count doesn't match with the rows count of current matrix it will return null.
     *
     * @param anotherMatrix of Matrix
     * @return Matrix
     */
    public Matrix multiply(Matrix anotherMatrix) {
        if (isNotMatrixInstance(anotherMatrix)) return null;
        if (this.columns != anotherMatrix.rows) return null;
        Matrix newMatrix = new Matrix(this.rows, anotherMatrix.columns);
        for (int rows = 0; rows < this.rows; rows++) {
            for (int columns = 0; columns < anotherMatrix.columns; columns++) {
                int cell = 0;
                for (int row = 0; row < this.columns; row++) {
                    cell += this.values[rows][row] * anotherMatrix.values[row][columns];
                }
                newMatrix.values[rows][columns] = cell;
            }
        }
        return newMatrix;
    }

    /**
     * This wil return the determinant of the current matrix.<br>
     * If the current matrix is not a square matrix then the result will be 0.
     *
     * @return determinant of the current matrix
     */
    public int determinant() {
        if (this.rows != this.columns) return 0;
        if (this.rows == 2) {
            return (
                    this.values[0][0] *
                            this.values[1][1] -
                            this.values[0][1] *
                                    this.values[1][0]
            );
        }
        int result = 0;
        for (int col = 0; col < this.columns; col++) {
            int sign = col % 2 != 0 ? -1 : 1;
            result +=
                    sign * this.values[0][col] * this.getSubMatrix(col).determinant();
        }
        return result;
    }

    private static boolean isValidMatrixValues(
            int rows,
            int columns,
            int[][] values
    ) {
        if (values.length != rows) return false;
        for (int row = 0; row < rows; row++) {
            if (values[row].length != columns) return false;
        }
        return true;
    }

    private boolean isNotMatrixInstance(Matrix anotherMatrix) {
        return anotherMatrix == null;
    }

    private boolean isNotSameSize(Matrix matrix) {
        return this.rows != matrix.rows || this.columns != matrix.columns;
    }

    private Matrix getSubMatrix(int colId) {
        Matrix subMatrix = new Matrix(this.rows - 1, this.columns - 1);
        for (int row = 1, sRow = 0; row < this.rows; row++) {
            for (int col = 0, sCol = 0; col < this.columns; col++) {
                if (col == colId) {
                    continue;
                }
                subMatrix.values[sRow][sCol] = this.values[row][col];
                sCol++;
            }
            sRow++;
        }
        return subMatrix;
    }

    /**
     * Return the string representation of the current matrix
     */
    @Override
    public String toString() {
        StringBuilder matrix = new StringBuilder();
        for (int[] row : this.values) {
            for (int cell : row) {
                matrix.append(cell).append(" ");
            }
            matrix.append("\n");
        }

        return "Matrix{" + "rows=" + rows + ", columns=" + columns + ", values=\n" + matrix + '}';
    }

    /**
     * This will check if the passed object is same as the current matrix, if yes it will return true else false.<br>
     * Passed Object<br>
     * - should be a instance of Matrix class<br>
     * - should be of same size as of current matrix<br>
     * - should have all values equal to the current matrix<br>
     *
     * @param o Any object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix matrix = (Matrix) o;
        if (this.isNotSameSize(matrix)) return false;

        for (int rows = 0; rows < this.rows; rows++) {
            for (int column = 0; column < this.columns; column++) {
                if (this.values[rows][column] != matrix.values[rows][column]) {
                    return false;
                }
            }
        }

        return true;
    }
}
