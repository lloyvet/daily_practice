public String defangIPaddr(String address) {
        char[] temp = address.toCharArray();
        char[] result = new char[temp.length+3*2];
        int j = 0;
        for(int i = 0;i<temp.length;i++,j++){
            if('.' == temp[i]){
                result[j++]='[';
                result[j++]='.';
                result[j]=']';
            }else{
                result[j]=temp[i];
            }
        }
        return String.valueOf(result);
    }