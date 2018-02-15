package com.egorzh.ktee

fun main(args: Array<String>) {
    val arguments = Arguments(args)
    val output = Output(arguments)

    System.`in`.reader().forEachLine { output.println(it) }
}