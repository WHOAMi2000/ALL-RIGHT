package utils;

import org.apache.commons.lang3.Conversion;
//靳辰辰 start
public class HexBinDecOct {
    public HexBinDecOct(){
    }
    //进制转换函数
    private String systemConvertion(String num,int current,int next){

        int integer = Integer.valueOf(num,current);
        String ans;
        switch (next){
            case 2: ans = Integer.toBinaryString(integer);break;
            case 8: ans = Integer.toOctalString(integer);break;
            case 10: ans = String.valueOf(integer);break;
            case 16: ans = Integer.toHexString(integer).toUpperCase();break;
            default:
                throw new IllegalStateException("Unexpected value: " + next);
        }

        return ans;
    }


    public StringBuilder Convertion(int next,int current,StringBuilder exp){
        StringBuilder expConverted=new StringBuilder();
        char []c;
        c = exp.toString().toCharArray();

        StringBuilder temp = new StringBuilder(); ;
        for (int i = 0; i < c.length; i++){
      //      System.out.println(c[i]);
            if (isNum(current,c[i])){
//                if (i < c.length-1&&isNum(current,c[i+1])){
//                    temp.append(c[i]);
//                }
//                if (i == c.length-1){
//                    temp.append(c[i]);
//                }
                temp.append(c[i]);
            }
//            System.out.println("temp:"+temp);
            if (!isNum(current,c[i])){
                if (temp.length()!=0){
                    expConverted.append(systemConvertion(temp.toString(),current,next));
                    temp.delete(0,temp.length());
                }
                expConverted.append(c[i]);
            }
        }

        if (temp.length()!=0){
            expConverted.append(systemConvertion(temp.toString(),current,next));
            temp.delete(0,temp.length());
        }

        return expConverted;
    }

    private boolean isNum(int system,char c){
        boolean flag;
        switch (system){
            case 2: if (c == '0'||c == '1') flag = true;else flag = false;break;
            case 8: if (c >= 48 && c <= 55) flag = true;else flag = false;break;
            case 10:if (c >= 48 && c <= 57) flag = true;else flag = false;break;
            case 16:if ((c >= 48 && c <= 57)||(c >= 65&&c <= 70))
                        flag = true;
                    else flag = false; break;
            default:flag = false;
        }
        return flag;
    }
}
//靳辰辰 end