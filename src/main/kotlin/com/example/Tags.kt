package com.example

import kotlinx.html.HTMLTag
import kotlinx.serialization.json.JsonElement

var HTMLTag.hxPost: String?
    get() = attributes["hx-post"]
    set(value) { value?.let { attributes["hx-post"] = it } }

var HTMLTag.hxGet: String?
    get() = attributes["hx-get"]
    set(value) { value?.let { attributes["hx-get"] = it } }

var HTMLTag.hxPushUrl: String?
    get() = attributes["hx-push-url"]
    set(value) { value?.let { attributes["hx-push-url"] = it } }

var HTMLTag.hxSelect: String?
    get() = attributes["hx-select"]
    set(value) { value?.let { attributes["hx-select"] = it } }

var HTMLTag.hxSelectOob: String?
    get() = attributes["hx-select-oob"]
    set(value) { value?.let { attributes["hx-select-oob"] = it } }

var HTMLTag.hxSwap: String?
    get() = attributes["hx-swap"]
    set(value) { value?.let { attributes["hx-swap"] = it } }

var HTMLTag.hxSwapOob: String?
    get() = attributes["hx-swap-oob"]
    set(value) { value?.let { attributes["hx-swap-oob"] = it } }

var HTMLTag.hxTarget: String?
    get() = attributes["hx-target"]
    set(value) { value?.let { attributes["hx-target"] = it } }

var HTMLTag.hxTrigger: String?
    get() = attributes["hx-trigger"]
    set(value) { value?.let { attributes["hx-target"] = it } }

var HTMLTag.hxVals: String?
    get() = attributes["hx-vals"]
    set(value) { value?.let { attributes["hx-vals"] = it } }

var HTMLTag.hxBoost: Boolean
    get() = attributes["hx-boost"]?.toBoolean() ?: false
    set(value) { value.let { attributes["hx-boost"] = it.toString() } }