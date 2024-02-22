package com.example

import kotlinx.html.*

fun HTML.layout(e: BODY.() -> Unit) {
    head {
        link(rel = "stylesheet", href = "https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css")
        script {
            src = "https://unpkg.com/htmx.org@1.9.10"
            integrity = "sha384-D1Kt99CQMDuVetoL1lrYwg5t+9QdHe7NLX/SoJYkXDFfX37iInKRy5xLSi8nO7UC"
            crossorigin = ScriptCrossorigin.anonymous
        }
    }

    body {
        e()
    }
}