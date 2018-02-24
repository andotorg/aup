package org.andot.test

fun main(args: Array<String>){
    println(getLcation("山东")[0])

}

fun getLcation(areaName: String): Array<String>{
    println(areaName)
    var ll: Array<String> = arrayOf("117.46", "85.87");
    return ll;
}