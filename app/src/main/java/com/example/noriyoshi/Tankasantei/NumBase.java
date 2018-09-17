package com.example.noriyoshi.Tankasantei;

public class NumBase {
    private static double liner;
    private static double flute;
    private static double haba;
    private static double nagare;
    private static double tenun;
    private static double lot;
    private static double insatuset;
    private static double insatutoosi;

    public static void setLiner(double liner) {
        NumBase.liner = liner;
    }

    public static void setFlute(double flute) {
        NumBase.flute = flute;
    }

    public static void setLot(double lot) {
        NumBase.lot = lot;
    }

    public static void setInsatutoosi(double insatutoosi) {
        NumBase.insatutoosi = insatutoosi;
    }

    public static void setInsatuset(double insatuset) {
        NumBase.insatuset = insatuset;
    }

    public static void setHaba(double haba) {
        NumBase.haba = haba;
    }

    public static void setNagare(double nagare) {
        NumBase.nagare = nagare;
    }

    public static void setTenun(double tenun) {
        NumBase.tenun = tenun;
    }

    public static double getInsatuset() {
        return insatuset;
    }

    public static double getLot() {
        return lot;
    }

    public static double getInsatutoosi() {
        return insatutoosi;
    }

    public static double getFlute() {
        return flute;
    }

    public static double getHaba() {
        return haba;
    }

    public static double getLiner() {
        return liner;
    }

    public static double getNagare() {
        return nagare;
    }

    public static double getTenun() {
        return tenun;
    }
}
