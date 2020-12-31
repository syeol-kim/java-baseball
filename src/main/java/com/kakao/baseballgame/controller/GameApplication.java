package com.kakao.baseballgame.controller;

import com.kakao.baseballgame.model.Game;
import com.kakao.baseballgame.model.GameState;
import com.kakao.baseballgame.view.GameView;
import javafx.util.Pair;

public class GameApplication {
    public static void main(String[] args) {
        Game game = new Game();
        while(game.getState() != GameState.FINISHED.ordinal()){
            int number = GameView.getNumber();
            Pair<Integer, Integer> hint = game.play(number);
            GameView.printHint(hint.getKey(), hint.getValue());
            if(hint.getKey() == Game.NUM_DIGITS){
                int option = GameView.getOption();
                game.goNext(option);
            }
        }
    }
}
