class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
        	if(isDividingNumber(i)){
        		list.add(i);
        	}
        }
        return list;
    }
    private boolean isDividingNumber(int num){
    	int temp = 0;
        int n = num;
        while(num > 0){
            temp = num%10;
            if(temp == 0||n%temp!=0){
                return false;
            }
            num /= 10;
        }
        return true;
        
    }

}   