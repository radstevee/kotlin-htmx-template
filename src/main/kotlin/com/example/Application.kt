package com.example

import com.example.plugins.configureHTTP
import com.example.plugins.configureSecurity
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.html.respondHtml
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.html.*

fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "0.0.0.0",
        module = Application::module,
    ).start(wait = true)
}

fun Application.module() {
    configureHTTP()
    configureSecurity()
    configureRouting()
}

fun FlowContent.home() = div {
    classes = setOf("container", "mx-auto", "py-4")
    id = "home"
    main {
        classes = setOf("container", "mx-auto", "py-4")
        div {
            classes = setOf("container", "mx-auto", "py-4")
            h1 {
                classes = setOf("text-3xl", "font-bold")
                hxGet = "/hello"
                hxTrigger = "click"
                hxSwap = "innerHTML"
                hxTarget = "#home"
                hxBoost = true
                +"Hello, Ktor!"
            }
        }
    }
}

fun FlowContent.hello() = div {
    classes = setOf("container", "mx-auto", "py-4")
    main {
        classes = setOf("container", "mx-auto", "py-4")
        div {
            classes = setOf("container", "mx-auto", "py-4")
            h1 {
                classes = setOf("text-3xl", "font-bold")
                hxGet = "/"
                hxTrigger = "click"
                hxSwap = "innerHTML"
                hxTarget = "#home"
                hxBoost = true
                +"Hello, HTMX!"
            }
        }
    }
}

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500 Internal Server Error: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        get("/") {
            call.respondHtml(HttpStatusCode.OK) {
                layout {
                    home()
                }
            }
        }
        get("/hello") {
            call.respondHtml(HttpStatusCode.OK) {
                layout {
                    hello()
                }
            }
        }
    }
}