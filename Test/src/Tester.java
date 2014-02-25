/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cowtop
 */
public class Tester {

    public static void main(String[] args) {
        int min = 9;
        int sec = 99;
        int count = 0;
        while(min >= 0) {
            while(sec >= 0) {
                sec--;
                count += (min * 60) + sec;
            }
            min--;
            sec = 60;
        }
        System.out.println("Count: " + count);
    }
}
