package com.egorzh.ktee

class Arguments(args: Array<String>) {
    var append = false
        private set
    var ignoreInterrupt = false
        private set
    var fileNames: List<String>
        private set

    init {
        val options = args.takeWhile { it.startsWith('-') }
        options.forEach {
            when (it) {
                "-a" -> append = true
                "-i" -> ignoreInterrupt = true
                else -> throw IllegalArgumentException("illegal option $it")
            }
        }

        fileNames = args.drop(options.size)
    }
}