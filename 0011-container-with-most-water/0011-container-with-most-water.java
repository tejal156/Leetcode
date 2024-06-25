class Solution {
    public int maxArea(int[] height) 
    {
        if( height.length <= 1 )
        {
            return 0 ;
        }
        
        int i = 0 ;
        int j = height.length - 1 ;
        int min ;
        if(height[j] >= height[i])
        {
            min = i ;
        }
        else
        {
            min = j ;
        }

        int maxA =  height[min] * (j-i) ;

        while( j>i ) 
        {
            int temp = min ;
            if( min == i)
            {
                for( int i1 = i ; i1 < j ; i1++  )
                {
                    if( height[i1] > height[i])
                    {
                        i = i1 ;
                        break ;
                    }
                }
            }
            else
            {
                for( int i1 = j ; i1 > i ; i1--  )
                {
                    if( height[i1] > height[j])
                    {
                        j = i1 ;
                        break ;
                    }
                }  
            }

            if(height[j] >= height[i])
            {
                min = i ;
            }
            else
            {
                min = j ;
            }

            int totalA =  height[min] * (j-i);
            if( maxA < totalA)
            {
                maxA = totalA ;
            }
            if( min == temp )
            {
                return maxA ;
            }
        }

        return maxA ;
    }
}