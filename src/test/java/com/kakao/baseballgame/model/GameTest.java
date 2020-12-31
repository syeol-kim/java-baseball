package com.kakao.baseballgame.model;

import com.kakao.baseballgame.view.GameView;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    void createAnswer() {
        Game game = new Game();
        game.createAnswer();
        Integer[] answer = game.getAnswer();
        assertTrue(isValidAnswer(answer));
    }

//    @Test
//    void createHint(){
//        Game game = new Game();
//        game.createAnswer();
//        Pair<Integer, Integer> hint = game.createHint(
//                new Integer[]{new Integer(1), new Integer(2), new Integer(3)});
//        GameView.printHint(hint.getKey(), hint.getValue());
//    }

    private boolean isValidAnswer(Integer[] answer){
        return (answer.length == Game.NUM_DIGITS)       // 생성한 정답의 자리수는 약속한 자리수와 동일해야한다
                && (!isOverlapping(answer));            // 생성한 정답의 구성 숫자들은 중복되지 않아야한다
    }

    private boolean isOverlapping(Integer[] answer){
        Set<Integer> set = new HashSet<>(Arrays.asList(answer));
        return set.size() < answer.length;
    }
}