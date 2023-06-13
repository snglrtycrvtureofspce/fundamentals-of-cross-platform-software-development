package MatrixTesting;
import Matrix.DoubleMatrix;
import org.junit.Assert;
import org.junit.Test;


public class DoubleMatrixTesting {
    @Test
    public void RowWithMaxElementTestSuccess()
    {
        DoubleMatrix matrix = new DoubleMatrix();
        int actual = matrix.RowWithMaxElement();
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void RowWithMaxElementTestFail()
    {
        DoubleMatrix matrix = new DoubleMatrix();
        int actual = matrix.RowWithMaxElement();
        int expected = 1;
        Assert.assertEquals( "Тест	не	прошел,	т.к. ожидаемый и реальный номер строки не совпали", expected, actual); // устаревшие варианты : //
    }
    @Test
    public void ColumnWithMinElementTestSuccess()
    {
        DoubleMatrix matrix = new DoubleMatrix();
        int actual = matrix.ColumnWithMinElement();
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void ColumnWithMinElementTestFail()
    {
        DoubleMatrix matrix = new DoubleMatrix();
        int actual = matrix.ColumnWithMinElement();
        int expected = 1;
        Assert.assertEquals( "Тест	не	прошел,	т.к. ожидаемый и реальный номер колонки не совпали", expected, actual); // устаревшие варианты : //
    }
    public static final double[][] MATRIX = {
            {1.2,5.3,2.5},
            {6.3,8.4,1.3},
            {4.2,7.3,9.5}};
    @Test
    public void ScalMultSuccess()
    {
        DoubleMatrix matrix = new DoubleMatrix();
        double actual = matrix.Scalmult();
        double expected = (1.2+4.2)*(6.3+7.3)*(4.2+9.5);
        Assert.assertEquals(expected, actual, 0); // устаревшие варианты : //
    }
    @Test
    public void ScalMultFail()
    {
        DoubleMatrix matrix = new DoubleMatrix();
        double actual = matrix.ColumnWithMinElement();
        double expected = (1.2+4.2)*(6.2+7.3)*(4.2+9.5);;
        Assert.assertEquals( "Тест	не	прошел,	т.к. скалярное произведение неверное", expected, actual,0); // устаревшие варианты : //
    }
}
