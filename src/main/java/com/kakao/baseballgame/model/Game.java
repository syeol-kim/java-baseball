package com.kakao.baseballgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    public static final int NUM_DIGITS = 3;
    final int TEN = 10;

    Integer[] answer;

    public Integer[] getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        if(answer.size() == NUM_DIGITS){
            this.answer = answer.toArray(new Integer[NUM_DIGITS]);
        }
    }

    public void createAnswer(){
        List<Integer> digits = new ArrayList<>();
        for(int i=1; i<TEN; ++i){
            digits.add(i);
        }
        Collections.shuffle(digits);
        List<Integer> answer = digits.subList(0, NUM_DIGITS);
        setAnswer(answer);
    }

}
