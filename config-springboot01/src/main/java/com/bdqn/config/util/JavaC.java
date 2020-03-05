package com.bdqn.config.util;

/**
 * @author zf
 * @create 2020-02-16 17:49
 */
public class JavaC {
    public static void main(String[] args) {
        int [] arr={1,8,9,12,14,10} ;
        int [] arr2=new int[3] ;
        //标记bianliang
        int b=0;

        arr2[0]=8;
        arr2[1]=14;
        arr2[2]=10;

     /*for (int i=0;i<3;i++){
                int ran2 = (int) (Math.random()*20);
            arr2[i]=ran2;

            }*/
            String str="";
        for (int i=0;i<arr.length;i++){

            if (arr[i]==arr2[b]){
    if(i+1>arr.length-1){
        i=0;
    }else {
        i=i+1;
    }
if (b+1>2){
    b=0;
}
else {
   b=b+1;
}
                if (arr[i]==arr2[b]){


                    if(i+1>arr.length-1){
                        i=0;
                    }else {
                        i=i+1;
                    }
                    if (b+1>2){
                        b=0;
                    }
                    else {
                        b=b+1;
                    }

                    if (arr[i]==arr2[b]){
                    System.out.println("恭喜中奖！！");
                    b=0;
                    break;
                    }
                    }else {    System.out.println("谢谢参与");break;}

                }
            }


        }




    }

