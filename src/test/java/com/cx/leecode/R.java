package com.cx.leecode;

import com.cx.leecode.In202007.Insert;
import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.math.BigInteger;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class R {
    private static BigInteger TWO = BigInteger.valueOf(2);

    @Test
    public void te(){
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.merge("1","2", String::concat);

        System.out.println(map);
    }

    @Test
    public void primeTest(){

        primes().map(p -> TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(m -> m.isProbablePrime(50))
                .limit(10)
                .forEach(System.out::println);

        Map<String,Integer> to = new HashMap<>();
        to.put("1",2);

        List<String> top = to.keySet().stream()
                .sorted(comparing(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String o) {
                        return null;
                    }
                }).reversed())
                .limit(10)
                .collect(Collectors.toList());

    }

    @Test
    public void sortMap(){
        Map<String,Integer> map = new HashMap<>();
        map.put("一",1);
        map.put("三",3);
        map.put("二",2);

        List<String> collect = map.keySet().stream()
                .sorted(comparing(map::get).reversed())
                .collect(Collectors.toList());
        System.out.println(collect);

    }

    @Test
    public void sort(){
        List<Integer> list = Arrays.asList(1,3,4,5);
        list.sort(comparingInt(x -> x));
        System.out.println(list);
    }

    public static Stream<BigInteger> primes(){
        return Stream.iterate(TWO,BigInteger::nextProbablePrime);
    }
}
