package com.ougen.myfirstkotlin;

public class Sorular {

    String q,opt1,opt2,opt3,answer;

    public Sorular(String q, String opt1, String opt2, String opt3, String answer) {
        this.q = q;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.answer = answer;
    }

    public String getQ() {
        return q;
    }

    public String getOpt1() {
        return opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public String getAnswer() {
        return answer;
    }
}
