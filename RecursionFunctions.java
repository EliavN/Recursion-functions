/**
 * Open University course 20441 
 * This file contains every recursive function of every exam since 2005 to 2016
 * @version 2.0
 * @author Eliav Nakam 
 */


/**
 * Exam 2007A2 first recursion question
 */
	public static int maxRow(int[][]a){   
		return maxRow(a,0,0,0,0);
	}
	
	private static int maxRow(int[][]a, int i, int j, int max, int maxI){
		if(i>a.length-1)
			return maxI;
		
		if(sumRow(a,i,j) > max){
			max = sumRow(a,i,j);
			maxI = i;
	}
		
		return maxRow(a,i+1,j,max,maxI);
	}
	private static int sumRow(int[][] a, int i, int j){
		if(j>a[i].length-1) 
			return 0;
		return a[i][j] + sumRow(a,i, j+1);
	}
	
	
	
	/**
	 * Exam 2007B1A first recursion question
	 */
	
	public static int equalSum(int[] a) {
		return equalSum(a,0,0);
	}
	
	private static int equalSum(int[] a, int i, int j) {
		if(j>a.length-1) 
			return -1;
		
		if(range(a,i,j) == range(a,j+1, a.length-1))
			return j;
		
		return equalSum(a, i, j+1);
	}
	
	
	private static int range(int[] a, int i, int j){
		if(i>j) return 0;
		return a[i] + range(a, i+1, j);
	}
	
	
	
	
	
	
	/**
	 * Exam A3 B 2007 first recursion method - without overloading
	 */
	public static boolean isSubString(String s1, String s2)
	{
		if(s1.length()<s2.length()) return false;
		if(s1.equals(s2)) return true;
		
		return isSubString(s1.substring(1), s2);
	}
	
	
	
	/**
	 *  Exam B1 B 2007 - merge method
	 */
	public static int[] merge(int[] ar1, int[] ar2){
		return merge(ar1, ar2, new int[ar1.length+ar2.length],0,0,0);
	}
	
	private static int[] merge(int[] ar1, int[] ar2, int[] sorted, int i, int j, int s)
	{
		if(s==sorted.length-1) return sorted;
		if(i==ar1.length) return merge(ar1, ar2, sorted, i, j+1, s+1); 
		if(j==ar2.length) return merge(ar1, ar2, sorted, i+1, j, s+1);
		if(ar1[i] >= ar2[j]){
			sorted[s] = ar2[j];
			return merge(ar1, ar2, sorted, i, j+1, s+1);
		}
		sorted[s] = ar1[i];
		return merge(ar1, ar2, sorted, i+1, j, s+1);
	}
	 
	
	
	
	
	/**
	 * Exam 2009B B6
	 * without overloading
	 */
	public static boolean samePattern(String s1, String s2)
	{
		if(s2.length() == 0) 
			return s1.length() == 0;
		if(s1.length() == 0) 
			return s2.length() == 0;
		
		if(s2.charAt(0) == '*') 
			return samePattern(s1,s2.substring(1)) || samePattern(s1.substring(1), s2);
		
		if(s2.charAt(0) == s1.charAt(0))
			return samePattern(s1.substring(1),s2.substring(1));
		
		return false;
	}
	
	
	
	/**
	 * Exam 2011A A6 first recursion isPath
	 */
	public static boolean isPath(int[][] mat){
		return isPath(mat, 0,0,0, true);
	}
	
	
	private static boolean isPath(int[][] mat, int i, int j, int prev, boolean s)
	{
		if(i==mat.length-1) return j==mat.length-1;
		if(i<0 || i>= mat.length || j>= mat.length || j<0)
			return false;
		if(prev+1==mat[i][j]|| s) {
		boolean right = isPath(mat,i,j+1,mat[i][j], false),
				left = isPath(mat,i,j-1,mat[i][j],false),
				up = isPath(mat,i+1,j,mat[i][j],false),
				down = isPath(mat,i-1,j,mat[i][j],false);
		
		return right || left || up || down;
		}
		return false;
	}
	
	
	
	
	
	/**
	 * 
	 * Exam 2012 A1 A - splitEqualSum
	 */
	public static boolean splitEqualSum(int[] a){
		return splitEqualSum(a,0,0,0);
	}
	

	public static boolean splitEqualSum(int[] a, int i, int sum1, int sum2) {
		if (i == a.length) return (sum1 == sum2);
		
		boolean split1 = splitEqualSum(a, i+1, sum1 + a[i], sum2);
		boolean split2 = splitEqualSum(a, i+1, sum1, sum2 + a[i]);
		return split1 || split2;
	}
	
	
	
	/**
	 * Exam 2012 A2 A - isSum method 
	 */
	public static boolean isSumOf(int[] s, int n){
		return isSumOf(s,n,0,"");
	}
	
	private static boolean isSumOf(int[] s, int n, int i, String st) {
		if(i==s.length || n<0) return false;
		if(n == 0) {
			System.out.println(st);
			return true;
		}
		return isSumOf(s,n, i+1,st) || isSumOf(s,n-s[i], i,st + s[i] + " ");
	}

	
	
	
	/**
	 * Exam 2012A 92 B5 - mirror method - option 1
	 */
	public static void mirror(int[] a) {
		 mirror(a,0,a.length-1, new int[a.length]);
	}
	
	private static void mirror(int[] a, int i, int j, int[] t) {
		
		if(i==a.length || j==0) {
			printArr(a,0);
			return;
		}
		if(t[i] == -1 || t[j] ==-1) 
			return;

		mirror(a,i+1,j-1,t);
		t[i] = -1;
		t[j]= -1;
		int tempI = a[i];
		a[i] = a[j];
		a[j] = tempI;
		mirror(a,i+1,j-1,t);
		tempI = a[i];
		a[i] = a[j];
		a[j] = tempI;
		t[i] = 0;
		t[j]= 0;
	}

	private static void printArr(int[] a, int i)
	{
		if(i== a.length) { System.out.println(); return;}
		System.out.print(a[i]);
		printArr(a,i+1);
	}
	
	/**
	 * Exam 2012A 92 B5 - mirror method - option 2
	 */
	public static void mirror2 (int [] a)
	   {
	      int i= 0;
	      if (a.length%2 == 0)
	          i = a.length/2;
	      else
	          i = a.length/2+1;
	      
	      mirror2 (a,i);
	    }
	    private static void mirror2 (int [] a ,int i){
	    if (i>a.length-1)
	    {
	        printArr(a,0);
	    }
	    else
	    {
	        mirror2 (a,i+1);
	        int temp = a[i];
	        a[i] = a[a.length-1-i];
	        a[a.length-1-i] = temp;
	        mirror2 (a,i+1);
	        temp = a[i];
	        a[i] = a[a.length-1-i];
	        a[a.length-1-i] = temp;
	    }
	}
	
	    
	
	
	
	/**
	 * Exam 2012B 85 A3 - printPathWeights method
	 */
	public static void printPathWeights(int[][] m) {
		printPathWeights(m, 0,0,0);
	}
	
	private static void printPathWeights(int[][] m, int i, int j, int count) {
		if(i>m.length-1 || i<0 || j>m[0].length-1 || j<0 || m[i][j] == -1)
			return;
		
		if(i==m.length-1 && j==m[0].length-1) {
			System.out.println(count);
			return;
		}
		count+=m[i][j];
		int temp = m[i][j];
		m[i][j] = -1;
		printPathWeights(m, i+1, j, count);
		printPathWeights(m, i-1, j, count);
		printPathWeights(m, i, j+1, count);
		printPathWeights(m, i, j-1, count);
		m[i][j] = temp;
	}
	
	
	
	
	/**
	 * Exam 2012B 92 B3 - isWay method
	 */
	public static boolean isWay(int[] a)
	{
		return isWay(a, 0, new int[a.length]);
	}
	private static boolean isWay(int[]a, int i, int[] reference)
	{
		if(i==a.length-1) return true;
		if(i<0||i>a.length-1 || reference[i] == -1) return false;
		
		reference[i] = -1;
		boolean right = isWay(a,i+a[i], reference);
		boolean left = isWay(a, i-a[i], reference);

		return right || left;
	}
	
	public static boolean isWay2(int[] a)
	{
		return isWay2(a, new boolean [a.length], 0);
	}
	private static boolean isWay2(int[]a,boolean[] reference, int i)
	{
		if(i==a.length-1) return true;
		if(i<0||i>a.length-1 || reference[i]) return false;
		
		reference[i] = true;
		boolean right = isWay2(a, reference,i+a[i]);
		boolean left = isWay2(a, reference, i-a[i]);

		return right || left;
	}
	
	
	
	
	/**
	 * Exam 2013A 92-B3 - match question
	 */
	
	public static boolean match (int[] a, int[] pattern){
		return match(a, pattern, 0, 0);
	}
	
	private static boolean match(int[] a, int[] pattern, int i, int j)
	{
		if(j==pattern.length) return true;
		if(i>a.length-1|| j>pattern.length-1) return false;
		 
		if(pattern[j] == 0)
			if(a[i] > 0 && a[i] < 100)
				return match(a,pattern,i+1,j+1);
			else
				return match(a,pattern,i+1,0);
		
		if(pattern[j] == 1)
			if(a[i] > 0 && a[i] < 10)
				return match(a,pattern,i+1,j+1);
			else
				return match(a,pattern,i+1,0);
		
		if(pattern[j] == 2)
			if(a[i] > 9 && a[i] < 100)
				return match(a,pattern,i+1,j+1);
			else
				return match(a,pattern,i+1,0);
		
		return false;
	}

	
	
	
	
	
	/**
 	* 	Exam 2013B - 85 - A5 - minDiff method
 	*/
	public static int minDiff(int[] a){
		return minDiff(a,0,0,0);
	}
	
	private static int minDiff(int[] a, int i, int sum1, int sum2) {
		if (i == a.length) return abs(sum1 - sum2);
		int group1 = minDiff(a, i+1, sum1 + a[i], sum2);
		int group2 = minDiff(a, i+1, sum1, sum2 + a[i]);
		return min(group1, group2); 
	}
	
	private static int min(int x, int y) {return x < y ? x : y;}
	private static int abs(int x) {return x < 0 ? x*-1 : x;}
	
	
	
	
	
	/**
	 * Exam 2013B 92 B3 - longestFlat method option 1
	 */
	public static int longestFlat(int[] arr){
		return longestFlat(arr,1,arr[0]);
	}
	
	private static int longestFlat(int[] arr, int i, int temp){
		if(i==arr.length) return 0;
		if(arr[i]== temp) return 1+ longestFlat(arr, i+1, temp);
		if(arr[i] > temp && arr[i] - temp == 1) return 1+ longestFlat(arr, i+1, temp);
		if(arr[i] < temp && temp - arr[i] == 1) return 1+ longestFlat(arr, i+1, temp);
		
		return longestFlat(arr, i+1, arr[i]);
	}
	
	
	
	/**
	 * Exam 2013B 92 B3 - longestFlat method option 2 - Better option
	 */
	public static int longestFlat1(int[] arr){
		return longestFlat1(arr,1,arr[0]);
	}
	
	private static int longestFlat1(int[] arr, int i, int temp){
		if(i==arr.length) return 0;
		
		if(arr[i] > temp && arr[i] - temp != 1) return longestFlat1(arr, i+1, arr[i]);
		if(arr[i] < temp && temp - arr[i] != 1) return longestFlat1(arr, i+1, arr[i]);
		
		return 1+longestFlat1(arr, i+1, temp);
	}

	
	/**
	 * Exam 2014A 85 A5 - printPath option 1
	 */
	public static void printPath1(int[][] a){
		printPath1(a,0,0,0);
	}
	private static void printPath1(int[][] a, int i, int j, int max)
	{
		if(i<0 || i==a.length || j < 0 || j==a.length || max>=a[i][j])  return;
		System.out.print("("+ i +","+ j +")");
		printPath1(a, i-1, j, a[i][j]); 
		printPath1(a, i+1, j, a[i][j]);
		printPath1(a, i, j-1, a[i][j]);
		printPath1(a, i, j+1, a[i][j]);
	}
	
	/** 
	 * Exam 2014A 85 A5 - printPath option 2
	 */
	public static void printPath(int[][] a){
		printPath(a,0,0);
	}
	private static void printPath(int[][] a, int i, int j)
	{		
		System.out.print("("+ i +","+ j +")"); 
		
		
		if(notOut(a,i+1,j)) 
			if(a[i+1][j] > a[i][j]) {
				printPath(a, i+1, j); 
				return;
			}


		if(notOut(a,i,j+1))
			if(a[i][j+1] > a[i][j]){
				printPath(a, i, j+1); 
				return;
			}

		if(notOut(a,i-1,j))
			if(a[i-1][j] > a[i][j]){
				printPath(a, i-1, j);
				return;
			}

		if(notOut(a,i,j-1))
			if(a[i][j-1] > a[i][j])	{
				printPath(a, i, j-1);
				return;
			}				
		}		
	
	private static boolean notOut(int[][] a, int i, int j)
	{
		if(i < 0 ||	i >a.length-1 || j < 0 || j > a[0].length-1)
			return false;
		return true;
	} 
	//								
	//			   
	//				 [#]-[#]
	//				   | | 
	//				[#]---[#]
	//
	//
	/**	
	 * 2014B A4 85 - longestWorm 
	 */
	public static int longestWorm(int[][] mat){
		return longestWorm(mat, 0,0,0);
	}
	
	private static int longestWorm(int[][] mat,int i, int j, int max){
		if (i == mat.length) return max;
		if (j == mat[i].length)
			return longestWorm(mat, i + 1, 0, max);
		max= Math.max(max,wormCount(mat,i,j));
		return longestWorm(mat, i, j + 1, Math.max(max,wormCount(mat,i,j)));
	}
	private static int wormCount(int[][] mat, int i, int j){
		if(i < mat.length-1 && mat[i][j] == mat[i+1][j]+1) 
			return 1+ wormCount(mat, i+1, j);
		if(j < mat[i].length-1 && mat[i][j] == mat[i][j+1]+1) 
			return 1+ wormCount(mat, i, j+1);
		if(i > 0 && mat[i][j] == mat[i-1][j]+1) 
			return 1+ wormCount(mat, i-1, j); 
		if(j > 0 && mat[i][j] == mat[i][j-1]+1)
			return 1+ wormCount(mat, i, j-1);
		return 1;
	}
	private static int max(int x,int y, int a, int b) {
		int max1 = x > y ? x : y;
		int max2 = a > b ? a : b;
		return max1 > max2 ? max1 : max2;
	}

	
	public static int wormCount(int[][] a,int i,int j,int lastValue,boolean start)
    {
      if(i<0||i==a.length||j<0||j==a[0].length )
        return 0;   
        if(lastValue == a[i][j] - 1 || start) {
        	int left = wormCount(a,i,j-1,a[i][j],false);
        	int right = wormCount(a,i,j+1,a[i][j],false);
        	int up = wormCount(a,i-1,j,a[i][j],false);
        	int down = wormCount(a,i+1,j,a[i][j],false);
        	return 1 + max(left,right,up,down);
        }
        return 0;
    }

    public static int longestWorm2(int[][] a,int i,int j,int max)
    {
        if(i==a.length)
            return max;        
        if(j==a[0].length)
            return longestWorm2(a,i+1,0,max);       
        max = Math.max(max, wormCount(a,i,j,a[i][j],true));
        return longestWorm2(a,i,j+1,max);        
    }
    public static int longestWorm2(int[][] a){
    	return longestWorm2(a,0,0,1);   
    }
	/**
	 * 2015A 89 - splitEqualMult
	 */
	
	public static boolean splitEqualMult(int[] a) {
		return splitEqualMult(a,0,1,1);
	}
	
	private static boolean splitEqualMult(int[] a, int i, int sum1, int sum2) {
		if(i == a.length) return sum1 == sum2;
		boolean split1 = splitEqualMult(a,i+1, sum1*a[i], sum2);
		boolean split2 = splitEqualMult(a, i+1, sum1, sum2*a[i]);
		return split1||split2;
	}
	
	
	/**
	 * Exam 2015A A2 83 - shortestPath method - option 1
	 */
	public static int shortestPath(int[][]mat) {
		return shortestPath(mat, new boolean[mat.length][mat.length], 0,0,-1,0);
	}
	
	private static int shortestPath(int[][] mat, boolean[][] reference, int i, int j, int prev, int length){
		if(i==mat.length-1 && j==mat[i].length) return length;
		if(i<0 || j<0 || i==mat.length || j==mat[0].length || reference[i][j] || mat[i][j] <= prev) return Integer.MAX_VALUE;
		reference[i][j] = true;
		int right = shortestPath(mat,reference, i,j+1,mat[i][j],length+1);
		int left  = shortestPath(mat,reference, i,j-1,mat[i][j],length+1);
		int down  = shortestPath(mat,reference, i-1,j,mat[i][j],length+1);
		int up    = shortestPath(mat,reference, i+1,j,mat[i][j],length+1);
		reference[i][j] = false;
		return min(left,right,up,down);
	}
	
	private static int min(int a, int b, int c, int d) {
		int min1 = a < b ? a : b;
		int min2 = c < d ? c : d;
		return min1 < min2 ? min1 : min2;
	}
	
	/**
	 * Exam 2015A A2 83 - shortestPath method - option 2
	 */
	public static int shortestPath1(int[][]mat) {
		return shortestPath1(mat, new boolean[mat.length][mat.length], 0,0,0);
	}
	private static int shortestPath1(int[][] mat, boolean[][] reference, int i, int j, int path)
	{
		int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE,down=Integer.MAX_VALUE,up=Integer.MAX_VALUE;
		if(i==mat.length-1 && j==mat[i].length-1)
			return path+1;
		if(i<mat.length-1 && mat[i+1][j] > mat[i][j])
			up = shortestPath1(mat,reference, i+1,j,path+1);
		if(i>0 && mat[i-1][j] > mat[i][j])
			down = shortestPath1(mat,reference, i-1,j,path+1);
		
		if(j<mat[0].length-1 && mat[i][j+1] > mat[i][j])
			right = shortestPath1(mat,reference, i,j+1,path+1);
		if(j>0 && mat[i][j-1] > mat[i][j])
			left = shortestPath1(mat,reference, i,j-1,path+1);
		
		return min(up,down,left,right);
	}
	
	
	
	
	
	
	/**
	 *  Exam 2015A-A4-85 - CountRopes method
	 *	Exam 2015A-A4-85 - CountRopes method
	 */
	
	
	public static int countRopes(int[][] mat) {
		return countRopes(mat,0,0);
	}
	private static int countRopes(int[][] mat, int j, int count) {
		if(j == mat[0].length) return count; 
		count += countRopes(mat,0,j,Integer.MAX_VALUE);
		return countRopes(mat,j+1, count);
	}
	private static int countRopes(int[][] mat, int i, int j,int prev) {
		if(j==mat[0].length  || j < 0 || mat[i][j] >= prev) return 0;
		if(i==mat.length-1) return 1;
		int down  = countRopes(mat,i+1,j,mat[i][j]),
			diagonalR = countRopes(mat,i+1,j+1,mat[i][j]),
			diagonalL = countRopes(mat,i+1,j-1,mat[i][j]);	
		return down + diagonalR + diagonalL;
	}
	
	
	/**
	 * 	 *	Exam 2015A-A4-85 - CountRopes method option 2
	 */
	
	public static int checkRope(int[][] mat,int i,int j,int lastValue,boolean start)
    {          
      if(j<0||j==mat[0].length)
        return 0;
      
      if(lastValue>mat[i][j] && i == mat.length-1)
        return 1;
        
      if(lastValue>mat[i][j]||start==true)
      {  
        int l = checkRope(mat,i+1,j-1,mat[i][j],false);
        int m = checkRope(mat,i+1,j,mat[i][j],false);
        int r = checkRope(mat,i+1,j+1,mat[i][j],false);
        
        return l + m + r;
      } 
      return 0;
    }
    public static int countRopes2(int[][] mat, int i, int j,int count)
    {
        if(j==mat[0].length)
            return count;
        
        count = count + checkRope(mat,i,j,mat[i][j],true);
        
        return countRopes2(mat,i,j+1,count);
    }
    public static int countRopes2(int[][] mat)
    {  
     return countRopes2(mat,0,0,0);   
    }
	
	
	
	
	
	/**
	 * 
	 * Exam 2015A-B2-91 - makeSum Method
	 */
	public static int makeSum(int[] lengths, int k, int num){
		return makeSum(lengths,k,num,0);
	}
	
	private static int makeSum(int[] lengths, int k, int num, int i){
		if(num<0 || i == lengths.length) return 0;
		if(k-lengths[i] == 0) 
			return 1+ makeSum(lengths,k,num,i+1);
		if(k-lengths[i] > 0)
			return makeSum(lengths,k-lengths[i],num-1,i) + makeSum(lengths,k,num,i+1);
		
		return makeSum(lengths,k,num,i+1); 
	}
	
	
	
	/**
	 * 
	 * Exam 2015B-A5-86 - makeSum Method
	 */
	public static void printSum(int[] a, int sum){
		printSum(a,sum,0,"");
	}
	
	private static void printSum(int[] a, int sum, int i, String st){
		if(i==a.length && sum == 0)
			System.out.println(st);
		
		else{
			printSum(a,sum-a[i], i+1, st + "1");
			printSum(a,sum, i+1, st + "0");	
		}
	}
	
	
	
	/**
	 * Exam 2015B B5  94 - lordOrdNum method
	 */
	public static int longOrdNum(String s) {
		return longOrdNum(s,0,0,1);
	}
	
	private static int longOrdNum(String s, int i, int max, int count) {
		if(count>max) max = count;
		if(i==s.length()-1) return max;
		if(s.charAt(i) < '0' || s.charAt(i) > '9' || s.charAt(i) >= s.charAt(i+1))
			return longOrdNum(s,i+1,max,1);
		return longOrdNum(s,i+1,max,count+1);
	}
	
	/**
	 * Exam 2016A B2 91 - minPath method
	 */
	public static int minPath(char[][] minChess, int i, int j){
		return minPath(minChess,new boolean[minChess.length][minChess.length], i,j, 0,0);
	}
	
	
	private static int minPath(char[][] minChess,boolean[][] ref, int i, int j, int min, int count)
	{
		if(i<0 || j<0 || i>minChess.length-1 || j>minChess[0].length-1||ref[i][j])
			return Integer.MAX_VALUE;
		
		if(minChess[i][j] == 'K') 
			return count;
		
		ref[i][j] = true;
		int a = minPath(minChess, ref, i+1,j+2,min,count+1);
		int b = minPath(minChess, ref, i+1,j-2,min,count+1);
		int c = minPath(minChess, ref, i-1,j+2,min,count+1);
		int d = minPath(minChess, ref, i-1,j-2,min,count+1);
		int e = minPath(minChess, ref, i+2,j+1,min,count+1);
		int f = minPath(minChess, ref, i+2,j-1,min,count+1);
		int g = minPath(minChess, ref, i-2,j+1,min,count+1);
		int h = minPath(minChess, ref, i-2,j-1,min,count+1);
		ref[i][j] = false;
		return 	Math.min(min(a,b,c,d), min(e,f,g,h));
	}
	
	
	public static int minPath2(char[][] minChess, int i, int j){
		return minPath(minChess,new boolean[minChess.length][minChess.length], i,j, 0,0);
	}
	
	
	private static int minPath2(char[][] minChess,boolean[][] ref, int i, int j, int min, int count)
	{
		if(i<0 || j<0 || i>minChess.length-1 || j>minChess[0].length-1||ref[i][j])
			return Integer.MAX_VALUE;
		if(minChess[i][j] == 'K') 
			return count;
		ref[i][j] = true;
		int a = minPath(minChess, ref, i+1,j+2,min,count+1);
		int b = minPath(minChess, ref, i+1,j-2,min,count+1);
		int c = minPath(minChess, ref, i-1,j+2,min,count+1);
		int d = minPath(minChess, ref, i-1,j-2,min,count+1);
		int e = minPath(minChess, ref, i+2,j+1,min,count+1);
		int f = minPath(minChess, ref, i+2,j-1,min,count+1);
		int g = minPath(minChess, ref, i-2,j+1,min,count+1);
		int h = minPath(minChess, ref, i-2,j-1,min,count+1);
		ref[i][j] = false;
		return 	Math.min(min(a,b,c,d), min(e,f,g,h));
	}
	
	
	/**
	 * Exam 2018A A1 - longestSlope
	 */
	public static int slopeCount(int[][] a, int k, int i,int j,int prev, boolean first)
    {
      if(i<0||i==a.length||j<0||j==a[0].length )
        return 0;   
        if(prev == a[i][j] - k || first) {
        int left = slopeCount(a,k, i,j-1,a[i][j],false);
        int right = slopeCount(a,k, i,j+1,a[i][j],false);
        int up = slopeCount(a,k, i-1,j,a[i][j],false);
        int down = slopeCount(a,k, i+1,j,a[i][j],false);
        
        return 1 + max(left,right,up,down);
   
        }
        return 0;
    }

    public static int longestSlope(int[][] a,int k, int i,int j,int max)
    {
        if(i==a.length)
            return max;        
        if(j==a[0].length)
            return longestSlope(a,k,i+1,0,max);       
        max = Math.max(max, slopeCount(a,k,i,j,a[i][j],true));
        return longestSlope(a,k,i,j+1,max);        
    }
    public static int longestSlope(int[][] a, int k){
    	return longestSlope(a,k,0,0,1);   
    }	
    
    
    
    
    
    
    
    private static boolean checkPoint(int[][] m, int i, int j, int num)
    {
    	if(i==m.length || j==m.length || num+m[i][j] < 1)
    		return false;
    	
    	if(i==m.length-1 && j==m.length-1)
    		return true;
    	
    	boolean right = checkPoint(m,i,j+1,num+m[i][j]);
    	boolean down = checkPoint(m,i+1,j,num+m[i][j]);
    	
    	return right||down;
    }
    
    private static int minPoint(int[][] m, int num) 
    {
    	if(checkPoint(m,0,0,num))
    		return num;
    	return minPoint(m,num+1);
    }
    /**
     * Exam 2016 A 82 A2
     */
    public static int minPoint(int[][] m){
    	return minPoint(m, 1);
    }
}
