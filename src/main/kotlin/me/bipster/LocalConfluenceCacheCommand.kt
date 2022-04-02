package me.bipster

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.annotation.Property
import jakarta.inject.Inject

import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Command(name = "local-confluence-cache", description = ["..."],
        mixinStandardHelpOptions = true)
class LocalConfluenceCacheCommand @Inject constructor (
        @Property(name = "confluence.token") private var confluenceToken: String,
    ) : Runnable {

    @Option(names = ["-v", "--verbose"], description = ["..."])
    private var verbose : Boolean = false

    override fun run() {
        // business logic here
        if (verbose) {
            println("Hi!")
        }
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            PicocliRunner.run(LocalConfluenceCacheCommand::class.java, *args)
        }
    }
}
