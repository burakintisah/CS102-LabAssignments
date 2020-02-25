/**
 * @(#)FillBox.java
 *
 *
 * @author OsmanBurak
 * @version 1.00 2017/11/28
 */


public class FillBox 
{

	/**
	 *creating array
	 *@param row
	 *@param column 
	 *@return String[][]
	 */
    public static String [][] createArray (int row, int column)
    {
    	String [][] array = new String[row][column];
    	for (int i = 0;i<row;i++)
    	{
    		array [i][0] = "#" ;
    		array [i][column-1] = "#";	
    	}
    	for (int j = 1 ; j< column ; j++)
    	{
    		array [0][j] = "#";
    		array [row-1][j] = "#";
    	}
    	for (int i = 0; i < array.length; i++)
    	{
    		for (int j=0; j < array[i].length; j++)
    		{
    			if (array[i][j] == null){
    				array[i][j]=" ";
    			}
			
    		}
    	}	
    	return array;
    }
    
    /**
     *printing array
     *param array 
     */
    public static void printArray(String [][] array)
    {
    	for (int i = 0; i < array.length; i++)
    	{
    		for (int j=0; j < array[i].length; j++)
    		{
    			System.out.print(array[i][j]) ;
    		}
    		System.out.println();
    	}	
    }
   	/**
   	 *filling box
   	 *@param array
   	 *@param row
   	 *@param column
   	 *@param str
   	 */
   	public static String[][] fillBox(String[][] array, int row, int column, String str)
   	{
   		//base case
		if(row==1 && column==1){
			array[row][column]=str;
			return array;
		}
		else{
			//changing row 
			if(column==1){
				array[row][column]=str;
				return fillBox(array,row-1,array[0].length-2,str);	
			} 
			//changing column number - 1
			else{
				array[row][column]=str;
				return fillBox(array,row,column-1,str);	
			}
		}
   	}
   	
   	/*
   	 *drawing figure inside 4 box
   	 *
   	 *@param array
   	 *@param row
   	 *@param column 
   	 *@param str
   	 */
   	public static String [][] drawFigure (String[][] array, int row, int column, String str)
   	{	
   		
   		if (row<7 || column<7)
   		{
   			return fillBox(array,row-2,column-2,str);
   		}
   		
   		else
   		{
			int a = row/2 + 1;
   			int b = column/2 + 1;

	   		String [][] ax = createArray(a,b);
	   		String [][] bx = createArray(a,column-b+1);
	   		String [][] c = createArray(row-a+1,b);
	   		String [][] d = createArray(row-a+1,column-b+1);
	   		
	   		drawFigure(ax,a,b,str);
	   		drawFigure(bx,a,column-b+1,str);
	   		drawFigure(c,row-a+1,b,str);
	   		drawFigure(d,row-a+1,column-b+1,str);
	   		
	   		for(int i= 0; i<a ;i++){
		   		for (int j=0; j<b ; j++){
		   			array[i][j] = ax[i][j];
		   		}
		   	}
		   	for(int i= 0; i<a ;i++){
		   		for (int j=0; j<column-b+1 ; j++){
		   			array[i][j+b-1] = bx[i][j];
		   		}
		   	}
		   	for(int i= 0; i<row-a+1 ;i++){
		   		for (int j=0; j<b ; j++){
		   			array[i+a-1][j] = c[i][j];
		   		}
		   	}
		   	for(int i= 0; i<row-a+1 ;i++){
		   		for (int  j=0; j<column-b+1 ; j++){
		   			array[i+a-1][j+b-1] = d[i][j];
		   		}
		   	}
	   		
	   		return array;
  		
   		}
	}   	
   	 /*
   	 *drawing figure inside 4 box with extra 2 parameters drawing pattern
   	 *
   	 *@param array
   	 *@param row
   	 *@param column 
   	 *@param str
   	 *@param pattern
   	 *@pattern2 
   	 */
   	 
