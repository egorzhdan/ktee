package com.egorzh.ktee

import sun.misc.Signal

fun main(args: Array<String>) {
    val arguments = Arguments(args)
    val output = Output(arguments)

    if (arguments.ignoreInterrupt) {
        Signal.handle(Signal("INT")) { }
    }

    System.`in`.reader().forEachLine { output.println(it) }
}