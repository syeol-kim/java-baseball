package com.kakao.baseballgame.view;

import com.kakao.baseballgame.model.Game;
import com.kakao.baseballgame.model.GameOption;

import java.util.Scanner;

public class GameView {
    private static final Scanner sc = new Scanner(System.in);

    public static int getNumber(){
        System.out.println("숫자를 입력해주세요: ");
        return sc.nextInt();
    }

    public static int getOptin(){
        int option = 0;
        while((option != GameOption.RESTART.ordinal()
                && option != GameOption.EXIT.ordinal())){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            option = getNumber();
        }
        return option;
    }

    public static void printHint(int numStrikes, int numBalls){
        String message = createHintMessage(numStrikes, numBalls);
        System.out.println(message);
    }

    private static String createHintMessage(int numStrikes, int numBalls){
        if(numStrikes ==  Game.NUM_DIGITS){
            return String.format("%d 스트라이크\n축하합니다 (〜￣▽￣)〜 %d개의 숫자를 모두 맞히셨습니다!", numStrikes, numStrikes);
        }
        String hint = (numStrikes == 0) ? "" : numStrikes + " 스트라이크 ";
        if(numBalls != 0){
            hint += numBalls + " 볼";
        }
        hint = (hint.equals("")) ? "낫싱" : hint;
        return hint;
    }
}