    public static String [][] drawFigure (String[][] array, int row, int column, String str, int pattern, int pattern2)
   	{
   		
   		if (row<7|| column<7)
   		{
   			return fillBox(array,row-2,column-2,str);
   		}
   		
   		else
   		{
   			int a = row/2 + 1;
   			int b = column/2 + 1;


	   		String [][] ax = createArray(a,b);
	   		String [][] bx = createArray(a,column-b+1);
	   		String [][] c = createArray(row-a+1,b);
	   		String [][] d = createArray(row-a+1,column-b+1);


	   		if(pattern == 1 && pattern2 == 1){
	   			
	   			drawFigure(ax,a,b,str,pattern,pattern2);
	   			drawFigure(d,row-a+1,column-b+1,str,pattern,pattern2);
	   			
	   			for(int i= 0; i<a ;i++){
			   		for (int j=0; j<b ; j++){
			   			array[i][j] = ax[i][j];
			   		}
			   	}
			   	for(int i= 0; i<row-a+1 ;i++){
			   		for (int  j=0; j<column-b+1 ; j++){
			   			array[i+a-1][j+b-1] = d[i][j];
			   		}
			   	}
	   		}
	   		
		   	if(pattern == 1 && pattern2 == 2){ 
		   		
		   		drawFigure(bx,a,column-b+1,str,pattern,pattern2);
	   			drawFigure(c,row-a+1,b,str,pattern,pattern2);
		   		
		   		for(int i= 0; i<a ;i++){
			   		for (int j=0; j<column-b+1 ; j++){
			   			array[i][j+b-1] = bx[i][j];
			   		}
			   	}
			   	for(int i= 0; i<row-a+1 ;i++){
		   			for (int j=0; j<b ; j++){
		   				array[i+a-1][j] = c[i][j];
		   			}
		  	 	}
		   	}
		   	
		   	if(pattern == 2){
		   		
		   		//changing pattern2 each time
		   		int second = pattern2;
		   		if ( pattern2 == 2) second  = 1 ;
		   		else if ( pattern2 == 1 ) second = 2 ;
		   		
		   		//writing boxes in terms of pattern2 
		   		if (second == 1){
		   			drawFigure(ax,a,b,str,pattern,second);
		   			drawFigure(d,row-a+1,column-b+1,str,pattern,second);
		   		}
		   		if (second == 2){
		   			drawFigure(bx,a,column-b+1,str,pattern,second);
		   			drawFigure(c,row-a+1,b,str,pattern,second);
		   		}
		   	
		   		// writing 4 part into the big box
		   		for(int i= 0; i<a ;i++){
			   		for (int j=0; j<b ; j++){
			   			array[i][j] = ax[i][j];
			   		}
			   	}
			   	for(int i= 0; i<a ;i++){
			   		for (int j=0; j<column-b+1 ; j++){
			   			array[i][j+b-1] = bx[i][j];
			   		}
			   	}
			   	for(int i= 0; i<row-a+1 ;i++){
			   		for (int j=0; j<b ; j++){
			   			array[i+a-1][j] = c[i][j];
			   		}
			   	}
			   	for(int i= 0; i<row-a+1 ;i++){
			   		for (int  j=0; j<column-b+1 ; j++){
			   			array[i+a-1][j+b-1] = d[i][j];
			   		}
			   	}
	
		   	}
	   		return array;
	  		
	   	}
	}   	
    public static void main (String [] args){
    	
    	String[][] a;
    	String[][] b;
    	String[][] c;
    	a = createArray(16,16);
    	b = createArray(16,16);
    	c = createArray (32,32);
    	printArray(a);
		System.out.println();
    	System.out.println();
    	System.out.println();
    	printArray(fillBox(a,14,14,"/"));
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	printArray(drawFigure(b,16,16,"-"));
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	printArray (drawFigure(c,32,32,"*",2,1));

    }//End main method
}//End of Class