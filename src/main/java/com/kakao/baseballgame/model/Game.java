package com.kakao.baseballgame.model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    public static final int NUM_DIGITS = 3;
    final int TEN = 10;

    Integer[] answer;
    int state;

    public Game(){
        createAnswer();
        setState(GameState.PLAYING.ordinal());
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Integer[] getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        if(answer.size() == NUM_DIGITS){
            this.answer = answer.toArray(new Integer[NUM_DIGITS]);
        }
    }

    public Pair<Integer, Integer> play(int number){
        Integer[] digits = numberToArray(number);
        return createHint(digits);
    }

    public void goNext(int option){
        setState((option == GameOption.RESTART.ordinal()) ? GameState.PLAYING.ordinal() : GameState.FINISHED.ordinal());
        createAnswer();
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

    public Pair<Integer, Integer> createHint(Integer[] digits){
        int numStrikes = 0;
        int numBalls = 0;
        for(int i=0; i<NUM_DIGITS; ++i){
            if(digits[i].equals(answer[i])){
                ++numStrikes;
                continue;
            }

            for(int j=0; j<NUM_DIGITS; ++j){
                if(digits[i].equals(answer[j])){
                    ++numBalls;
                    break;
                }
            }
        }
        return new Pair<>(numStrikes, numBalls);
    }

    private Integer[] numberToArray(int number){
        Integer[] array = new Integer[NUM_DIGITS];
        for(int i = 0, j = (int) Math.pow(TEN, NUM_DIGITS-1); number!=0; ++i){
            array[i] = number/j;
            number %= j;
            j /= TEN;
        }
        return array;
    }
}
