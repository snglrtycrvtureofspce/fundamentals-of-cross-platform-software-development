package Matrix;

public class DoubleMatrix {
    public static final double[][] MATRIX = {
            {1.2,5.3,2.5},
            {6.3,8.4,1.3},
            {4.2,7.3,9.5}};
    public int ColumnWithMinElement()
    {
        int indexJ=0;
        double min = MATRIX[0][0];
        for(int i = 0;i<MATRIX.length;i++)
        {
            for(int j = 0; j< MATRIX[0].length; j++)
            {
                if(MATRIX[i][j]<min)
                {
                    min=MATRIX[i][j];
                    indexJ=j;
                }
            }
        }
        return indexJ;
    }
    public int RowWithMaxElement()
    {
        int indexI=0;
        double max = MATRIX[0][0];
        for(int i = 0;i<MATRIX.length;i++)
        {
            for(int j = 0; j< MATRIX[0].length; j++)
            {
                if(MATRIX[i][j]>max)
                {
                    max=MATRIX[i][j];
                    indexI=i;
                }
            }
        }
        return indexI;
    }
    public double Scalmult() {
        double mult = 1;
        int row = RowWithMaxElement();
        int column = ColumnWithMinElement();
        for (int i = 0; i< MATRIX.length;i++)
        {
            mult*=(MATRIX[i][column]+MATRIX[row][i]);
        }
        return mult;
    }

}
