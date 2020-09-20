package com.web.app.webapp.model;

public class test {
    public static void main(String[] args) {
        dummy x = new dummy();
        x.a= 54676;
        x.ab = "sggffdeuegwyufryuufuidvuihbvyoil";
        x.d= 0.43178585;
        x.b = "geygyfyugesfyfuisguigge";

        dummy y = new dummy();
        y.a= 54676;
        y.ab = "sggffdeuegwyufryuufuidvuihbvyoil";
        y.d = 0.43178585;
        y.b = "geygyfyugesfyfuisguigge";

        System.out.println(x.equals(y));
    }
}
class dummy{
    int a;
    String ab;
    double d;
    String b;


    @Override
    public boolean equals(Object obj) {
        /*if(this == obj){
            return  true;
        }*/
        if( obj == null){
            return  false;
        }
        if(getClass()!= obj.getClass()){
            return false;
        }
        dummy dummy = (dummy) obj;
        if(ab != dummy.ab){
            return false;
        }
        return true;
    }
}