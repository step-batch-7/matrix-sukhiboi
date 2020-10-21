package com.github.sukhiboi.matrix;

public class Matrix {
  private final int rows;
  private final int columns;
  private int[][] values;

  public Matrix(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    this.values = new int[rows][columns];
  }

  public static Matrix createMatrix(int rows, int columns, int[][] values) {
    Matrix newMatrix = new Matrix(rows, columns);
    for (int row = 0; row < rows; row++) {
      for (int cell = 0; cell < columns; cell++) {
        newMatrix.values[row][cell] = values[row][cell];
      }
    }
    return newMatrix;
  }

  private boolean isSizeSame(Matrix matrix) {
    return this.rows == matrix.rows && this.columns == matrix.columns;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Matrix)) return false;
    Matrix matrix = (Matrix) obj;
    if (this.rows != matrix.rows) return false;
    if (this.columns != matrix.columns) return false;

    for (int rows = 0; rows < this.rows; rows++) {
      for (int column = 0; column < this.columns; column++) {
        if (this.values[rows][column] != matrix.values[rows][column]) {
          return false;
        }
      }
    }

    return true;
  }

  @Override
  public String toString() {
    StringBuilder representation = new StringBuilder();
    for (int row[] : this.values) {
      for (int cell : row) {
        representation.append(cell).append(" ");
      }
      representation.append("\n");
    }
    return representation.toString();
  }

  public Matrix add(Matrix anotherMatrix) {
    Matrix newMatrix = new Matrix(this.rows, this.columns);
    if (!this.isSizeSame(anotherMatrix)) return null;
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.columns; j++) {
        newMatrix.values[i][j] = this.values[i][j] + anotherMatrix.values[i][j];
      }
    }
    return newMatrix;
  }

  public Matrix subtract(Matrix anotherMatrix) {
    Matrix newMatrix = new Matrix(this.rows, this.columns);
    if (!this.isSizeSame(anotherMatrix)) return null;
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.columns; j++) {
        newMatrix.values[i][j] = this.values[i][j] - anotherMatrix.values[i][j];
      }
    }
    return newMatrix;
  }

  public Matrix multiply(int multiplier) {
    Matrix newMatrix = new Matrix(this.rows, this.columns);
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.columns; j++) {
        newMatrix.values[i][j] = this.values[i][j] * multiplier;
      }
    }
    return newMatrix;
  }

  public Matrix multiply(Matrix anotherMatrix) {
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

  private Matrix getSubMatrix(int rowIdx, int colIdx) {
    Matrix subMatrix = new Matrix(this.rows - 1, this.columns - 1);
    for (int row = 0, sRow = 0; row < this.rows; row++) {
      if (row == rowIdx) {
        continue;
      }
      for (int col = 0, sCol = 0; col < this.columns; col++) {
        if (col == colIdx) {
          continue;
        }
        subMatrix.values[sRow][sCol] = this.values[row][col];
        sCol++;
      }
      sRow++;
    }
    return subMatrix;
  }

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
        sign * this.values[0][col] * this.getSubMatrix(0, col).determinant();
    }
    return result;
  }
}
