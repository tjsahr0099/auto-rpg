package common.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Fibonacci {

    private static Integer[] fibonacci = null;
    public static Integer maxLength = 30;

    public static Integer[] getFibonacci(){
        if(fibonacci==null){
            log.info("피보나치 신규생성");
            fibonacci = makeFibonacci();
        }else{
            log.info("피보나치 기존활용");
        }
        return fibonacci;
    }

    private static Integer[] makeFibonacci(){
        Integer[] _fibonacci = new Integer[maxLength];
        for(int i=0;i<maxLength;i++){
            if(i==0){
                _fibonacci[i]=1;
            }else if(i==1){
                _fibonacci[i]=2;
            }else{
                _fibonacci[i]=_fibonacci[i-1]+_fibonacci[i-2];
            }
        }
        return _fibonacci;
    }

}
