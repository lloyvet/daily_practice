public int reverse(int x) {
        boolean negative = x < 0;
        if (negative) x = -x;
        long r = 0;
        while (x>0)
        {            
            r = r * 10 + x % 10; 
            x /= 10;        
        }       
        if (negative) r = -r;   
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) 
         return 0;       
        return (int)r;

    }